package abstracts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;

import search.PokemonGoSearchNode;
import search.PokemonGoState;

//represents any abstract Search Problem
public abstract class SearchProblem {
	private HashMap<State, State> stateSpace;
	private State initialState;
	private ArrayList<Operation<? extends SearchNode>> operations;

	// Constructor
	public SearchProblem(ArrayList<State> stateSpace, State initialState,
			ArrayList<Operation<? extends SearchNode>> operations) {
	    this.stateSpace = new HashMap<State, State>();	
	    for (State state : stateSpace) {
	    	    this.stateSpace.put(state, state);
	    	}

		this.initialState = initialState;
		this.operations = operations;
		this.stateSpace.put(initialState, initialState);
	}

	public SearchProblem() {
		this.stateSpace = new HashMap<State, State>();
	}

	// Abstract methods, any subclasses should implement.
	public abstract boolean goalTest(State state);

	public static int pathCost(SearchNode n) {
	    return 0;
	}

	// Setters and Getters
	public HashMap<State, State> getStateSpace() {
		return stateSpace;
	}
	
	public void setStateSpace(ArrayList<? extends State> stateSpace) {
	    this.stateSpace.clear();
	    for (State state : stateSpace) {
		this.stateSpace.put(state, state);
	    }
	    
	}
	
	public void clearStateSpace() {
	    this.stateSpace.clear();
	}


	public boolean addToStateSpace(State state) {
	    if (this.stateSpace.containsValue((state)) != true) {
		this.stateSpace.put(state, state);
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

	public abstract SearchNode createNodeFromState(State newState, SearchNode parentNode, Operation<? extends SearchNode> operation);

}
