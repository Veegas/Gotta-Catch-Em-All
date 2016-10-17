package abstracts;

import java.util.ArrayList;
import java.util.PriorityQueue;

public interface QueuingFunction<T> {
    ArrayList<T> enqueue(T N, ArrayList<T> queue);
}
