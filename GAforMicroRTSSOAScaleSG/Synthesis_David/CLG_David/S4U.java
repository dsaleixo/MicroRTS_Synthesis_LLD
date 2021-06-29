package CLG_David;

import java.util.ArrayList;
import java.util.List;

import rts.GameState;
import rts.units.Unit;

public class S4U implements NodeU,NoTerminal,ChildS4 {

	ChildS4U childs4u;
	
	public S4U() {
		// TODO Auto-generated constructor stub
		childs4u=null;
	}

	
	
	
	public S4U(ChildS4U childs4u) {
		super();
		this.childs4u = childs4u;
	}




	public ChildS4U getChilds4u() {
		return childs4u;
	}




	public void setChilds4u(ChildS4U childs4u) {
		this.childs4u = childs4u;
	}




	@Override
	public String translate() {
		// TODO Auto-generated method stub
		if(this.childs4u==null)return "S4U";
		return this.childs4u.translate();
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
		
		l.add(new CU_S4U());
		l.add(new S2U_S4U());
		l.add(new Empty());
		
		
		return l;
	}



	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "S4U";
	}




	@Override
	public void interpret(GameState gs, int player, Interpreter automato) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void interpret(GameState gs, int player, Unit u, Interpreter automato) {
		if (this.childs4u!=null)this.childs4u.interpret(gs, player,u, automato);
		
	}




	@Override
	public String translateIndentation(int tap) {
		// TODO Auto-generated method stub
		String esp= "";
		for(int i =0; i<tap;i++)esp+="\t";
		if(this.childs4u==null)return esp+"S4U";
		return this.childs4u.translateIndentation(tap);
	}

}
