package CLG_David;

import java.util.ArrayList;
import java.util.List;

import rts.GameState;
import rts.units.Unit;

public class S4 implements NodeU,NoTerminal {

	ChildS4 childS4;
	
	
	
	public S4(ChildS4 childS4) {
		super();
		this.childS4 = childS4;
	}

	public ChildS4 getChildS4() {
		return childS4;
	}

	public void setChildS4(ChildS4 childS4) {
		this.childS4 = childS4;
	}

	public S4() {
		// TODO Auto-generated constructor stub
		childS4=null;
	}

	@Override
	public String translate() {
		// TODO Auto-generated method stub
		if(this.childS4==null)return "S4";
		return this.childS4.translate();
	}



	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}



	
	
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "S4";
	}

	@Override
	public List<Node> Rules() {
		// TODO Auto-generated method stub
		List<Node>  l = new ArrayList<>();
		
		l.add(new S4G());
		l.add(new S4U());
		
		
		return l;
	}

	@Override
	public void interpret(GameState gs, int player, Interpreter automato) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void interpret(GameState gs, int player, Unit u, Interpreter automato) {
		// TODO Auto-generated method stub
		if (this.childS4==null)return;
		if (this.childS4 instanceof S4U)this.childS4.interpret(gs, player,u, automato);
		if (this.childS4 instanceof S4G)this.childS4.interpret(gs, player, automato);
		
	}

	@Override
	public String translateIndentation(int tap) {
		// TODO Auto-generated method stub
		String esp= "";
		for(int i =0; i<tap;i++)esp+="\t";
		if(this.childS4==null)return esp+"S4";
		return this.childS4.translateIndentation(tap);
	}

}
