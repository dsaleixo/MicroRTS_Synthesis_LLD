package SBI_Actions;

import CFG_Actions.Idle;
import SBI_CFG.ChildC_SBI;
import SBI_CFG.Node_SBI;

public class Idle_SBI extends Idle implements ChildC_SBI, Node_SBI {

	public Idle_SBI() {
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
