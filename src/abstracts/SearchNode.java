package abstracts;

//represents an abstract node in the search tree problem
public class SearchNode {
    private State state;
    private SearchNode parent;
    private int cost;

    // Should have cost?


    // Constructor
    public SearchNode(State s, SearchNode p) {
	this.state = s;
	this.parent = p;
    }

    // Setters and Getters
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
    
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    
    public String toString() {
	return state.toString() + " *" + this.cost + "* ";
    }

}
