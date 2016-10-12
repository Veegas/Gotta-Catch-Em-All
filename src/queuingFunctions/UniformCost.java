package queuingFunctions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import abstracts.QueuingFunction;
import abstracts.SearchNode;
import search.PokemonGoSearchProblem;

public class UniformCost implements QueuingFunction<SearchNode>  {

    @Override
    public ArrayList<SearchNode> enqueue(SearchNode N,
	    ArrayList<SearchNode> queue) {
	queue.add(N);
	
	Collections.sort(queue, new Comparator<SearchNode>() {

	    @Override
	    public int compare(SearchNode o1, SearchNode o2) {
		int pathCost1 = PokemonGoSearchProblem.pathCost(o1);
		int pathCost2 = PokemonGoSearchProblem.pathCost(o2);
		if (pathCost1 == pathCost2) {
		    return 0;
		}
		
		return pathCost1 > pathCost2 ? 1 : -1;
	    }
	    
	});
	
	return queue;
	
    }

}
