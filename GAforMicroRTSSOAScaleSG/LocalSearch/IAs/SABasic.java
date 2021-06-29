package IAs;

import java.util.Random;

import AIs.Interpreter;
import CFG.Factory;
import CFG.Node;
import EvaluateGameState.CabocoDagua;
import EvaluateGameState.Playout;
import EvaluateGameState.SimplePlayout;
import LS_CFG.Empty_LS;
import LS_CFG.FactoryLS;
import LS_CFG.Node_LS;
import LS_CFG.S_LS;
import ai.core.AI;
import rts.GameState;
import rts.units.UnitTypeTable;
import util.Pair;

public class SABasic implements Search {

	Factory f;
	boolean use_cleanr;
	AI adv;
	Playout playout;
	double T0;
	double alpha;
	double beta;
	
	Node_LS best;
	Pair<Double,Double> best_v;
	public SABasic() {
		// TODO Auto-generated constructor stub
		f = new FactoryLS();
		use_cleanr = true;
		Node_LS n =new S_LS(new Empty_LS());
		UnitTypeTable utt = new UnitTypeTable();
		this.adv = new Interpreter(utt,n);
		this.playout = new SimplePlayout();
		this.T0 = 2000;
		this.alpha=0.9;
		this.beta = 1;
		this.best = new S_LS(new Empty_LS());
		this.best_v= new Pair<>(-1.0,-1.0);
	}

	public SABasic(boolean clear,AI adv,Playout playout,double T0,double alpha,double beta) {
		// TODO Auto-generated constructor stub
		
		this.f = new FactoryLS();
		this.use_cleanr = clear;
		this.adv = adv;
		this.playout= playout;
		this.T0=T0;
		this.alpha = alpha;
		this.beta= beta;
		this.best = new S_LS(new Empty_LS());
		this.best_v = new Pair<>(-1.0,-1.0);
		
	}
	
	public boolean if_best(Pair<Double,Double> v1 ,Pair<Double,Double>  v2) {
		if(v2.m_a>v1.m_a)return true;
	
		boolean aux = Math.abs(v2.m_a - v1.m_a) <0.1;
		if(aux && v2.m_b > v1.m_b) return true;
		return false;
	}
	
	public boolean accept(Pair<Double,Double> v1 ,Pair<Double,Double>  v2) {
		if(v2.m_a>v1.m_a)return true;
	
		boolean aux = Math.abs(v2.m_a - v1.m_a) <0.1;
		if(aux && v2.m_b > v1.m_b) return true;
		return false;
	}
	
	Pair<Double,Double> Avalia(GameState gs, int max_cicle,Node_LS n) throws Exception{
		UnitTypeTable utt = new UnitTypeTable();
		AI ai = new Interpreter(utt,n);
		return this.playout.run(gs, 0, max_cicle, ai, adv, false);
		
	}
	
	boolean stop(Pair<Double,Double> v1 ) {
		return false;
	}
	
	@Override
	public Node run(GameState gs, int max_cicle) throws Exception {
		// TODO Auto-generated method stub
		
		long Tini1 = System.currentTimeMillis();
		long paraou1 = System.currentTimeMillis()-Tini1;
		while( (paraou1*1.0)/1000.0 <3600) {
			Random r =new Random();
			Node_LS atual =  new S_LS(new Empty_LS());
			Pair<Double,Double> v = new Pair<>(-1.0,-1.0);
			
		
			long Tini = System.currentTimeMillis();
			long paraou = System.currentTimeMillis()-Tini;
			while( (paraou*1.0)/1000.0 <360) {
				for(int i= 0;i<1000;i++) {
					if(this.stop(v))break;
					Node_LS aux = (Node_LS) (atual.Clone(f));
					int n = r.nextInt(aux.countNode());
					int custo = r.nextInt(9)+1;
					aux.mutation(n, custo);
				
					Pair<Double,Double> v2 = this.Avalia(gs, max_cicle,aux);
					//System.out.println(v2.m_b+" "+aux.translate());
					boolean b = accept(v,v2);
				//	System.out.println("atual "+v2.m_a+" "+v2.m_b+" "+aux.translate());
					
					if(b) {
						//System.out.println("Sujo "+aux.translate());
						if(this.use_cleanr)aux.clear(null, f);
						//System.out.println("Limpo "+aux.translate());
						//System.out.println("Ciclo "+i+":\n\t"+aux.translate()+"\n\t"+m_ais.m_a.translate());
						best = (Node_LS) aux.Clone(f);
			
						v=v2;
						
						if(if_best(this.best_v,v2)) {
							System.out.println("atual\t"+((paraou*1.0)/1000.0)+"\t"+v.m_a+"\t"+v.m_b+"\t"+
									best.translate()+"\t"+aux.translate());
							this.best = (Node_LS) aux.Clone(f);
							this.best_v = v;
						}
						
						
						
						
					}
					
				}
				paraou = System.currentTimeMillis()-Tini;
			//System.out.println(rep+" Ciclo "+i+": "+m_ais.m_a.translate());
			
			
			}
			paraou1 = System.currentTimeMillis()-Tini;
		}
		System.out.println("atual\t"+3600+"\t"+this.best_v.m_a+"\t"+this.best_v.m_b+"\t"+
				best.translate()+"\t"+this.best.translate());
		
		return this.best;
	}

	
}