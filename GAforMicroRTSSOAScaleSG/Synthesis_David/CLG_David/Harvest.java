package CLG_David;



import rts.GameState;
import rts.PhysicalGameState;
import rts.Player;
import rts.units.Unit;

public class Harvest implements Node,ChildK {

	N n;
	public Harvest() {
		// TODO Auto-generated constructor stub
		n=new N();
	}

	
	
	
	public Harvest(N n) {
		super();
		this.n = n;
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
		return "Harvest("+this.n.translate()+")";
	}



	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Havest_N";
	}




	@Override
	public void interpret(GameState gs, int player, Interpreter automato) {
		// TODO Auto-generated method stub
		
		PhysicalGameState pgs = gs.getPhysicalGameState();
		int n_int= Integer.parseInt(n.getValue());
		int cont =0;
		 Player p = gs.getPlayer(player);
		for(Unit u:pgs.getUnits()) {
			
			if(u.getPlayer() == player && u.getType().canHarvest ) {
				
				
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
	               
	                cont++;
	            }
				
				
			}
			
				
				
			
			if(cont>=n_int)break;
			
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
