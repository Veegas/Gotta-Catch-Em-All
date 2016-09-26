package abstracts;

import java.util.ArrayList;

public abstract class SearchProblem {
	private ArrayList<State> stateSpace;
	private State initialState;
	private ArrayList<Operation> operations;
	
	public abstract boolean goalTest();
	public abstract int pathCost();
	
} 
