package abstracts;

import java.util.ArrayList;
import java.util.function.Function;

//represents any abstract Search Problem
public abstract class SearchProblem<NodeType, StateType> {
	private ArrayList<StateType> stateSpace;
	private StateType initialState;
	private ArrayList<Operation <NodeType>> operations;

	// Constructor
	public SearchProblem(ArrayList<StateType> stateSpace, StateType initialState,
			ArrayList<Operation<NodeType>> operations) {
		this.stateSpace = stateSpace;
		this.initialState = initialState;
		this.operations = operations;
	}
	
	public SearchProblem() {
	  this.stateSpace = new ArrayList<StateType>();  
	}

	// Abstract methods, any subclasses should implement.
	public abstract boolean goalTest(SearchNode node);

	public abstract int pathCost();

	// Setters and Getters
	public ArrayList<StateType> getStateSpace() {
		return stateSpace;
	}

	public void setStateSpace(ArrayList<StateType> stateSpace) {
		this.stateSpace.clear();
		this.stateSpace.addAll(stateSpace);
	}

	public StateType getInitialState() {
		return initialState;
	}

	public void setInitialState(StateType initialState) {
		this.initialState = initialState;
	}

	public ArrayList<Operation<NodeType>> getOperations() {
	    return operations;
	}

	public void setOperations(ArrayList<Operation<NodeType>> operations) {
	    this.operations = operations;
	}


}
