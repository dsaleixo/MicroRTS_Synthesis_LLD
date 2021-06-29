package CLG_David;

import rts.GameState;
import rts.PhysicalGameState;
import rts.units.Unit;

public class For_S4_S1 implements ChildS1, Node {

	
	

	S4 s4;
	S1 s1;
	public For_S4_S1() {
		// TODO Auto-generated constructor stub
		s4 = new S4();
		s1= new S1();
	}

	public For_S4_S1(S4 s4, S1 s1) {
		// TODO Auto-generated constructor stub
		this.s4 = s4;
		this.s1= s1;
	}
	
	public S4 getS4() {
		return s4;
	}

	public void setS4(S4 s4) {
		this.s4 = s4;
	}

	public S1 getS1() {
		return s1;
	}

	public void setS1(S1 s1) {
		this.s1 = s1;
	}
	
	@Override
	public String translate() {
		// TODO Auto-generated method stub
		return "For(u){"+s4.translate()+"} "+ this.s1.translate();
	}

	

	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "For_S4_S1";
	}

	@Override
	public void interpret(GameState gs, int player, Interpreter automato) {
		// TODO Auto-generated method stub
		PhysicalGameState pgs = gs.getPhysicalGameState();
		for(Unit u:pgs.getUnits()) {

			if(this.s4!=null && u.getPlayer()==player)s4.interpret(gs, player,u, automato);

		 }
		
		if(this.s1!=null)s1.interpret(gs, player, automato);
		
	}

	@Override
	public String translateIndentation(int tap) {
		// TODO Auto-generated method stub
		String esp= "";
		for(int i =0; i<tap;i++)esp+="\t";
		return "For(u){\n"+
				s4.translateIndentation(tap+1)+"\n"+
				esp+"}\n"
				+ this.s1.translateIndentation(tap);
	}

}
