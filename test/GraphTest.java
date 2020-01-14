import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class GraphTest {

  @Test
  public void GraphInitialisedWithSizeZero() {
    Graph<Integer> graph = new Graph<>();

    assertTrue(graph.size() == 0);
  }
}
