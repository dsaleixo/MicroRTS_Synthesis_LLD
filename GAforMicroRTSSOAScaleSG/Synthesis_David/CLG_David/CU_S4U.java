package CLG_David;

import rts.GameState;
import rts.units.Unit;

public class CU_S4U implements  ChildS4U {

	
	CU cu;
	S4U s4u;
	
	public CU_S4U() {
		// TODO Auto-generated constructor stub
		cu = new CU();
		s4u = new S4U();
	}

	
	
	
	
	
	
	public CU_S4U(CU cu, S4U s4u) {
		super();
		this.cu = cu;
		this.s4u = s4u;
	}







	public CU getCu() {
		return cu;
	}





	public void setCu(CU cu) {
		this.cu = cu;
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
		return this.cu.translate() +" "+this.s4u.translate();
	}

	

	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}

	
	



	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "CU_S4U";
	}







	@Override
	public void interpret(GameState gs, int player, Interpreter automato) {
		// TODO Auto-generated method stub
		
	}







	@Override
	public void interpret(GameState gs, int player, Unit u, Interpreter automato) {
		// TODO Auto-generated method stub
		if (this.cu!=null)this.cu.interpret(gs, player,u, automato);
		if (this.s4u!=null)this.s4u.interpret(gs, player,u, automato);
		
	}







	@Override
	public String translateIndentation(int tap) {
		// TODO Auto-generated method stub
		return this.cu.translateIndentation(tap) +"\n"+this.s4u.translateIndentation(tap);
	}

}
