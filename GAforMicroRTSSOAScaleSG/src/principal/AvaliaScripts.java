package principal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ai.RandomBiasedAI;
import ai.CMAB.A3NWithin;
import ai.abstraction.LightRush;
import ai.abstraction.WorkerRush;
import ai.configurablescript.BasicExpandedConfigurableScript;
import ai.configurablescript.ScriptsCreator;
import ai.core.AI;
import ai.evaluation.SimpleSqrtEvaluationFunction3;
import ai.synthesis.dslForScriptGenerator.DslAI;
import ai.synthesis.dslForScriptGenerator.DSLCommandInterfaces.ICommand;
import ai.synthesis.dslForScriptGenerator.DSLCompiler.IDSLCompiler;
import ai.synthesis.dslForScriptGenerator.DSLCompiler.MainDSLCompiler;
import ai.synthesis.grammar.dslTree.interfacesDSL.iDSL;
import ai.synthesis.twophasessa.TradutorDSL;
import rts.GameState;
import rts.PhysicalGameState;
import rts.PlayerAction;
import rts.units.UnitTypeTable;

public class AvaliaScripts {
	static String path_map = "";
	static int id_map=0;
	static UnitTypeTable utt;
	static String a = "";
	static String b = "";
	static String c = "";
	
	public static List<AI> decodeScripts(UnitTypeTable utt, String sScripts) {

		//decompõe a tupla
		ArrayList<Integer> iScriptsAi1 = new ArrayList<>();
		String[] itens = sScripts.split(";");

		for (String element : itens) {
			iScriptsAi1.add(Integer.decode(element));
		}

		List<AI> scriptsAI = new ArrayList<>();

		ScriptsCreator sc = new ScriptsCreator(utt, 300);
		ArrayList<BasicExpandedConfigurableScript> scriptsCompleteSet = sc.getScriptsMixReducedSet();

		iScriptsAi1.forEach((idSc) -> {
			scriptsAI.add(scriptsCompleteSet.get(idSc));
		});

		return scriptsAI;
	}
	
	public static AI getIA(int i) {
		if(i==0)return new A3NWithin(100, -1, 100, 8, 0.3F, 0.0F, 0.4F, 0, new RandomBiasedAI(utt),
				new SimpleSqrtEvaluationFunction3(), true, utt, "ManagerClosestEnemy", 3,
				decodeScripts(utt, "1;2;3;"), "A3N");
		else if(i==1) return new WorkerRush(utt);
		else if(i==2) return new LightRush(utt);
		else if(i==3) return ScriptHumano(id_map,0);
		else if(i==4) return ScriptHumano(id_map,1);
		else if(i==5) return ScriptHumano(id_map,2);
		else if(i==6) return ScriptHumano(id_map,3);
		return null;
	}
	
	public static void define_map(String i) {
		if(i.equals( "0")) {
		
			path_map = "./maps/mapadavid2.xml";
			id_map=0;
		}
		if(i.equals( "1")) {
			
			path_map = "./maps/8x8/basesWorkers8x8A.xml";
			id_map=1;
			
		}
		if(i.equals("3")) {
		
			path_map = "./maps/NoWhereToRun9x8.xml";
			id_map=3;
		}
		if(i.equals( "2")) {
			
			path_map = "./maps/24x24/basesWorkers24x24A.xml";
			id_map=2;
			
		}
		if(i.equals( "4")) {
		
			path_map = "./maps/DoubleGame24x24.xml";
			id_map=4;
		
		}
	}
	
	public static void ler() throws Exception {
		
		BufferedReader buffRead = new BufferedReader(new FileReader("./Camp/out_"+a+"_"+b+"_"+c+".txt"));
		String linha = "";
		linha = buffRead.readLine();
		while (true) {
			if (linha != null) {
				String dados[] = linha.split(";");
				String dados0[] = dados[0].split(" ");
				double r=0;
				if(dados0[0].equals("Camp")) {
					try {
						System.out.println("RRR  "+linha);
						TradutorDSL trad = new TradutorDSL(dados[1]);
						iDSL j = trad.getAST();
						r = Avalia(j,0);
					}catch(Exception e) {
						System.out.println("RRR  "+linha);
						r = 0;
					}
					try {
						TradutorDSL trad2 = new TradutorDSL(dados[2]);
						iDSL j2 = trad2.getAST();
						r += Avalia(j2,1);
					}
					catch(Exception e) {
						r += 0;
					}
					System.out.println("R "+r);
				}
				
			} else
				break;
			linha = buffRead.readLine();
		}
		buffRead.close();
	}
	
	private static AI buildCommandsIA(UnitTypeTable utt, iDSL code) {
		IDSLCompiler compiler = new MainDSLCompiler();   
        HashMap<Long, String> counterByFunction = new HashMap<Long, String>();
        List<ICommand> commandsDSL = compiler.CompilerCode(code, utt);
        AI aiscript = new DslAI(utt, commandsDSL, "P1", code, counterByFunction);
        return aiscript;
    }
	
