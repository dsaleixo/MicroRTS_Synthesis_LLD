package CLG_David;

import rts.GameState;
import rts.units.Unit;

public class NotS3 implements ChildS5U {

	
	S3 s3;
	
	public NotS3() {
		// TODO Auto-generated constructor stub
		s3 = new S3();
	}

	
	
	
	
	public NotS3(S3 s3) {
		super();
		this.s3 = s3;
	}





	public S3 getS3() {
		return s3;
	}





	public void setS3(S3 s3) {
		this.s3 = s3;
	}





	@Override
	public String translate() {
		// TODO Auto-generated method stub
		if(this.s3==null)return " not S3";
		return " not "+this.s3.translate();
	}

	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "NotS3";
	}


	@Override
	public boolean getValue() {
		// TODO Auto-generated method stub
		return this.s3.getValue() == false;
	}





	@Override
	public void interpret(GameState gs, int player, Unit u, Interpreter automato) {
		// TODO Auto-generated method stub
		if(this.s3==null)this.s3.interpret(gs, player, u, automato);
		
	}





	@Override
	public void interpret(GameState gs, int player, Interpreter automato) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public String translateIndentation(int tap) {
		// TODO Auto-generated method stub
		if(this.s3==null)return " not S3";
		return " not "+this.s3.translateIndentation(tap);
	}

}
