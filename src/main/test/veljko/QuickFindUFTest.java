package veljko;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QuickFindUFTest {
  private QuickFindUF qf;

  @BeforeEach
  private void reset() {
    qf = new QuickFindUF(UFTest.ElementsCount);
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
