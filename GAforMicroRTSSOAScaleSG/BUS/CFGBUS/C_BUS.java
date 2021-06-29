package CFGBUS;

import java.util.ArrayList;
import java.util.List;

import CFG.C;
import CFG.ChildC;
import CFG.Factory;
import CFG.FactoryBase;

public class C_BUS extends C implements NodeBUS  {

	int size;
	public C_BUS() {
		// TODO Auto-generated constructor stub
	}

	public C_BUS(ChildC childC) {
		super(childC);
		// TODO Auto-generated constructor stub
		size =1;
		//if(childC instanceof Attack)size+=2;
		//if(childC instanceof Build)size+=3;
		//if(childC instanceof Train)size+=3;
		//if(childC instanceof moveToUnit)size+=3;
		//if(childC instanceof MoveAway)size+=1;
		//if(childC instanceof Harvest)size+=1;
	}

	
	 public List<S_BUS> grow() {
		// TODO Auto-generated method stub
		List<S_BUS> plist = new ArrayList<>();
		Factory f = new FactoryBase();
		for(C c : this.AllCombinations(f)) {
			plist.add(new S_BUS(new C_BUS(c.getChildC())));
		}
		
		return plist;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

}
