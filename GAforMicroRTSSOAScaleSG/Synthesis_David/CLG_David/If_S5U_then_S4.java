package CLG_David;

import rts.GameState;
import rts.units.Unit;

public class If_S5U_then_S4 implements  ChildS2U {

	S5U s5u;
	S4 s4;
	
	public If_S5U_then_S4() {
		// TODO Auto-generated constructor stub
		s5u = new S5U();
		s4= new S4();
	}

	
	public If_S5U_then_S4(S5U s5u,S4 s4) {
		// TODO Auto-generated constructor stub
		this.s5u = s5u;
		this.s4= s4;
	}

	
	
	public S5U getS5u() {
		return s5u;
	}





	public void setS5u(S5U s5u) {
		this.s5u = s5u;
	}





	public S4 getS4() {
		return s4;
	}





	public void setS4(S4 s4) {
		this.s4 = s4;
	}





	@Override
	public String translate() {
		// TODO Auto-generated method stub
		return "if ( "+ this.s5u.translate()+" ) then { "+this.s4.translate()+" }";
	}



	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "if_S5U_then_S4";
	}


	@Override
	public void interpret(GameState gs, int player, Unit u, Interpreter automato) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void interpret(GameState gs, int player, Interpreter automato) {
		// TODO Auto-generated method stub
		s5u.interpret(gs, player, automato);
		
		boolean bool = s5u.getValue();
		
		
		if(bool) {
			if (this.s4!=null)this.s4.interpret(gs, player, automato);
		}
		
		
	}


	@Override
	public String translateIndentation(int tap) {
		// TODO Auto-generated method stub
		String esp= "";
		for(int i =0; i<tap;i++)esp+="\t";
		return esp+"if ( "+ this.s5u.translate()+" ) then {\n"
				+this.s4.translateIndentation(tap+1)+"\n"+
				esp+"}";
	
	}




}
