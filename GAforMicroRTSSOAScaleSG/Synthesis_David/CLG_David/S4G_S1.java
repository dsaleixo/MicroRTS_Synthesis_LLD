package CLG_David;

import rts.GameState;

public class S4G_S1 implements ChildS1 {

	S4G s4g;
	
	S1  s1;
	
	
	
	public S4G_S1() {
		// TODO Auto-generated constructor stub
		s4g=new S4G();
		s1=new S1();
	}
	public S4G_S1(S4G s4g,S1 s1) {
		// TODO Auto-generated constructor stub
		this.s4g=s4g;
		this.s1=s1;
	}
	
	
	public S4G getS4g() {
		return s4g;
	}

	public void setS4g(S4G s4g) {
		this.s4g = s4g;
	}

	public S1 getS1() {
		return s1;
	}

	public void setS1(S1 s1) {
		this.s1 = s1;
	}

	

	

	@Override
	public String translate() {
		
		return s4g.translate()+" "+s1.translate();
	}



	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "S4G_S1";
	}
	@Override
	public void interpret(GameState gs, int player, Interpreter automato) {
		// TODO Auto-generated method stub
		if (this.s4g!=null)this.s4g.interpret(gs, player, automato);
		if (this.s1!=null)this.s1.interpret(gs, player, automato);
	}
	@Override
	public String translateIndentation(int tap) {
		// TODO Auto-generated method stub
		return s4g.translateIndentation(tap)+"\n"+s1.translateIndentation(tap);
	}

}
