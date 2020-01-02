import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

  private final LinkedList<String> linkedList = new LinkedList<>();

  @Test
  public void isEmptyOnInitialisation() {
    assertTrue(new LinkedList<String>().isEmpty());
  }

  @Test
  public void addIncrementsSize() {
    linkedList.add("1");
    linkedList.add("2");
    linkedList.add("3");
    linkedList.add("4");

    assertTrue(linkedList.size() == 4);
  }

  @Test
  public void containsItemsAppended() {
    linkedList.add("1");
    linkedList.add("2");
    linkedList.add("3");

    assertTrue(linkedList.contains("1"));
    assertTrue(linkedList.contains("2"));
    assertTrue(linkedList.contains("3"));
  }
  
}