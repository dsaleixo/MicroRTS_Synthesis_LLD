package CLG_David;

import java.util.ArrayList;
import java.util.List;

import rts.GameState;
import rts.units.Unit;

public class B implements ChildS5,Node,ChildS3,NoTerminal {

	ChildB childB;
	
	
	
	
	public B(ChildB childB) {
		super();
		this.childB = childB;
	}

	public ChildB getChildB() {
		return childB;
	}

	public void setChildB(ChildB childB) {
		this.childB = childB;
	}

	public B() {
		// TODO Auto-generated constructor stub
		childB=null;
	}

	@Override
	public String translate() {
		// TODO Auto-generated method stub
		if(this.childB==null)return "B";
		return this.childB.translate();
	}

	

	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getValue() {
		// TODO Auto-generated method stub
		
		return this.childB.getValue();

	}

	@Override
	public List<Node> Rules() {
		// TODO Auto-generated method stub
		List<Node>  l = new ArrayList<>();
		
		
		l.add(new HasNumberOfUnits());
		l.add(new HasNumberOfWorkersHarvesting());
		l.add(new HaveQtdUnitsAttacking());
		
		return l;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "B";
	}

	@Override
	public void interpret(GameState gs, int player, Interpreter automato) {
		// TODO Auto-generated method stub
		if (this.childB!=null)this.childB.interpret(gs, player, automato);
		
	}

	@Override
	public void interpret(GameState gs, int player, Unit u, Interpreter automato) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String translateIndentation(int tap) {
		// TODO Auto-generated method stub
		return this.translate();
	}

}
