package EvaluationFunctions;

import abstracts.EvaluationFunction;
import abstracts.SearchNode;
import abstracts.SearchProblem;
import search.PokemonGoSearchNode;
import search.PokemonGoSearchProblem;
import search.Position;

//Manhattan blocks algorithm
//considering no walls and left pokemons are on the way to the end point
public class Heuristic1 implements EvaluationFunction {

    @Override
    public int Evaluate(SearchProblem problem, SearchNode node) {
	
	PokemonGoSearchProblem pokeProblem = (PokemonGoSearchProblem) problem;
	PokemonGoSearchNode pokeNode = (PokemonGoSearchNode) node;
	
	Position endPosition = pokeProblem.getMaze().getEnd().getPosition();
	Position nodePosition = pokeNode.getState().getCurrentPosition();
	
	int xSquared = (endPosition.getX() - nodePosition.getX()) ^ 2;
	int ySquared = (endPosition.getY() - nodePosition.getY()) ^ 2;
	double shortestDistance = Math.sqrt(xSquared + ySquared);
	return (int) Math.ceil(shortestDistance);
    }

}
