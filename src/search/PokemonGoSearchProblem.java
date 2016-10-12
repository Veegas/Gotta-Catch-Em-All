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
		PokemonGoState initialState = new PokemonGoState(maze.getStart().getPosition(), 0, maze.getPokemonsGenerated(),
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

	@Override
	public int pathCost() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean goalTest(State state) {
		PokemonGoState pokeState = (PokemonGoState) state;
		//System.out.println(pokeState.getPokemonsLeft().size());
		if (//pokeState.getStepsMoved() >= this.StepsToMove && 
				//pokeState.getPokemonsLeft().isEmpty() && 
					this.maze.getEnd().getX() == pokeState.getCurrentPosition().getX()
						&& this.maze.getEnd().getY() == pokeState.getCurrentPosition().getY()) {
			System.out.println(this.StepsToMove);
			System.out.println(pokeState.getStepsMoved());
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

	public int getStepsToMove() {
		return StepsToMove;
	}

	public void setStepsToMove(int stepsToMove) {
		StepsToMove = stepsToMove;
	}
	

}
