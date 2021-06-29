package CFGBUS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import CFG.B;

public class ProgramList {
	Map<Integer, List<S_BUS>> plist;
	List<B> blist;
	int number_programs ;
	public ProgramList() {
		// TODO Auto-generated constructor stub
		this.number_programs=0;
		this.plist = new HashMap<Integer, List<S_BUS>>();
		this.blist = new ArrayList<>();
	}
	
	public List<S_BUS> get_programs(int i) {
		
		if (plist.containsKey(i)) {
			return plist.get(i);
		}
		return new ArrayList<>();
		
	}
	
	public int get_number_programs() {
		return this.number_programs;
	}

	
	public void insert(S_BUS program ) {
		int size = program.getSize();
		
		if (!plist.containsKey(size)) {
			plist.put(size, new ArrayList<>());
		}
		plist.get(size).add(program);
		this.number_programs+=1;
	}
	
	
	public void insertB(B b) {
		this.blist.add(b);
	}
	
	public List<B>  get_ProgramsB(){
		return blist;
	}
}
