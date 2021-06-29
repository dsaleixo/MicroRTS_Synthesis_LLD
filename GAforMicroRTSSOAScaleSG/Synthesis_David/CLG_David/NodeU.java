package CLG_David;

import rts.GameState;
import rts.units.Unit;

public interface NodeU extends Node {

	void interpret(GameState gs, int player, Unit u,Interpreter automato);
}
