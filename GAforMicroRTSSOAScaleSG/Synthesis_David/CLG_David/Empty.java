package CLG_David;

import rts.GameState;
import rts.units.Unit;

public class Empty implements Node, ChildS1,ChildS4G,ChildS4U,ChildC,ChildCU {

	public Empty() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String translate() {
		// TODO Auto-generated method stub
		return "e";
	}


	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "e";
	}



	@Override
	public void interpret(GameState gs, int player, Interpreter automato) {
		;
		
	}

	@Override
	public void interpret(GameState gs, int player, Unit u, Interpreter automato) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String translateIndentation(int tap) {
		// TODO Auto-generated method stub
		String esp= "";
		for(int i =0; i<tap;i++)esp+="\t";
		return esp + this.translate();
	}

}
