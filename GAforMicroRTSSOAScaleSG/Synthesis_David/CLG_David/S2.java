package CLG_David;

import java.util.ArrayList;
import java.util.List;

import rts.GameState;

public class S2 implements Node,NoTerminal {

	ChildS2  childS2;
	
	
	public S2() {
		// TODO Auto-generated constructor stub
		childS2=null;
	}

	public S2(ChildS2 childS2) {
		// TODO Auto-generated constructor stub
		this.childS2=childS2;
	}

	
	public ChildS2 getChildS2() {
		return childS2;
	}

	public void setChildS2(ChildS2 childS2) {
		this.childS2 = childS2;
	}



	@Override
	public String translate() {
		// TODO Auto-generated method stub
		if(this.childS2==null)return "S2";
		return this.childS2.translate();
	}

	

	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "S2";
	}

	@Override
	public List<Node> Rules() {
		// TODO Auto-generated method stub
		List<Node>  l = new ArrayList<>();
		
		l.add(new If_S5_then_S4G());
		l.add(new If_B_then_S4G_else_S4G());
		
		
		return l;
	}

	@Override
	public void interpret(GameState gs, int player, Interpreter automato) {
		// TODO Auto-generated method stub
		if (this.childS2!=null)this.childS2.interpret(gs, player, automato);
	}

	@Override
	public String translateIndentation(int tap) {
		// TODO Auto-generated method stub
		String esp= "";
		for(int i =0; i<tap;i++)esp+="\t";
		if(this.childS2==null)return esp+"S2";
		return this.childS2.translateIndentation(tap);
	}

}
