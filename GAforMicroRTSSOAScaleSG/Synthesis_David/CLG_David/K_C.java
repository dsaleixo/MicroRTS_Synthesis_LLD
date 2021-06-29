package CLG_David;

import rts.GameState;

public class K_C implements ChildC, Node {

	
	K k;
	C c;
	
	public K_C() {
		// TODO Auto-generated constructor stub
		k = new K();
		c = new C();
	}

	
	
	
	
	public K_C(K k, C c) {
		super();
		this.k = k;
		this.c = c;
	}





	public K getK() {
		return k;
	}





	public void setK(K k) {
		this.k = k;
	}





	public C getC() {
		return c;
	}





	public void setC(C c) {
		this.c = c;
	}





	@Override
	public String translate() {
		// TODO Auto-generated method stub
		return this.k.translate() + " " + this.c.translate();
	}



	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}





	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "K_C";
	}





	@Override
	public void interpret(GameState gs, int player, Interpreter automato) {
		// TODO Auto-generated method stub
		if (this.k!=null)this.k.interpret(gs, player, automato);
		if (this.c!=null)this.c.interpret(gs, player, automato);
		
	}





	@Override
	public String translateIndentation(int tap) {
		// TODO Auto-generated method stub
		return this.k.translateIndentation(tap) + "\n" + this.c.translateIndentation(tap);
	}

}
