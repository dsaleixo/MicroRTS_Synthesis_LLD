package CFG_Actions;

import java.util.ArrayList;
import java.util.List;

import AIs.Interpreter;
import CFG.ChildC;
import CFG.Factory;
import CFG.Node;
import rts.GameState;
import rts.PhysicalGameState;
import rts.Player;
import rts.units.Unit;

public class Harvest implements ChildC {

	boolean used;
	public Harvest() {
		// TODO Auto-generated constructor stub
		this.used=false;
	}

	@Override
	public String translate() {
		// TODO Auto-generated method stub
		return "u.harvest()";
	}


	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Harvest";
	
	}


	@Override
	public void interpret(GameState gs, int player, Unit u, Interpreter automato) throws Exception {
		
		PhysicalGameState pgs = gs.getPhysicalGameState();
		
		
		Player p = gs.getPlayer(player);
		
		//if(!u.getType().canHarvest) 	throw new Exception();
		if(!u.getType().canHarvest) return;
		if(u.getPlayer() == player   && automato.getAbstractAction(u)==null) {
				
				
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
	               this.used= true;
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

	@Override
	public Node Clone(Factory f) {
		// TODO Auto-generated method stub
		return f.build_Harvest();
	}

	@Override
	public boolean equals(Node n) {
		// TODO Auto-generated method stub
		if (!(n instanceof Harvest)) return false;
		
		return true;
	}

	@Override
	public List<ChildC> AllCombinations(Factory f) {
		// TODO Auto-generated method stub
		Harvest h = (Harvest) f.build_Harvest();
		List<ChildC> l = new ArrayList<>();
		l.add(h);
		return l;
	}

	@Override
	public void resert() {
		// TODO Auto-generated method stub
		this.used=false;
		
	}
	
	@Override
	public boolean clear(Node father,Factory f ) {
		// TODO Auto-generated method stub
		return used;
	}

	@Override
	public void load(List<String> list,Factory f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void salve(List<String> list) {
		// TODO Auto-generated method stub
		list.add(this.getName());
		
	}
	
}
