package SBI_Actions;

import java.util.List;

import AIs.Interpreter;
import CFG.ChildC;
import CFG.Factory;
import CFG.Node;
import CFG_Actions.Harvest;
import SBI_CFG.ChildC_SBI;
import SBI_CFG.Node_SBI;
import rts.GameState;
import rts.units.Unit;

public class Harvest_SBI extends Harvest implements Node_SBI, ChildC_SBI {

	public Harvest_SBI() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sample(int budget) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public int countNode() {
		// TODO Auto-generated method stub
		return 1;
	}
	@Override
	public void mutation(int node_atual, int budget) {
		// TODO Auto-generated method stub
		if(node_atual==0)this.sample(budget);
	}

}
