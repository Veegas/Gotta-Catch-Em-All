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
	PokemonGoState initialState = new PokemonGoState(maze.getStart().getPosition(), 0, maze.getPokemonsGenerated(), Orientation.DOWN);
	ArrayList<PokemonGoState> stateSpace = new ArrayList<PokemonGoState>();
	this.setInitialState(initialState);
	this.setStateSpace(stateSpace);

	ArrayList<Operation<? extends SearchNode>> operations = new ArrayList<Operation<? extends SearchNode>>();

	
	Operation<PokemonGoSearchNode> moveForward = new MoveForwardOperation(this);
	Operation<PokemonGoSearchNode> rotateRight = new RotateRightOperation(this);
	Operation<PokemonGoSearchNode> rotateLeft = new RotateLeftOperation(this);
		

	operations.add(moveForward);
	operations.add(rotateRight);
	operations.add(rotateLeft);
	this.setOperations(operations);
    }

    

 

    @Override
    public int pathCost() {
	// TODO Auto-generated method stub
	return 0;
    }



    @Override
    public boolean goalTest(State state) {
	PokemonGoState pokeState = (PokemonGoState) state;
	if (this.maze.getEnd().getX() == pokeState.getCurrentPosition().getX() && this.maze.getEnd().getY() == pokeState.getCurrentPosition().getY()) {
	    return true;
	}
	return false;
    }


    public Maze getMaze() {
        return maze;
    }



    public void setMaze(Maze maze) {
        this.maze = maze;
    }
    
    public SearchNode createNodeFromState(State newState, SearchNode parentNode) {
	PokemonGoSearchNode pokeParentNode = (PokemonGoSearchNode) parentNode;
	PokemonGoState pokeNewState = (PokemonGoState) newState;
	
	if (newState != null) {
	    PokemonGoSearchNode newNode = new PokemonGoSearchNode(pokeNewState, pokeParentNode);
	    return newNode;    
	} else {
	    return null;
	}
    }

}
