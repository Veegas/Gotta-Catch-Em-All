package operations;

import abstracts.Environment;
import abstracts.Operation;
import abstracts.SearchNode;
import search.PokemonGoSearchNode;
import search.PokemonGoState;

public class MoveForwardOperation implements Operation<PokemonGoSearchNode> {

    public PokemonGoSearchNode apply(PokemonGoSearchNode node) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public SearchNode apply(SearchNode node, Environment enviroment) {
	PokemonGoState state = (PokemonGoState) node.getState();
	PokemonGoState newState = state.moveForward(enviroment);
	PokemonGoSearchNode newNode = new PokemonGoSearchNode(newState);
	return newNode;
    }

}
