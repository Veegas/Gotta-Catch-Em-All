package main;

import java.util.Random;
import java.util.stream.IntStream;

import EvaluationFunctions.Heuristic1;
import abstracts.EvaluationFunction;
import abstracts.GeneralSearchAlgorithm;
import abstracts.QueuingFunction;
import abstracts.SearchNode;
import abstracts.SearchProblem;
import abstracts.State;
import mazeGenerator.Maze;
import queuingFunctions.BreadthFirst;
import queuingFunctions.UniformCost;
import queuingFunctions.DepthFirst;
import queuingFunctions.DepthLimited;
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
	
//	search(maze, "BF", true);
//	search(maze, "DF", true);
//	search(maze, "UF", true);
//	search(maze, "IF", true);
	search(maze, "GR1", true);
	search(maze, "AS1", true);
	
    }
    
    public static void search(Maze maze, String strategy, boolean visualize) {
	PokemonGoEnvironment assumedEnviroment= new PokemonGoEnvironment(maze);
	Random random = new Random();
	int x = random.ints(0, maze.getHeight() * maze.getWidth()).findFirst().getAsInt();
	PokemonGoSearchProblem pokeSearch = new PokemonGoSearchProblem(maze, x);
	
	System.out.println("Steps To Move: " + pokeSearch.getStepsToMove() + ", Number Of Pokemons: " + maze.getPokemonsGenerated().size());
	
	
	PokemonGoSearchAlgorithm searchAlgorithm = new PokemonGoSearchAlgorithm(assumedEnviroment); 

	QueuingFunction<SearchNode> bfs = new BreadthFirst();
	QueuingFunction<SearchNode> ufc = new UniformCost();
	QueuingFunction<SearchNode> dfs = new DepthFirst();
	QueuingFunction<SearchNode> depthLimited = new DepthLimited();
	
	EvaluationFunction H1= new Heuristic1();
	
	
	SearchNode answer = null;
	switch (strategy) {
		case "BF": answer = searchAlgorithm.GeneralSearch(pokeSearch, bfs); break;
		case "UC": answer = searchAlgorithm.GeneralSearch(pokeSearch, ufc);break;
		case "DF": answer = searchAlgorithm.GeneralSearch(pokeSearch, dfs);break;
		case "ID": answer = searchAlgorithm.IterativeDeepening(pokeSearch, depthLimited);break;
		case "GR1": answer = searchAlgorithm.BestFirstSearch(pokeSearch, H1, "Greedy");break;
		case "AS1": answer = searchAlgorithm.BestFirstSearch(pokeSearch, H1, "AS");break;
		default: answer = null;
	}
	
	
	
	
	if (answer == null) {
	    System.out.println("No Solution found");
	} else {
	    System.out.println();
	    System.out.println("________________SOLUTION______________"); 
	    answer.printPathToRoot();
	    System.out.println();
	    maze.drawMaze();
	    System.out.println("___________________________________");
	}
	
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
