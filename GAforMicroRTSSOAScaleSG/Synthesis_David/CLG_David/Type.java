package CLG_David;

import java.util.ArrayList;
import java.util.List;

public class Type implements AlmostTerminal {

	String type;
	public Type() {
		// TODO Auto-generated constructor stub
		type = null;
	}
	
	
	
	
	public Type(String type) {
		super();
		this.type = type;
	}




	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String getValue() {
		return type;
	}
	
	@Override
	public String getName() {
		return "Type";
	}
	
	@Override
	public String translate() {
		return type;
	}
	
	@Override
	public List<String> Rules(){
		List<String> l = new ArrayList<>();
		l.add("Base");
		l.add("Barracks");
		l.add("Worker");
		l.add("Ranger");
		l.add("Light");
		l.add("Heavy");
		
		return l;
		
	}

}
