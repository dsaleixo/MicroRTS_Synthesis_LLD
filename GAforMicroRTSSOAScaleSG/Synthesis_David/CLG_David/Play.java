package CLG_David;

import java.util.ArrayList;
import java.util.List;

public class Play implements AlmostTerminal {

	String value;
	
	public Play() {
		// TODO Auto-generated constructor stub
		this.value=null;
	}

	
	
	
	public Play(String value) {
		super();
		this.value = value;
	}




	@Override
	public List<String> Rules() {
		// TODO Auto-generated method stub
		List<String> l = new ArrayList<>();
		l.add("player");
		l.add("1 - player");
		
		
		return l;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Play";
	}

	@Override
	public String translate() {
		// TODO Auto-generated method stub
		return this.value;
	}




	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return value;
	}

}
