package principal;

import java.util.ArrayList;
import java.util.List;
import ai.synthesis.dslForScriptGenerator.DSLTableGenerator.FunctionsforDSL;
import ai.synthesis.grammar.dslTree.CDSL;
import ai.synthesis.grammar.dslTree.S1DSL;
import ai.synthesis.grammar.dslTree.S2DSL;
import ai.synthesis.grammar.dslTree.S3DSL;
import ai.synthesis.grammar.dslTree.S4DSL;
import ai.synthesis.grammar.dslTree.interfacesDSL.iDSL;
import ai.synthesis.grammar.dslTree.interfacesDSL.iNodeDSLTree;
import ai.synthesis.twophasessa.TradutorDSL;

public class TESTEgramatica {

	
	static String QualProducao(iNodeDSLTree node) {
		
		if(node instanceof S1DSL) {
			if(node.getLeftChild() instanceof CDSL)return "S1=>0";
			else if(node.getLeftChild() instanceof S2DSL)return "S1=>1";
			else if(node.getLeftChild() instanceof S3DSL)return "S1=>2";		
			return "S1=>3" ;
		}
		if(node instanceof S2DSL) {
			if (((S2DSL) node).getElseCommand() instanceof CDSL){
				return "S2->1";
			}
			return "S2->0";
		}
		
		
		if(node instanceof S3DSL) {
			return "S3=>0";
		}
		if(node instanceof S4DSL) {
			if(node.getLeftChild() instanceof CDSL)return "S4=>0";
			else if(node.getLeftChild() instanceof S2DSL)return "S4=>1";
			else return "S4=>2";
		}
		if(node instanceof CDSL) {
			iDSL temp = (iDSL) node;
			
			return "C=>"+temp.translate();
		}
		iDSL temp = (iDSL) node;
		
		return "não pegou " + temp.getClass().getName();
	}
	
	
	public static void traco( iNodeDSLTree node,List<String> ls,int nivel ) {
	
        if (node != null) {
            iDSL temp = (iDSL) node;
            
           // sb.append(temp.getClass().getName() + " " + temp.translate());
           // sb.append("\n");
            String prod = QualProducao(node);
          
            ls.add(prod);
            traco( node.getRightNode(),ls,nivel+1);
            traco( node.getLeftNode(),ls,nivel+1);
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FunctionsforDSL gramatica = new FunctionsforDSL();
		String s ="for(u) (if(HaveUnitsToDistantToEnemy(Worker,3,u)) then(attack(Worker,closest,u)) if(HaveQtdUnitsAttacking(Worker,13,u)) then((Z)) harvest(50,u) if(HaveQtdUnitsbyType(Worker,13,u)) then((Z)) else(train(Worker,50,Down,u))) (Z) for(u) (moveToUnit(Worker,Enemy,farthest,u)) for(u) (if(HaveQtdUnitsAttacking(Heavy,15,u)) then((Z)))"; 

		TradutorDSL trad = new TradutorDSL(s);
		iDSL j = trad.getAST();
		List<String> ls= new ArrayList<>();
		
		
		List<FunctionsforDSL> l = gramatica.getBasicFunctionsForGrammar();
		System.out.println(gramatica.getNameFunction());
		for (FunctionsforDSL k:l) {
			System.out.println(k.getNameFunction());
		}
		
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		
		
		List<FunctionsforDSL> l3 = gramatica.getBasicFunctionsForGrammarUnit();
		System.out.println(gramatica.getNameFunction());
		for (FunctionsforDSL k:l3) {
			System.out.println(k.getNameFunction());
		}
	
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		List<FunctionsforDSL> l2 = gramatica.getConditionalsForGrammar();
		System.out.println(gramatica.getNameFunction());
		for (FunctionsforDSL k:l2) {
			System.out.println(k.getNameFunction());
		}
		
	
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		List<FunctionsforDSL> l4 = gramatica.getConditionalsForGrammarUnit();
		System.out.println(gramatica.getNameFunction());
		for (FunctionsforDSL k:l4) {
			System.out.println(k.getNameFunction());
		}
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		/*
		//BuilderDSLTreeSingleton b = new BuilderDSLTreeSingleton();
		
		//BuilderDSLTreeSingleton.formatedStructuredDSLTreePreOrderPrint((iNodeDSLTree)j);
		//iDSL jj = (iDSL) b.buildS1Grammar();
		//System.out.println(jj.translate());
		
		  List<FunctionsforDSL> L = gramatica.getBasicFunctionsForGrammar();
		  for(FunctionsforDSL l : L) {
			  System.out.println(l.getNameFunction());
			  for (ParameterDSL ll : l.getParameters()) {
				  System.out.println("    "+ll.getParameterName());
			  }
			  System.out.println();
			  System.out.println();
		  }
		*/
		//traco((iNodeDSLTree)j,ls,0);
		 
		 //Random rand = new Random();
		
		//for(String p : ls) {
			//System.out.println(p);
		//}
	        
	   
		//gramatica.printFunctions(gramatica.getBasicFunctionsForGrammarUnit());
		//System.out.println("");
		//gramatica.printFunctions(gramatica.getBasicFunctionsForGrammar());
		
	}

}
