package main;

import java.util.Random;
import java.util.stream.IntStream;
import abstracts.GeneralSearchAlgorithm;
import abstracts.QueuingFunction;
import abstracts.SearchNode;
import abstracts.SearchProblem;
import abstracts.State;
import mazeGenerator.Maze;
import queuingFunctions.BreadthFirst;
import queuingFunctions.DepthFirst;
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
	Random random = new Random();
	int x = random.ints(0,10).findFirst().getAsInt();
	PokemonGoSearchProblem pokeSearch = new PokemonGoSearchProblem(maze, x);
	QueuingFunction<SearchNode> bfs = new BreadthFirst();
	QueuingFunction<SearchNode> dfs = new DepthFirst();
	PokemonGoSearchAlgorithm searchAlgorithm = new PokemonGoSearchAlgorithm(assumedEnviroment); 
	searchAlgorithm.GeneralSearch(pokeSearch, dfs);
	maze.drawMaze();
	
	
//	System.out.println("-----Ending Search Agent------");
	

    }
}
