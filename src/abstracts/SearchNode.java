package abstracts;

//represents an abstract node in the search tree problem
public abstract class SearchNode {
	private State state;
	private SearchNode parent;
	
	//Constructor
	public SearchNode(State s, SearchNode p) {
		this.state = s;
		this.parent = p;
	}

	//Setters and Getters
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public SearchNode getParent() {
		return parent;
	}

	public void setParent(SearchNode parent) {
		this.parent = parent;
	}
	
}
