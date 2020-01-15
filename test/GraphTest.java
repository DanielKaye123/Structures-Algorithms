import org.junit.Test;

import java.io.File;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class GraphTest {

  private final Graph<String> graph = new Graph();
  private final File tmp = new File("tmp");

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

  @Test
  public void graphToString() {
    graph.addEdge("1", "2");
    graph.addEdge("1", "3");
    graph.addEdge("1", "4");
    graph.addEdge("2", "3");
    graph.addEdge("2", "4");
    graph.addEdge("3", "4");

    System.out.println(graph.toString());
    assertEquals(graph.toString(),"1 -> 2 3 4 \n2 -> 3 4 \n3 -> 4 \n4 -> \n");
  }
}
