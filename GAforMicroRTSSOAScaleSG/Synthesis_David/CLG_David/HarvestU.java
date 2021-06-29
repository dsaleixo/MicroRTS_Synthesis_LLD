package CLG_David;

import rts.GameState;
import rts.PhysicalGameState;
import rts.Player;
import rts.units.Unit;

public class HarvestU implements NodeU,ChildKU {


	public HarvestU() {
		// TODO Auto-generated constructor stub
		;
	}

	@Override
	public String translate() {
		// TODO Auto-generated method stub
		return "Harvest(u)";
	}


	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Havest_U";
	
	}

	@Override
	public void interpret(GameState gs, int player, Interpreter automato) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void interpret(GameState gs, int player, Unit u, Interpreter automato) {
		
		PhysicalGameState pgs = gs.getPhysicalGameState();
		
		
		Player p = gs.getPlayer(player);
		
			
		if(u.getPlayer() == player && u.getType().canHarvest && gs.getActionAssignment(u) == null && automato.getAbstractAction(u)==null) {
				
				
				Unit closestBase = null;
	            Unit closestResource = null;
	            int closestDistance = 0;
	            for (Unit u2 : pgs.getUnits()) {
	                if (u2.getType().isResource) {
	                    int d = Math.abs(u2.getX() - u.getX()) + Math.abs(u2.getY() - u.getY());
	                    if (closestResource == null || d < closestDistance) {
	                        closestResource = u2;
	                        closestDistance = d;
	                    }
	                }
	            }
	            closestDistance = 0;
	            for (Unit u2 : pgs.getUnits()) {
	                if (u2.getType().isStockpile && u2.getPlayer()==p.getID()) {
	                    int d = Math.abs(u2.getX() - u.getX()) + Math.abs(u2.getY() - u.getY());
	                    if (closestBase == null || d < closestDistance) {
	                        closestBase = u2;
	                        closestDistance = d;
	                    }
	                }
	            }
	            if (closestResource != null && closestBase != null) {
	                
	                automato.harvest(u, closestResource, closestBase);
	             
	            }
				
				
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
