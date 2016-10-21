package EvaluationFunctions;

import java.util.ArrayList;

import abstracts.EvaluationFunction;
import abstracts.SearchNode;
import abstracts.SearchProblem;
import gameObjects.Pokemon;
import search.PokemonGoSearchNode;
import search.Position;

public class Heuristic3 implements EvaluationFunction {

	@Override
	public int Evaluate(SearchProblem problem, SearchNode node) {
		PokemonGoSearchNode pokeNode = (PokemonGoSearchNode) node;

		Position nodePosition = pokeNode.getState().getCurrentPosition();

		ArrayList<Pokemon> pokemonsLeft = pokeNode.getState().getPokemonsLeft();
		int shortestDistance = 0;
		if (node.getParent() == null) {
			Pokemon closestPokemon = getClosestPokemon(nodePosition, pokemonsLeft);
			int xSquared = (closestPokemon.getCell().getPosition().getX() - nodePosition.getX()) ^ 2;
			int ySquared = (closestPokemon.getCell().getPosition().getY() - nodePosition.getY()) ^ 2;

			shortestDistance += (int) Math.sqrt(xSquared + ySquared);

		}
		for(int i = 0; i < pokemonsLeft.size(); i++) {
			shortestDistance += 1;
		}
		shortestDistance += 1;
		return shortestDistance;
	}

	public Pokemon getClosestPokemon(Position currentPos, ArrayList<Pokemon> pokemonsLeft) {
		Pokemon ClosestPokemon = pokemonsLeft.get(0);
		int xSquared = (currentPos.getX() - pokemonsLeft.get(0).getCell().getPosition().getX()) ^ 2;
		int ySquared = (currentPos.getY() - pokemonsLeft.get(0).getCell().getPosition().getY()) ^ 2;
		double shortestDistance = Math.sqrt(xSquared + ySquared);
		for (int i = 1; i < pokemonsLeft.size(); i++) {
			xSquared = (currentPos.getX() - pokemonsLeft.get(i).getCell().getPosition().getX()) ^ 2;
			ySquared = (currentPos.getY() - pokemonsLeft.get(i).getCell().getPosition().getY()) ^ 2;
			Double distance = Math.sqrt(xSquared + ySquared);
			if (distance < shortestDistance) {
				shortestDistance = distance;
				ClosestPokemon = pokemonsLeft.get(i);
			}
		}
		return ClosestPokemon;
	}

}
