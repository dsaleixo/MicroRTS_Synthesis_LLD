package CLG_David;

import rts.GameState;

public class If_B_then_S4G_else_S4G implements  ChildS2 {

	B b;
	S4G then_S4G;
	S4G else_S4G;
	
	public If_B_then_S4G_else_S4G() {
		// TODO Auto-generated constructor stub
		b = new B();
		then_S4G = new S4G();
		else_S4G = new S4G();
	}

	
	public If_B_then_S4G_else_S4G(B b, S4G then_S4G, S4G else_S4G) {
		// TODO Auto-generated constructor stub
		this.b=b ;
		this.then_S4G = then_S4G;
		this.else_S4G = else_S4G;
	}
	
	public B getB() {
		return b;
	}




	public void setB(B b) {
		this.b = b;
	}




	public S4G getThen_S4G() {
		return then_S4G;
	}




	public void setThen_S4G(S4G then_S4G) {
		this.then_S4G = then_S4G;
	}




	public S4G getElse_S4G() {
		return else_S4G;
	}




	public void setElse_S4G(S4G else_S4G) {
		this.else_S4G = else_S4G;
	}




	@Override
	public String translate() {
		// TODO Auto-generated method stub
		return "if( "+this.b.translate()+" ) then { "+this.then_S4G.translate()+" } else { "+this.else_S4G.translate()+" }";
	}



	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}




	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "if_B_then_S4G_else_S4G";
	}


	@Override
	public void interpret(GameState gs, int player, Interpreter automato) {
		// TODO Auto-generated method stub
		
		b.interpret(gs, player, automato);
		
		boolean bool = b.getValue();
		
		
		if(bool) {
			if (this.then_S4G!=null)this.then_S4G.interpret(gs, player, automato);
		}
		else {
			if (this.else_S4G!=null)this.else_S4G.interpret(gs, player, automato);
		}
		
	}


	@Override
	public String translateIndentation(int tap) {
		// TODO Auto-generated method stub
		
		String esp= "";
		for(int i =0; i<tap;i++)esp+="\t";
		
		return esp+ "if( "+this.b.translate()+" ) then {\n "+
						this.then_S4G.translateIndentation(tap+1)+"\n"+
						esp+"} else {\n "
						+this.else_S4G.translateIndentation(tap+1)+"\n"+
						esp+"}";
	}

}
