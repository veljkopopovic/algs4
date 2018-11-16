package veljko;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeightedUnionUFTest {
  private class WeightedUnion extends WeightedUnionUF{
    public int getSize(int index){
      return size[index];
    }

    public int exposeRoot(int index) {
      return findRoot(index);
    }

    public int exposeLink(int index){
      return elements[index];
    }
  }

  private WeightedUnion wu = new WeightedUnion();

  @BeforeEach
  public void reset(){
    wu.reset(UFTest.ElementsCount);
  }

  @Test
  public void initialWeightShouldBeZeri() {
    for (int i = 0; i < UFTest.ElementsCount; i++) {
      assertEquals(1,wu.getSize(i));
    }
  }

  @Test
  public void testAddingSimpleNode(){
    wu.union(0,1);
    assertEquals(2, wu.getSize(0));
    assertEquals(1,wu.getSize(1));
  }

  @Test
  public void testIfTreeNotDisperzed(){
    wu.union(0,1);
    wu.union(0,2);
    wu.union(0,3);
    assertEquals(2, wu.getSize(0));
    wu.union(3,4);
    assertEquals(2, wu.getSize(0));
  }

  @Test
  public void testComplexTreeAssignment(){
    wu.union(4,3);
    assertEquals(2, wu.getSize(4));
    wu.union(3,8);
    assertEquals(2, wu.getSize(4));
    assertEquals(4, wu.exposeLink(8));
    wu.union(6,5);
    wu.union(9,4);
    wu.union(2,1);
    wu.union(5,0);
    assertEquals(6,wu.exposeLink(0));
    wu.union(7,2);
    assertEquals(2, wu.exposeLink(7));
    wu.union(6,1);
    assertEquals(6, wu.exposeLink(2));
    assertEquals(3, wu.getSize(6));
    wu.union(7,3);
    assertEquals(6, wu.exposeLink(4));
  }
}

