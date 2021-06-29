package CLG_David;

import java.util.ArrayList;
import java.util.List;

import rts.GameState;
import rts.units.Unit;

public class S4G implements ChildS4,Node,NoTerminal {

	ChildS4G  childS4G;
	
	
	
	

	public S4G(ChildS4G childS4G) {
		// TODO Auto-generated constructor stub
		this.childS4G = childS4G;
	}
	
	public ChildS4G getChildS4G() {
		return childS4G;
	}

	public void setChildS4G(ChildS4G childS4G) {
		this.childS4G = childS4G;
	}

	public S4G() {
		// TODO Auto-generated constructor stub
		childS4G=null;
	}

	@Override
	public String translate() {
		// TODO Auto-generated method stub
		if(this.childS4G==null)return "S4G";
		return this.childS4G.translate();
	}

	

	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "S4G";
	}

	@Override
	public List<Node> Rules() {
		// TODO Auto-generated method stub
		List<Node>  l = new ArrayList<>();
		
		l.add(new C_S4G());
		l.add(new S2_S4G());
		l.add(new Empty());
		
		
		return l;
	}



	@Override
	public void interpret(GameState gs, int player, Interpreter automato) {
		// TODO Auto-generated method stub
		if (this.childS4G!=null)this.childS4G.interpret(gs, player, automato);
		
	}

	@Override
	public void interpret(GameState gs, int player, Unit u, Interpreter automato) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String translateIndentation(int tap) {
		// TODO Auto-generated method stub
		String esp= "";
		for(int i =0; i<tap;i++)esp+="\t";
		if(this.childS4G==null)return esp+"S4G";
		return this.childS4G.translateIndentation(tap);
	}

	

}
