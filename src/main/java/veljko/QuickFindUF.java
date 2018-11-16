package veljko;

public class QuickFindUF implements UF {
  private int[] elements;

  @Override
  public void reset(int numberOfElements){
    elements = new int[numberOfElements];
    for (int i = 0; i < numberOfElements; i++) {
      elements[i] = i;
    }
  }

  @Override
  public void union(int index1, int index2) {
    if (connected(index1, index2)) {
      //if elements already connected, nothing to be done
      return;
    }
    int leftval = elements[index1];
    int rightval = elements[index2];
    elements[index2] = leftval;

    for (int i = 0; i < elements.length; i++) {
      if (elements[i] == rightval) {
        elements[i] = leftval;
      }
    }
  }

  @Override
  public boolean connected(int index1, int index2) {
    return elements[index1] == elements[index2];
  }
}
