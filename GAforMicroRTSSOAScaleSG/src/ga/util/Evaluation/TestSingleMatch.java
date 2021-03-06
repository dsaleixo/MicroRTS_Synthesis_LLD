/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ga.util.Evaluation;

import ai.core.AI;
import ai.synthesis.dslForScriptGenerator.DSLCommandInterfaces.ICommand;
import ai.synthesis.dslForScriptGenerator.DSLCompiler.IDSLCompiler;
import ai.synthesis.dslForScriptGenerator.DSLCompiler.MainDSLCompiler;
import ai.synthesis.dslForScriptGenerator.DslAI;
import ai.synthesis.grammar.dslTree.interfacesDSL.iDSL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import rts.GameState;
import rts.PhysicalGameState;
import rts.PlayerAction;
import rts.units.UnitTypeTable;

public class TestSingleMatch extends Thread {

    IDSLCompiler compiler = new MainDSLCompiler();    
    HashSet<String> usedCommands;
    AI ai;
    iDSL sIA1;
    iDSL sIA2;
    float result;
    int winner;
    //Smart Evaluation Settings
    String initialState;
    private final int CYCLES_LIMIT = 200;
    List<ICommand> allCommandIA1;
    List<ICommand> allCommandIA2;
    GameState gs2;
    PhysicalGameState pgs;
    UnitTypeTable utt;
    String message;
    int idIA1;
    int idIA2;

    public float getResult() {
        return result;
    }

    public int getWinner() {
        return winner;
    }

    public TestSingleMatch(iDSL sIA1, iDSL sIA2, GameState gs, PhysicalGameState pgs, UnitTypeTable utt, String message, int idIA1, int idIA2) {
        this.sIA1 = sIA1;
        this.sIA2 = sIA2;
        this.allCommandIA1 = new ArrayList<>();
        this.allCommandIA2 = new ArrayList<>();
        this.winner = -1;
        this.gs2=gs.clone();
        this.pgs=pgs;
        this.utt=utt;
        this.message=message;
        this.idIA1=idIA1;
        this.idIA2=idIA1;
    }

    public List<ICommand> getAllCommandIA1() {
        return allCommandIA1;
    }

    public List<ICommand> getAllCommandIA2() {
        return allCommandIA2;
    }
    
    

