package operations;

import abstracts.Environment;
import abstracts.Operation;
import abstracts.SearchNode;
import search.PokemonGoSearchNode;
import search.PokemonGoSearchProblem;
import search.PokemonGoState;

public class RotateRightOperation extends PokemonGoOperation implements Operation<PokemonGoSearchNode> {

    public RotateRightOperation() {
	super();
	// TODO Auto-generated constructor stub
    }


    public RotateRightOperation(PokemonGoSearchProblem problem) {
	super(problem);
	// TODO Auto-generated constructor stub
    }


    public PokemonGoSearchNode apply(PokemonGoSearchNode node) {
	// TODO Auto-generated method stub
	System.out.println("El fadya");
	return null;
    }


    @Override
    public SearchNode apply(SearchNode node, Environment enviroment) {
	PokemonGoState state = (PokemonGoState) node.getState();
	PokemonGoSearchNode currentNode = (PokemonGoSearchNode) node;
	PokemonGoState newState = state.rotateRight(enviroment);
	
	if (newState == null) {
	    return null;
	}
	
	SearchNode newNode = this.getProblem().createNodeFromState(newState, currentNode, this); 
	newNode.setCost(1);
	
	
	return newNode;
	
    }
    
    public String toString() {
	return "Rotate Right";
    }

}
