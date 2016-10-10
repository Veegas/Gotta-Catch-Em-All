package operations;

import abstracts.Environment;
import abstracts.Operation;
import abstracts.SearchNode;
import search.PokemonGoSearchNode;
import search.PokemonGoState;

public class RotateRightOperation implements Operation<PokemonGoSearchNode> {

    public PokemonGoSearchNode apply(PokemonGoSearchNode node) {
	// TODO Auto-generated method stub
	System.out.println("El fadya");
	return null;
    }


    @Override
    public SearchNode apply(SearchNode node, Environment enviroment) {
	PokemonGoState state = (PokemonGoState) node.getState();
	PokemonGoState newState = state.rotateRight();
	PokemonGoSearchNode newNode = new PokemonGoSearchNode(newState);
	return newNode;    
    }

}
