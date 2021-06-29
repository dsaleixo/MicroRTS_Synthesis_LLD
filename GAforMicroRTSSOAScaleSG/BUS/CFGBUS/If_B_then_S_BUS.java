package CFGBUS;

import java.util.ArrayList;
import java.util.List;
import CFG.B;
import CFG.If_B_then_S;
import CFG.S;

public class If_B_then_S_BUS extends If_B_then_S implements Grow {

	int size;
	public If_B_then_S_BUS() {
		// TODO Auto-generated constructor stub
	}

	public If_B_then_S_BUS(B b, S s) {
		super(b, s);
		// TODO Auto-generated constructor stub
		S_BUS n = (S_BUS)s;
		this.size = 2 + n.getSize();
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
		return this.size;
	}

	@Override
	public void grow(ProgramList plist, int Size, List<S_BUS> newList) {
		// TODO Auto-generated method stub
		List<List<Integer>> combinations = createcombinations(Size);
		
		for (List<Integer> c : combinations) {
			
			if(c.get(0)+2 !=Size)continue;
			
			List<S_BUS> program_set1 = plist.get_programs(c.get(0));
    
	
			for(B b : plist.get_ProgramsB()) {
				for(S s1 : program_set1) {
					
						S_BUS aux = new S_BUS(new If_B_then_S_BUS(b,s1));
						newList.add(aux);
					
				}
			}
		
		}
		
	}

	

}
