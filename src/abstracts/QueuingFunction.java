package abstracts;

import java.util.ArrayList;

public interface QueuingFunction<T> {
	ArrayList<T> enqueue(T N, ArrayList<T> queue);
}
