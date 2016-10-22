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
	private int StepsToMove;

	public PokemonGoSearchProblem(Maze maze, int x) {
		super();
		this.maze = maze;
		PokemonGoState initialState = new PokemonGoState(maze.getStart().getPosition(), x, maze.getPokemonsGenerated(),
				Orientation.DOWN);
		ArrayList<PokemonGoState> stateSpace = new ArrayList<PokemonGoState>();
		this.setInitialState(initialState);
		this.setStateSpace(stateSpace);
		this.StepsToMove = x;

		ArrayList<Operation<? extends SearchNode>> operations = new ArrayList<Operation<? extends SearchNode>>();

		Operation<PokemonGoSearchNode> moveForward = new MoveForwardOperation(this);
		Operation<PokemonGoSearchNode> rotateRight = new RotateRightOperation(this);
		Operation<PokemonGoSearchNode> rotateLeft = new RotateLeftOperation(this);

		operations.add(moveForward);
		operations.add(rotateRight);
		operations.add(rotateLeft);
		this.setOperations(operations);
	}

    
    public static int pathCost(SearchNode n) {
	PokemonGoSearchNode node = (PokemonGoSearchNode) n;
	PokemonGoState state = node.getState();
	
	int cost = node.getCost();
	
	while(node.getParent() != null) {
	    cost += node.getParent().getCost(); 
	    node = (PokemonGoSearchNode) node.getParent();
	}
	
	return cost;
    }

	@Override
	public boolean goalTest(State state) {
		PokemonGoState pokeState = (PokemonGoState) state;
		if (pokeState.getStepsLeft() == 0 && 
				pokeState.getPokemonsLeft().isEmpty() && 
					this.maze.getEnd().getX() == pokeState.getCurrentPosition().getX()
						&& this.maze.getEnd().getY() == pokeState.getCurrentPosition().getY()) {
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

	public SearchNode createNodeFromState(State newState, SearchNode parentNode, Operation<? extends SearchNode> operation) {
		PokemonGoSearchNode pokeParentNode = (PokemonGoSearchNode) parentNode;
		PokemonGoState pokeNewState = (PokemonGoState) newState;

		if (newState != null) {
			PokemonGoSearchNode newNode = new PokemonGoSearchNode(pokeNewState, pokeParentNode, operation);
			return newNode;
		} else {
			return null;
		}
	}
	
	
	public boolean addToStateSpace(SearchNode node) {
	    PokemonGoState state = (PokemonGoState) node.getState();

	    if (this.getStateSpace().containsValue((state)) != true) {
		    if (state.getStepsLeft() == 0 && state.getPokemonsLeft().isEmpty()) {
			if (node.foundInAncestors()) {
			    return false;
			}
		    }
		this.getStateSpace().put(state, state);
		return true;
	    } else {
		return false;
	    }

	}

	public int getStepsToMove() {
		return StepsToMove;
	}

	public void setStepsToMove(int stepsToMove) {
		StepsToMove = stepsToMove;
	}
	
	

}
