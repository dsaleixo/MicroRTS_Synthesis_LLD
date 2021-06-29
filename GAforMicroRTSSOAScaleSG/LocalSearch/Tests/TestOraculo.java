package Tests;

import java.util.ArrayList;
import java.util.List;

import AIs.Interpreter;
import Oraculo.Oraculo;
import ai.RandomBiasedAI;
import ai.CMAB.A3NWithin;
import ai.abstraction.WorkerRush;
import ai.configurablescript.BasicExpandedConfigurableScript;
import ai.configurablescript.ScriptsCreator;
import ai.core.AI;
import ai.evaluation.SimpleSqrtEvaluationFunction3;
import ajuda.ScriptsFactory;
import rts.GameState;
import rts.PhysicalGameState;
import rts.units.UnitTypeTable;

public class TestOraculo {

	public TestOraculo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		UnitTypeTable utt = new UnitTypeTable();
		String path_map ="./maps/24x24/basesWorkers24x24A.xml";
		PhysicalGameState pgs = PhysicalGameState.load(path_map, utt);
		GameState gs2 = new GameState(pgs, utt);
		AI adv = new WorkerRush(utt);
		AI oraculo = new A3NWithin(100, -1, 100, 8, 0.3F, 0.0F, 0.4F, 0, adv,
				new SimpleSqrtEvaluationFunction3(), true, utt, "ManagerClosestEnemy", 3,
				decodeScripts(utt, "1;2;3;"), "A3N");
		AI adv2 = new WorkerRush(utt);
		List<GameState> gss = Oraculo.gerar(gs2,0,3000,adv2,adv,false);
		Oraculo.reproduz(gss);
		
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
