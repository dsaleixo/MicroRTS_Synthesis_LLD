package principal;


import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;

import ai.RandomBiasedAI;
import ai.CMAB.A3NWithin;
import ai.abstraction.LightRush;
import ai.abstraction.RangedRush;
import ai.abstraction.WorkerRush;
import ai.configurablescript.BasicExpandedConfigurableScript;
import ai.configurablescript.ScriptsCreator;
import ai.core.AI;
import ai.evaluation.EvaluationFunction;
import ai.evaluation.SimpleSqrtEvaluationFunction3;
import ai.synthesis.dslForScriptGenerator.DslAI;
import ai.synthesis.dslForScriptGenerator.DSLCommandInterfaces.ICommand;
import ai.synthesis.dslForScriptGenerator.DSLCompiler.IDSLCompiler;
import ai.synthesis.dslForScriptGenerator.DSLCompiler.MainDSLCompiler;
import ai.synthesis.grammar.dslTree.builderDSLTree.BuilderDSLTreeSingleton;
import ai.synthesis.grammar.dslTree.interfacesDSL.iDSL;
import ai.synthesis.grammar.dslTree.utils.ReduceDSLController;
import ai.synthesis.twophasessa.TradutorDSL;
import ga.ScriptTableGenerator.ScriptsTable;
import ga.config.ConfigurationsGA;
import gui.PhysicalGameStatePanel;
import rts.GameState;
import rts.PhysicalGameState;
import rts.PlayerAction;
import rts.units.Unit;
import rts.units.UnitType;
import rts.units.UnitTypeTable;
import ga.util.Evaluation.AvaliaInvidual;


public class TestBU {
	
	static String curriculumportfolio = "empty";	;
	static Random rand = new Random();
	static private List<GameState> states;
	static UnitTypeTable utt;
	static List<iDSL> sIA1;
	static List<iDSL> sIA2;
	static List<iDSL> Camp;
	static List<Double> CampTempo;
	static int n_filho=40;
	static int n_ficticions=5;
	static int erros= 5;
	
	
	
	static double horas = 24;
	

	static ScriptsTable scrTable;
	private final static String pathTableScripts = System.getProperty("user.dir").concat("/Table/");
	private final static String pathUsedCommands = System.getProperty("user.dir").concat("/commandsUsed/");
	private final static String pathLogs = System.getProperty("user.dir").concat("/Tracking/");
	static String scriptsSetCover="";
	static HashSet<String> booleansUsed=new HashSet<>();

