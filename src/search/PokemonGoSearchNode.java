package search;

import abstracts.SearchNode;
import abstracts.State;

public class PokemonGoSearchNode extends SearchNode {

    public PokemonGoSearchNode(PokemonGoState s, PokemonGoSearchNode p) {
	super(s, p);
	this.setCost(0);
    }
    
    public PokemonGoSearchNode(PokemonGoState s) {
	super(s, null);
	this.setCost(0);
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

}
