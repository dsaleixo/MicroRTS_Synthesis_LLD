package CLG_David;

import rts.GameState;

public interface Node {

	
	String translate();
	void interpret(GameState gs,int player, Interpreter automato);
	boolean isComplete();
	
	String getName();
	String translateIndentation(int tap);
}
