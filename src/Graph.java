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
    graph.get(vertex2).add(vertex1);
  }

  public void addDirectedEdge(E vertex1, E vertex2) {
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
    return isCyclicUtil(graph.keySet().iterator().next(), new HashSet<>(), new HashMap<>());
  }

  private boolean isCyclicUtil(E vertex, Set<E> visited, Map<E, E> parent) {
    visited.add(vertex);
    for (int i = 0 ; i < graph.get(vertex).size(); i++) {
      E v = graph.get(vertex).get(i);

      if (!visited.contains(v) && parent.get(vertex) != v) {
        parent.put(v, vertex);
        return isCyclicUtil(v, visited, parent);
      }

      if (visited.contains(v) && parent.get(vertex) != v ) {
        return true;
      }


    }
    return false;
  }
}
