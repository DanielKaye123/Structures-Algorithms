import org.junit.Test;

import java.io.File;

import static junit.framework.TestCase.*;

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

  /*Test that the to string method returns the same value after multiple calls */
  @Test
  public void graphToStringRetainsIntegrity() {
    graph.addEdge("1", "2");
    graph.addEdge("1", "3");
    graph.addEdge("1", "4");
    graph.addEdge("2", "3");
    graph.addEdge("2", "4");
    graph.addEdge("3", "4");

    assertEquals(graph.toString(), graph.toString());
  }

  @Test
  public void isCyclicReturnsFalseForEmptyGraph() {
    assertFalse(graph.isCyclic());
  }

  @Test
  public void isCyclicReturnsFalseForSingleVertex() {
    graph.addVertex("1");
    assertFalse(graph.isCyclic());
  }

  @Test
  public void returnsFalseWhenNoCycle() {
    graph.addEdge("1", "2");
    graph.addEdge("2", "3");
    assertFalse(graph.isCyclic());
  }

  @Test
  public void cyclicWhenLoop() {
    graph.addEdge("1", "1");
    assertTrue(graph.isCyclic());
  }

  @Test
  public void isCyclicReturnsTrueWhenManyCycles() {
    graph.addEdge("1", "2");
    graph.addEdge("1", "3");
    graph.addEdge("1", "4");
    graph.addEdge("2", "3");
    graph.addEdge("2", "4");
    graph.addEdge("3", "4");

    assertTrue(graph.isCyclic());
  }

}
