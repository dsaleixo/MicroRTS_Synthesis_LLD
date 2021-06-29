package CLG_David;

import java.util.ArrayList;
import java.util.List;

import rts.GameState;
import rts.units.Unit;

public class CU implements NodeU,NoTerminal {

	ChildCU childCU;
	
	public CU() {
		// TODO Auto-generated constructor stub
		childCU =null;
	}

	
	
	
	public CU(ChildCU childCU) {
		super();
		this.childCU = childCU;
	}




	public ChildCU getChildCU() {
		return childCU;
	}




	public void setChildCU(ChildCU childCU) {
		this.childCU = childCU;
	}




	@Override
	public String translate() {
		// TODO Auto-generated method stub
		if(this.childCU==null)return "CU";
		return this.childCU.translate();
	}



	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}


	
	@Override
	public List<Node> Rules() {
		// TODO Auto-generated method stub
		List<Node>  l = new ArrayList<>();
		l.add(new KU_CU());
		l.add(new KU());
		l.add(new Empty());
		
		
		return l;
	}
	



	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "CU";
	}




	@Override
	public void interpret(GameState gs, int player, Interpreter automato) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void interpret(GameState gs, int player, Unit u, Interpreter automato) {
		// TODO Auto-generated method stub
		if (this.childCU!=null)this.childCU.interpret(gs, player,u, automato);
		
	}




	@Override
	public String translateIndentation(int tap) {
		// TODO Auto-generated method stub
		String esp= "";
		for(int i =0; i<tap;i++)esp+="\t";
		if(this.childCU==null)return esp+"CU";
		return this.childCU.translateIndentation(tap);
	}

}
