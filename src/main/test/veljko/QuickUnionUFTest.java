package veljko;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QuickUnionUFTest {
  private QuickUnionUF qf;

  @BeforeEach
  private void reset(){
    qf = new QuickUnionUF(UFTest.ElementsCount);
  }

  @Test
  public void testIfElementsAreNotConnectedInitially(){
    UFTest.testIfElementsAreNotConnectedInitially(qf);
  }

  @Test
  public void testIfElementIsConnectedToItself(){
    UFTest.testIfElementIsConnectedToItself(qf);
  }

  @Test
  public void testIfConnectionIsMade() {
    UFTest.testIfConnectionIsMade(qf);
  }

  @Test
  public void testIfMergeWasMade() {
    UFTest.testIfConnectionIsMade(qf);
  }
}
