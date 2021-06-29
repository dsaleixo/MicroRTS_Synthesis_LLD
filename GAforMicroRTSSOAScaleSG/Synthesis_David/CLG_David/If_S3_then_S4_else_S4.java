package CLG_David;

import rts.GameState;
import rts.units.Unit;

public class If_S3_then_S4_else_S4 implements ChildS2U, NodeU {

	
	S3 s3;
	S4 then_S4;
	S4 else_S4;
	
	
	public If_S3_then_S4_else_S4() {
		// TODO Auto-generated constructor stub
		s3 = new S3();
		then_S4 = new S4();
		else_S4 = new S4();
	}

	public If_S3_then_S4_else_S4(S3 s3,S4 then_S4,S4 else_S4) {
		// TODO Auto-generated constructor stub
		this.s3 = s3;
		this.then_S4 = then_S4;
		this.else_S4 = else_S4;
	}
	
	
	
	
	public S3 getS3() {
		return s3;
	}






	public void setS3(S3 s3) {
		this.s3 = s3;
	}






	public S4 getThen_S4() {
		return then_S4;
	}






	public void setThen_S4(S4 then_S4) {
		this.then_S4 = then_S4;
	}






	public S4 getElse_S4() {
		return else_S4;
	}






	public void setElse_S4(S4 else_S4) {
		this.else_S4 = else_S4;
	}






	@Override
	public String translate() {
		// TODO Auto-generated method stub
		return "if( "+this.s3.translate()+" ) then { "+this.then_S4.translate()+" } else {"+this.else_S4.translate()+" }";
	}



	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}








	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "if_S3_then_s4_else_S4";
	}

	@Override
	public void interpret(GameState gs, int player, Interpreter automato) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void interpret(GameState gs, int player, Unit u, Interpreter automato) {
		// TODO Auto-generated method stub
		s3.interpret(gs, player,u, automato);
		
		boolean bool = s3.getValue();
		
	
		if(bool) {
			
			if (this.then_S4!=null)this.then_S4.interpret(gs, player,u, automato);
		}
		else {
		
			if (this.else_S4!=null)this.else_S4.interpret(gs, player,u, automato);
		}
		
	}

	@Override
	public String translateIndentation(int tap) {
		// TODO Auto-generated method stub
		String esp= "";
		for(int i =0; i<tap;i++)esp+="\t";
		return esp+"if( "+this.s3.translate()+" ) then {\n "+
				this.then_S4.translateIndentation(tap+1)+"\n"+
				esp+"} else {\n"+
				this.else_S4.translateIndentation(tap+1)+"\n"+
				esp+" }";
	}

}
