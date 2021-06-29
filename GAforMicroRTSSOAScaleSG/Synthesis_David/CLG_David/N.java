package CLG_David;

import java.util.ArrayList;
import java.util.List;

public class N implements AlmostTerminal {
	String n;
		
	public N() {
		// TODO Auto-generated constructor stub
		n=null;
	}
	
	
	
	public N(String n) {
		super();
		this.n = n;
	}



	public String getN() {
		return n;
	}



	public void setN(String n) {
		this.n = n;
	}



	@Override
	public String getValue() {
		return n;
	}
	
	@Override
	public String getName() {
		return "N";
	}
	
	@Override
	public String translate() {
		 return ""+n;
	 }
	
	@Override
	public List<String> Rules(){
		List<String> l = new ArrayList<>();
		l.add("50");
		l.add("1");
		l.add("5");
		l.add("10");
		l.add("25");
	
		return l;
	
		
	}

}
