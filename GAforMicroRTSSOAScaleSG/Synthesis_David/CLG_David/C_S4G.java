package CLG_David;

import rts.GameState;

public class C_S4G implements Node, ChildS4G {

	
	C c;
	S4G s4g;
	
	public C_S4G() {
		// TODO Auto-generated constructor stub
		 c= new C();
		 s4g = new S4G();
	}

	public C_S4G(C c,S4G s4g) {
		// TODO Auto-generated constructor stub
		this.c = c;
		 this.s4g = s4g;
	}
	
	public C getC() {
		return c;
	}



	public void setC(C c) {
		this.c = c;
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
		return this.c.translate() + " "+this.s4g.translate();
	}

	

	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "C_S4G";
	}

	@Override
	public void interpret(GameState gs, int player, Interpreter automato) {
		// TODO Auto-generated method stub
		if (this.c!=null)this.c.interpret(gs, player, automato);
		if (this.s4g!=null)this.s4g.interpret(gs, player, automato);
		
	}

	@Override
	public String translateIndentation(int tap) {
		// TODO Auto-generated method stub
		return this.c.translateIndentation(tap) + "\n"+this.s4g.translateIndentation(tap);
	}

}
