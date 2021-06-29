package CLG_David;

import rts.GameState;
import rts.units.Unit;

public class KU_CU implements NodeU, ChildCU {

	KU ku;
	CU cu;
	public KU_CU() {
		// TODO Auto-generated constructor stub
		ku = new KU();
		cu = new CU();
	}

	
	
	
	
	public KU_CU(KU ku, CU cu) {
		super();
		this.ku = ku;
		this.cu = cu;
	}





	public KU getKu() {
		return ku;
	}





	public void setKu(KU ku) {
		this.ku = ku;
	}





	public CU getCu() {
		return cu;
	}





	public void setCu(CU cu) {
		this.cu = cu;
	}





	@Override
	public String translate() {
		// TODO Auto-generated method stub
		return this.ku.translate()+" "+this.cu.translate();
	}



	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}

	





	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "KU_CU";
	}





	@Override
	public void interpret(GameState gs, int player, Interpreter automato) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void interpret(GameState gs, int player, Unit u, Interpreter automato) {
		// TODO Auto-generated method stub
		if (this.ku!=null)this.ku.interpret(gs, player,u, automato);
		if (this.cu!=null)this.cu.interpret(gs, player,u, automato);
	}





	@Override
	public String translateIndentation(int tap) {
		// TODO Auto-generated method stub
		return this.ku.translateIndentation(tap)+"\n"+this.cu.translateIndentation(tap);
	}

}
