package CLG_David;

import java.util.ArrayList;
import java.util.List;

import rts.GameState;
import rts.units.Unit;

public class S2U implements NodeU,NoTerminal {

	ChildS2U s2u;
	public ChildS2U getS2u() {
		return s2u;
	}

	public void setS2u(ChildS2U s2u) {
		this.s2u = s2u;
	}

	public S2U() {
		// TODO Auto-generated constructor stub
		s2u = null;
	}

	public S2U(ChildS2U s2u) {
		// TODO Auto-generated constructor stub
		this.s2u = s2u;
	}
	
	@Override
	public String translate() {
		// TODO Auto-generated method stub
		if(this.s2u==null)return "S2U";
		return s2u.translate();
	}

	

	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "S2U";
	}

	@Override
	public List<Node> Rules() {
		// TODO Auto-generated method stub
		List<Node>  l = new ArrayList<>();
		
		l.add(new If_S5U_then_S4());
		l.add(new If_S3_then_S4_else_S4());
		
		
		return l;
	}

	@Override
	public void interpret(GameState gs, int player, Interpreter automato) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void interpret(GameState gs, int player, Unit u, Interpreter automato) {
		// TODO Auto-generated method stub
		if (this.s2u!=null)this.s2u.interpret(gs, player,u, automato);
		
	}

	@Override
	public String translateIndentation(int tap) {
		// TODO Auto-generated method stub
		String esp= "";
		for(int i =0; i<tap;i++)esp+="\t";
		if(this.s2u==null)return esp+"S2U";
		return this.s2u.translateIndentation(tap);
	}

}
