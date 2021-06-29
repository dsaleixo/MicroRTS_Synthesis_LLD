package CLG_David;

import java.util.ArrayList;
import java.util.List;

import rts.GameState;
import rts.units.Unit;

public class S5U implements NodeU,NoTerminal {

	ChildS5U childS5U;
	
	public S5U() {
		// TODO Auto-generated constructor stub
		childS5U = null;
	}

	
	
	
	
	
	public S5U(ChildS5U childS5U) {
		super();
		this.childS5U = childS5U;
	}






	public ChildS5U getChildS5U() {
		return childS5U;
	}






	public void setChildS5U(ChildS5U childS5U) {
		this.childS5U = childS5U;
	}






	@Override
	public String translate() {
		// TODO Auto-generated method stub
		if(this.childS5U==null)return "S5U";
		return this.childS5U.translate();
	}

	

	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}








	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "S5U";
	}


	@Override
	public List<Node> Rules() {
		// TODO Auto-generated method stub
		List<Node>  l = new ArrayList<>();
		
		l.add(new NotS3());
		l.add(new S3());
		
		
		
		return l;
	}






	@Override
	public void interpret(GameState gs, int player, Interpreter automato) {
		// TODO Auto-generated method stub
		
	}



	public boolean getValue() {
		return childS5U.getValue();
	}


	@Override
	public void interpret(GameState gs, int player, Unit u, Interpreter automato) {
		// TODO Auto-generated method stub
		if(this.childS5U==null)childS5U.interpret(gs, player,u, automato);
	}






	@Override
	public String translateIndentation(int tap) {
		// TODO Auto-generated method stub
		String esp= "";
		for(int i =0; i<tap;i++)esp+="\t";
		if(this.childS5U==null)return esp+"S5U";
		return this.childS5U.translateIndentation(tap);
	}


	
}
