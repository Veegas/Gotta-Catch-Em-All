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
import queuingFunctions.UniformCost;
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
	
	search(maze, "bfs", true);
	search(maze, "dfs", true);
	search(maze, "ufc", true);
	
    }
    
    public static void search(Maze maze, String strategy, boolean visualize) {
	PokemonGoEnvironment assumedEnviroment= new PokemonGoEnvironment(maze);
	Random random = new Random();
	int x = random.ints(0,10).findFirst().getAsInt();
	PokemonGoSearchProblem pokeSearch = new PokemonGoSearchProblem(maze, x);
	
	PokemonGoSearchAlgorithm searchAlgorithm = new PokemonGoSearchAlgorithm(assumedEnviroment); 

	maze.drawMaze();

	QueuingFunction<SearchNode> bfs = new BreadthFirst();
	QueuingFunction<SearchNode> ufc = new UniformCost();
	QueuingFunction<SearchNode> dfs = new DepthFirst();

	QueuingFunction<SearchNode> toBeUsed;
	
	switch (strategy) {
		case "bfs": toBeUsed = bfs; break;
		case "ufc": toBeUsed = ufc;break;
		case "dfs": toBeUsed = dfs;break;
		default: toBeUsed = bfs;
	}
	
	
	SearchNode answer = searchAlgorithm.GeneralSearch(pokeSearch, toBeUsed);
	
	System.out.println();
	System.out.println("________________SOLUTION______________");
	printPathToRoot(answer);
	System.out.println();
	System.out.println("___________________________________\n");
	System.out.println("Number Of Expanded Nodes: " + searchAlgorithm.getExpandedNodesNumber());
	System.out.println();
    }
    
    public static void printPathToRoot(SearchNode answer) {
	while(answer != null) {
	    int totalPathCost = PokemonGoSearchProblem.pathCost(answer);
	    System.out.println(answer + " --> Path Cost: " + totalPathCost);
	    answer = answer.getParent();
	}
    }
}
