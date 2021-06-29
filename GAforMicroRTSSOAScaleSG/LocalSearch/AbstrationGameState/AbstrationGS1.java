package AbstrationGameState;

import rts.GameState;
import rts.PhysicalGameState;
import rts.units.Unit;

public class AbstrationGS1 implements AbstrationGS {
	int worker;
	int light;
	int ranged;
	int heavy;
	int base;
	int barrack;
	int saved_resource;
	
	
	public AbstrationGS1(GameState gs,int player) {
		// TODO Auto-generated constructor stub
		this.worker=0;
		this.light=0;
		this.ranged=0;
		this.heavy=0;
		this.base=0;
		this.barrack=0;
		
		PhysicalGameState pgs = gs.getPhysicalGameState();
		this.saved_resource=pgs.getPlayer(player).getResources();
		for(Unit u2:pgs.getUnits()) {
            if(u2.getPlayer()==player) {
            	if(u2.getType().name.equals("Worker"))worker+=1;
            	if(u2.getType().name.equals("Base"))base+=1;
            	if(u2.getType().name.equals("Ranged"))ranged+=1;
            	if(u2.getType().name.equals("Light"))light+=1;
            	if(u2.getType().name.equals("Heavy"))heavy+=1;
            	if(u2.getType().name.equals("Barracks"))barrack+=1;
            }

		 }
		
	}

	double diffType(int a,int b) {
		if(a==0&&b==0)return 0;
		double delta = Math.abs( a-b);
		return delta /Math.max(a,b);
	}
	
	@Override
	public float comparar(AbstrationGS ags) {
		// TODO Auto-generated method stub
	
		if(!(ags instanceof AbstrationGS1))return 0;
		
		AbstrationGS1 ags1 = (AbstrationGS1)ags;
		double pont= 0.0;
		
		pont += 1 - diffType(this.worker,ags1.worker);
		pont += 1 - diffType(this.light,ags1.light);	
		pont += 1 - diffType(this.ranged,ags1.ranged);	
		pont += 1 - diffType(this.heavy,ags1.heavy);	
		pont += 1 - diffType(this.base,ags1.base);	
		pont += (1 - diffType(this.barrack,ags1.barrack));	
		pont += 1 - diffType(this.saved_resource,ags1.saved_resource);	
		
		return (float) (pont/7);
	}

}
