//specifies operations common to all trees
public interface TreeInterface<T> {
	
	public T getRootData();
	public int getHeight();
	public int getNumberOfNodes();
	public boolean isEmpty();
	public void clear();

}