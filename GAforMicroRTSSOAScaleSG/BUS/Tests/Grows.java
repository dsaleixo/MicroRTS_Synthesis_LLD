package Tests;

import java.util.ArrayList;
import java.util.List;

import CFG.B;
import CFG.Factory;
import CFG.FactoryBase;
import CFG.S;
import CFGBUS.B_BUS;
import CFGBUS.C_BUS;
import CFGBUS.If_B_then_S_else_S_BUS;
import CFGBUS.S_BUS;

public class Grows {

	public Grows() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Factory f = new FactoryBase();
		C_BUS c = new C_BUS();
		List<S_BUS> l = c.grow();
	
		
		B_BUS b = new B_BUS();
		List<B> bl = b.AllCombinations(f);
	
		If_B_then_S_else_S_BUS iff= new If_B_then_S_else_S_BUS();
		long Tini = System.currentTimeMillis();
		List<S> aux2 = new ArrayList<>() ;
	
		long paraou = System.currentTimeMillis()-Tini;
		double tempo_total = (paraou*1.0)/1000.0;
		System.out.println(aux2.size()+" "+tempo_total);
		
	}

}
