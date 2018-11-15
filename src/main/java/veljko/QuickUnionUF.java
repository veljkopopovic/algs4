package veljko;

public class QuickUnionUF implements UF {
  private int[] elements;
  public QuickUnionUF(int numberOfElements) {
    elements = new int[numberOfElements];
    init();
  }

  private void init() {
    for (int i = 0; i < elements.length; i++) {
      elements[i] = i;
    }
  }

  public void union(int index1, int index2) {
    if (connected(index1, index2)) {
      return;
    }
    elements[findRoot(index2)] = findRoot(index1);
  }

  public boolean connected (int index1, int index2) {
    if (index1 == index2) {
      return true;
    }
    return findRoot(index1) == findRoot(index2);
  }

  private int findRoot(int index) {
    if (elements[index] == index) {
      return index;
    }

    int root = elements[index];
    while (elements[root] != root) {
      root = elements[root];
    }
    return root;
  }
}
