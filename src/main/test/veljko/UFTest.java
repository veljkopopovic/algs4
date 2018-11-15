package veljko;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UFTest {
  public static final int ElementsCount = 10;
  public static void testIfElementsAreNotConnectedInitially(UF qf){
    assertEquals(false, qf.connected(0,1));
    assertEquals(false, qf.connected(0,9));
  }

  public static void testIfElementIsConnectedToItself(UF qf){
    for (int i = 0; i < ElementsCount; i++) {
      assertEquals(true, qf.connected(i,i));
    }
  }

  public static void testIfConnectionIsMade(UF qf) {
    assertEquals(false, qf.connected(0,2));
    qf.union(0,2);
    assertEquals(true, qf.connected(0,2));
  }

  public static void testIfMergeWasMade(UF qf) {
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
