package CLG_David;
import java.util.ArrayList;
import java.util.List;

public class Direction implements AlmostTerminal {

	String direc;
	
	public Direction() {
		// TODO Auto-generated constructor stub
		direc=null;
	}

	
	
	public Direction(String direc) {
		super();
		this.direc = direc;
	}



	public String getDirection() {
		return direc;
	}
	public void setDirection(String type) {
		this.direc = type;
	}
	
	@Override
	public String getValue() {
		return direc;
	}
	
	@Override
	public String getName() {
		return "Direction";
	}
	
	@Override
	public String translate() {
		return direc;
	}
	
	@Override
	public List<String> Rules(){
		List<String> l = new ArrayList<>();
		l.add("Right");
		l.add("Left");
		l.add("Up");
		l.add("Down");
		l.add("EnemyDir");
	
		return l;
	
		
	}


	
}
