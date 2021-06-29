package CLG_David;

import java.util.ArrayList;
import java.util.List;

import rts.GameState;

public class S5 implements Node,NoTerminal {

	ChildS5 childS5;
	
	public ChildS5 getChildS5() {
		return childS5;
	}

	
	
	
	
	public S5(ChildS5 childS5) {
		super();
		this.childS5 = childS5;
	}





	public void setChildS5(ChildS5 childS5) {
		this.childS5 = childS5;
	}

	public S5() {
		// TODO Auto-generated constructor stub
		childS5=null;
	}

	@Override
	public String translate() {
		// TODO Auto-generated method stub
		if(this.childS5==null)return "S5";
		return this.childS5.translate();
	}



	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "S5";
	}
	
	
	@Override
	public List<Node> Rules() {
		// TODO Auto-generated method stub
		List<Node>  l = new ArrayList<>();
		
		l.add(new NotB());
		l.add(new B());
	
		return l;
	}


	boolean getValue() {
		return childS5.getValue();
	}


	@Override
	public void interpret(GameState gs, int player, Interpreter automato) {
		// TODO Auto-generated method stub
		if (this.childS5!=null)this.childS5.interpret(gs, player, automato );
		
	}





	@Override
	public String translateIndentation(int tap) {
		// TODO Auto-generated method stub
		if(this.childS5==null)return "S5";
		return this.childS5.translate();
	}

}
