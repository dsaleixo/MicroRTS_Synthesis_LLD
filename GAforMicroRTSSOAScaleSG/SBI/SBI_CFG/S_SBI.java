package SBI_CFG;

import java.util.Random;

import CFG.ChildS;
import CFG.S;
import LS_CFG.C_LS;
import LS_CFG.Empty_LS;
import LS_CFG.For_S_LS;
import LS_CFG.If_B_then_S_LS;
import LS_CFG.If_B_then_S_else_S_LS;
import LS_CFG.Node_LS;
import LS_CFG.S_S_LS;

public class S_SBI extends S implements Node_SBI, NoTerminal_SBI {

	public S_SBI() {
		// TODO Auto-generated constructor stub
	}

	public S_SBI(ChildS child) {
		super(child);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Node_LS sorteiaFilho(int budget) {
		// TODO Auto-generated method stub
		int op=0;
		if(budget>=1)op=1;
		if(budget>=2)op=3;
		if(budget>=3)op=4;
		if(budget>=4)op=5;
		
		
		if(op==0)return  new Empty_LS();
		
		Random gerador = new Random();
		
		int g = gerador.nextInt(op);

		if(g==0) return new C_LS();
		if(g==1) return new S_S_LS();
		if(g==2) return new For_S_LS();
		if(g==3) return new If_B_then_S_LS();
		if(g==4) return new If_B_then_S_else_S_LS();

		return  new Empty_LS();
		
		
	}

	@Override
	public void sample(int budget) {
		// TODO Auto-generated method stub
		Node_LS child = this.sorteiaFilho(budget);
		child.sample(budget );
		this.setChild((ChildS) child);
		
	}

	public void sample(int budget,Node_LS n) {
		// TODO Auto-generated method stub
		Node_LS child = this.sorteiaFilho(budget);
		child.sample(budget );
		
		if(child instanceof S_S_LS) {
			Random r = new Random();
			if(r.nextFloat()>0.5)((S_S_LS)child).getRightS().setChild((ChildS) n);
			else ((S_S_LS)child).getLeftS().setChild((ChildS) n);
		}
		if(child instanceof If_B_then_S_else_S_LS) {
			Random r = new Random();
			if(r.nextFloat()>0.5)((If_B_then_S_else_S_LS)child).getElse_S().setChild((ChildS) n);
			else ((If_B_then_S_else_S_LS)child).getThen_S().setChild((ChildS) n);
		}
		if(child instanceof If_B_then_S_LS) {
			((If_B_then_S_LS)child).getS().setChild((ChildS)n);
		}
		if(child instanceof For_S_LS) {
			 ((For_S_LS)child).getChild().setChild((ChildS)n);
		}
		this.setChild((ChildS) child);
		
	}
	
	@Override
	public int countNode() {
		// TODO Auto-generated method stub
		Node_LS n = (Node_LS)this.getChild();
		return 1 + n.countNode();
	}

	@Override
	public void mutation(int node_atual, int budget) {
		// TODO Auto-generated method stub
		if(node_atual==0) {
			Node_LS n = (Node_LS)this.getChild();
			Random r = new Random();
			if(r.nextFloat()>0.5)this.sample(budget);
			else this.sample(budget,n);
		}
		else {
			Node_LS n = (Node_LS)this.getChild();
			node_atual-=1;
			n.mutation(node_atual, budget);
			
		}
	}

}
