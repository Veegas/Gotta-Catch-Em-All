package search;

import java.util.ArrayList;
import java.util.function.Function;

import operations.MoveForwardOperation;
import operations.RotateLeftOperation;
import operations.RotateRightOperation;

import abstracts.Operation;
import abstracts.SearchNode;
import abstracts.SearchProblem;
import abstracts.State;

public class PokemonGoSearchProblem extends SearchProblem<PokemonGoSearchNode, PokemonGoState>  {
    
//    private Operation<Object> operations;

    public PokemonGoSearchProblem() {
	super();

	PokemonGoState initialState = new PokemonGoState();
	ArrayList<PokemonGoState> stateSpace = new ArrayList<PokemonGoState>();
	this.setInitialState(initialState);
	this.setStateSpace(stateSpace);

	ArrayList<Operation<PokemonGoSearchNode>> operations = new ArrayList<Operation<PokemonGoSearchNode>>();

	
	Operation<PokemonGoSearchNode> moveForward = new MoveForwardOperation();
	Operation<PokemonGoSearchNode> rotateRight = new RotateRightOperation();
	Operation<PokemonGoSearchNode> rotateLeft = new RotateLeftOperation();
		

	operations.add(moveForward);
	operations.add(rotateRight);
	operations.add(rotateLeft);
	this.setOperations(operations);
    }

    

    @Override
    public boolean goalTest(SearchNode node) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public int pathCost() {
	// TODO Auto-generated method stub
	return 0;
    }

}
