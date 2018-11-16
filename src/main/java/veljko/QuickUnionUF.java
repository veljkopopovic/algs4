package veljko;

public class QuickUnionUF implements UF {
  protected int[] elements;

  @Override
  public void reset(int numberOfElements) {
    elements = new int[numberOfElements];
    for (int i = 0; i < elements.length; i++) {
      initializeElement(i);
    }
  }

  protected void initializeElement(int i) {
    elements[i] = i;

  }

  @Override
  public void union(int index1, int index2) {
    if (connected(index1, index2)) {
      return;
    }
    elements[findRoot(index2)] = findRoot(index1);
  }

  @Override
  public boolean connected (int index1, int index2) {
    if (index1 == index2) {
      return true;
    }
    return findRoot(index1) == findRoot(index2);
  }

  protected int findRoot(int index) {
    if (elements[index] == index) {
      return index;
    }

    int root = elements[index];
    while (elements[root] != root) {
      elements[root] = elements[elements[root]]; //path compression
      root = elements[root];
    }
    return root;
  }
}
