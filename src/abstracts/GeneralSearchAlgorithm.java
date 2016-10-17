package abstracts;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.function.Function;

import queuingFunctions.BestFirst;
import queuingFunctions.DepthLimited;
import search.PokemonGoSearchProblem;
import search.PokemonGoState;

public abstract class GeneralSearchAlgorithm {
    Environment environment;
    SearchProblem problem;
    private int expandedNodesNumber;

    public GeneralSearchAlgorithm(Environment environment) {
	this.environment = environment;
	this.setExpandedNodesNumber(0);
    }

    public SearchNode GeneralSearch(SearchProblem problem,
	    QueuingFunction<SearchNode> queuingFunction) {
	this.problem = problem;
	ArrayList<SearchNode> nodes = new ArrayList<SearchNode>();
	SearchNode initialNode = this.problem
		.createNodeFromState(problem.getInitialState(), null, null);
	nodes.add(initialNode);

	while (true) {

	    if (nodes.isEmpty()) {
		System.out.println("Nodes are Empty");
		return null;
	    }

	    SearchNode currentNode = nodes.remove(0);
	    expandedNodesNumber++;

	    PokemonGoState state = (PokemonGoState) currentNode.getState();
	    
	    System.out.println(state);
	    // currentNode.printPathToRoot();
	    // pokeProblem.getMaze().drawMaze();

	    if (this.problem.goalTest(currentNode.getState())) {
		System.out.println("Passed Goal Test");
		return currentNode;
	    }

	    ArrayList<? extends SearchNode> expandedNodes = this
		    .expandNode(currentNode, this.problem.getOperations());

	    for (SearchNode toBeAddedNode : expandedNodes) {
		nodes = queuingFunction.enqueue(toBeAddedNode, nodes);
	    }

	}
    }

    public SearchNode DepthLimitedSearch(SearchProblem problem,
	    QueuingFunction<SearchNode> queuingFunction, int depth) {
	this.problem = problem;
	ArrayList<SearchNode> nodes = new ArrayList<SearchNode>();
	SearchNode initialNode = this.problem
		.createNodeFromState(problem.getInitialState(), null, null);
	nodes.add(initialNode);

	while (true) {

	    if (nodes.isEmpty()) {
		return null;
	    }

	    SearchNode currentNode = nodes.remove(0);
	    expandedNodesNumber++;

	    System.out.println(currentNode);
	    if (this.problem.goalTest(currentNode.getState())) {
		System.out.println("Passed Goal Test");
		return currentNode;
	    }

	    ArrayList<? extends SearchNode> expandedNodes = this
		    .expandNode(currentNode, this.problem.getOperations());

	    for (SearchNode toBeAddedNode : expandedNodes) {
		DepthLimited depthLimited = (DepthLimited) queuingFunction;
		nodes = depthLimited.depthLimitedEnqueue(toBeAddedNode, nodes,
			depth);
	    }
	}
    }

    public SearchNode IterativeDeepening(SearchProblem problem,
	    QueuingFunction<SearchNode> queuingFunction) {
	DepthLimited depthLimitedQueueing = new DepthLimited();
	for (int depth = 0; true; depth++) {
	    problem.clearStateSpace();
	    SearchNode result = this.DepthLimitedSearch(problem,
		    depthLimitedQueueing, depth);
	    if (result != null) {
		return result;
	    }
	}
    }

    public SearchNode BestFirstSearch(SearchProblem problem,
	    EvaluationFunction evaluation) {
	QueuingFunction<SearchNode> BestFirst = new BestFirst(problem,
		evaluation);
	return GeneralSearch(problem, BestFirst);
    }

    public ArrayList<? extends SearchNode> expandNode(SearchNode node,
	    ArrayList<Operation<? extends SearchNode>> operations) {
	ArrayList<SearchNode> expandedNodes = new ArrayList<SearchNode>();

	for (Operation<? extends SearchNode> operation : operations) {
	    SearchNode newNode = operation.apply(node, this.environment);
	    if (newNode != null) {
		State nodeState = newNode.getState();
		boolean undiscoveredState = this.problem
			.addToStateSpace(nodeState);

		if (undiscoveredState == true) {
		    expandedNodes.add(newNode);
		}
	    }
	}

	return expandedNodes;
    }

    public int getExpandedNodesNumber() {
	return expandedNodesNumber;
    }

    public void setExpandedNodesNumber(int expandedNodesNumber) {
	this.expandedNodesNumber = expandedNodesNumber;
    }

}
