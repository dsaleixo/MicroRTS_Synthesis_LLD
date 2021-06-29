package CLG_David;

import rts.GameState;
import rts.PhysicalGameState;
import rts.units.Unit;
 
public class HasNumberOfUnits implements ChildB {

	
	Type type;
	N n;
	Play play;
	boolean value;
	
	public HasNumberOfUnits() {
		// TODO Auto-generated constructor stub
		this.type = new Type();
		this.n = new N();
		this.play = new Play();
		
	}

	
	
	
	public HasNumberOfUnits(Type type, N n) {
		super();
		this.type = type;
		this.n = n;
	}



	
	

	public Play getPlay() {
		return play;
	}




	public void setPlay(Play play) {
		this.play = play;
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
		return "HasNumberOfUnits("+type.translate()+","+n.translate()+","+play.getValue()+")";
	}

	@Override
	public void interpret(GameState gs, int player, Interpreter automato) {
		// TODO Auto-generated method stub
		PhysicalGameState pgs = gs.getPhysicalGameState();
       
        int cont =0;
    	int n_int= Integer.parseInt(n.getValue());
    	
    	int jogador =-1 ;
    	if(play.value.equals("player"))jogador = player;
    	if(play.value.equals("1 - player"))jogador = 1 - player;
    	
		 for(Unit u:pgs.getUnits()) {

			// if(u.getType()==UTType)System.out.println("d");
	            if (  u.getPlayer() == jogador && u.getType().name.equals(this.type.getValue())) {
	            
	            	cont++;
	         
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
		return "HasNumberOfUnits_Type_N _play";
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
