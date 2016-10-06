package main;

import abstracts.GeneralSearchAlgorithm;
import abstracts.QueuingFunction;
import abstracts.SearchNode;
import abstracts.SearchProblem;
import abstracts.State;
import mazeGenerator.Maze;
import queuingFunctions.BreadthFirst;
import search.PokemonGoEnvironment;
import search.PokemonGoSearchAlgorithm;
import search.PokemonGoSearchNode;
import search.PokemonGoSearchProblem;
import search.PokemonGoState;

public class Main {
    
    
    public static void main(String [] args) {
//	System.out.println("-----Starting Search Agent------");

	Maze maze = new Maze();
	maze.genMaze();
	PokemonGoEnvironment assumedEnviroment= new PokemonGoEnvironment(maze);
	PokemonGoSearchProblem pokeSearch = new PokemonGoSearchProblem(maze);
	QueuingFunction<SearchNode> bfs = new BreadthFirst();
	PokemonGoSearchAlgorithm searchAlgorithm = new PokemonGoSearchAlgorithm(assumedEnviroment); 
	searchAlgorithm.GeneralSearch(pokeSearch, bfs);
	
	
//	System.out.println("-----Ending Search Agent------");
	

    }
}
