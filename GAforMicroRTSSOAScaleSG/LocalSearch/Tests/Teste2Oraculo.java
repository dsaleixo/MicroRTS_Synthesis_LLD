package Tests;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import EvaluateGameState.CabocoDagua;
import Oraculo.EstadoAcoes;

import ai.CMAB.A3NWithin;
import ai.abstraction.LightRush;
import ai.abstraction.RangedRush;
import ai.abstraction.WorkerRush;
import ai.configurablescript.BasicExpandedConfigurableScript;
import ai.configurablescript.ScriptsCreator;
import ai.core.AI;
import ai.evaluation.SimpleSqrtEvaluationFunction3;
import rts.GameState;
import rts.PhysicalGameState;
import rts.PlayerAction;
import rts.units.UnitTypeTable;

public class Teste2Oraculo {

	public Teste2Oraculo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		UnitTypeTable utt = new UnitTypeTable();
		String path_map ="./maps/24x24/basesWorkers24x24A.xml";;
		PhysicalGameState pgs = PhysicalGameState.load(path_map, utt);
		GameState gs2 = new GameState(pgs, utt);
		
		
		AI adv = new WorkerRush(utt);
		
		int num=100;
		//if(args[0].equals("0"))num=10;
		//if(args[0].equals("1"))num=100;
		//if(args[0].equals("2"))num=500;
		//if(args[0].equals("3"))num=1000;
		//if(args[0].equals("4"))num=2000;
		
		//AI oraculo = new A3NWithin(num, -1, 100, 8, 0.3F, 0.0F, 0.4F, 0, adv,
		//	new SimpleSqrtEvaluationFunction3(), true, utt, "ManagerClosestEnemy", 3,
			//	decodeScripts(utt, "1;2;3;"), "A3N");
		
		
		AI oraculo = new RangedRush(utt);
		
		EstadoAcoes EAs = new EstadoAcoes(gs2,0,3000,oraculo,adv,true,true);
		EAs.salvar("RRvsWR", true);
		//EstadoAcoes EAs = new EstadoAcoes("A3NvsWR",true);
		
		
	}
	
	public static List<AI> decodeScripts(UnitTypeTable utt, String sScripts) {

		//decompõe a tupla
		ArrayList<Integer> iScriptsAi1 = new ArrayList<>();
		String[] itens = sScripts.split(";");

		for (String element : itens) {
			iScriptsAi1.add(Integer.decode(element));
		}

		List<AI> scriptsAI = new ArrayList<>();

		ScriptsCreator sc = new ScriptsCreator(utt, 300);
		ArrayList<BasicExpandedConfigurableScript> scriptsCompleteSet = sc.getScriptsMixReducedSet();

		iScriptsAi1.forEach((idSc) -> {
			scriptsAI.add(scriptsCompleteSet.get(idSc));
		});

		return scriptsAI;
	}

}
