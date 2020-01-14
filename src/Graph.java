import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.ToDoubleBiFunction;

public class Graph<E> {
  private Map<E, LinkedList<E>> graph;

  public Graph() {
    this.graph = new HashMap<>();
  }

  public void addVertex(E vertex) {
    LinkedList<E> edges = new LinkedList<>();
    graph.putIfAbsent(vertex, edges);
  }

  public void addEdge(E node1, E node2) {
    //TODO
  }

  public int size() {
    return graph.size();
  }


}
