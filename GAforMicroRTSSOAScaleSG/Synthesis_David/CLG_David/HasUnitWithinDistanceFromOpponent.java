package CLG_David;

import rts.GameState;
import rts.PhysicalGameState;
import rts.units.Unit;

public class HasUnitWithinDistanceFromOpponent implements ChildBU {

	
	Type type;
	N n;
	boolean value; 
	
	
	public HasUnitWithinDistanceFromOpponent() {
		// TODO Auto-generated constructor stub
		type = new Type();
		n = new N();
	}

	
	
	
	public HasUnitWithinDistanceFromOpponent(Type type, N n) {
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
	public void interpret(GameState gs, int player, Unit u, Interpreter automato) {
		// TODO Auto-generated method stub
		this.value=false;
		 
		 PhysicalGameState pgs = gs.getPhysicalGameState();
		 int player_enemy = 1 - player;
	     
		 int distance= Integer.parseInt(n.getValue());
	        
		 for(Unit u2:pgs.getUnits()) {

			// if(u.getType()==UTType)System.out.println("d");
	            if (  u2.getPlayer() == player_enemy && u.getType().name.equals(this.type.getValue()) ) {
	            	
	            	int dx = u2.getX() - u.getX();
                    int dy = u2.getY() - u.getY();
                    double d = Math.sqrt(dx * dx + dy * dy);
                    if (d<=distance) {
                    	this.value=true;
                    }
	         
	            }

		 }
		 

	}

	@Override
	public String translate() {
		// TODO Auto-generated method stub
		return "HasUnitWithinDistanceFromOpponent("+type.translate()+","+n.translate()+")";
	}

	@Override
	public void interpret(GameState gs, int player, Interpreter automato) {
		


	}

	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "HasUnitWithinDistanceFromOpponent_Type_N";
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
