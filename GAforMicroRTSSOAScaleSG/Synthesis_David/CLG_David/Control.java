package CLG_David;

import java.util.ArrayList;
import java.util.List;

public class Control {

	public Control() {
	
	}

	public Node getInitialSimbol(){
		return new S1();
	}
	
	public List<NoTerminal> getNoterminal(){
		List<NoTerminal>  l = new ArrayList<>();
		
		l.add(new S1());
		
		l.add(new S2());
		l.add(new S2U());
		
		l.add(new S4G());
		l.add(new S4());
		l.add(new S4U());
		
		l.add(new S5());
		l.add(new S5U());
		
		l.add(new S3());
		
		l.add(new B());
		l.add(new C());
		l.add(new K());
		
		l.add(new BU());
		l.add(new CU());
		l.add(new KU());
		
		return l;
	}
	
	public List<AlmostTerminal> getAlmostTerminal(){
		List<AlmostTerminal> l = new ArrayList<>();
		l.add(new Type());
		l.add(new N());
		l.add(new OpponentPolicy());
		l.add(new Direction());
		return l;
	}
	
	
	public void PrintGrmmar() {
		
		List<NoTerminal> l = getNoterminal();
		for (NoTerminal nt : l) {
			System.out.print(((Node)nt).getName()+" ==> ");
			boolean b=true;
			for( Node n : nt.Rules()) {
				if(b) {
					System.out.print(n.getName());
					b=false;
				}
				else{
					System.out.print(" | "+n.getName());
					
				}
				
				
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("AlmostTerminal");
		List<AlmostTerminal> ll = this.getAlmostTerminal();
		for (AlmostTerminal at : ll) {
			System.out.print(at.getName()+" ==> ");
			boolean b=true;
			for( String s : at.Rules()) {
				if(b) {
					System.out.print(s);
					b=false;
				}
				else{
					System.out.print(" | "+s);
					
				}
				
				
			}
			System.out.println();
		}
	}
}
