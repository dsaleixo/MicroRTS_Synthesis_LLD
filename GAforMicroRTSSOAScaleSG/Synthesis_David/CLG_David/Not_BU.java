package CLG_David;

import rts.GameState;
import rts.units.Unit;

public class Not_BU implements ChildS5U, NodeU {

	BU b;
	public Not_BU() {
		// TODO Auto-generated constructor stub
		b = new BU();
	}

	
	
	
	
	
	public Not_BU(BU b) {
		super();
		this.b = b;
	}






	public BU getB() {
		return b;
	}






	public void setB(BU b) {
		this.b = b;
	}






	@Override
	public String translate() {
		// TODO Auto-generated method stub
		if(this.b==null)return " not BU";
		return " not  "+this.b.translate();
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
		return "Not_BU";
	}






	@Override
	public void interpret(GameState gs, int player, Interpreter automato) {
		// TODO Auto-generated method stub
		
	}






	@Override
	public void interpret(GameState gs, int player, Unit u, Interpreter automato) {
		// TODO Auto-generated method stub
		if(this.b==null)this.b.interpret(gs, player, u, automato);
	}






	@Override
	public String translateIndentation(int tap) {
		// TODO Auto-generated method stub
		if(this.b==null)return " not BU";
		return " not  "+this.b.translateIndentation(tap);
	}

}
