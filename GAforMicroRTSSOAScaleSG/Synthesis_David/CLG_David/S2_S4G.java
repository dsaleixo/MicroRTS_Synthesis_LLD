package CLG_David;

import rts.GameState;

public class S2_S4G implements ChildS4G, Node {

	
	S2 s2;
	S4G s4g;
	
	public S2_S4G() {
		// TODO Auto-generated constructor stub
		s2 = new S2();
		s4g = new S4G();
	}

	
	
	
	public S2_S4G(S2 s2, S4G s4g) {
		super();
		this.s2 = s2;
		this.s4g = s4g;
	}




	public S2 getS2() {
		return s2;
	}



	public void setS2(S2 s2) {
		this.s2 = s2;
	}



	public S4G getS4g() {
		return s4g;
	}



	public void setS4g(S4G s4g) {
		this.s4g = s4g;
	}



	@Override
	public String translate() {
		// TODO Auto-generated method stub
		return this.s2.translate()+" "+ this.s4g.translate();
	}

	

	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "S2_S4G";
	}




	@Override
	public void interpret(GameState gs, int player, Interpreter automato) {
		// TODO Auto-generated method stub
		if (this.s2!=null)this.s2.interpret(gs, player, automato);
		if (this.s4g!=null)this.s4g.interpret(gs, player, automato);
		
	}




	@Override
	public String translateIndentation(int tap) {
		// TODO Auto-generated method stub
		return this.s2.translateIndentation(tap)+"\n"+ this.s4g.translateIndentation(tap);
	}

}
