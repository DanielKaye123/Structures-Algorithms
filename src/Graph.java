import java.util.*;
import java.util.function.ToDoubleBiFunction;

public class Graph<E> {
  private Map<E, LinkedList<E>> graph;

  public Graph() {
    this.graph = new HashMap<>();
  }

  public int size() {
    return graph.size();
  }

  public void addVertex(E vertex) {
    graph.putIfAbsent(vertex, new LinkedList<>());
  }

  public void addEdge(E vertex1, E vertex2) {
    addVertex(vertex1);
    addVertex(vertex2);

    graph.get(vertex1).add(vertex2);
  }

  @Override
  public String toString() {
    String graphString = "";
    for (Map.Entry<E, LinkedList<E>> entry : graph.entrySet()) {
      graphString += entry.getKey() + " -> ";

      for(int i = 0; i < entry.getValue().size(); i++) {
        graphString += entry.getValue().get(i) + " ";
      }
      graphString += "\n";
    }
    return graphString;
  }

  public boolean isCyclic() {
    if (graph.keySet().isEmpty()) {
      return false;
    }
    HashSet<E> visited = new HashSet<>();
    return isCyclicUtil(graph.keySet().iterator().next(), visited);
  }

  private boolean isCyclicUtil(E vertex, Set<E> visited) {
    visited.add(vertex);
    for (int i = 0 ; i < graph.get(vertex).size(); i++) {
      E v = graph.get(vertex).get(i);
      if (visited.contains(v)) {
        return true;
      }
      if (isCyclicUtil(v, visited)) {
        return true;
      }
    }
    return false;
  }
}
