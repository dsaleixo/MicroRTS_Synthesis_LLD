package CFGBUS;

import java.util.ArrayList;
import java.util.List;
import CFG.B;
import CFG.If_B_then_S_else_S;
import CFG.S;

public class If_B_then_S_else_S_BUS extends If_B_then_S_else_S implements Grow {
	int size;
	public If_B_then_S_else_S_BUS() {
		// TODO Auto-generated constructor stub
	}

	public If_B_then_S_else_S_BUS(B b, S then_S, S else_S) {
		super(b, then_S, else_S);
		// TODO Auto-generated constructor stub
		S_BUS s1 = (S_BUS)then_S;
		S_BUS s2 = (S_BUS)else_S;
		this.size = 2 + s1.getSize() + s2.getSize(); 
	}

	

	@Override
	public List<List<Integer>> createcombinations(int size) {
		// TODO Auto-generated method stub
	
			List<List<Integer>>  l = new ArrayList<>();
			for(int i =1;i<size;i++) {
				
				for(int j=1;j<size;j++) {
					List<Integer>  l2 = new ArrayList<>();
					l2.add(i);
					l2.add(j);
					l.add(l2);
				}
				
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
			
			if(c.get(1)+c.get(0)+2 !=Size)continue;
			
			List<S_BUS> program_set1 = plist.get_programs(c.get(0));
           
			List<S_BUS> program_set2 = plist.get_programs(c.get(1));
	
			
			
		
			for(B b : plist.get_ProgramsB()) {
				for(S_BUS s1 : program_set1) {
					for(S_BUS s2 : program_set2) {
						S_BUS aux = new S_BUS(new If_B_then_S_else_S_BUS(b,s1,s2));
						newList.add(aux);
					}
				}
			}
		
		}
	}

	

}
