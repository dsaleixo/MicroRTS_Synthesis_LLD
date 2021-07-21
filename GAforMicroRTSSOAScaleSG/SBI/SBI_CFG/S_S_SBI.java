package SBI_CFG;
import CFG.S;
import CFG.S_S;
import LS_CFG.Node_LS;
import LS_CFG.S_LS;

public class S_S_SBI extends S_S implements Node_SBI, ChildS_SBI {

	public S_S_SBI() {
		// TODO Auto-generated constructor stub
	}

	public S_S_SBI(S leftS, S rightS) {
		super(leftS, rightS);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sample(int budget) {
		// TODO Auto-generated method stub
		S_LS s1 = new S_LS();
		s1.sample(budget/2);
		this.setLeftS(s1);
		S_LS s2 = new S_LS();
		s2.sample(budget/2);
		this.setRightS(s2);
	}

	@Override
	public int countNode() {
		// TODO Auto-generated method stub
		Node_LS n1 = (Node_LS)this.getLeftS();
		Node_LS n2 = (Node_LS)this.getRightS();
		return 1 + n1.countNode()+ n2.countNode();
	}

	@Override
	public void mutation(int node_atual, int budget) {
		// TODO Auto-generated method stub
		if(node_atual==0)this.sample(budget);
		else {
			Node_LS n = (Node_LS)this.getLeftS();
			node_atual-=1;
			n.mutation(node_atual, budget);
			Node_LS n2 = (Node_LS)this.getRightS();
			node_atual-=1;
			n2.mutation(node_atual, budget);
			
		}
	}

}
