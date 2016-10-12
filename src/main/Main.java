package main;

import abstracts.GeneralSearchAlgorithm;
import abstracts.QueuingFunction;
import abstracts.SearchNode;
import abstracts.SearchProblem;
import abstracts.State;
import mazeGenerator.Maze;
import queuingFunctions.BreadthFirst;
import queuingFunctions.UniformCost;
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
	search(maze, "ufc", true);
	
    }
    
    public static void search(Maze maze, String strategy, boolean visualize) {
	PokemonGoEnvironment assumedEnviroment= new PokemonGoEnvironment(maze);
	PokemonGoSearchProblem pokeSearch = new PokemonGoSearchProblem(maze);
	PokemonGoSearchAlgorithm searchAlgorithm = new PokemonGoSearchAlgorithm(assumedEnviroment); 
	
	QueuingFunction<SearchNode> bfs = new BreadthFirst();
	QueuingFunction<SearchNode> ufc = new UniformCost();
	QueuingFunction<SearchNode> toBeUsed;
	
	switch (strategy) {
		case "bfs": toBeUsed = bfs; break;
		case "ufc": toBeUsed = ufc;break;
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
