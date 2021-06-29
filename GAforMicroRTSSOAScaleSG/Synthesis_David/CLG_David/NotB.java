package CLG_David;

import rts.GameState;

public class NotB implements ChildS5, Node {

	B b;
	
	
	
	public NotB(B b) {
		super();
		this.b = b;
	}

	public NotB() {
		// TODO Auto-generated constructor stub
		b = new B();
	}

	@Override
	public String translate() {
		// TODO Auto-generated method stub
		if(this.b==null)return "not B";
		return "not "+this.b.translate();
	}

	
	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getValue() {
		// TODO Auto-generated method stub
		return this.b.getValue() == false;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "NotB";
	}

	@Override
	public void interpret(GameState gs, int player, Interpreter automato) {
		// TODO Auto-generated method stub
		if(this.b==null)this.b.getValue();
		
	}

	@Override
	public String translateIndentation(int tap) {
		// TODO Auto-generated method stub
		if(this.b==null)return "not B";
		return "not "+this.b.translateIndentation(tap);
	}

}
