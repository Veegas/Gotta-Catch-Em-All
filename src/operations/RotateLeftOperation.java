package operations;

import abstracts.Environment;
import abstracts.Operation;
import abstracts.SearchNode;
import search.PokemonGoSearchNode;
import search.PokemonGoSearchProblem;
import search.PokemonGoState;

public class RotateLeftOperation extends PokemonGoOperation implements Operation<PokemonGoSearchNode> {


    public RotateLeftOperation() {
	super();
	// TODO Auto-generated constructor stub
    }


    public RotateLeftOperation(PokemonGoSearchProblem problem) {
	super(problem);
	// TODO Auto-generated constructor stub
    }


    public PokemonGoSearchNode apply(PokemonGoSearchNode node) {
	// TODO Auto-generated method stub
	return null;
    }


    @Override
    public SearchNode apply(SearchNode node, Environment enviroment) {
	PokemonGoState state = (PokemonGoState) node.getState();
	PokemonGoSearchNode currentNode = (PokemonGoSearchNode) node;
	PokemonGoState newState = state.rotateLeft(enviroment);
	
	if (newState == null) {
	    return null;
	}
	
	SearchNode newNode = this.getProblem().createNodeFromState(newState, currentNode); 
	newNode.setCost(1);
	
	
	return newNode;
	
    }
}
