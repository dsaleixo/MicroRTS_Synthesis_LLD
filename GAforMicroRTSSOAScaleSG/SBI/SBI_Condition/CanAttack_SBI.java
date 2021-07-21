package SBI_Condition;

import CFG_Condition.CanAttack;
import SBI_CFG.ChildB_SBI;
import SBI_CFG.Node_SBI;

public class CanAttack_SBI extends CanAttack implements ChildB_SBI, Node_SBI {

	public CanAttack_SBI() {
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
