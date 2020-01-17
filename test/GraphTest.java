import org.junit.Test;

import java.io.File;

import static junit.framework.TestCase.*;

public class GraphTest {

  private final Graph<String> graph = new Graph();
  private final File tmp = new File("tmp");

  /*Graph1: Connected, acyclic, size 4 */
  private Graph<String> graph1() {
    Graph<String> graph1 = new Graph<>();
    graph1.addDirectedEdge("1", "2");
    graph1.addDirectedEdge("1", "3");
    graph1.addDirectedEdge("1", "4");
    graph1.addDirectedEdge("2", "3");
    graph1.addDirectedEdge("2", "4");
    graph1.addDirectedEdge("3", "4");
    return graph1;
  }

  /*Graph2: Connected, cyclic, size 11 */
  private Graph<String> graph2() {
    Graph<String> graph2= new Graph<>();
    graph2.addEdge("1", "2");
    graph2.addEdge("2", "3");
    graph2.addEdge("3", "4");
    graph2.addEdge("4", "5");
    graph2.addEdge("5", "6");
    graph2.addEdge("6", "7");
    graph2.addEdge("7", "1");
    graph2.addEdge("7", "8");
    graph2.addEdge("8", "9");
    graph2.addEdge("9", "10");
    graph2.addEdge("10", "11");
    return graph2;
  }

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
    assertTrue(graph.size() == 2);
  }

  @Test
  public void graphToString() {
    assertEquals(graph1().toString(),"1 -> 2 3 4 \n2 -> 3 4 \n3 -> 4 \n4 -> \n");
  }

  /*Test that the to string method returns the same value after multiple calls */
  @Test
  public void graphToStringRetainsIntegrity() {
    Graph<String> graph1 = graph1();
    assertEquals(graph1.toString(), graph1.toString());
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
  public void isCyclicTest() {
    assertFalse(graph1().isCyclic());
    System.out.println(graph2());
    assertTrue(graph2().isCyclic());
  }

}
