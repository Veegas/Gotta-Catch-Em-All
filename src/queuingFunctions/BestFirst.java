package queuingFunctions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import abstracts.EvaluationFunction;
import abstracts.QueuingFunction;
import abstracts.SearchNode;
import abstracts.SearchProblem;
import search.PokemonGoSearchProblem;

public class BestFirst implements QueuingFunction<SearchNode>{
    
    private SearchProblem problem;
    private EvaluationFunction eval;
    
    public BestFirst(SearchProblem problem, EvaluationFunction eval) {
	this.problem = problem;
	this.eval = eval;
    }
    
    @Override
    public ArrayList<SearchNode> enqueue(SearchNode N,
	    ArrayList<SearchNode> queue) {
	N.setEvaluationCost(eval.Evaluate(problem, N));
	queue.add(N);
	
	Collections.sort(queue, new Comparator<SearchNode>() {

	    @Override
	    public int compare(SearchNode o1, SearchNode o2) {
		int EvaluationCost1 = o1.getEvaluationCost();
		int EvaluationCost2 = o2.getEvaluationCost();
		if (EvaluationCost1== EvaluationCost2) {
		    return 0;
		}
		
		return EvaluationCost1 > EvaluationCost2 ? 1 : -1;
	    }
	    
	});
	
	return queue;
    }

}
