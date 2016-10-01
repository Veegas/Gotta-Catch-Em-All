package abstracts;

import java.util.ArrayList;

public interface QueuingFunction<SearchNode> {
	ArrayList<SearchNode> enqueue(SearchNode N, ArrayList<SearchNode> queue);
}
