package CLG_David;

import java.util.ArrayList;
import java.util.List;

import rts.GameState;

public class C implements Node,NoTerminal {

	ChildC childC;
	
	
	
	
	
	public C(ChildC childC) {
		super();
		this.childC = childC;
	}

	public ChildC getChildC() {
		return childC;
	}

	public void setChildC(ChildC childC) {
		this.childC = childC;
	}

	public C() {
		// TODO Auto-generated constructor stub
		childC=null;
	}

	@Override
	public String translate() {
		// TODO Auto-generated method stub
		if(this.childC==null)return "C";
		return this.childC.translate();
	}


	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "C";
	}
	
	
	@Override
	public List<Node> Rules() {
		// TODO Auto-generated method stub
		List<Node>  l = new ArrayList<>();
		l.add(new K_C());
		l.add(new K());
		l.add(new Empty());
		
		
		return l;
	}

	@Override
	public void interpret(GameState gs, int player, Interpreter automato) {
		// TODO Auto-generated method stub
		if (this.childC!=null)this.childC.interpret(gs, player, automato);
		
	}

	@Override
	public String translateIndentation(int tap) {
		// TODO Auto-generated method stub
		String esp= "";
		for(int i =0; i<tap;i++)esp+="\t";
		if(this.childC==null)return esp+"C";
		return this.childC.translateIndentation(tap);
	}
	
	

}
