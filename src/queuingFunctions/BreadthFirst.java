package queuingFunctions;

import java.util.ArrayList;

import abstracts.QueuingFunction;
import abstracts.SearchNode;

public class BreadthFirst implements QueuingFunction<SearchNode> {

    @Override
    public ArrayList<SearchNode> enqueue(SearchNode N,
	    ArrayList<SearchNode> queue) {
	queue.add(N);
	return queue;
    }

}