    public int execute() throws Exception {   
    	//System.out.println("start match "+message);
//        String map = SettingsAlphaDSL.get_map();
//        UnitTypeTable utt = new UnitTypeTable();
//        PhysicalGameState pgs = PhysicalGameState.load(map, utt);

        //printMatchDetails(sIA1,sIA2,map);
        //GameState gs = new GameState(pgs, utt);
        int MAXCYCLES = 4000;
        int PERIOD = 20;
        boolean gameover = false;

        if (pgs.getHeight() == 8) {
            MAXCYCLES = 3000;
        }
        if (pgs.getHeight() == 16) {
            MAXCYCLES = 5000;
            //MAXCYCLES = 1000;
        }
        if (pgs.getHeight() == 24) {
            MAXCYCLES = 6000;
        }
        if (pgs.getHeight() == 32) {
            MAXCYCLES = 7000;
        }
        if (pgs.getHeight() == 64) {
            MAXCYCLES = 12000;
        }

        AI ai1 = buildCommandsIA(utt, sIA1);
        AI ai2 = buildCommandsIA(utt, sIA2);
        
//        AI ai1 = new WorkerRush(utt);
//        AI ai2 = new WorkerRush(utt);


        //JFrame w = PhysicalGameStatePanel.newVisualizer(gs, 640, 640, false, PhysicalGameStatePanel.COLORSCHEME_BLACK);
//        JFrame w = PhysicalGameStatePanel.newVisualizer(gs,640,640,false,PhysicalGameStatePanel.COLORSCHEME_WHITE);        
        long nextTimeToUpdate = System.currentTimeMillis() + PERIOD;
        do {
        	//System.out.println(message);
 //           if (System.currentTimeMillis() >= nextTimeToUpdate) {
                PlayerAction pa1 = ai1.getAction(0, gs2);
                PlayerAction pa2 = ai2.getAction(1, gs2);
                gs2.issueSafe(pa1);
                gs2.issueSafe(pa2);
                if (smartEvaluationForStop(gs2)) {
                    this.allCommandIA1.clear();
                    this.allCommandIA1.addAll(((DslAI) ai1).getCommands());
                    this.allCommandIA2.clear();
                    this.allCommandIA2.addAll(((DslAI) ai2).getCommands());
                    result = 0.5f;    
                    //System.out.println("end match "+message);
                    return -1;
                }
                // simulate:
                gameover = gs2.cycle();
                //w.repaint();
                //nextTimeToUpdate += PERIOD;
//            } else {
//                try {
//                    Thread.sleep(1);
//                } catch (Exception e) {
//                    System.err.println("ai.synthesis.runners.roundRobinLocal.RoundRobinGrammarAgainstGrammar.run() " + e.getMessage());
//                }
 //           }

        } while (!gameover && (gs2.getTime() <= MAXCYCLES));     
        //System.out.println("printing current state "+gs);
        winner = gs2.winner();
        this.allCommandIA1.clear();
        this.allCommandIA1.addAll(((DslAI) ai1).getCommands());
        this.allCommandIA2.clear();
        this.allCommandIA2.addAll(((DslAI) ai2).getCommands());  
        //System.out.println("end match "+message);
        if (winner != -1) {
            //w.dispatchEvent(new WindowEvent(w, WindowEvent.WINDOW_CLOSING));
            //System.out.println("\n"+sIA1+"\n "+sIA2+ "\n Winner "+winner);
            if (winner == 0) {
                result = 1.0f;
            } else {
                result = 1.0f;
            }
            return winner;
        } else {
            //w.dispatchEvent(new WindowEvent(w, WindowEvent.WINDOW_CLOSING));
            result = 0.5f;
            return -1;
        }

    }

    private AI buildCommandsIA(UnitTypeTable utt, iDSL code) {
        HashMap<Long, String> counterByFunction = new HashMap<Long, String>();
        List<ICommand> commandsDSL = compiler.CompilerCode(code, utt);
        AI aiscript = new DslAI(utt, commandsDSL, "P1", code, counterByFunction);
        return aiscript;
    }

    private void printMatchDetails(String sIA1, String sIA2, String map) {
        System.out.println("Script 1 = " + sIA1);
        System.out.println("Script 2 = " + sIA2);
        System.out.println("Map = " + map);
    }

    @Override
    public void run() {
        try {
            this.winner = execute();
        } catch (Exception ex) {
            Logger.getLogger(TestSingleMatch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Check if after a quantity of cycles (defined by CYCLES_LIMIT) the game
     * can be stopped. If the state of the game continues the same for more than
     * CYCLES_LIMIT, the function will return true.
     *
     * @param gs - Game to be considered.
     * @return True - If the game can be stopped and defined as draw. False if the 
     * game changed after CYCLES_LIMIT games cycles.
     */
    private boolean smartEvaluationForStop(GameState gs) {
        if (gs.getTime() == 0) {            
            String cleanState = cleanStateInformation(gs);
            this.initialState = cleanState;
        } else if (gs.getTime() % CYCLES_LIMIT == 0) {
            String cleanState = cleanStateInformation(gs);
            if(cleanState.equals(initialState)){
                //System.out.println("** Smart Stop activate.\n Original state =\n"+initialState+
                //        " verified same state at \n"+cleanState);
                return true;
            }else{
                initialState = cleanState;
            }
        }

        return false;
    }

    private String cleanStateInformation(GameState gs) {
        String sGame = gs.toString().replace("\n", "");
        sGame = sGame.substring(sGame.indexOf("PhysicalGameState:")); 
        sGame = sGame.replace("PhysicalGameState:", "").trim();
        return sGame;
    }

}
