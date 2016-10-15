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
    
    public void printPathToRoot() {
	String path = "************************\n";
	SearchNode currentNode = this;
	while (currentNode != null) {
	    path = currentNode.toString() + "\n" + path;
	    currentNode = currentNode.parent;
	}
	path = "************************\n" + path;
	System.out.println(path);
    } 
    
    public boolean foundInAncestors() {
	SearchNode parent = this.parent;
	while (parent != null) {
	    if (parent.state.equals(this.state)) {
		return true;
	    }
	    parent = parent.parent;
	}
	return false;
    }
    
    public boolean foundAsParent() {
	return parent.state.equals(this.state);
    }
    
    public boolean foundInLimitedAncestors(int n) {
	SearchNode parent = this.parent;
	while (parent != null) {
	    if (n <= 0) {
	       return false;
	   } else {
	       n--;
	       if (parent.state.equals(this.state))
		   return true;
	   }
	    parent = this.parent;
	}
	return false;
    }

}
