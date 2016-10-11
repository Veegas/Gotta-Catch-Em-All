package operations;

import search.PokemonGoSearchNode;
import search.PokemonGoSearchProblem;
import search.PokemonGoState;

public class PokemonGoOperation {
    private PokemonGoSearchProblem problem;
    
    public PokemonGoOperation() {
	super();
    }

    public PokemonGoOperation(PokemonGoSearchProblem problem) {
	super();
	this.problem = problem;
    }

    public PokemonGoSearchProblem getProblem() {
	return problem;
    }

    public void setProblem(PokemonGoSearchProblem problem) {
	this.problem = problem;
    }
       
}
