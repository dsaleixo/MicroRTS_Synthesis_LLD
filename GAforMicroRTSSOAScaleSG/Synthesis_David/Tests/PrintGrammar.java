package Tests;

import CLG_David.Control;

public class PrintGrammar {

	public PrintGrammar() {
		// TODO Auto-generated constructor stub
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Control c = new Control();
		System.out.println("InitialSymbol ==> " + c.getInitialSimbol().getName());
		System.out.println("");
		System.out.println("Grammar");
		c.PrintGrmmar();
		

		
		

	}

}
