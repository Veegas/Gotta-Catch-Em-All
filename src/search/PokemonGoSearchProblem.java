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
import mazeGenerator.Maze;

public class PokemonGoSearchProblem extends SearchProblem {
    
    
    private Maze maze;

    public PokemonGoSearchProblem(Maze maze) {
	super();
	this.maze = maze;
	PokemonGoState initialState = new PokemonGoState();
	ArrayList<PokemonGoState> stateSpace = new ArrayList<PokemonGoState>();
	this.setInitialState(initialState);
	this.setStateSpace(stateSpace);

	ArrayList<Operation<? extends SearchNode>> operations = new ArrayList<Operation<? extends SearchNode>>();

	
	Operation<PokemonGoSearchNode> moveForward = new MoveForwardOperation();
//	Operation<PokemonGoSearchNode> rotateRight = new RotateRightOperation();
//	Operation<PokemonGoSearchNode> rotateLeft = new RotateLeftOperation();
		

	operations.add(moveForward);
//	operations.add(rotateRight);
//	operations.add(rotateLeft);
	this.setOperations(operations);
    }

    

    public boolean goalTest(PokemonGoState state) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public int pathCost() {
	// TODO Auto-generated method stub
	return 0;
    }



    @Override
    public boolean goalTest(State state) {
	// TODO Auto-generated method stub
	return false;
    }

}
