package ga.util.Evaluation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import ai.synthesis.DslLeague.Runner.SettingsAlphaDSL;
import ai.synthesis.dslForScriptGenerator.DSLCommandInterfaces.ICommand;
import ai.synthesis.grammar.dslTree.interfacesDSL.iDSL;
import ai.synthesis.grammar.dslTree.utils.ReduceDSLController;
import ga.ScriptTableGenerator.ScriptsTable;
import ga.config.ConfigurationsGA;
import ga.model.Chromosome;
import ga.model.Population;
import rts.GameState;
import rts.units.UnitTypeTable;

public class DavidEval implements RatePopulation {
	ArrayList<iDSL> scriptsAST;
	
	public DavidEval() {
		super();
	}
	
	@Override
	public Population evalPopulation(Population population, int generation, ScriptsTable scriptsTable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void finishProcess() {
		// TODO Auto-generated method stub

	}
	
	public Population evalPopulation(GameState gs,List<Chromosome> Ficticion,int play ,Population population, int generation, ScriptsTable scriptsTable) {
		// TODO Auto-generated method stub
		population.clearValueChromosomes();
		ArrayList<AvaliaInvidual> singleMatches=new ArrayList<AvaliaInvidual>();
		HashMap<Integer, HashSet<ICommand>> uniqueCommandsPopulation=new HashMap<Integer, HashSet<ICommand>>();
		UnitTypeTable utt = new UnitTypeTable();
		for (Chromosome ch : Ficticion) {
			String s1 = convertBasicTuple(ch);
			iDSL ia =convertToDSL(s1);
			for (Chromosome cIA1 : population.getChromosomes().keySet()) {
				String s2 = convertBasicTuple(cIA1);
				iDSL ia2 = convertToDSL(s2);
				int idIA1=convertToInt(s1);
				int idIA2=convertToInt(s2);
				HashSet<ICommand> uniqueCommandsS1 = new HashSet<>();
				HashSet<ICommand> uniqueCommandsS2 = new HashSet<>();
				uniqueCommandsPopulation.put(idIA1, uniqueCommandsS1);
				uniqueCommandsPopulation.put(idIA2, uniqueCommandsS2);
				int id=convertToInt(convertBasicTuple(cIA1));
				if(play==1)singleMatches.add(new AvaliaInvidual(ia, ia2,1, gs.clone(), 1000, utt,  id,s1,s2));
				if(play==0)singleMatches.add(new AvaliaInvidual(ia2 ,ia,0,  gs.clone(), 1000, utt,  id,s2,s1));
			
			}
		}
		
		
		for(int i=0;i<singleMatches.size();i++){
			singleMatches.get(i).start();	
		}			
		
		try {
			for(int i=0;i<singleMatches.size();i++){
				singleMatches.get(i).join();
			}

		} catch (Exception e) {
			System.err.println("ai.synthesis.localsearch.DoubleProgramSynthesis.processMatch() " + e.getMessage());

		}
		
		
		
		for(int i=0;i<singleMatches.size();i++)
		{				
			population=updateChromosomes(singleMatches.get(i).getWinner(),singleMatches.get(i).j1,
													singleMatches.get(i).j2,singleMatches.get(i).play, population);
			
			int idIA1=convertToInt(singleMatches.get(i).j1);
			int idIA2=convertToInt(singleMatches.get(i).j2);
			
	
			uniqueCommandsPopulation.get(idIA1).addAll(singleMatches.get(i).getAllCommandIA1());
			uniqueCommandsPopulation.get(idIA2).addAll(singleMatches.get(i).getAllCommandIA2());            		
		}

		if(ConfigurationsGA.removeRulesAST)
		{
			population=updatePopulationRemotionRules(population,uniqueCommandsPopulation);
		}
		
		
		
		
		return population;
	}
	
	
	private Population updatePopulationRemotionRules(Population population, HashMap<Integer, HashSet<ICommand>> uniqueCommandsPopulation)
	{
		for (Chromosome ch : population.getChromosomes().keySet()) {
			int idScript=Integer.parseInt(convertBasicTuple(ch).replace(";", ""));
			BigDecimal toUpdate = population.getChromosomes().get(ch);
			iDSL originalScript=scriptsAST.get(idScript);
			String originalScriptStr=originalScript.translate();
			ReduceDSLController.removeUnactivatedParts(originalScript, new ArrayList<>(uniqueCommandsPopulation.get(idScript)));
			//updateReferencesforScript(originalScriptStr,originalScript.translate(),idScript);
			//population=addToPopulation(newScript,population,toUpdate);
		}
		return population;
		
	}
	
	
	private Population updateChromosomes(int winner, String j1,String j2,int lado, Population population) {
	
		String player0=j1;
		String player1=j2;

		
		if(winner==0 && lado==0)
		{
			population=updatePopulationASTs(population,player0, BigDecimal.ONE);
		}
		else if(winner==1 && lado==1)
		{
			population=updatePopulationASTs(population,player1, BigDecimal.ONE);
		}
		else if(winner==-1)
		{
			
				if(lado==0)population=updatePopulationASTs(population,player0, new BigDecimal(0.5));
				if(lado==1)population=updatePopulationASTs(population,player1, new BigDecimal(0.5));
			
		}
		return population;	
		
	}
	
	private Population updatePopulationASTs(Population population,String IAWinner, BigDecimal value) {
		
		Chromosome chrUpdate = null;
		for (Chromosome ch : population.getChromosomes().keySet()) {
			if (convertBasicTuple(ch).equals(IAWinner)) {
				chrUpdate = ch;
			}
		}

		if (chrUpdate != null) {
			BigDecimal toUpdate = population.getChromosomes().get(chrUpdate);
			if (toUpdate != null) {
				toUpdate = toUpdate.add(value);
				HashMap<Chromosome, BigDecimal> chrTemp = population.getChromosomes();
				chrTemp.put(chrUpdate, toUpdate);
			}
		}
		
		return population;
	}
	
	
	
	private int convertToInt(String script) {

		ArrayList<Integer> iScriptsAi1 = new ArrayList<>();
		String[] itens = script.replace("(", "").replace(")", "").split(";");

		for (String element : itens) {
			iScriptsAi1.add(Integer.decode(element));
		}

		return iScriptsAi1.get(0);
	}

	
	private String convertBasicTuple(Chromosome cromo) {
		String tuple = "";

		for (Integer integer : cromo.getGenes()) {
			tuple += integer + ";";
		}

		return tuple;
	}

	
	public void setASTlist(ArrayList<iDSL> scriptsAST) {
		this.scriptsAST = scriptsAST;
	}
	private iDSL convertToDSL(String script) {

		ArrayList<Integer> iScriptsAi1 = new ArrayList<>();
		String[] itens = script.replace("(", "").replace(")", "").split(";");

		for (String element : itens) {
			iScriptsAi1.add(Integer.decode(element));
		}

		return scriptsAST.get(iScriptsAi1.get(0));
	}
	
	
}



