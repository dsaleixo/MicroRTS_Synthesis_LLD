package CFGBUS;

import CFG.B;
import CFG.ChildB;

public class B_BUS extends B implements NodeBUS {

	public B_BUS() {
		// TODO Auto-generated constructor stub
	}

	public B_BUS(ChildB childB) {
		super(childB);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 1;
	}

}
