package CLG_David;

import rts.GameState;
import rts.units.Unit;

public class S2U_S4U implements ChildS4U, NodeU {

	
	S2U s2u;
	S4U s4u;
	
	
	public S2U_S4U() {
		// TODO Auto-generated constructor stub
		s2u=null;
		s4u=null;
	}

	
	
	
	public S2U_S4U(S2U s2u, S4U s4u) {
		super();
		this.s2u = s2u;
		this.s4u = s4u;
	}




	public S2U getS2u() {
		return s2u;
	}




	public void setS2u(S2U s2u) {
		this.s2u = s2u;
	}




	public S4U getS4u() {
		return s4u;
	}




	public void setS4u(S4U s4u) {
		this.s4u = s4u;
	}




	@Override
	public String translate() {
		// TODO Auto-generated method stub
		return this.s2u.translate()+" "+this.s4u.translate();
	}




	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}





	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "S2U_S4U";
	}




	@Override
	public void interpret(GameState gs, int player, Interpreter automato) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void interpret(GameState gs, int player, Unit u, Interpreter automato) {
		// TODO Auto-generated method stub
		if (this.s2u!=null)this.s2u.interpret(gs, player,u, automato);
		if (this.s4u!=null)this.s4u.interpret(gs, player,u, automato);
		
	}




	@Override
	public String translateIndentation(int tap) {
		// TODO Auto-generated method stub
		return this.s2u.translateIndentation(tap)+"\n"+this.s4u.translateIndentation(tap);
	}

}
