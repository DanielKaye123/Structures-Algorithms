import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<E> {
  private Map<Vertex, List<Vertex>> graph;

  public Graph() {
    this.graph = new HashMap<>();
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
