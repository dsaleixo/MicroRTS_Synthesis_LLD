package CLG_David;

import rts.GameState;

public class If_S5_then_S4G implements  ChildS2 {

	S5 s5;
	S4G then_S4G;
	
	public If_S5_then_S4G() {
		// TODO Auto-generated constructor stub
		s5=new S5();
		then_S4G= new S4G();
	}

	public If_S5_then_S4G(S5 s5,S4G then_S4G) {
		// TODO Auto-generated constructor stub
		this.s5=s5;
		this.then_S4G= then_S4G;
	}
	
	
	public S5 getS5() {
		return s5;
	}




	public void setS5(S5 s5) {
		this.s5 = s5;
	}




	public S4G getThen_S4G() {
		return then_S4G;
	}




	public void setThen_S4G(S4G then_S4G) {
		this.then_S4G = then_S4G;
	}




	@Override
	public String translate() {
		// TODO Auto-generated method stub
		return " if( "+this.s5.translate()+" ) then { "+this.then_S4G.translate()+" }";
	}

	

	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "If_S5_then_S4G";
	}

	@Override
	public void interpret(GameState gs, int player, Interpreter automato) {
		// TODO Auto-generated method stub
		s5.interpret(gs, player, automato);
		
		boolean bool = s5.getValue();
		
		
		if(bool) {
			if (this.then_S4G!=null)this.then_S4G.interpret(gs, player, automato);
		}
		
		
	}

	@Override
	public String translateIndentation(int tap) {
		// TODO Auto-generated method stub
		String esp= "";
		for(int i =0; i<tap;i++)esp+="\t";
		return esp +"if( "+this.s5.translate()+" ) then {\n"
				+this.then_S4G.translateIndentation(tap+1)+"\n"+
				esp+"}";
	}

}
