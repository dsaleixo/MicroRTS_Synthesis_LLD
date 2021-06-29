package LS_Actions;

import java.util.List;
import java.util.Random;

import CFG.Direction;
import CFG.Type;
import CFG_Actions.Build;
import LS_CFG.ChildC_LS;
import LS_CFG.Node_LS;

public class Build_LS extends Build implements Node_LS,ChildC_LS  {

	public Build_LS() {
		// TODO Auto-generated constructor stub
	}

	public Build_LS(Type type, Direction direc) {
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
