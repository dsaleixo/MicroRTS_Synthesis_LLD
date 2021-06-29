package CLG_David;

import java.util.List;

import ai.abstraction.AbstractionLayerAI;
import ai.abstraction.pathfinding.AStarPathFinding;

import ai.core.AI;
import ai.core.ParameterSpecification;
import rts.GameState;

import rts.PlayerAction;

import rts.units.UnitType;
import rts.units.UnitTypeTable;

public class Interpreter extends AbstractionLayerAI {

	
	protected UnitTypeTable utt;
	UnitType workerType;
    UnitType baseType;
    UnitType barracksType;
    UnitType lightType;
    Node node;
	
	public Interpreter(UnitTypeTable a_utt) {
		this(a_utt, new AStarPathFinding());
		// TODO Auto-generated constructor stub
	}

	public Interpreter(UnitTypeTable a_utt,Node n) {
		this(a_utt, new AStarPathFinding());
		// TODO Auto-generated constructor stub
		this.node = n;
	}

	public Interpreter(UnitTypeTable a_utt, AStarPathFinding a_pf) {
		super(a_pf);
        reset(a_utt);
	}

	
	@Override
	public void reset(UnitTypeTable a_utt)  
    {
        utt = a_utt;
        workerType = utt.getUnitType("Worker");
        baseType = utt.getUnitType("Base");
        barracksType = utt.getUnitType("Barracks");
        lightType = utt.getUnitType("Light");
    }   


	
	
	
	public Node getNode() {
		return node;
	}



	public void setNode(Node node) {
		this.node = node;
	}



	@Override
	public PlayerAction getAction(int player, GameState gs) throws Exception {
		// TODO Auto-generated method stub

	
		node.interpret(gs, player, this);
		return translateActions(player, gs);
	}

	@Override
	public AI clone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ParameterSpecification> getParameters() {
		// TODO Auto-generated method stub
		return null;
	}

}
