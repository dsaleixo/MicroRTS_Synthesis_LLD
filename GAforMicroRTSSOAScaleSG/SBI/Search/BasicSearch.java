package Search;

import java.util.List;
import java.util.Random;

import CFG.Factory;
import CFG.Node;
import EvaluateGameState.Playout;
import LS_CFG.Empty_LS;
import LS_CFG.Node_LS;
import LS_CFG.S_LS;
import SBI_CFG.Node_SBI;
import ai.core.AI;
import rts.GameState;
import util.Pair;

public class BasicSearch {

	Factory f;
	boolean use_cleanr;
	
	
	Random r =new Random();

	
	long tempo_ini;
	
	public BasicSearch() {
		// TODO Auto-generated constructor stub
	}

	
	public void run(GameState gs,List<Node_SBI> sAI0,List<Node_SBI> sAI1, int max_cicle,long max_seg) throws Exception {
		// TODO Auto-generated method stub
		
		long Tini = System.currentTimeMillis();
		long paraou = System.currentTimeMillis()-Tini;
		
	
		while( (paraou*1.0)/1000.0 <max_seg) {
			
			
			
			
			
		}
		
		
		
	}
	
}
