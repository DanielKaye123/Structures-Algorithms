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
    graph.putIfAbsent(vertex, new LinkedList<>());
  }

  public void addEdge(E vertex1, E vertex2) {
    addVertex(vertex1);
    addVertex(vertex2);

    graph.get(vertex1).add(vertex2);
  }
  

  public int size() {
    return graph.size();
  }


}
