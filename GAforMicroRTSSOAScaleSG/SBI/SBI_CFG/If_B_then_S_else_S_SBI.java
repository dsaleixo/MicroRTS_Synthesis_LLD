package SBI_CFG;

import CFG.B;
import CFG.If_B_then_S_else_S;
import CFG.S;
import LS_CFG.B_LS;
import LS_CFG.Node_LS;
import LS_CFG.S_LS;

public class If_B_then_S_else_S_SBI extends If_B_then_S_else_S implements Node_SBI, ChildS_SBI {

	public If_B_then_S_else_S_SBI() {
		// TODO Auto-generated constructor stub
	}

	public If_B_then_S_else_S_SBI(B b, S then_S, S else_S) {
		super(b, then_S, else_S);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sample(int budget) {
		// TODO Auto-generated method stub
		B_LS b = new B_LS();
		int aux = budget/2 -1;
		b.sample(1);
		this.setB(b);
		S_LS s1 = new S_LS();
		s1.sample(aux);
		this.setThen_S(s1);
		S_LS s2 = new S_LS();
		s2.sample(aux);
		this.setElse_S(s2);

	}

	@Override
	public int countNode() {
		// TODO Auto-generated method stub
		Node_LS n1 = (Node_LS)this.getB();
		Node_LS n2 = (Node_LS)this.getThen_S();
		Node_LS n3 = (Node_LS)this.getElse_S();
		return 1 + n1.countNode()+ n2.countNode() + n3.countNode();
	}

	@Override
	public void mutation(int node_atual, int budget) {
		// TODO Auto-generated method stub
		if(node_atual==0)this.sample(budget);
		else {
			Node_LS n = (Node_LS)this.getB();
			node_atual-=1;
			n.mutation(node_atual, budget);
			Node_LS n2 = (Node_LS)this.getThen_S();
			node_atual-=1;
			n2.mutation(node_atual, budget);
			Node_LS n3 = (Node_LS)this.getElse_S();
			node_atual-=1;
			n3.mutation(node_atual, budget);
			
		}
	}


}
