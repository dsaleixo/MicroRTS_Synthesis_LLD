package Tests;

import javax.swing.JFrame;

import CLG_David.Attack;
import CLG_David.AttackU;
import CLG_David.BU;
import CLG_David.Build;
import CLG_David.BuildU;
import CLG_David.C;
import CLG_David.CU;
import CLG_David.CU_S4U;
import CLG_David.C_S4G;
import CLG_David.Direction;
import CLG_David.Empty;
import CLG_David.For_S4_S1;
import CLG_David.Harvest;
import CLG_David.HarvestU;
import CLG_David.HasUnitWithinDistanceFromOpponent;
import CLG_David.If_S3_then_S4_else_S4;
import CLG_David.Interpreter;
import CLG_David.K;
import CLG_David.KU;
import CLG_David.KU_CU;
import CLG_David.K_C;
import CLG_David.N;
import CLG_David.Node;
import CLG_David.OpponentPolicy;
import CLG_David.S1;
import CLG_David.S2U;
import CLG_David.S2U_S4U;
import CLG_David.S3;
import CLG_David.S4;
import CLG_David.S4G;
import CLG_David.S4G_S1;
import CLG_David.S4U;
import CLG_David.Train;
import CLG_David.Type;
import ai.abstraction.WorkerRush;
import ai.core.AI;
import gui.PhysicalGameStatePanel;
import rts.GameState;
import rts.PhysicalGameState;
import rts.PlayerAction;
import rts.units.UnitTypeTable;

public class TestesComandosWorkerRush {

	
	
	public static Node monta() {
		
		Attack h= new Attack(new Type("Worker"),new OpponentPolicy("Closest"));
		
		Train t= new Train( new N("3"), new Type("Worker") , new  Direction("EnemyDir"));
	
		Harvest a = new Harvest(new N("1"));
	
		K ka = new K(a);
		K kt = new K(t);
		K kh = new K(h);
	
		C c1 = new C(ka);
		K_C kc1 = new K_C(kt,c1);
		C c2 =  new C(kc1);
		K_C kc2 = new K_C(kh,c2);
		C c3 =  new C(kc2);

		Empty e = new Empty();
		S4G s4g1 = new S4G(e);
		C_S4G cs4g1 = new C_S4G(c3,s4g1);
		S4G s4g2 = new S4G(cs4g1);

		S1 s1_2 = new S1(e);
		S4G_S1 s4g_s1 = new S4G_S1(s4g2,s1_2);
		S1 ai = new S1(s4g_s1);
	
		return ai;
	}
	
	
	
	
	public static Node monta2() {

	

	Attack a= new Attack(new Type("Worker"),new OpponentPolicy("Closest"));
		
		Train t= new Train( new N("3"), new Type("Worker") , new  Direction("EnemyDir"));
	
		Harvest h = new Harvest(new N("1"));
	
		K ka = new K(a);
		K kt = new K(t);
		K kh = new K(h);
	
		C c1 = new C(ka);
		K_C kc1 = new K_C(kt,c1);
		C c2 =  new C(kc1);
		K_C kc2 = new K_C(kh,c2);
		C c3 =  new C(kc2);
	
		Empty e = new Empty();
		S4G s4g1 = new S4G(e);
		C_S4G cs4g1 = new C_S4G(c3,s4g1);
		S4G s4g2 = new S4G(cs4g1);
		
		S1 s1_2 = new S1(e);
		S4G_S1 s4g_s1 = new S4G_S1(s4g2,s1_2);
		S1 ai = new S1(s4g_s1);
	
		return ai;
	}
	
	
	
