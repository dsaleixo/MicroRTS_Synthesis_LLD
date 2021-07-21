package SBI_CFG;

import CFG.B;
import CFG.If_B_then_S;
import CFG.S;
import LS_CFG.B_LS;
import LS_CFG.Node_LS;
import LS_CFG.S_LS;

public class If_B_then_S_SBI extends If_B_then_S implements Node_SBI {

	public If_B_then_S_SBI() {
		// TODO Auto-generated constructor stub
	}

	public If_B_then_S_SBI(B b, S s) {
		super(b, s);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sample(int budget) {
		// TODO Auto-generated method stub
		B_LS b = new B_LS();
		b.sample(1);
		this.setB(b);
		S_LS s1 = new S_LS();
		s1.sample(budget-2);
		this.setS(s1);
		
	}

	@Override
	public int countNode() {
		// TODO Auto-generated method stub
		Node_LS n1 = (Node_LS)this.getB();
		Node_LS n2 = (Node_LS)this.getS();
		return 1 + n1.countNode()+ n2.countNode();
	}

	@Override
	public void mutation(int node_atual, int budget) {
		// TODO Auto-generated method stub
		if(node_atual==0)this.sample(budget);
		else {
			Node_LS n = (Node_LS)this.getB();
			node_atual-=1;
			n.mutation(node_atual, budget);
			Node_LS n2 = (Node_LS)this.getS();
			node_atual-=1;
			n2.mutation(node_atual, budget);
			
		}
	}
	

}
