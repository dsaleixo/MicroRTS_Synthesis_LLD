package Tests;

import java.util.List;

import CFG.B;
import CFG.Factory;
import CFG.FactoryBase;
import CFG.S;
import CFGBUS.B_BUS;
import CFGBUS.C_BUS;
import CFGBUS.S_BUS;

public class TestGrowCB {

	public TestGrowCB() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C_BUS c = new C_BUS();
		List<S_BUS> l = c.grow();
		Factory f = new FactoryBase();
		System.out.println("Comandos "+l.size());
		for(S s : l) {
			System.out.println("\t"+s.translate());
		}
		B_BUS b = new B_BUS();
		List<B> bl = b.AllCombinations(f);
		System.out.println("boolean "+bl.size());
		for(B bb : bl) {
			System.out.println("\t"+bb.translate());
		}
	}

}
