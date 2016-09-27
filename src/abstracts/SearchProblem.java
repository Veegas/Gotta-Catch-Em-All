package abstracts;

import java.util.ArrayList;

//represents any abstract Search Problem
public abstract class SearchProblem {
	private ArrayList<State> stateSpace;
	private State initialState;
	private ArrayList<Operation> operations;
	
	//Constructor
	public SearchProblem(ArrayList<State> stateSpace, State initialState, ArrayList<Operation> operations) {
		this.stateSpace = stateSpace;
		this.initialState = initialState;
		this.operations = operations;
	}
	
	//Abstract methods, any subclasses should implement.
	public abstract boolean goalTest();
	public abstract int pathCost();
	
	//Setters and Getters
	public ArrayList<State> getStateSpace() {
		return stateSpace;
	}
	public void setStateSpace(ArrayList<State> stateSpace) {
		this.stateSpace.clear();
		this.stateSpace.addAll(stateSpace);
	}
	public State getInitialState() {
		return initialState;
	}
	public void setInitialState(State initialState) {
		this.initialState = initialState;
	}
	public ArrayList<Operation> getOperations() {
		return operations;
	}
	public void setOperations(ArrayList<Operation> operations) {
		this.operations.clear();
		this.operations.addAll(operations);
	}
	
	
	
} 
