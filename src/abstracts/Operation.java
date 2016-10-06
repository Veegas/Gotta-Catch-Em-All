package abstracts;

//represents any abstract operation in a search problem
public interface Operation<T extends SearchNode> {
	public abstract SearchNode apply(SearchNode node);
}
