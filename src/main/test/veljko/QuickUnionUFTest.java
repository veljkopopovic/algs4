package veljko;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuickUnionUFTest {
  private class QuickUnionTest extends QuickUnionUF{
    public int exposeRoot(int index) {
      return findRoot(index);
    }
  }

  private final QuickUnionTest qf = new QuickUnionTest();

  @BeforeEach
  public void reset() {
    qf.reset(UFTest.ElementsCount);
  }

  @Test
  public void testIfInitialRootIsSet() {
    for (int i = 0; i < UFTest.ElementsCount; i++){
      assertEquals(i, qf.exposeRoot(i));
    }
  }

  @Test
  public void testSimpleRoot(){
    qf.union(1,2);
    qf.union(2,3);
    qf.union(3,4);
    assertEquals(1, qf.exposeRoot(4));
  }

  @Test
  public void testRootAfterMerge(){
    qf.union(1,2);
    qf.union(5,6);
    assertEquals(1, qf.exposeRoot(2));
    assertEquals(5, qf.exposeRoot(6));
    qf.union(2,5);

    assertEquals(1, qf.exposeRoot(2));
    assertEquals(1, qf.exposeRoot(6));
  }
}
