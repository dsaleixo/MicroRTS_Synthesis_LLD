package Tests;

import java.util.List;
import java.util.Random;

import AIs.Interpreter;
import CFG.Node;
import EvaluateGameState.CabocoDagua;
import EvaluateGameState.Cego;
import EvaluateGameState.EvaluateGS;
import EvaluateGameState.LTD3;
import EvaluateGameState.Perfect;
import EvaluateGameState.Playout;
import EvaluateGameState.SimplePlayout;
import Evaluations.Evaluation;
import Evaluations.Kakashi;
import Evaluations.SimplesEvaluations;

import IAs.LSBasic;
import IAs.Search;
import LS_CFG.*;
import Oraculo.Oraculo;
import Util.ScriptsFactory;
import ai.abstraction.LightRush;
import ai.abstraction.WorkerRush;
import ai.core.AI;
import rts.GameState;
import rts.PhysicalGameState;
import rts.units.UnitTypeTable;
import util.Pair;

public class Test1 {

	public Test1() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		UnitTypeTable utt = new UnitTypeTable();
		String path_map ="./maps/24x24/basesWorkers24x24A.xml";
		PhysicalGameState pgs = PhysicalGameState.load(path_map, utt);
		GameState gs2 = new GameState(pgs, utt);
		
		
		
		AI adv = new WorkerRush(utt);
		EvaluateGS eval = null;
		if(args[0].equals("0")) {
			List<GameState> gss2= Oraculo.carregar("oraculo2");
			eval = new Perfect(gss2);
		}
		if(args[0].equals("1"))eval = new LTD3();
		if(args[0].equals("2"))eval = new Cego();
		if(args[0].equals("3")) {
			List<GameState> gss2= Oraculo.carregar("oraculo2");
			eval = new CabocoDagua(gss2,0);
			((CabocoDagua)eval).oraculo.imprimir();
		}
		
		Playout playout = new SimplePlayout(eval);
		Search search = new LSBasic(true,adv,playout);
		Node n = search.run(gs2, 5000);
		System.out.println("FIM");
		System.out.println(n.translateIndentation(0));
	}

}
