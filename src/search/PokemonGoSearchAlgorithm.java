package search;

import abstracts.GeneralSearchAlgorithm;
import abstracts.QueuingFunction;
import abstracts.SearchNode;
import abstracts.SearchProblem;
import abstracts.State;

public class PokemonGoSearchAlgorithm extends GeneralSearchAlgorithm {

    public PokemonGoSearchAlgorithm(PokemonGoEnvironment enviroment) {
	super(enviroment);
	// TODO Auto-generated constructor stub
    }

    public void GeneralSearch(PokemonGoSearchProblem pokeSearch,
	    QueuingFunction<SearchNode> strategy) {
	SearchProblem problem = (SearchProblem) pokeSearch;
	super.GeneralSearch(problem, strategy);
	
    }
    

    
}
