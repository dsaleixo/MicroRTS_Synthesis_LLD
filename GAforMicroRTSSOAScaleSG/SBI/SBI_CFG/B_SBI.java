package SBI_CFG;

import java.util.Random;

import CFG.B;
import CFG.ChildB;
import LS_CFG.Node_LS;
import LS_Condition.CanAttack_LS;
import LS_Condition.CanHarvest_LS;
import LS_Condition.HasLessNumberOfUnit_LS;
import LS_Condition.HasNumberOfUnits_LS;
import LS_Condition.HasNumberOfWorkersHarvesting_LS;
import LS_Condition.HasUnitInOpponentRange_LS;
import LS_Condition.HasUnitThatKillsInOneAttack_LS;
import LS_Condition.HasUnitWithinDistanceFromOpponent_LS;
import LS_Condition.HaveQtdUnitsAttacking_LS;
import LS_Condition.Is_Builder_LS;
import LS_Condition.Is_Type_LS;
import LS_Condition.OpponentHasNumberOfUnits_LS;
import LS_Condition.OpponentHasUnitInPlayerRange_LS;
import LS_Condition.OpponentHasUnitThatKillsUnitInOneAttack_LS;

public class B_SBI extends B implements Node_SBI, NoTerminal_SBI {

	public B_SBI() {
		// TODO Auto-generated constructor stub
	}

	public B_SBI(ChildB childB) {
		super(childB);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Node_LS sorteiaFilho(int budget) {
		// TODO Auto-generated method stub
		Random gerador = new Random();
		
		int g = gerador.nextInt(14);

		if(g==0) return new CanAttack_LS();
		if(g==1) return new CanHarvest_LS();
		if(g==2) return new HasLessNumberOfUnit_LS();
		if(g==3) return new HasNumberOfUnits_LS();
		if(g==4) return new HasNumberOfWorkersHarvesting_LS();
		if(g==5) return new HasUnitInOpponentRange_LS();
		if(g==6) return new HasUnitThatKillsInOneAttack_LS();
		if(g==7) return new HasUnitWithinDistanceFromOpponent_LS();
		if(g==8) return new HaveQtdUnitsAttacking_LS();
		if(g==9) return new Is_Builder_LS();
		if(g==10) return new Is_Type_LS();
		if(g==11) return new OpponentHasNumberOfUnits_LS();
		if(g==12) return new OpponentHasUnitInPlayerRange_LS();
		if(g==13) return new OpponentHasUnitThatKillsUnitInOneAttack_LS();
		return null;
	}

	@Override
	public void sample(int budget) {
		// TODO Auto-generated method stub
		Node_LS child = this.sorteiaFilho(budget);
		child.sample(budget );
		this.setChildB((ChildB)child);
	}

	@Override
	public int countNode() {
		// TODO Auto-generated method stub
		Node_LS n2 = (Node_LS)this.getChildB();
		return 1 + n2.countNode();
	}

	@Override
	public void mutation(int node_atual, int budget) {
		if(node_atual==0)this.sample(budget);
		else {
			Node_LS n2 = (Node_LS)this.getChildB();
			node_atual-=1;
			n2.mutation(node_atual, budget);
		}
		
	}

}
