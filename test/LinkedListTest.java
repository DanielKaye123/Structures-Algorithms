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
  public void notEmptyAfterItemsAdded() {
    linkedList.add("1");
    assertFalse(linkedList.isEmpty());
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

  @Test
  public void onlyContainsItemsAdded() {
    linkedList.add("1");

    assertTrue(linkedList.contains("1"));
    assertFalse(linkedList.contains("2"));
  }
  @Test
  public void returnNullFromBadIndex() {
    linkedList.add("1");
    assertTrue(linkedList.get(-1) == null);
    assertTrue(linkedList.get(1) == null);
  }

  @Test
  public void throwsNullPointerWhenNullAdded() {
    try {
      linkedList.add(null);
      fail();
    } catch (Exception e) {
      assertTrue(e instanceof NullPointerException);
    }
  }

  @Test
  public void appendedItemsInOrder() {
    linkedList.add("1");
    linkedList.add("2");
    linkedList.add("3");

    assertTrue(linkedList.get(0) == "1");
    assertTrue(linkedList.get(1) == "2");
    assertTrue(linkedList.get(2) == "3");
  }

  @Test
  public void addFirstInsertsItemAtFront() {
    linkedList.add("1");
    linkedList.addFirst("2");

    assertTrue(linkedList.get(0) == "2");
  }

  @Test
  public void addFirstRetainsEndOfList() {
    linkedList.add("1");
    linkedList.addFirst("2");
    linkedList.addFirst("3");

    assertTrue(linkedList.get(0) == "3");
    assertTrue(linkedList.get(1) == "2");
    assertTrue(linkedList.get(2) == "1");
  }

  @Test
  public void addAtIndexOfEmptyList() {
    linkedList.add("1", 0);
    assertTrue(linkedList.get(0) == "1");
  }

  @Test
  public void addAtIndexIncreasesSize() {
    linkedList.add("1", 0);
    linkedList.add("2", 0);
    linkedList.add("2", 0);

    assertTrue(linkedList.size() == 3);
  }

  @Test
  public void addOnlyAtValidIndex() {
    linkedList.add("1", 2);
    assertTrue(linkedList.isEmpty());
  }

  @Test
  public void pollLastOfEmptyReturnsNull() {
    assertTrue(linkedList.pollLast() == null);
  }

  @Test
  public void pollFirstOfEmptyReturnsNull() {
    assertTrue(linkedList.pollFirst() == null);
  }

  @Test
  public void pollLastOfSingleListReturnsEmpty() {
    linkedList.add("1");
    linkedList.pollLast();

    linkedList.isEmpty();
  }

  @Test
  public void pollLastReturnsValue() {
    linkedList.add("1");
    linkedList.add("2");

    assertTrue(linkedList.pollLast() == "2");
  }

  @Test
  public void pollFirstOfSingleListReturnsEmpty() {
    linkedList.add("1");
    linkedList.pollFirst();

    assertTrue(linkedList.isEmpty());
  }

  @Test
  public void pollFirstReturnsValue() {
    linkedList.add("1");
    linkedList.add("2");

    assertTrue(linkedList.pollFirst() == "1");
  }

  @Test
  public void polledItemsNoLongerInList() {
    linkedList.add("1");
    linkedList.add("2");
    linkedList.pollFirst();
    linkedList.pollLast();

    assertTrue(linkedList.isEmpty());
  }

  @Test
  public void removeItemAtIndex() {
    linkedList.add("1");
    linkedList.add("2");
    linkedList.add("3");

    assertTrue(linkedList.remove(1) == "2");
    assertFalse(linkedList.contains("2"));
    assertTrue(linkedList.size() == 2);
  }
}