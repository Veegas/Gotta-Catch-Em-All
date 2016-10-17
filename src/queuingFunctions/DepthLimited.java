package queuingFunctions;

import java.util.ArrayList;

import abstracts.QueuingFunction;
import abstracts.SearchNode;

public class DepthLimited extends DepthFirst implements QueuingFunction<SearchNode> {


    
    public ArrayList<SearchNode> depthLimitedEnqueue(SearchNode N,
	    ArrayList<SearchNode> queue, int depth) {
	if (N.getLevel() <= depth) {
	    return this.enqueue(N, queue);
	} 
	return queue;
    }

}
