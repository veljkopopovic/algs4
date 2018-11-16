package veljko;

public interface UF {
  void reset(int numberOfElements);
  void union(int index1, int index2);
  boolean connected(int index1, int index2);
}
