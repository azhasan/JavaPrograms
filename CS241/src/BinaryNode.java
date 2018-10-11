
public class BinaryNode {
	
	private int data;
	private BinaryNode left;
	private BinaryNode right;

	
	public BinaryNode() { 
		this(0); // calls BinaryNode(T dataPortion)
	}
	
	
	public BinaryNode(int dataPortion) {
		this(dataPortion, null, null); //calls BinaryNode(T dataPortion, BinaryNode<T>, newleft...)
	}
	
	public BinaryNode(int dataPortion, BinaryNode newleft, BinaryNode newright) {
		data = dataPortion;
		left = newleft;
		right = newright;
		
	}
	
	public int getData() {
		return data;
	}
	
	public void setData(int newData) {
		data = newData;
	}
	
	public BinaryNode getLeft(){
		return left;
	}
	
	public BinaryNode getRight(){
		return right;
	}
	
	public void setLeftSub(BinaryNode newleft) {
		left = newleft;
	}
	
	public void setRightSub(BinaryNode newright) {
		right = newright;
	}
	
	public boolean hasleft() {
		return left != null;
	}
	
	public boolean hasright() {
		return right != null;
	}
	
	public boolean isLeaf() {
		return (left == null) && (right == null);
	}
	
	public int getNumberOfNodes() {
		int leftNumber = 0;
		int rightNumber = 0;
		
		if(left != null) 
			leftNumber = left.getNumberOfNodes();
		
		if(right != null) 
			rightNumber = right.getNumberOfNodes();
		
		return 1 + leftNumber + rightNumber;
	}
	
	public int getHeight() {
		return getHeight(this);
	}
	
	
	//public BinaryNode removeRightMost() {
		
	//}
	
	
	private int getHeight(BinaryNode node) {
		int height = 0;
		if(node!=null) 
			height = 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight())); 
		return height;
	}
	
	public BinaryNode copy() {
		
		BinaryNode newRoot = new BinaryNode(data);
		if(left != null)
			newRoot.setLeftSub(left.copy());
		
		if(right != null) 
			newRoot.setRightSub(right.copy());
		
		return newRoot;
		
	}
	
	
	
	
	
}
