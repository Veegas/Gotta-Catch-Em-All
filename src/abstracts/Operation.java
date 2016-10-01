package abstracts;

//represents any abstract operation in a search problem
public interface Operation<T> {
	public abstract T apply(T node);
}
