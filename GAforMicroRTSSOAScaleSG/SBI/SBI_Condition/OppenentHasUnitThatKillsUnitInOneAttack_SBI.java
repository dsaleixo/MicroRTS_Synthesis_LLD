package SBI_Condition;

import CFG_Condition.OpponentHasUnitThatKillsUnitInOneAttack;
import SBI_CFG.ChildB_SBI;
import SBI_CFG.ChildC_SBI;
import SBI_CFG.Node_SBI;

public class OppenentHasUnitThatKillsUnitInOneAttack_SBI extends OpponentHasUnitThatKillsUnitInOneAttack
		implements ChildB_SBI, Node_SBI {

	public OppenentHasUnitThatKillsUnitInOneAttack_SBI() {
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
