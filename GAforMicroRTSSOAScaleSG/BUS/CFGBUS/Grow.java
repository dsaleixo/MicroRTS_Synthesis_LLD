package CFGBUS;

import java.util.List;



public interface Grow extends NodeBUS {

	void grow(ProgramList plist,int Size,List<S_BUS> newList);
	List<List<Integer>> createcombinations(int size);
}
