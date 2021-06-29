package CLG_David;

import java.util.ArrayList;
import java.util.List;

import rts.GameState;
import rts.units.Unit;

public class BU implements  ChildS5U,ChildS3,ChildBU, NoTerminal {

	ChildBU childBU;
	public BU() {
		// TODO Auto-generated constructor stub
		childBU=null;
	}

	
	
	public BU(ChildBU childBU) {
		super();
		this.childBU = childBU;
	}



	public ChildBU getChildBU() {
		return childBU;
	}



	public void setChildBU(ChildBU childBU) {
		this.childBU = childBU;
	}



	@Override
	public String translate() {
		// TODO Auto-generated method stub
		if(this.childBU==null)return "BU";
		return this.childBU.translate();
	}



	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}





	@Override
	public boolean getValue() {
		// TODO Auto-generated method stub
	
		return this.childBU.getValue();
	}

	@Override
	public List<Node> Rules() {
		// TODO Auto-generated method stub
		List<Node>  l = new ArrayList<>();
		
		
		l.add(new HasUnitWithinDistanceFromOpponent());
		
		
		return l;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "BU";
	}



	@Override
	public void interpret(GameState gs, int player, Interpreter automato) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void interpret(GameState gs, int player, Unit u, Interpreter automato) {
		// TODO Auto-generated method stub
	
		if (this.childBU!=null)this.childBU.interpret(gs, player,u, automato);
		
		
	}



	@Override
	public String translateIndentation(int tap) {
		// TODO Auto-generated method stub
		return this.translate();
	}

}
