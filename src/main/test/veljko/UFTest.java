package veljko;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UFTest {
  static final int ElementsCount = 10;
  private final List<UF> testufs;

  public UFTest(){
     testufs = Arrays.asList(
         new QuickFindUF(),
         new QuickUnionUF(),
         new WeightedUnionUF()
     );
  }
  private void testIfElementsAreNotConnectedInitially(UF qf){
    assertEquals(false, qf.connected(0,1));
    assertEquals(false, qf.connected(0,9));
  }

  private void testIfElementIsConnectedToItself(UF qf){
    for (int i = 0; i < ElementsCount; i++) {
      assertEquals(true, qf.connected(i,i));
    }
  }

  private void testIfConnectionIsMade(UF qf) {
    assertEquals(false, qf.connected(0,2));
    qf.union(0,2);
    assertEquals(true, qf.connected(0,2));
  }

  private void testIfMergeWasMade(UF qf) {
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

  @BeforeEach
  private void initialie() {
    testufs.forEach(uf -> {
      uf.reset(ElementsCount);
    });
  }

  @Test
  public void testIfElementsAreNotConnectedInitially(){
    testufs.forEach(uf -> {
      testIfElementsAreNotConnectedInitially(uf);
    });
  }

  @Test
  public void testIfElementIsConnectedToItself(){
    testufs.forEach(uf->{
      testIfElementIsConnectedToItself(uf);
    });
  }

  @Test
  public void testIfConnectionIsMade() {
    testufs.forEach(uf->{
      testIfConnectionIsMade(uf);
    });
  }

  @Test
  public void testIfMergeWasMade() {
    testufs.forEach(uf->{
      testIfMergeWasMade(uf);
    });
  }
}
