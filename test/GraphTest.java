import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class GraphTest {

  private final Graph<String> graph = new Graph();

  @Test
  public void graphInitialisedWithSizeZero() {
    assertTrue(graph.size() == 0);
  }

  @Test
  public void addVertexIncreasesSize() {
    graph.addVertex("1");
    assertTrue(graph.size() == 1);
  }

  @Test
  public void noDuplicateVertices() {
    graph.addVertex("1");
    graph.addVertex("1");
    assertTrue(graph.size() == 1);
  }

  @Test
  public void addEdgeCreatesNewVertices() {
    graph.addEdge("1", "2");
    assertTrue(graph.size() == 2);;
  }

}
