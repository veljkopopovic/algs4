package veljko;

public class QuickFind {
  private final int[] elements;

  public QuickFind (int numberOfElements) {
    elements = new int[numberOfElements];
    this.init();
  }

  private void init(){
    for (int i = 0; i < this.elements.length; i++) {
      elements[i] = i;
    }
  }

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

  public boolean connected(int index1, int index2) {
    return elements[index1] == elements[index2];
  }
}
