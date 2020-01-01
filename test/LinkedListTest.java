import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

  @Test
  public void isEmptyOnInitialisation() {
    assertTrue(new LinkedList<String>().isEmpty());
  }
}