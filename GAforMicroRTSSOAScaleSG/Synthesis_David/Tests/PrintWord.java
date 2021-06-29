package Tests;

import CLG_David.Attack;
import CLG_David.C;
import CLG_David.C_S4G;
import CLG_David.Direction;
import CLG_David.Empty;
import CLG_David.Harvest;
import CLG_David.K;
import CLG_David.K_C;
import CLG_David.N;
import CLG_David.OpponentPolicy;
import CLG_David.S1;
import CLG_David.S4G;
import CLG_David.S4G_S1;
import CLG_David.Train;
import CLG_David.Type;

public class PrintWord {

	public PrintWord() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Comandos");
		Attack a= new Attack(new Type("worker"),new OpponentPolicy("Closest"));
		System.out.println(a.translate());
		Train t= new Train( new N("100"), new Type("worker") , new  Direction("EnemyDir"));
		System.out.println(t.translate());
		Harvest h = new Harvest(new N("1"));
		System.out.println(h.translate());
		System.out.println("");
		System.out.println("K");
		K ka = new K(a);
		K kt = new K(t);
		K kh = new K(h);
		System.out.println(ka.translate());
		System.out.println(kt.translate());
		System.out.println(kh.translate());
		System.out.println("");
		System.out.println("C");
		C c1 = new C(ka);
		K_C kc1 = new K_C(kt,c1);
		C c2 =  new C(kc1);
		K_C kc2 = new K_C(kh,c2);
		C c3 =  new C(kc2);
		System.out.println(c3.translate());
		System.out.println("");
		System.out.println("S4G");
		Empty e = new Empty();
		S4G s4g1 = new S4G(e);
		C_S4G cs4g1 = new C_S4G(c3,s4g1);
		S4G s4g2 = new S4G(cs4g1);
		System.out.println(s4g2.translate());
		System.out.println("");
		System.out.println("S1");
		S1 s1_2 = new S1(e);
		S4G_S1 s4g_s1 = new S4G_S1(s4g2,s1_2);
		S1 ai = new S1(s4g_s1);
		System.out.println(ai.translate());
		
		//AI a1 = new LightRush();
	}

}
