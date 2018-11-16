package veljko;

public class WeightedUnionUF extends QuickUnionUF{
  protected int[] size;

  @Override
  public void reset(int elementsCount) {
    size = new int[elementsCount];
    super.reset(elementsCount);
  }

  @Override
  protected void initializeElement(int i) {
    super.initializeElement(i);
    size[i] = 1;
  }

  @Override
  public void union(int index1, int index2) {
    int root1 = findRoot(index1);
    int root2 = findRoot(index2);

    int size1 = size[root1];
    int size2 = size[root2];

    if (size1 < size2) {
      super.union(index2, index1);
      int projected_size = 1+size1;
      size[root2] = Math.max(projected_size, size[root2]);
    } else {
      super.union(index1, index2);
      int projected_size = 1+size2;
      size[root1] = Math.max(projected_size, size[root1]);
    }
  }
}
