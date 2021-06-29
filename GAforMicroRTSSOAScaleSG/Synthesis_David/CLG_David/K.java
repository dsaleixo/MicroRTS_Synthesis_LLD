package CLG_David;

import java.util.ArrayList;
import java.util.List;

import rts.GameState;

public class K implements Node,ChildC,NoTerminal {

	ChildK childK;
	
	
	
	
	public K(ChildK childK) {
		super();
		this.childK = childK;
	}

	public ChildK getChildK() {
		return childK;
	}

	public void setChildK(ChildK childK) {
		this.childK = childK;
	}

	public K() {
		// TODO Auto-generated constructor stub
		childK=null;
		
	}

	@Override
	public String translate() {
		// TODO Auto-generated method stub
		if(this.childK==null)return "K";
		return this.childK.translate();
	}



	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "K";
	}
	
	@Override
	public List<Node> Rules() {
		// TODO Auto-generated method stub
		List<Node>  l = new ArrayList<>();
		
		
		l.add(new Build());
		l.add(new Train());
		l.add(new Harvest());
		l.add(new Attack());
		
		
		return l;
	}

	@Override
	public void interpret(GameState gs, int player, Interpreter automato) {
		// TODO Auto-generated method stub
		if (this.childK!=null)this.childK.interpret(gs, player, automato);
		
	}

	@Override
	public String translateIndentation(int tap) {
		// TODO Auto-generated method stub
		String esp= "";
		for(int i =0; i<tap;i++)esp+="\t";
		if(this.childK==null)return "K";
		return this.childK.translateIndentation(tap);
	}

}
