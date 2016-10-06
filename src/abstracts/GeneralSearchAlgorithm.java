package abstracts;

import java.util.ArrayList;
import java.util.function.Function;

public abstract class GeneralSearchAlgorithm {

    public SearchNode GeneralSearch(SearchProblem problem,
	    QueuingFunction<SearchNode> queuingFunction) {

	ArrayList<SearchNode> nodes = new ArrayList<SearchNode>();
	SearchNode initialNode = new SearchNode(problem.getInitialState(), null);
	nodes.add(initialNode);

	while (true) {


	    if (nodes.isEmpty()) {
		return null;
	    }
	    
	    SearchNode currentNode = nodes.remove(0);
	    
	    if (problem.goalTest(currentNode.getState())) {
		return currentNode;
	    }

	    ArrayList<? extends SearchNode> expandedNodes = GeneralSearchAlgorithm
		    .expandNode(currentNode, problem.getOperations());

	    for (SearchNode toBeAddedNode : expandedNodes) {
		nodes = queuingFunction.enqueue(toBeAddedNode, nodes);
	    }
	}

    }

    public static ArrayList<? extends SearchNode> expandNode(SearchNode node,
	    ArrayList<Operation<? extends  SearchNode>> operations) {
	ArrayList<SearchNode> expandedNodes = new ArrayList<SearchNode>();

	for (Operation<? extends SearchNode> operation : operations) {
	    System.out.println("expandNode");
	    expandedNodes.add(operation.apply(node));
	}

	return expandedNodes;
    }

}
