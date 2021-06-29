package CFGBUS;

import java.util.ArrayList;
import java.util.List;

import AIs.Search;
import CFG.B;
import CFG.Factory;
import CFG.FactoryBase;
import CFG.Node;
import Evaluations.Evaluation;
import Evaluations.Playout;
import Evaluations.SimplesEvaluations;
import rts.GameState;
import util.Pair;

public class BottomUp_Search implements Search {
	Evaluation eval;
	Factory f;
	
	public Pair<Node,Node> getAIs() {
		return eval.getAIS();
	}
	
	public BottomUp_Search() {
		// TODO Auto-generated constructor stub
		eval = new SimplesEvaluations();
		f = new FactoryBase();
	}

	 void init(ProgramList plist) {
		C_BUS c = new C_BUS();
		List<S_BUS> l = c.grow();
		for(S_BUS s : l) {
			plist.insert(s);
		}
		
		
		B_BUS b = new B_BUS();
		List<B> bl = b.AllCombinations(f);
		for(B s : bl) {
			plist.insertB(s);
		}
		
	}
	
	 List<Grow> grower(){
		
		List<Grow> l = new ArrayList<>();
		l.add(new For_S_BUS());
		l.add(new S_S_BUS());
		l.add(new If_B_then_S_else_S_BUS());
		l.add(new If_B_then_S_BUS());
		return l;
	}
	
	 void  grows(ProgramList plist,int size, GameState gs, int max_cycle) throws Exception {
		
		
		List<Grow> grower = this.grower();
		List<S_BUS> newList = new ArrayList<>();
		for(Grow g : grower) {
			g.grow(plist, size, newList);
		
		}
		
		for(S_BUS s : newList) {
			this.eval.evaluation(gs, new Pair<>(s,s), max_cycle,f);

			plist.insert(s);
		}
		
		
		
	}

	
	
	 @Override
	public Pair<Node, Node> run(GameState gs,int max_cicle) throws Exception{
		
		ProgramList plist= new ProgramList();
		
		this.init(plist);
		
		
		for(int i =1;i<8;i++) {
			long Tini = System.currentTimeMillis();
			this.grows(plist, i,gs,max_cicle);

			long paraou = System.currentTimeMillis()-Tini;
			double tempo_total = (paraou*1.0)/1000.0;
			System.out.println("nivel " +i+"\t number programs "+plist.get_programs(i).size()
															+"\t number invalid "+Playout.n/2+"\t tempo "+tempo_total);
			System.out.println(this.eval.getAIS().m_a.translate());
		
		}
		
		
		return this.eval.getAIS();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
		
	}

}
