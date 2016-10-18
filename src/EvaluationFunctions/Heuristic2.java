package EvaluationFunctions;

import java.util.ArrayList;

import abstracts.EvaluationFunction;
import abstracts.SearchNode;
import abstracts.SearchProblem;
import gameObjects.Pokemon;
import search.PokemonGoSearchNode;
import search.PokemonGoSearchProblem;
import search.Position;

//considering no walls but pokemons are not on the way towards the end.
public class Heuristic2 implements EvaluationFunction {

	@Override
	public int Evaluate(SearchProblem problem, SearchNode node) {
		PokemonGoSearchProblem pokeProblem = (PokemonGoSearchProblem) problem;
		PokemonGoSearchNode pokeNode = (PokemonGoSearchNode) node;
		
		Position endPosition = pokeProblem.getMaze().getEnd().getPosition();
		Position nodePosition = pokeNode.getState().getCurrentPosition();
		
		ArrayList<Pokemon> pokemonsLeft = pokeNode.getState().getPokemonsLeft();
		double shortestDistance = 0;
		while (!pokemonsLeft.isEmpty()) {
			Pokemon closestPokemon = getClosestPokemon(nodePosition, pokemonsLeft);
			int xSquared = (closestPokemon.getCell().getPosition().getX() - nodePosition.getX()) ^ 2;
			int ySquared = (closestPokemon.getCell().getPosition().getY() - nodePosition.getY()) ^ 2;
			
			shortestDistance += Math.sqrt(xSquared + ySquared);
			nodePosition = closestPokemon.getCell().getPosition();
			pokemonsLeft.remove(closestPokemon);
			
		}
		//add distance from last pokemon node position to end point
		int xSquared = (endPosition.getX() - nodePosition.getX()) ^ 2;
		int ySquared = (endPosition.getY() - nodePosition.getY()) ^ 2;
		shortestDistance += Math.sqrt(xSquared + ySquared);
		return (int) Math.ceil(shortestDistance);
		
	}
	
	public Pokemon getClosestPokemon(Position currentPos, ArrayList<Pokemon> pokemonsLeft) {
		Pokemon ClosestPokemon = pokemonsLeft.get(0);
		int xSquared = (currentPos.getX() - pokemonsLeft.get(0).getCell().getPosition().getX()) ^ 2;
		int ySquared = (currentPos.getY() - pokemonsLeft.get(0).getCell().getPosition().getY()) ^ 2;
		double  shortestDistance = Math.sqrt(xSquared + ySquared);
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
