package CLG_David;

import ai.abstraction.AbstractAction;
import ai.abstraction.Attack;
import rts.GameState;
import rts.PhysicalGameState;
import rts.units.Unit;

public class HaveQtdUnitsAttacking implements ChildB {

	Type type;
	N n;
	Boolean value;
	
	public HaveQtdUnitsAttacking() {
		// TODO Auto-generated constructor stub
		type = new Type();
		n = new N();
	}

	
	
	
	public HaveQtdUnitsAttacking(Type type, N n) {
		super();
		this.type = type;
		this.n = n;
	}




	public Type getType() {
		return type;
	}




	public void setType(Type type) {
		this.type = type;
	}




	public N getN() {
		return n;
	}




	public void setN(N n) {
		this.n = n;
	}




	@Override
	public String translate() {
		// TODO Auto-generated method stub
		return "HaveQtdUnitsAttacking("+type.getValue()+","+n.getValue()+")";
	}

	@Override
	public void interpret(GameState gs, int player, Interpreter automato) {
		// TODO Auto-generated method stub
		PhysicalGameState pgs = gs.getPhysicalGameState();
       
        int cont =0;
    	int n_int= Integer.parseInt(n.getValue());
		 for(Unit u:pgs.getUnits()) {

			// if(u.getType()==UTType)System.out.println("d");
	            if (  u.getPlayer() == player && u.getType().canAttack) {
	            	AbstractAction aa = automato.getAbstractAction(u);
	            	
	            	if (aa instanceof Attack) {
	            		cont++;
	            	}
	         
	            }


		 }
		 
		 this.value = cont>=n_int;


	}

	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "HaveQtdUnitsAttacking_Type_N";
	}

	@Override
	public boolean getValue() {
		// TODO Auto-generated method stub
		return value;
	}




	@Override
	public String translateIndentation(int tap) {
		// TODO Auto-generated method stub
		return this.translate();
	}

}
