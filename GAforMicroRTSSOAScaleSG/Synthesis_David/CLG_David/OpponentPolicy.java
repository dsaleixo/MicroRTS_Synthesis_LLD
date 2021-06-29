package CLG_David;

import java.util.ArrayList;
import java.util.List;

public class OpponentPolicy implements AlmostTerminal {

	String OP;
	public OpponentPolicy() {
		// TODO Auto-generated constructor stub
		OP=null;
	}

	
	
	
	
	public OpponentPolicy(String oP) {
		super();
		OP = oP;
	}





	public String getOpponentPolicy() {
		return OP;
	}
	public void setOpponentPolicy(String type) {
		this.OP = type;
	}
	
	@Override
	public String getValue() {
		return OP;
	}
	
	@Override
	public String getName() {
		return "OpponentPolicy";
	}
	
	@Override
	public String translate() {
		return OP;
	}
	
	@Override
	public List<String> Rules(){
		List<String> l = new ArrayList<>();
		l.add("Strongest");
		l.add("Weakest");
		l.add("Closest");
		l.add("Farthest");
		l.add("MostHealthy");
		l.add("Random");
		
		return l;
	
		
	}

	
	
}
