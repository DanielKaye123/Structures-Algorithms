import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.ToDoubleBiFunction;

public class Graph<E> {
  private Map<Vertex, LinkedList<Vertex>> graph;

  public Graph() {
    this.graph = new HashMap<>();
  }

  public void addVertex(E data) {
    Vertex<E> vertex = new Vertex<>(data);
    LinkedList<Vertex> edges = new LinkedList<>();
    graph.put(vertex, edges);
  }

  public void addEdge(E node1, E node2) {
    Vertex<E> v1 = new Vertex<>(node1);
    Vertex<E> v2 = new Vertex<>(node2);
    //TODO
  }

  public int size() {
    return graph.size();
  }

  private class Vertex<E> {
    E data;

    private Vertex(E data) {
      this.data = data;
    }
  }
}
