package veljko;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class QuickFindTest {
  private QuickFind qf;
  private int elements = 10;

  @BeforeEach
  private void reset() {
    this.qf = new QuickFind(elements);
  }

  @Test
  public void testIfElementsAreNotConnectedInitially(){
    assertEquals(false, qf.connected(0,1));
    assertEquals(false, qf.connected(0,9));
  }
  @Test
  public void testIfElementIsConnectedToItself(){
    for (int i = 0; i < elements; i++) {
      assertEquals(true, qf.connected(i,i));
    }
  }

  @Test
  public void testIfConnectionIsMade() {
    assertEquals(false, qf.connected(0,2));
    qf.union(0,2);
    assertEquals(true, qf.connected(0,2));
  }

  @Test
  public void testIfMergeWasMade() {
    qf.union(0,2);
    qf.union(3,4);
    assertEquals(false, qf.connected(0,4));
    qf.union(2,3);
    assertEquals(true, qf.connected(0,4));
    qf.union(6,7);
    qf.union(7,8);
    assertEquals(true, qf.connected(6,8));
    qf.union(4,6);
    assertEquals(true, qf.connected(0,8));
  }
}
