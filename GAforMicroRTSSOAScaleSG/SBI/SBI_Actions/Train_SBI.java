package SBI_Actions;

import java.util.List;
import java.util.Random;

import CFG.Direction;
import CFG.Type;
import CFG_Actions.Train;
import SBI_CFG.ChildC_SBI;
import SBI_CFG.Node_SBI;

public class Train_SBI extends Train implements ChildC_SBI, Node_SBI {

	public Train_SBI() {
		// TODO Auto-generated constructor stub
	}

	public Train_SBI(Type type, Direction direc) {
		super(type, direc);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sample(int budget) {
		// TODO Auto-generated method stub
		Type type = new Type();
		Direction direc = new Direction();
		
		List<String> l1 = type.Rules();
		Random gerador = new Random();
		int g = gerador.nextInt(l1.size());
		type.setType(l1.get(g));
		this.setType(type);
		
		List<String> l2 = direc.Rules();
		g = gerador.nextInt(l2.size());
		direc.setDirection(l2.get(g));
		this.setDirec(direc);
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
