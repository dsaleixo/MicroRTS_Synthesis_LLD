package SBI_CFG;

import CFG.Node;

public interface Node_SBI extends Node {
	void sample(int budget);
	int countNode();
	void mutation(int node_atual,int budget);
}
