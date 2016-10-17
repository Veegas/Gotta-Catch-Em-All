package search;

import abstracts.Operation;
import abstracts.SearchNode;
import abstracts.State;
import operations.PokemonGoOperation;

public class PokemonGoSearchNode extends SearchNode  implements Comparable<PokemonGoSearchNode>{

    public PokemonGoSearchNode(PokemonGoState s, PokemonGoSearchNode p, Operation<? extends SearchNode> operation) {
	super(s, p, operation);
	this.setCost(0);
	this.setEvaluationCost(0);
    }
    
    public PokemonGoSearchNode(PokemonGoState s) {
	super(s, null, null);
	this.setCost(0);
	this.setEvaluationCost(0);
    }
    
    public PokemonGoState getState() {
	return (PokemonGoState) super.getState();
    }
    
    public void setState(PokemonGoState state) {
	super.setState(state);
    }
    
	public PokemonGoSearchNode moveForward() {
	    return this;
	}
	
	public PokemonGoSearchNode rotateRight() {
	    return this;
	}
	
	public PokemonGoSearchNode rotateLeft() {
	    return this;
	}

	@Override
	public int compareTo(PokemonGoSearchNode o) {
	    if (this.getEvaluationCost() < o.getEvaluationCost()) {
		return -1;
	    }
	    if (this.getEvaluationCost() > o.getEvaluationCost()) {
		return 1;
	    }
	    return 0;
	}
	

}
