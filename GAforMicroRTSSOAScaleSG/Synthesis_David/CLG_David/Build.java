package CLG_David;

import java.util.LinkedList;
import java.util.List;

import rts.GameState;
import rts.PhysicalGameState;
import rts.Player;
import rts.units.Unit;
import rts.units.UnitType;

public class Build implements Node,ChildK {
	
	N n;
	Type type;
	Direction dic;
	
	public Build() {
		// TODO Auto-generated constructor stub
		n = new N();
		type= new Type();
		dic = new Direction(); 
	}

	
	
	
	public Build(N n, Type type, Direction dic) {
		super();
		this.n = n;
		this.type = type;
		this.dic = dic;
	}




	public N getN() {
		return n;
	}




	public void setN(N n) {
		this.n = n;
	}




	public Type getType() {
		return type;
	}




	public void setType(Type type) {
		this.type = type;
	}




	public Direction getDic() {
		return dic;
	}




	public void setDic(Direction dic) {
		this.dic = dic;
	}




	@Override
	public String translate() {
		// TODO Auto-generated method stub
		return "Build("+this.type.translate()+","+this.n.translate()+","+this.dic.translate()+")";                     
	}



	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Build_Type_N_Direction";
		
	}




	@Override
	public void interpret(GameState gs, int player, Interpreter automato) {
		// TODO Auto-generated method stub
		
		PhysicalGameState pgs = gs.getPhysicalGameState();
        Player p = gs.getPlayer(player);
        UnitType UType = automato.utt.getUnitType(type.getValue());
		
        int cont=0;
        
        for(Unit u:pgs.getUnits()) {
        	if(u.getType().equals(UType) && u.getPlayer() == player) {
        		cont++;
        	}
        }
        
        List<Integer> reservedPositions = new LinkedList<>();
        for(Unit u:pgs.getUnits()) {
        	if(cont < Integer.parseInt(n.getValue()) ) {
	        	if( u.getPlayer() == player && u.getType().name.equals("Worker") && gs.getActionAssignment(u) == null && automato.getAbstractAction(u)==null){
	        		
	        		automato.buildIfNotAlreadyBuilding(u,UType,u.getX(),u.getY(),reservedPositions,p,pgs);
	        		System.out.println("sss");
	        	}
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