	static String path_map = "maps/mapadavid2.xml";
	static int max_cicle=500;
	static int id_map=0;
	static File arq ;
	static PrintWriter gravarArq ;
	static int cont=0;
	static UnitType workerType;
	static   UnitType baseType;
	static    UnitType barracksType;
	static   UnitType lightType;
	static  UnitType heavyType;
	static    UnitType rangedType;
	static EvaluationFunction evaluation = new SimpleSqrtEvaluationFunction3();
	
	
	public static void imprimir_gs(GameState gs) {
		int w1 = 0;
        int br1 = 0;
        int ba1 = 0;
        int r1 = 0;
        int l1 = 0;
        int h1 = 0;
        int w2 = 0;
        int br2 = 0;
        int ba2 = 0;
        int r2 = 0;
        int l2 = 0;
        int h2 = 0;
        EvaluationFunction evaluation = new SimpleSqrtEvaluationFunction3();
        for (Unit u : gs.getUnits()) {
            if (u.getPlayer() == 0) {
                if (u.getType() == baseType) {
                    ba1++;
                } else if (u.getType() == barracksType) {
                    br1++;
                } else if (u.getType() == lightType) {
                    l1++;
                } else if (u.getType() == rangedType) {
                    r1++;
                } else if (u.getType() == heavyType) {
                    h1++;
                } else if (u.getType() == workerType) {
                    w1++;
                }
            }

            if (u.getPlayer() == 1) {
                if (u.getType() == baseType) {
                    ba2++;
                } else if (u.getType() == barracksType) {
                    br2++;
                } else if (u.getType() == lightType) {
                    l2++;
                } else if (u.getType() == rangedType) {
                    r2++;
                } else if (u.getType() == heavyType) {
                    h2++;
                } else if (u.getType() == workerType) {
                    w2++;
                }
            }
        }

        System.out.println("----------------------------------------------------");
        System.out.println("Player 0 avaliacao = " + evaluation.evaluate(0, 1, gs));
        System.out.println("		Recurso = " + gs.getPlayer(0).getResources());
        System.out.println("		Base = " + ba1);
        System.out.println("		barracks = " + br1);
        System.out.println("		Worker = " + w1);
        System.out.println("		Light = " + l1);
        System.out.println("		Heavy = " + h1);
        System.out.println("		Ranged = " + r1);

        System.out.println("Player 1 avaliacao = " + evaluation.evaluate(1, 0, gs));
        System.out.println("		Recurso = " + gs.getPlayer(1).getResources());
        System.out.println("		Base = " + ba2);
        System.out.println("		barracks = " + br2);
        System.out.println("		Worker = " + w2);
        System.out.println("		Light = " + l2);
        System.out.println("		Heavy = " + h2);
        System.out.println("		Ranged = " + r2);
        System.out.println("");
        System.out.println("");
        
        
        gravarArq.println("----------------------------------------------------");
        gravarArq.println("Player 0 avaliacao = " + evaluation.evaluate(0, 1, gs));
        gravarArq.println("		Recurso = " + gs.getPlayer(0).getResources());
        gravarArq.println("		Base = " + ba1);
        gravarArq.println("		barracks = " + br1);
        gravarArq.println("		Worker = " + w1);
        gravarArq.println("		Light = " + l1);
        gravarArq.println("		Heavy = " + h1);
        gravarArq.println("		Ranged = " + r1);

        gravarArq.println("Player 1 avaliacao = " + evaluation.evaluate(1, 0, gs));
        gravarArq.println("		Recurso = " + gs.getPlayer(1).getResources());
        gravarArq.println("		Base = " + ba2);
        gravarArq.println("		barracks = " + br2);
        gravarArq.println("		Worker = " + w2);
        gravarArq.println("		Light = " + l2);
        gravarArq.println("		Heavy = " + h2);
        gravarArq.println("		Ranged = " + r2);
        gravarArq.println("	");
        gravarArq.println("	");
    }
	
	
	
