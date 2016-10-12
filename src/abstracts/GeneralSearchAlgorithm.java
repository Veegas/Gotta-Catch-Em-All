package abstracts;

import java.util.ArrayList;
import java.util.function.Function;

import search.PokemonGoSearchProblem;
import search.PokemonGoState;

public abstract class GeneralSearchAlgorithm {
    Environment enviroment;
    SearchProblem problem;
    
    public GeneralSearchAlgorithm(Environment enviroment) {
	this.enviroment = enviroment;
    }
    
    public SearchNode GeneralSearch(SearchProblem problem,
	    QueuingFunction<SearchNode> queuingFunction) {
	this.problem = problem;
	ArrayList<SearchNode> nodes = new ArrayList<SearchNode>();
	SearchNode initialNode = this.problem.createNodeFromState(problem.getInitialState(), null);
	nodes.add(initialNode);

//	TODO: REMOVE AFTER REMOVING PRINT STATEMENT INSIDE
	PokemonGoSearchProblem pokeProblem = (PokemonGoSearchProblem) this.problem;

	while (true) {


	    if (nodes.isEmpty()) {
		return null;
	    }
	    
	    SearchNode currentNode = nodes.remove(0);
	    
	    PokemonGoState state = (PokemonGoState) currentNode.getState();
	    if (state!= null) {
		System.out.println("[ " + state.getCurrentPosition().getX() + ", " + state.getCurrentPosition().getY() + "] => " 
				+ state.getOrientation()  + " :: Target => " + pokeProblem.getMaze().getEnd().getPosition());
	   }
	    
	    if (this.problem.goalTest(currentNode.getState())) {
		return currentNode;
	    }

	    ArrayList<? extends SearchNode> expandedNodes = this.expandNode(currentNode, this.problem.getOperations());

	    for (SearchNode toBeAddedNode : expandedNodes) {
		nodes = queuingFunction.enqueue(toBeAddedNode, nodes);
	    }
	}

    }

    public ArrayList<? extends SearchNode> expandNode(SearchNode node,
	    ArrayList<Operation<? extends  SearchNode>> operations) {
	ArrayList<SearchNode> expandedNodes = new ArrayList<SearchNode>();

	for (Operation<? extends SearchNode> operation : operations) {
	    SearchNode newNode = operation.apply(node, this.enviroment);
	    if (newNode != null) {
		State nodeState = newNode.getState();
		boolean undiscoveredState = this.problem.addToStateSpace(nodeState);
		if (undiscoveredState == true) {
		    expandedNodes.add(newNode);  
		}
	    }
	}

	return expandedNodes;
    }

}
