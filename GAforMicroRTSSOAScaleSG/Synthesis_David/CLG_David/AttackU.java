package CLG_David;

import rts.GameState;
import rts.PhysicalGameState;
import rts.Player;
import rts.units.Unit;

public class AttackU implements NodeU,ChildKU {

	Type type;
	OpponentPolicy OP;
	
	public AttackU() {
		// TODO Auto-generated constructor stub
		type= new Type();
		OP = new OpponentPolicy();
	}

	
	
	
	
	public AttackU(Type type, OpponentPolicy oP) {
		super();
		this.type = type;
		OP = oP;
	}





	public Type getType() {
		return type;
	}



	public void setType(Type type) {
		this.type = type;
	}






	public OpponentPolicy getOP() {
		return OP;
	}



	public void setOP(OpponentPolicy oP) {
		OP = oP;
	}



	@Override
	public String translate() {
		// TODO Auto-generated method stub
		return "attack("+this.type.translate()+","+this.OP.translate()+",u)";
	}



	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Attack_Type_OpponentPolicy_U";
	}





	@Override
	public void interpret(GameState gs, int player, Interpreter automato) {
		// TODO Auto-generated method stub
		
	}

	public Unit meleeUnitBehavior(Unit u, Player p, GameState gs) {
        PhysicalGameState pgs = gs.getPhysicalGameState();
        Unit closestEnemy = null;
        int closestDistance = 0;
        for (Unit u2 : pgs.getUnits()) {
            if (u2.getPlayer() >= 0 && u2.getPlayer() != p.getID()) {
                int d = Math.abs(u2.getX() - u.getX()) + Math.abs(u2.getY() - u.getY());
                if (closestEnemy == null || d < closestDistance) {
                    closestEnemy = u2;
                    closestDistance = d;
                }
            }
        }
        return closestEnemy;

 }



	@Override
	public void interpret(GameState gs, int player, Unit u, Interpreter automato) {
		// TODO Auto-generated method stub
		
		
        Player p = gs.getPlayer(player);

        
		 

			// if(u.getType()==UTType)System.out.println("d");
	            if (  u.getPlayer() == player && u.getType().name.equals(this.type.getValue())) {
	            	Unit target = this.meleeUnitBehavior(u,p,gs);
	            	automato.attack(u, target);
	            	
	         
	            }


		
		
	}





	@Override
	public String translateIndentation(int tap) {
		// TODO Auto-generated method stub
		String esp= "";
		for(int i =0; i<tap;i++)esp+="\t";
		return esp + this.translate();
	}

	

}