	public	static AI ScriptHumano(int mapa, int p) {
		String s="";
		if(mapa==0) {
			if(p==0) s= "moveToUnit(Ranged,Enemy,closest) attack(Ranged,closest) attack(Heavy,closest)";
			if(p==1) s=  "attack(Heavy,closest) attack(Ranged,closest)";
			if(p==2) s=  "if(HaveUnitsToDistantToEnemy(Ranged,8)) then(attack(Ranged,closest)) moveToUnit(Ranged,Ally,mostHealthy) attack(Heavy,closest)";
			if(p==3) s=  "attack(Heavy,closest) attack(Ranged,closest)";
		}
		else if(mapa==1) {
			if(p==0) s=  "attack(Worker,closest) train(Worker,5,EnemyDir)";
			if(p==1) s=  "harvest(1) train(Worker,100,EnemyDir) attack(Worker,closest)";
			if(p==2) s=  "harvest(1) train(Worker,50,EnemyDir) if(HaveUnitsToDistantToEnemy(All,3)) then(attack(All,closest))";
			if(p==3) s=  "train(Worker,25,Right) harvest(1) attack(Worker,closest)";
		}
		else if(mapa==2 || mapa==4) {
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
	
	
	public static void define_map(String i) {
		if(i.equals( "0")) {
			max_cicle=500;
			path_map = "./maps/mapadavid2.xml";
			id_map=0;
		}
		if(i.equals( "1")) {
			max_cicle=1500;
		
			path_map = "./maps/8x8/basesWorkers8x8A.xml";
			id_map=1;
		}
		if(i.equals("3")) {
			max_cicle=1500;
			path_map = "./maps/NoWhereToRun9x8.xml";
			id_map=3;
			horas=24;
		}
		if(i.equals( "2")) {
			max_cicle=2200;
			path_map = "./maps/24x24/basesWorkers24x24A.xml";
			id_map=2;
			horas=24;
		}
		if(i.equals( "4")) {
			max_cicle=5200;
			path_map = "./maps/DoubleGame24x24.xml";
			id_map=4;
			horas=24;
		}
	}
	
	public static void BuscaBU(int div) throws Exception {
		PhysicalGameState pgs = PhysicalGameState.load(path_map, utt);
		
		 GameState gs = new GameState(pgs, utt);
		long Tini = System.currentTimeMillis();
		int cont=0;
		boolean parada=true;
		while(parada) {
		
			
			
			AI ai1 =new A3NWithin(100, -1, 100, 8, 0.3F, 0.0F, 0.4F, 0, new RandomBiasedAI(utt),
					new SimpleSqrtEvaluationFunction3(), true, utt, "ManagerClosestEnemy", 3,
					decodeScripts(utt, "1;2;3;"), "A3N");
			
			AI ai2 =new A3NWithin(100, -1, 100, 8, 0.3F, 0.0F, 0.4F, 0, new RandomBiasedAI(utt),
					new SimpleSqrtEvaluationFunction3(), true, utt, "ManagerClosestEnemy", 3,
					decodeScripts(utt, "1;2;3;"), "A3N");
			
			if(id_map==1) {
				ai1 = new WorkerRush(utt);
				
				ai2 = new WorkerRush(utt);
			}
			if(id_map==2 ) {
				ai1 = new LightRush(utt);
				
				ai2 = new LightRush(utt);
			}
			if(id_map==4) {
				ai1 = new RangedRush(utt);
				
				ai2 = new RangedRush(utt);
			}
			
			
			if(div==1) {
				states.clear();
				states.add(gs.clone());
			}else {
				GerarPartida(ai1,ai2,path_map,false);
				filtra(div);
			}
			//ShowStates();
			sIA1 = new ArrayList<>();
			sIA2 = new ArrayList<>();
		    for(int i = 0;i<states.size();i++) {
		    	
		    	GameState gss = states.get(i).clone();
		    	long parar = System.currentTimeMillis()-Tini;
		    	if((parar*1.0)/1000.0>horas*3600.0) {
					System.out.println("criterio "+parar);
					parada=false;
					break;
				}
		    	
		    	Busca(gss,max_cicle,Tini);
		    	
		    	 
				    	 
				if(sIA1.size()!=0 && sIA2.size()!=0) {
					iDSL LSFinal0 = sIA1.get(sIA1.size()-1);
					iDSL LSFinal1 = sIA2.get(sIA2.size()-1);
						 
						//sIA1.add((iDSL) LSFinal0.clone());
						//sIA2.add((iDSL) LSFinal1.clone());
					}
		    	
		  	
		    }
		 ;
	    	 
			if(sIA1.size()!=0 && sIA2.size()!=0) {
				iDSL LSFinal0 = sIA1.get(sIA1.size()-1);
				iDSL LSFinal1 = sIA2.get(sIA2.size()-1);
				long paraou = System.currentTimeMillis()-Tini;
				CampTempo.add((paraou*1.0)/1000.0);
				CampTempo.add((paraou*1.0)/1000.0);
				 Camp.add(LSFinal0);
				 Camp.add(LSFinal1);
				 gravarArq.println("Ganhador "+cont);
				 System.out.println("Ganhador "+cont);
				 gravarArq.println("script 0 = "+LSFinal0.translate());
				 System.out.println("script 0 = "+LSFinal0.translate());
				 gravarArq.println("script 1 = "+LSFinal1.translate());
				 System.out.println("script 1 = "+LSFinal1.translate());
				 gravarArq.println("");
				 System.out.println("");
				 cont++;
			}
		
		}
	}
	
	public static void BuscaTD() throws Exception {
		PhysicalGameState pgs = PhysicalGameState.load(path_map, utt);
		
		 GameState gs = new GameState(pgs, utt);
		long Tini = System.currentTimeMillis();
		int cont=0;
		boolean parada=true;
		while(parada) {
		
			
			//ShowStates();
			sIA1 = new ArrayList<>();
			sIA2 = new ArrayList<>();
			int limite =150;
		    while(true) {
		    	
		    	
		    	long parar = System.currentTimeMillis()-Tini;
		    	if((parar*1.0)/1000.0>horas*3600.0) {
					System.out.println("criterio "+parar);
					parada=false;
					break;
				
		    	
		    	}
		    	boolean terminou = Busca(gs,limite,Tini);
		    	gravarArq.println("rodou limite = "+limite+" foi ate o fim "+terminou);
				System.out.println("rodou limite = "+limite+" foi ate o fim "+terminou);
		    	if(limite>max_cicle|| terminou)break;
		    	limite+=limite;
		    	
		    	
		    
			    	 
				if(sIA1.size()!=0 && sIA2.size()!=0) {
					iDSL LSFinal0 = sIA1.get(sIA1.size()-1);
					iDSL LSFinal1 = sIA2.get(sIA2.size()-1);
					 
					//sIA1.add(LSFinal0);
					//sIA2.add(LSFinal1);
				}
		    	
		    	
		    	
		    	
		    	
		  	
		    }
	
	    	 
			if(sIA1.size()!=0 && sIA2.size()!=0) {
			 iDSL LSFinal0 = sIA1.get(sIA1.size()-1);
			 iDSL LSFinal1 = sIA2.get(sIA2.size()-1);
			 Camp.add(LSFinal0);
			 Camp.add(LSFinal1);
			long paraou = System.currentTimeMillis()-Tini;
			CampTempo.add((paraou*1.0)/1000.0);
			CampTempo.add((paraou*1.0)/1000.0);
			 gravarArq.println("Ganhador "+cont);
			 System.out.println("Ganhador "+cont);
			 gravarArq.println("script 0 = "+LSFinal0.translate());
			 System.out.println("script 0 = "+LSFinal0.translate());
			 gravarArq.println("script 1 = "+LSFinal1.translate());
			 System.out.println("script 1 = "+LSFinal1.translate());
			 gravarArq.println("");
			 System.out.println("");
			 cont++;
			}
			 
		
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		utt = new UnitTypeTable();
		states = new ArrayList<>();
		
		sIA1 = new ArrayList<>();
		sIA2 = new ArrayList<>();
		
		Camp = new ArrayList<>();
		CampTempo = new ArrayList<>();

	
		
		scrTable = new ScriptsTable(pathTableScripts);
		
		//scrTable = scrTable.generateScriptsTable(ConfigurationsGA.SIZE_TABLE_SCRIPTS);
				scrTable = scrTable.generateScriptsTableFromSetCover(ConfigurationsGA.SIZE_TABLE_SCRIPTS,scriptsSetCover,booleansUsed,curriculumportfolio);
				//scrTable = scrTable.generateScriptsTableRecover();
				scrTable.setCurrentSizeTable(scrTable.getScriptTable().size());
		
		
		
	
		scrTable.setCurrentSizeTable(scrTable.getScriptTable().size());
		
		
		arq = new File("./rrr/log_"+args[2]+"_"+args[1]+"_"+args[0]+".txt");
		int div =0;
		if(args[2].equals("0")) div=0;
		if(args[2].equals("1")) div=1;
		if(args[2].equals("2")) div=2;
		if(args[2].equals("3")) div=3;
		if(args[2].equals("4")) div=4;
		if(args[2].equals("5")) div=5;
		if(args[2].equals("6")) div=6;
		if(args[2].equals("7")) div=7;
		if(args[2].equals("8")) div=8;
		 System.out.println("dividir "+div+" horas "+horas);
		gravarArq = new PrintWriter(arq);
		gravarArq.println("trtrt");
		gravarArq.println("trtrt");
		define_map(args[1]);
		
	     workerType = utt.getUnitType("Worker");
	      baseType = utt.getUnitType("Base");
	     barracksType = utt.getUnitType("Barracks");
	        rangedType = utt.getUnitType("Ranged");
	        heavyType = utt.getUnitType("Heavy");
	        lightType = utt.getUnitType("Light");
		
		
		

		
	        System.out.println(" horasss "+horas);
	
		System.out.println("map "+path_map);
		 PhysicalGameState pgs = PhysicalGameState.load(path_map, utt);
				
		 GameState gs = new GameState(pgs, utt);
		
		long Tini = System.currentTimeMillis();
		
		if(div==0)BuscaTD();
		else BuscaBU(div);
		
	 
	    
	    long Tfim = System.currentTimeMillis();
		 double tempo = (Tfim-Tini)*1.0/1000.0;
		 System.out.println("TempoLSBU  = "+tempo);
		 gravarArq.println("TempoLSBU  = "+tempo);
		
		
		 
		 
		 for(int i =0;i<Camp.size();i++) {
			 System.out.println("Camp;"+Camp.get(i).translate()+";"+CampTempo.get(i) );
			 gravarArq.println("Camp;"+Camp.get(i).translate()+";"+CampTempo.get(i) );
			
		 }
		 
		 
		 System.out.println("");
		 System.out.println("");
		 System.out.println("LSBU");
		 gravarArq.println("");
		 gravarArq.println("");
		 gravarArq.println("LSBU");
		 gravarArq.println("Ganhadores 0 n = "+Camp.size());
		 System.out.println("Ganhadores 0 n = "+Camp.size());
		 iDSL LS00 = torneio(Camp,Camp,0);// Camp0.get(Camp0.size()-1);
		 gravarArq.println("Ganhadores 1 n = "+Camp.size());
		 System.out.println("Ganhadores 1 n = "+Camp.size());
		 iDSL LS11 =  torneio(Camp,Camp,1);//Camp1.get(Camp1.size()-1);
		 
		 gravarArq.println("");
		 System.out.println("");
		 gravarArq.println("");
		 System.out.println("");
		 gravarArq.println("Campeao0 "+LS00.translate());
		 System.out.println("Campeao0 "+LS00.translate());
		 gravarArq.println("Campeao1 "+LS11.translate());
		 System.out.println("Campeao1 "+LS11.translate());
		 gravarArq.println("");
		 System.out.println("");
		 gravarArq.println("");
		 System.out.println("");
		 teste_final(LS00,0);
		 teste_final(LS11,1);
		 
		 
	    long Tfim1 = System.currentTimeMillis();
		 double tempo1 = (Tfim1-Tini)*1.0/1000.0;
		 System.out.println("Tempo  = "+tempo1);
		 gravarArq.println("Tempo  = "+tempo1);
		 gravarArq.close();
		 
	}
	
	static iDSL torneio(List<iDSL> jogador, List<iDSL> advs, int play) throws Exception {
		iDSL melhor=null;
		double melhor_pontuacao=-10000000;
		
		 PhysicalGameState pgs = PhysicalGameState.load(path_map, utt);
			
		GameState gs =new GameState(pgs, utt);
		
		
		List<AvaliaInvidual> jogos= new ArrayList<>();;
			
		for(iDSL j : jogador) {
				jogos.add(new AvaliaInvidual(j,advs,play,gs,utt,max_cicle,0,scrTable));
				jogos.get(jogos.size()-1).start();
		}
			
			
		for(AvaliaInvidual jo : jogos) {
			jo.join();
		}
			
		for(AvaliaInvidual jo : jogos) {
			 gravarArq.println(jo.result+" "+jo.sIA1.translate());
			 System.out.println(jo.result+" "+jo.sIA1.translate());
			if (jo.result>melhor_pontuacao) {
				melhor = jo.sIA1;
				melhor_pontuacao=jo.result;
			}
		}	
			
		
		return melhor;
	}
	

	



	public static double Avalia(int player, String path_map,boolean exibe) throws Exception {
		PhysicalGameState pgs = PhysicalGameState.load(path_map, utt);
	
		
		AI ai1 = buildCommandsIA(utt, sIA1.get(sIA1.size()-1));
	    AI ai2 = buildCommandsIA(utt, sIA2.get(sIA2.size()-1));
	    if(player==1) ai1 = new LightRush(utt);
	    if(player==0) ai2 = new LightRush(utt);
		GameState gs2 = new GameState(pgs, utt);
		boolean gameover = false;
		JFrame w=null;
		if(exibe) w = PhysicalGameStatePanel.newVisualizer(gs2,640,640,false,PhysicalGameStatePanel.COLORSCHEME_BLACK);  
        do {
      
                PlayerAction pa1 = ai1.getAction(0, gs2);
                PlayerAction pa2 = ai2.getAction(1, gs2);
                gs2.issueSafe(pa1);
                gs2.issueSafe(pa2);
             
                gameover = gs2.cycle();
                if(exibe) {
                	w.repaint();
                	Thread.sleep(100);
                }
              
                

        } while (!gameover && (gs2.getTime() <= max_cicle));   
		
		
		double resultado =0;
		if(gs2.winner()==player)resultado+=1;
		if(gs2.winner()==-1)resultado+=0.5;
		
		return resultado;
		
	
	}
	
	
	public static void  filtra(int n) {
		List<GameState> aux=new ArrayList<>();
		int p=states.size()/n;
		for(int i =0;i<states.size();i+=p+1) {
			System.out.println(i+ " est "+states.size());
			aux.add(states.get(i).clone());
		}
		System.out.println("est "+states.size());
		states.clear();
		for(int i = aux.size()-1;i>=0;i--) {
			states.add(aux.get(i).clone());
		}
		System.out.println("Estados "+states.size());
		
		
	}

	

	
	
	
	
	public static void GerarPartida(AI ai1,AI ai2,String path_map,boolean exibe) throws Exception {
		PhysicalGameState pgs = PhysicalGameState.load(path_map, utt);
		ai1.reset();
		ai2.reset();
		states.clear();
		GameState gs2 = new GameState(pgs, utt);
		boolean gameover = false;
		JFrame w=null;
		if(exibe) w = PhysicalGameStatePanel.newVisualizer(gs2,640,640,false,PhysicalGameStatePanel.COLORSCHEME_BLACK);  
        do {
        	if(gs2.getTime()%10==0) {
        
        		states.add(gs2.clone());
        	}
                PlayerAction pa1 = ai1.getAction(0, gs2);
                PlayerAction pa2 = ai2.getAction(1, gs2);
                gs2.issueSafe(pa1);
                gs2.issueSafe(pa2);
             
                gameover = gs2.cycle();
                if(exibe) {
                	w.repaint();
                	Thread.sleep(1);
                }
                
                

        } while (!gameover && (gs2.getTime() <= max_cicle));   
		System.out.println("gerou "+states.size());
		

	}
	
	public static double Avalia4(AI ai1,AI ai2,int play,String path_map,boolean exibe) throws Exception {
		PhysicalGameState pgs = PhysicalGameState.load(path_map, utt);
		ai1.reset();
		ai2.reset();
		
		GameState gs2 = new GameState(pgs, utt);
		boolean gameover = false;
		JFrame w=null;
		if(exibe) w = PhysicalGameStatePanel.newVisualizer(gs2,640,640,false,PhysicalGameStatePanel.COLORSCHEME_BLACK);  
        do {
        		;
                PlayerAction pa1 = ai1.getAction(play, gs2);
                PlayerAction pa2 = ai2.getAction(1-play, gs2);
                try {
                gs2.issueSafe(pa1);
                }catch(Exception e) {
                	;
                }
             
                try {
                    gs2.issueSafe(pa2);
                    }catch(Exception e) {
                    	;
                    }
             
                try {
                	gameover = gs2.cycle();
                
                }catch(Exception e) {
                	;
                }
              
                if(exibe) {
                	w.repaint();
                	Thread.sleep(1);
                }
                
                

        } while (!gameover && (gs2.getTime() <= max_cicle));   
		
		double r = 0;
		if(gs2.winner()==play)r=1;
		else if (gs2.winner()==-1)r=0.5;

		return r;
	}
	
	
	public static void ShowStates() {
		System.out.println("ssss");

		for (int i =0;i<states.size();i++) {
			JFrame w = PhysicalGameStatePanel.newVisualizer(states.get(i),640,640,false,PhysicalGameStatePanel.COLORSCHEME_BLACK); 
		}
	}
	
	
	public static int verifyIfExistsIndividualInTable(ArrayList<iDSL> scriptsAST, String candidate)
	{
		for(int i=0;i< scriptsAST.size();i++)
		{
			if(scriptsAST.get(i).translate().equals(candidate))
			{
				return i;
			}
		}
		return -1;
	}
	
	
	
	
	
	public static boolean getMelhor(GameState gs,List<iDSL> ais,List<iDSL> ais2,int limite) throws Exception {
		HashMap<Integer, HashSet<ICommand>> uu=new HashMap<Integer, HashSet<ICommand>>();
		
	
		
		iDSL c1= ais.get(ais.size()-1);
		iDSL c2= ais2.get(ais2.size()-1);
		int id1=0;
		int id2=0;
		boolean atualizou =false;
		
		double melhor =-10000000;
	 
		double melhor2 =-10000000;
		List<AvaliaInvidual> jogos= new ArrayList<>();;
		List<AvaliaInvidual> jogos2= new ArrayList<>();;
	
		jogos.add(new AvaliaInvidual(c1,ais2,0,gs,utt,limite,0,scrTable));
		jogos.get(0).start();
		for (int i =0; i<n_filho;i++) {
			jogos.add(new AvaliaInvidual(c1,ais2,0,gs,utt,limite,1,scrTable));
			jogos.get(jogos.size()-1).start();
		}
		jogos2.add(new AvaliaInvidual(c2,ais,1,gs,utt,limite,0,scrTable));
		jogos2.get(0).start();
		for (int i =0; i<n_filho;i++) {
			jogos2.add(new AvaliaInvidual(c2,ais,1,gs,utt,limite,1,scrTable));
			jogos2.get(jogos2.size()-1).start();
		}
		
		for(AvaliaInvidual j : jogos) {
			j.join();
		}
		for(AvaliaInvidual j : jogos2) {
			j.join();
		}
		
	    melhor =jogos.get(0).result;
		 
		melhor2 =jogos2.get(0).result;
		
	//	System.out.println("Lista 0 "+c1.translate());
		int i=0;
		for(AvaliaInvidual j : jogos) {
			if(melhor<j.result) {
				melhor = j.result;
				id1 =i;
			//	
			}
		//	System.out.println(j.result+" "+j.sIA1.translate());
			i+=1;
			
		}
		
		i=0;
	//	System.out.println("Lista 1 "+c2.translate());
		for(AvaliaInvidual j : jogos2) {
			if(melhor2<j.result) {
				melhor2 = j.result;
				id2=i;
			//	
			}
		//	System.out.println(j.result+" "+j.sIA1.translate());
			i+=1;
			
		}
	//System.out.println("");
		//System.out.println("");
	
		if(id1!=0) {
			if(ais.size()>n_ficticions)ais.remove(0);
			ReduceDSLController.removeUnactivatedParts(jogos.get(id1).sIA1, new ArrayList<>(((DslAI)  jogos.get(id1).ai1).getCommands()));
	        
			ais.add(jogos.get(id1).sIA1);
			atualizou= true;
		}
		if(id2!=0) {
			if(ais2.size()>n_ficticions)ais2.remove(0);
			 ReduceDSLController.removeUnactivatedParts(jogos2.get(id2).sIA1,new ArrayList<>(((DslAI)  jogos2.get(id2).ai1).getCommands()));
		        
			ais2.add(jogos2.get(id2).sIA1);
			atualizou= true;
		}
	
		return atualizou;
		
	}
	


	
	public static boolean Busca(GameState gs,int limite,long fim) throws Exception {
		
		if(sIA1.size()==0) {
			iDSL a1=BuilderDSLTreeSingleton.getInstance().buildS1Grammar(scrTable.allBasicFunctionsRedefined,scrTable.allBooleansFunctionsRedefined);
		 	a1=BuilderDSLTreeSingleton.changeNeighbourPassively(a1);
		
		 	sIA1.add(a1);
		 	
		}
		if(sIA2.size()==0) {
			iDSL a2=BuilderDSLTreeSingleton.getInstance().buildS1Grammar(scrTable.allBasicFunctionsRedefined,scrTable.allBooleansFunctionsRedefined);
			a2=BuilderDSLTreeSingleton.changeNeighbourPassively(a2);
			sIA2.add(a2);
		}
		
		
		
		
			
			
		int atualiza = 0;
		int oo =0;
		boolean terminou = true;
		while(atualiza<erros&&oo<50) {
			long parar = System.currentTimeMillis()-fim;
	    	if((parar*1.0)/1000.0>horas*3600.0) {
				return false;
				
	    	}
	    	long inicio = System.currentTimeMillis();
			terminou = true;
			oo++;
		
			
			
			
		
			
			//System.out.println("fsdfdf "+atualiza+" time = "+ gs.getTime()+" limite = "+limite);

			
			if(getMelhor(gs,sIA1,sIA2,limite)) {
				atualiza=0;
			}
			else {
				atualiza+=1;
			}
		
			//System.out.println("script0 = "+sIA1.get(sIA1.size()-1).translate());
			//System.out.println("script1 = "+sIA2.get(sIA2.size()-1).translate());
		
			//emprestimo(gs,sIA1,sIA2,0);
			//emprestimo(gs,sIA2,sIA1,1);
			//System.out.println("fsdfdf2 "+atualiza+" time = "+ gs.getTime()+" n0 = "+sIA1.size()+ " n1 = "+sIA2.size());
			
			
			long final2 = System.currentTimeMillis()-inicio;
			double tempo_total = (final2*1.0)/1000.0;
			System.out.println("TTTempo3 "+tempo_total+" "+atualiza+" jf0="+sIA1.size()+" jf1="+sIA2.size());
			//System.out.println("");
		}
		
		return !terminou;
		
	}
	
	public static void teste_final(iDSL ch,int play) throws Exception {
		AI ai1 = buildCommandsIA(utt, ch);
		
		AI ai2 =new A3NWithin(100, -1, 100, 8, 0.3F, 0.0F, 0.4F, 0, new RandomBiasedAI(utt),
				new SimpleSqrtEvaluationFunction3(), true, utt, "ManagerClosestEnemy", 3,
				decodeScripts(utt, "1;2;3;"), "A3N");
		double r=0;
		gravarArq.println("Resultado "+play);
		gravarArq.println("Script "+ch.translate());
		
		System.out.println("Resultado "+play);
		System.out.println("Script "+ch.translate());
		for(int i =0;i<10;i++) {
			ai2 =new A3NWithin(100, -1, 100, 8, 0.3F, 0.0F, 0.4F, 0, new RandomBiasedAI(utt),
					new SimpleSqrtEvaluationFunction3(), true, utt, "ManagerClosestEnemy", 3,
					decodeScripts(utt, "1;2;3;"), "A3N");
			r+=Avalia4(ai1,ai2,play,path_map,false);
		}
		gravarArq.println(play+" TT A3N =" + r);
		System.out.println(play+" TT A3N =" + r);
		r=0;
		ai2=new LightRush(utt);
		for(int i =0;i<10;i++) {
			r+=Avalia4(ai1,ai2,play,path_map,false);
		}
		gravarArq.println(play+" TT LR =" + r);
		System.out.println(play+" TT LR =" + r);
		r=0;
		ai2=new WorkerRush(utt);
		for(int i =0;i<10;i++) {
			r+=Avalia4(ai1,ai2,play,path_map,false);
		}
		gravarArq.println(play+" TT WR =" + r);
		System.out.println(play+" TT WR =" + r);
		for(int j=0;j<4;j++) {
			r=0;
			ai2= ScriptHumano(id_map,j);
			for(int i =0;i<10;i++) {
				r+=Avalia4(ai1,ai2,play,path_map,false);
			}
			gravarArq.println(play+" TT P"+j+" =" + r);
			System.out.println(play+" TT P"+j+" =" + r);
		}
	}
	
	
	
	
	
	

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


	private static AI buildCommandsIA(UnitTypeTable utt, iDSL code) {
		IDSLCompiler compiler = new MainDSLCompiler();   
        HashMap<Long, String> counterByFunction = new HashMap<Long, String>();
        List<ICommand> commandsDSL = compiler.CompilerCode(code, utt);
        AI aiscript = new DslAI(utt, commandsDSL, "P1", code, counterByFunction);
        return aiscript;
    }
	

}