	public	static AI ScriptHumano(int mapa, int p) {
		String s="";
		if(mapa==0) {
			if(p==0) s= "moveToUnit(Ranged,Enemy,closest) attack(Ranged,closest) attack(Heavy,closest)";
			if(p==1) s=  "if(IsPlayerInPosition(Left)) then(moveOnceToCoord(Heavy,3,2,4) moveOnceToCoord(Ranged,2,1,4)) if(IsPlayerInPosition(Right)) then(moveOnceToCoord(Ranged,3,16,4) moveOnceToCoord(Heavy,3,15,4)) attack(Heavy,closest) attack(Ranged,closest) ";
			if(p==2) s=  "if(HaveUnitsToDistantToEnemy(Ranged,8)) then(attack(Ranged,closest)) moveToUnit(Ranged,Ally,mostHealthy) attack(Heavy,closest)";
			if(p==3) s=  "attack(Heavy,closest) attack(Ranged,closest)";
		}
		else if(mapa==1) {
			if(p==0) s=  "attack(Worker,closest) train(Worker,5,EnemyDir)";
			if(p==1) s=  "harvest(1) train(Worker,100,EnemyDir) attack(Worker,closest)";
			if(p==2) s=  "harvest(1) train(Worker,50,EnemyDir) if(HaveUnitsToDistantToEnemy(All,3)) then(attack(All,closest))";
			if(p==3) s=  "train(Worker,25,Right) harvest(1) attack(Worker,closest)";
		}
		else if(mapa==2||mapa==4) {
			if(p==0) s=  "attack(Worker,closest) train(Worker,5,EnemyDir) ";
			if(p==1) s=  "harvest(4) build(Barrack,2,Down) train(Worker,100,EnemyDir) attack(Worker,closest) attack(Light,closest) train(Ranged,100,EnemyDir) attack(Ranged,closest) ";
			if(p==2) s=  "train(Worker,50,EnemyDir) harvest(2) if(HaveUnitsinEnemyRange(Worker)) then(attack(Worker,closest)) if(HaveQtdUnitsbyType(Worker,15)) then(attack(Worker,mostHealthy)) if(IsPlayerInPosition(Up)) then(moveToCoord(Worker,5,6) moveToCoord(Worker,18,6)) if(IsPlayerInPosition(Down)) then(moveToCoord(Worker,18,15) moveToCoord(Worker,5,15)) if(HaveQtdUnitsbyType(Worker,10)) then(harvest(10))";
			if(p==3) s=  "train(Worker,20,Up) harvest(5) attack(Worker,closest)";
		}
		else if(mapa==3) {
			if(p==0) s=  "train(Worker,1,Up) build(Barrack,1,Down) harvest(1) train(Ranged,5,EnemyDir) attack(Ranged,closest) train(Heavy,2,EnemyDir) attack(Heavy,closest) ";
			if(p==1) s=  "train(Worker,2,EnemyDir) if(IsPlayerInPosition(Right)) then(build(Barrack,1,Right)) if(IsPlayerInPosition(Left)) then(build(Barrack,1,Left)) harvest(3) train(Ranged,100,Up) attack(Ranged,closest) ";
			if(p==2) s=  "build(Barrack,1,Up) train(Worker,2,EnemyDir) harvest(2) train(Ranged,2,EnemyDir) attack(Ranged,closest) for(u) (if(HaveQtdUnitsAttacking(Ranged,1,u)) then(train(Ranged,50,EnemyDir,u))) for(u) (if(HaveUnitsinEnemyRange(Worker,u)) then(moveaway(Worker,u)))";
			if(p==3) s=  "train(Worker,25,Right) harvest(1) attack(Worker,closest)";
		}
		TradutorDSL trad = new TradutorDSL(s);
		iDSL j = trad.getAST();

		return  buildCommandsIA(utt,j);
	}
	
	public static double Avalia(iDSL s, int player) throws Exception {
		double cont=0;
		for(int i=0;i<7;i++) {
			
			PhysicalGameState pgs = PhysicalGameState.load(path_map, utt);
			
			
			
			GameState gs = new GameState(pgs, utt);
			
			double cont2=0;
			for(int j =0;j<5;j++) {
				System.out.println("jj "+j);
				AI  ai1 = buildCommandsIA(utt,s);
				AI  ai2 = getIA(i);
				cont2+=partida(gs,ai1,ai2,player);
			}
			cont+=cont2;
			System.out.println("TT "+i+" "+player+" "+cont2);
		
		}
		return cont;
	}
	
	public static double partida(GameState gs,AI ai1, AI ai2,int play) throws Exception {
		double r = 0;
		for(int p=0;p<1;p++) {
	
			GameState gs2 = gs.clone();
			
			boolean gameover = false;
			
			       do {
			    	   long Tini = System.currentTimeMillis();
	                PlayerAction pa1 = ai1.getAction(play, gs2);
	                
	                PlayerAction pa2 = ai2.getAction(1-play, gs2);
	                gs2.issueSafe(pa1);
	                gs2.issueSafe(pa2);
	        
	                gameover = gs2.cycle();
	                
	                
	        } while (!gameover && (gs2.getTime() <= 5000));   
			
			
			if(gs2.winner()==play)r+=1;
			else if (gs2.winner()==-1)r+=0.5;
		}
		return r;
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		a=args[0];
		b=args[1];
		c=args[2];
		define_map(args[1]);
		utt = new UnitTypeTable();
		ler();

	}

}
