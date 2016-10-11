package operations;

import abstracts.Environment;
import abstracts.Operation;
import abstracts.SearchNode;
import search.PokemonGoSearchNode;
import search.PokemonGoSearchProblem;
import search.PokemonGoState;

public class MoveForwardOperation extends PokemonGoOperation implements Operation<PokemonGoSearchNode> {
   
    
    public MoveForwardOperation() {
	super();
	// TODO Auto-generated constructor stub
    }

    public MoveForwardOperation(PokemonGoSearchProblem problem) {
	super(problem);
    }

    public PokemonGoSearchNode apply(PokemonGoSearchNode node) {
	return null;
    }

    @Override
    public SearchNode apply(SearchNode node, Environment enviroment) {
	PokemonGoState state = (PokemonGoState) node.getState();
	PokemonGoSearchNode currentNode = (PokemonGoSearchNode) node;
	PokemonGoState newState = state.moveForward(enviroment);
	
	if (newState == null) {
	    return null;
	}
	
	return this.getProblem().createNodeFromState(newState, currentNode);
	
    }

}
