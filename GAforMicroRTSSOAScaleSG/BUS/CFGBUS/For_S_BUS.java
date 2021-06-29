package CFGBUS;

import java.util.ArrayList;
import java.util.List;
import CFG.For_S;
import CFG.S;

public class For_S_BUS extends For_S implements Grow {
	int size;
	public For_S_BUS() {
		// TODO Auto-generated constructor stub
	}

	public For_S_BUS(S child) {
		super(child);
		// TODO Auto-generated constructor stub
		S_BUS s = (S_BUS)child;
		this.size = s.getSize() + 1; 
	}

	
	
	@Override
	public List<List<Integer>> createcombinations(int size) {
		// TODO Auto-generated method stub
		List<List<Integer>>  l = new ArrayList<>();
		for(int i =1;i<size;i++) {
			
				List<Integer>  l2 = new ArrayList<>();
				l2.add(i);
				l.add(l2);
		}
	
		return l;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public void grow(ProgramList plist, int Size,  List<S_BUS> newList) {
		// TODO Auto-generated method stub
		List<List<Integer>> combinations = createcombinations(Size);
		
		for (List<Integer> c : combinations) {
			
			if(c.get(0)+1!=Size)continue;
			
			List<S_BUS> program_set1 = plist.get_programs(c.get(0));
    
			for(S_BUS s1 : program_set1) {
				S_BUS aux = new S_BUS(new For_S_BUS(s1));
				newList.add(aux);
			}
		
		}
	}

	

}
