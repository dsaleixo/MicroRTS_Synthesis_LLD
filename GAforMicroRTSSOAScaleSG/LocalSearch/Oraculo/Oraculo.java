package Oraculo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import ai.core.AI;
import gui.PhysicalGameStateJFrame;
import gui.PhysicalGameStatePanel;
import rts.GameState;
import rts.PlayerAction;
import rts.units.UnitTypeTable;

public class Oraculo {

	public Oraculo() {
		// TODO Auto-generated constructor stub
	}
	public static List<GameState> gerar(GameState gs, int player, int max_cycle, AI oraculo, AI adv, boolean exibe) throws Exception {
		List<GameState> gss = new ArrayList<>();
		
		UnitTypeTable utt = new UnitTypeTable();
		oraculo.reset(utt);
		adv.reset(utt);
		GameState gs2 = gs.cloneChangingUTT(utt);
		boolean gameover = false;
		
		JFrame w=null;
		if(exibe) w = PhysicalGameStatePanel.newVisualizer(gs2,640,640,false,PhysicalGameStatePanel.COLORSCHEME_BLACK);
	
		 gss.add(gs2.clone());
        do {
        		PlayerAction pa1 = oraculo.getAction(player, gs2);
                PlayerAction pa2 = adv.getAction(1-player, gs2);
                gs2.issueSafe(pa1);
                gs2.issueSafe(pa2);
                gameover = gs2.cycle();
                if(exibe) {
                	w.repaint();
                	Thread.sleep(2);
                }
                gss.add(gs2.clone());
    
        } while (!gameover && (gs2.getTime() <= max_cycle)); 
        
        return gss;	
	}
	
	public static void reproduz(List<GameState> gss) throws InterruptedException {
		PhysicalGameStateJFrame w=null;
		GameState gs=gss.get(0).clone();
		w = PhysicalGameStatePanel.newVisualizer(gs,640,640,false,PhysicalGameStatePanel.COLORSCHEME_BLACK);                     
		for(int i=0;i<gss.size();i++) {
			Thread.sleep(20);
			
			w.repaint();
			w.setStateCloning(gss.get(i));
		}
		
	}
	
	public static void salvar(List<GameState> gss,String nome) throws IOException {
		
		 File file = new File("./Replay/"+nome);
		 file.mkdir();
		 FileWriter arq = new FileWriter("./Replay/"+nome+"/Controle.txt");
		 PrintWriter gravarArq = new PrintWriter(arq);
		 gravarArq.printf("N="+gss.size()+"\n");
		 arq.close();
		 for(GameState gs :gss) {
			 gs.toxml("./Replay/"+nome+"/gs"+gs.getTime());
		 }
	}
	
	public static List<GameState> carregar(String nome) throws IOException {
		List<GameState> gss = new ArrayList<>();
		int n_gs=0;
		
		BufferedReader buffRead = new BufferedReader(new FileReader("./Replay/"+nome+"/Controle.txt"));
		String linha = "";
		while (true) {
			if (linha != null) {
				String dados[] = linha.split("=");
				if(dados[0].equals("N"))n_gs = Integer.parseUnsignedInt(dados[1]);

			} else
				break;
			linha = buffRead.readLine();
		}
		buffRead.close();
		UnitTypeTable utt = new UnitTypeTable();

		for(int i=0;i<n_gs;i++) {
			String aux= ""+i;
			gss.add(GameState.fromXML("./Replay/"+nome+"/gs"+aux, utt));
		}
		return gss;
	}
	
	
}
