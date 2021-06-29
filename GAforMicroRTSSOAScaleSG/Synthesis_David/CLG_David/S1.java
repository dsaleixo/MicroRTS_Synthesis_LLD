package CLG_David;

import java.util.ArrayList;
import java.util.List;

import rts.GameState;

public class S1 implements Node,NoTerminal {

	ChildS1 childS1;	
	
	public S1(ChildS1 childS1) {
		// TODO Auto-generated constructor stub
		this.childS1= childS1;
	}
	
	public S1() {
		// TODO Auto-generated constructor stub
		childS1= null;
	}
	
	public ChildS1 getChildS1() {
		return childS1;
	}

	public void setChildS1(ChildS1 childS1) {
		this.childS1 = childS1;
	}

	

	@Override
	public String translate() {
		// TODO Auto-generated method stub
		
		if(this.childS1==null)return "S1";
		return this.childS1.translate();
	}

	@Override
	public void interpret(GameState gs,int player, Interpreter automato) {
		// TODO Auto-generated method stub
		if(this.childS1!=null)childS1.interpret(gs, player, automato);

	}

	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "S1";
	}

	@Override
	public List<Node> Rules() {
		// TODO Auto-generated method stub
		List<Node>  l = new ArrayList<>();
		
		l.add(new S4G_S1());
		l.add(new For_S4_S1());
		l.add(new Empty());
		
		return l;
	}

	@Override
	public String translateIndentation(int tap) {
		// TODO Auto-generated method stub
		String esp= "";
		for(int i =0; i<tap;i++)esp+="\t";
		if(this.childS1==null)return esp+"S1";
		return this.childS1.translateIndentation(tap);
	}

	

}
