package principal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import ai.core.AI;
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

public class GuerraDosMelhores {
	static List<iDSL> jogadores;
	static List<Double> tempos;
	static float Partida[][];
	
	static String path_map = "";
	static int id_map=0;
	static UnitTypeTable utt;
	static String a = "";
	static String b = "";
	static String c = "";
	
	public static void ler() throws IOException {
		jogadores= new ArrayList<>();
		 tempos= new ArrayList<>();
		BufferedReader buffRead = new BufferedReader(new FileReader("./Melhores/log_"+a+"_"+b+"_"+c+".txt"));
		String linha = "";
		linha = buffRead.readLine();
		while (true) {
			if (linha != null) {
				String dados[] = linha.split(";");
				if (dados[0].equals("Camp")){
					double d = Double.parseDouble(dados[2].replace(",", "."));
					TradutorDSL trad = new TradutorDSL(dados[1]);
					iDSL j = trad.getAST();
					jogadores.add(j);
					tempos.add(d);
					
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
	
	public static void getMelhores(float intervalo) {
		String s0=" ";
		String s1=" ";
		double melhor =-1000;
		for(int i=0;i<tempos.size() && tempos.get(i)<=intervalo;i++) {
			double cont =0;
			for(int j=0;j<tempos.size() && tempos.get(j)<=intervalo;j++) {
				cont+=Partida[i][j];
			}
			//System.out.println(i+ " "+jogadores.get(i).translate()+" "+cont);
			if(melhor<cont) {
				melhor= cont;
				s0=jogadores.get(i).translate();
				
			}
		}
		melhor =10000;
		for(int i=0;i<tempos.size() && tempos.get(i)<=intervalo;i++) {
			double cont =0;
			for(int j=0;j<tempos.size() && tempos.get(j)<=intervalo;j++) {
			
					cont+=Partida[j][i];
				
				
				
			}
			//System.out.println(i+ " "+jogadores.get(i).translate()+" "+cont);
			if(melhor>cont) {
				s1=jogadores.get(i).translate();
				melhor= cont;
				
			}
		}
		int i=0;
		System.out.println("");
		for(;i<tempos.size() && tempos.get(i)<=intervalo;i++) {
			
		}
		
		System.out.println("Camp "+ i +";"+s0+";"+s1);
		System.out.println("\n\n\n\n");
		
	}
	
	
	
	public static void torneio() throws Exception {
		
		PhysicalGameState pgs = PhysicalGameState.load(path_map, utt);
		GameState gs = new GameState(pgs, utt);
		
		Partida = new float[tempos.size()][tempos.size()];
		for (int i = 0;i<tempos.size();i++) {
			AI ai1 = buildCommandsIA(utt,jogadores.get(i));
			for (int j = 0;j<tempos.size();j++) {
				System.out.println(i+" "+j);
				AI ai2 = buildCommandsIA(utt,jogadores.get(j));
				double r = partida(gs,ai1,ai2,0);
				Partida[i][j] =(float) r;
				
				
				
			}
		}
		
		
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
	                
	                
	                
	
	        } while (!gameover && (gs2.getTime() <= 2500));   
			
			
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
		torneio();
		float intervalo[]= {4,8,12,16,20,25};
		for(int i = 0; i<intervalo.length;i++) {
			getMelhores(intervalo[i]*3600);
		}
		int i =0;
		int j=1;
		for(int k=0;k<0;k++) {
			String s0 = jogadores.get(i+k).translate();
			String s1 = jogadores.get(j+k).translate();
			System.out.println("Camp "+ k +";"+s0+";"+s1);
		}
		System.out.println("fddffff");
	}

}
