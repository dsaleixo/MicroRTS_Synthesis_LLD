package CLG_David;

import java.util.ArrayList;
import java.util.List;

import rts.GameState;
import rts.units.Unit;

public class KU implements ChildCU,NoTerminal {

	ChildKU childKU;
	public KU() {
		// TODO Auto-generated constructor stub
		childKU = null;
		
	}

	
	
	public KU(ChildKU childKU) {
		super();
		this.childKU = childKU;
	}



	public ChildKU getChildKU() {
		return childKU;
	}



	public void setChildKU(ChildKU childKU) {
		this.childKU = childKU;
	}



	@Override
	public String translate() {
		// TODO Auto-generated method stub
		if(this.childKU==null)return "KU";
		return this.childKU.translate();
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
		
		
		l.add(new BuildU());
		l.add(new HarvestU());
		l.add(new AttackU());
		
		
		return l;
	}


	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "KU";
	}



	@Override
	public void interpret(GameState gs, int player, Interpreter automato) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void interpret(GameState gs, int player, Unit u, Interpreter automato) {
		// TODO Auto-generated method stub
		if (this.childKU!=null)this.childKU.interpret(gs, player,u, automato);
		
		
	}



	@Override
	public String translateIndentation(int tap) {
		// TODO Auto-generated method stub
		String esp= "";
		for(int i =0; i<tap;i++)esp+="\t";
		if(this.childKU==null)return esp+"KU";
		return this.childKU.translateIndentation(tap);
	}

}
