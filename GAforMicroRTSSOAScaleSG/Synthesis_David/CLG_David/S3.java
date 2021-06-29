package CLG_David;

import java.util.ArrayList;
import java.util.List;

import rts.GameState;
import rts.units.Unit;

public class S3 implements NodeU,NoTerminal {

	ChildS3 childs3;
	
	
	
	public S3(ChildS3 childs3) {
		super();
		this.childs3 = childs3;
	}


	public S3() {
		// TODO Auto-generated constructor stub
		childs3=null;
	}

	
	boolean getValue() {
		return childs3.getValue();
	}
	
	
	public ChildS3 getChilds3() {
		return childs3;
	}


	public void setChilds3(ChildS3 childs3) {
		this.childs3 = childs3;
	}


	@Override
	public String translate() {
		// TODO Auto-generated method stub
		if(this.childs3==null)return "S3";
		return this.childs3.translate();
	}

	

	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}


	
	@Override
	public List<Node> Rules() {
		// TODO Auto-generated method stub
		List<Node>  l = new ArrayList<>();
		
		l.add(new BU());
		l.add(new B());
		
		
		
		return l;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "S3";
	}


	@Override
	public void interpret(GameState gs, int player, Interpreter automato) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void interpret(GameState gs, int player, Unit u, Interpreter automato) {
		// TODO Auto-generated method stub
		if (this.childs3==null)return;
		if (this.childs3 instanceof BU)this.childs3.interpret(gs, player,u, automato);
		if (this.childs3 instanceof B)this.childs3.interpret(gs, player, automato);
		
	}


	@Override
	public String translateIndentation(int tap) {
		// TODO Auto-generated method stub
		if(this.childs3==null)return "S3";
		return this.childs3.translateIndentation(tap);
		
	}

}
