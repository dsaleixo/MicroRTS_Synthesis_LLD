package LS_Actions;

import CFG_Actions.MoveAway;
import LS_CFG.ChildC_LS;
import LS_CFG.Node_LS;

public class MoveAway_LS extends MoveAway implements Node_LS,ChildC_LS  {

	public MoveAway_LS() {
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