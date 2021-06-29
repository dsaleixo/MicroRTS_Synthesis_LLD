package CFGBUS;

import CFG.ChildS;
import CFG.S;

public class S_BUS extends S implements NodeBUS {
	int size;
	public S_BUS() {
		// TODO Auto-generated constructor stub
	}

	public S_BUS(ChildS child) {
		super(child);
		// TODO Auto-generated constructor stub
		NodeBUS n = (NodeBUS)child;
		size = n.getSize();
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return  size;
	}

}
