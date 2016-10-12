package abstracts;

import java.util.ArrayList;
import java.util.function.Function;

import search.PokemonGoSearchNode;
import search.PokemonGoState;

//represents any abstract Search Problem
public abstract class SearchProblem {
	private ArrayList<State> stateSpace;
	private State initialState;
	private ArrayList<Operation<? extends SearchNode>> operations;

	// Constructor
	public SearchProblem(ArrayList<State> stateSpace, State initialState,
			ArrayList<Operation<? extends SearchNode>> operations) {
		this.stateSpace = stateSpace;
		this.initialState = initialState;
		this.operations = operations;
		this.stateSpace.add(initialState);
	}

	public SearchProblem() {
		this.stateSpace = new ArrayList<State>();
	}

	// Abstract methods, any subclasses should implement.
	public abstract boolean goalTest(State state);

	public static int pathCost(SearchNode n) {
	    return 0;
	}

	// Setters and Getters
	public ArrayList<State> getStateSpace() {
		return stateSpace;
	}

	public void setStateSpace(ArrayList<? extends State> stateSpace) {
		this.stateSpace.clear();
		this.stateSpace.addAll(stateSpace);
	}

	public boolean addToStateSpace(State state) {
	    if (!this.stateSpace.contains(state)) {
		this.stateSpace.add(state);
//		System.out.println("Added " + state + " to State Space");
		return true;
	    } else {
		return false;
	    }
	}

	public State getInitialState() {
		return initialState;
	}

	public void setInitialState(State initialState) {
		this.initialState = initialState;
	}

	public ArrayList<Operation<? extends SearchNode>> getOperations() {
		return operations;
	}

	public void setOperations(ArrayList<Operation<? extends SearchNode>> operations) {
		this.operations = operations;
	}

	public abstract SearchNode createNodeFromState(State newState, SearchNode parentNode);

}