	public static Node monta3() {
	
		Attack a= new Attack(new Type("Ranged"),new OpponentPolicy("Closest"));

		Attack a2= new Attack(new Type("Worker"),new OpponentPolicy("Closest"));
	
		Train t= new Train( new N("2"), new Type("Worker") , new  Direction("EnemyDir"));
		
		Train t2= new Train( new N("3"), new Type("Ranged") , new  Direction("EnemyDir"));
		
		Harvest h = new Harvest(new N("1"));
	
		Build b = new Build(new N("1"), new Type("Barracks") , new  Direction("EnemyDir"));

		

		K ka = new K(a);
		K ka2 = new K(a2);
		K kt = new K(t);
		K kh = new K(h);
		K kt2 = new K(t2);
		K kb = new K(b);
	
		
		C c1 =  new C(ka2);
		K_C kc1 = new K_C(ka,c1);
		C c2 =  new C(kc1);
		K_C kc2 = new K_C(kt2,c2);
		C c3 =  new C(kc2);
		K_C kc3 = new K_C(kh,c3);
		C c4 =  new C(kc3);
		K_C kc4 = new K_C(kb,c4);
		C c5 =  new C(kc4);
	;
		Empty e = new Empty();
		S4G s4g1 = new S4G(e);
		C_S4G cs4g1 = new C_S4G(c5,s4g1);
		S4G s4g2 = new S4G(cs4g1);
	
		S1 s1_2 = new S1(e);
		S4G_S1 s4g_s1 = new S4G_S1(s4g2,s1_2);
		S1 ai = new S1(s4g_s1);
	
		return ai;
	}
	
	
	public static Node monta4() {
		
		AttackU a= new AttackU(new Type("Ranged"),new OpponentPolicy("Closest"));
	
		AttackU a2= new AttackU(new Type("Worker"),new OpponentPolicy("Closest"));
		
		Train t= new Train( new N("2"), new Type("Worker") , new  Direction("EnemyDir"));
		
		Train t2= new Train( new N("3"), new Type("Ranged") , new  Direction("EnemyDir"));
		
		HarvestU h = new HarvestU();
		
		BuildU b = new BuildU(new N("1"), new Type("Barracks") , new  Direction("EnemyDir"));
	
		KU ka = new KU(a);
		KU ka2 = new KU(a2);
		K kt = new K(t);
		KU kh = new KU(h);
		
		KU kb = new KU(b);
		
		
		CU c1 =  new CU(ka2);
		KU_CU kc1 = new KU_CU(ka,c1);
		CU c2 =  new CU(kc1);
		
	
		KU_CU kc3 = new KU_CU(kh,c2);
		CU c4 =  new CU(kc3);
		KU_CU kc4 = new KU_CU(kb,c4);
		CU c5 =  new CU(kc4);
	
		Empty e = new Empty();
		S4U s4g1 = new S4U(e);
		CU_S4U cs4g1 = new CU_S4U(c5,s4g1);
		S4U s4u = new S4U(cs4g1);
		S4 s4g2 = new S4(s4u);
	
		
		
		
		K kt2 = new K(t2);
		C ct1 = new C(kt2);
		S4G s4gg = new S4G(e);
		C_S4G cs4gg = new C_S4G(ct1,s4gg);
		S4G naruto = new S4G(cs4gg);
		
		S1 s1_2 = new S1(e);
		
		S4G_S1 s4g_s11= new S4G_S1(naruto,s1_2);
		
		S1 s111 = new S1(s4g_s11);

		For_S4_S1 s4g_s1 = new For_S4_S1(s4g2,s111);
		S1 ai = new S1(s4g_s1);
	
		return ai;
	}
	
	
	public static Node monta5() {
		Empty e = new Empty();
		S4U s4u_e = new S4U(e);
		
		HarvestU b = new HarvestU();
		KU else_ku = new KU(b);
		CU else_CU = new CU(else_ku);
		CU_S4U else_cu_s4u = new CU_S4U(else_CU,s4u_e);
		S4U else_s4u = new S4U(else_cu_s4u);
		S4 else_S4 =new S4(else_s4u);
		
		
		AttackU a = new AttackU(new Type("Worker"),new OpponentPolicy("Closest"));
		KU then_ku = new KU(a);
		CU then_CU = new CU(then_ku);
		CU_S4U then_cu_s4u = new CU_S4U(then_CU,s4u_e);
		S4U then_s4u = new S4U(then_cu_s4u);
		S4 then_S4 =new S4(then_s4u);
		HasUnitWithinDistanceFromOpponent dist = new HasUnitWithinDistanceFromOpponent(new Type("Worker"), new N("10"));             
		BU bu = new BU(dist);
		S3 s3 = new S3(bu);
		If_S3_then_S4_else_S4 iff = new If_S3_then_S4_else_S4(s3,then_S4,else_S4);
		S2U s2u = new S2U(iff);
		
		S2U_S4U s2u_s4u = new S2U_S4U(s2u,s4u_e);
		S4U s4u = new S4U(s2u_s4u);
		S4 s4 = new S4(s4u);
		S1 s1_e = new S1(e);
		For_S4_S1 for_s4_s1= new For_S4_S1(s4,s1_e);
		S1  s1= new S1(for_s4_s1);
	
		return s1;
	}
	
	
	
	
	public TestesComandosWorkerRush() {
		// TODO Auto-generated constructor stub
	}

	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		UnitTypeTable utt = new UnitTypeTable();
		
		
		String path_map ="./maps/24x24/basesWorkers24x24A.xml";
		
		
		
	
		Node no= monta4();
		//if(true)return ;
		System.out.println(no.translateIndentation(0));
		
		Interpreter ai1 = new Interpreter(utt,no);
		PhysicalGameState pgs = PhysicalGameState.load(path_map, utt);
	
		AI ai2 = new WorkerRush(utt);
		
	
		GameState gs2 = new GameState(pgs, utt);
		boolean gameover = false;
		JFrame w=null;
		if(true) w = PhysicalGameStatePanel.newVisualizer(gs2,640,640,false,PhysicalGameStatePanel.COLORSCHEME_BLACK);  
        do {
      
                PlayerAction pa1 = ai1.getAction(0, gs2);
                PlayerAction pa2 = ai2.getAction(1, gs2);
                gs2.issueSafe(pa1);
                gs2.issueSafe(pa2);
             
                gameover = gs2.cycle();
                if(true) {
                	w.repaint();
                	Thread.sleep(20);
                }
              
                

        } while (!gameover && (gs2.getTime() <= 5000));   
		
		
		
		
		
	
		
	}

}
