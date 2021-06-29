package CLG_David;

import ai.abstraction.AbstractAction;
import ai.abstraction.Harvest;
import rts.GameState;
import rts.PhysicalGameState;
import rts.Player;
import rts.units.Unit;

public class HasNumberOfWorkersHarvesting implements ChildB {

	
	N n;
	boolean value;
	public HasNumberOfWorkersHarvesting() {
		// TODO Auto-generated constructor stub
		n = new N();
	}

	

	
	
	public HasNumberOfWorkersHarvesting(N n) {
		super();
		this.n = n;
	}



	

	@Override
	public String translate() {
		// TODO Auto-generated method stub
		return "HasNumberOfWorkersHarvesting("+n.translate()+")";
	}

	@Override
	public void interpret(GameState gs, int player, Interpreter automato) {
		// TODO Auto-generated method stub
		PhysicalGameState pgs = gs.getPhysicalGameState();
        Player p = gs.getPlayer(player);
        int cont =0;
    	int n_int= Integer.parseInt(n.getValue());
		 for(Unit u:pgs.getUnits()) {

			// if(u.getType()==UTType)System.out.println("d");
	            if (  u.getPlayer() == player && u.getType().canHarvest) {
	            	AbstractAction aa = automato.getAbstractAction(u);
	            	
	            	if (aa instanceof Harvest) {
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
		return "HasNumberOfWorkersHarvesting_N";
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
