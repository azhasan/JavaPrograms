public class BinaryTree {
	
	private BinaryNode root;
	
	public BinaryTree() {
		root = null;
	}
	
	public BinaryTree(int rootData) {
		root = new BinaryNode(rootData);
	}
	
	/*  this method returns true or false depending on whether the node is empty or not. 	 */
	public boolean isEmpty() {
		return root == null;
	} 
	
	
	/** this method calls upon the private addEntry method, for usage in the main class. 
	 * @param newEntry - is the data inputed into the add method to add into the tree. */
	public BinaryNode add(int newEntry) {
		 if(root == null) {
	     		root = new BinaryNode(newEntry);
	     		return root;
		 	}    
		return addEntry(root, newEntry);  
	}
	
	
	/** this private method adds the data to the node. follows BST rules where if data is less than the node data,
	 * it's sent to the left subtree. otherwise if it's greater it's sent to the right subtree. both cases are
	 * recursively called as required.
	 * @param node - starts at the root, compares the newEntry and as a result the data is sent to either
	 *               left or right subtree and added.
	 * @param newEntry - the data user wants to add to the tree. 
	 * @return node - returns the address where the new data value is added*/
	private BinaryNode addEntry(BinaryNode node, int newEntry) {
			
		if(newEntry == node.getData()){
			node = null;
			return node;
		}
		
		else if(newEntry < node.getData()){
			if(node.hasleft())
			    return addEntry(node.getLeft(), newEntry);
			else {
				node.setLeftSub(new BinaryNode(newEntry));
				return node; 
			}		
		} 
		
		else {
			if(node.hasright())
				return addEntry(node.getRight(), newEntry);
			else {
				node.setRightSub(new BinaryNode(newEntry));
				return node;
			}
		}
	}
	
	
	/** this method is the public method of the removeEntry, to call upon the private removeEntry in the main 
	 * method.
	 * @param entry - the desired data to remove.*/
	public BinaryNode remove(int entry) {
		
	     return removeEntry(root, entry);
	}
	
	
	/** this method is the private remove, where the removing is done. compares the node to various cases and does
	 * the removing required for each case. has 4 different cases: node is a leaf, node has only a left child,
	 * node has only a right child, and node has two children
	 * @param node - the node passed in from the public method, starting at the root and used for comparing
	 *               the entry passed in.
	 * @param entry - the data desired to remove from the tree. */
	private BinaryNode removeEntry(BinaryNode node, int entry)	{
		
		if(node == null)
			return node;
		else if(entry < node.getData())
			node.setLeftSub(removeEntry(node.getLeft(), entry));
		else if(entry > node.getData())
			node.setRightSub(removeEntry(node.getRight(), entry));
		else {
			//case 1: is a leaf
			if(node.getLeft() == null && node.getRight() == null) {
				node = null;
			}
			
			//case 2: has only right child
			else if(node.getLeft() == null && node.getRight()!= null) {
				BinaryNode temp = node;
				node = node.getRight();
				temp = null;
			
			}
			//case 3: has only left child
			else if(node.getRight() == null && node.getLeft() != null) {
				BinaryNode temp = node;
				node = node.getLeft();
				temp = null;
			}
			
			//case 4: has two children
			else {
				BinaryNode temp = leftMostRight(node.getRight());
				node.setData(temp.getData());
				node.setRightSub(removeEntry(node.getRight(), temp.getData()));
			}
		}
		
		return node;		
	} 
	
	/** public method for calling the private findParent method. 
	 * @param entry - is the data user wants to find the parent of.*/
	public BinaryNode findParent(int entry) {
		return findParent(root, entry);
	}
	
	
	
	/** private method that find the parent of the desired entry.
	 * @param node - node originally starting from root, compares with entry to find parent
	 * @param entry - is the desired data value the user wants the parent of.
	 * @return node - returns location of the parent*/
	private BinaryNode findParent(BinaryNode node, int entry) {
		if(entry == node.getData())
			return null; // this is the root
		else {
			if(node.getLeft()!=null && entry == node.getLeft().getData() || node.getRight() != null && entry == node.getRight().getData()) {
				return node;
			}
			else {
				if(entry < node.getData())
					return findParent(node.getLeft(), entry);
				else {
					if(entry > node.getData()) {
						return findParent(node.getRight(), entry);
					}
				}
			}
		}
		return node;	
			
		}
	
	/** public method for calling the private method findEntry for the main class
	 * @param entry - desired data value you want to find in the tree. 
	 * @return root - returns the node that has the entry*/
	public BinaryNode getEntry(int entry) {
		  root = findEntry(root, entry);
		  return root;
	}
	
	
	/** private method findEntry that finds the entry within the BST. 
	 * @param node - starts from the root, traverses down recursively to find the entry
	 * @param entry - desired data value the user wants to locate in the tree.
	 * @return node - returns the location of the entry as a node*/
	private BinaryNode findEntry(BinaryNode node, int entry) {
		if(node != null) {
			if(entry == node.getData())
				return node;
			else if(entry < node.getData())
				return findEntry(node.getLeft(), entry);
			else if(entry > node.getData())
			 return findEntry(node.getRight(), entry);	
		}
		return node; 
		
	}
	
	
	/** public method that finds the leftmost node in the right subtree. aka min value
	 * @param node - used to find the subsequent min value.
	 * @return node - the address of the smallest node value. */
	public BinaryNode leftMostRight(BinaryNode node) {
		if(node == null)
			return null; 
		while(node.getLeft() != null)
			node = node.getLeft();
		return node;
	}
	
	
	/** public method that finds the rightmost node in the left subtree. aka max value
	 * @param node - used to find the subsequent max value.
	 * @return node - the address of the largest node value. */
	public BinaryNode rightMostLeft(BinaryNode node) {
		if(node.getRight() == null) {
			return node;
		}
		else
			return rightMostLeft(node.getRight());
	}

	/** public method calling the private getSuccessor method in the main class.
	 * @param entry - desired successor of this entry data value
	 * @return node - returns location of the address of the node that is successor of entry*/
	public BinaryNode getSuccessor(int entry) {
		root = getSuccessor(root, entry);
		return root;
	}
	
	
	/**private method that locates successor. successor is the leftmost right in
	 * the right subtree.
	 * @param node - used to find the subsequent min value.
	 * @return node - the address of the smallest node value. */
	private BinaryNode getSuccessor(BinaryNode node, int entry) {
		
		BinaryNode current = getEntry(entry);
		if(current == null) //if this node has nothing, return nothing. 
			return null; 
		if(current.getRight()!=null) //node has a right subtree. 
			return leftMostRight(current.getRight()); //returns the leftmost node in the right subtree
		
		else { //node has no right subtree. we need to find deepest node that is a left node
			BinaryNode succ = null; 
			BinaryNode parent = node;
			while(parent != current) { //traverse tree as long as the parent doesn't equal the current node
				if(current.getData() < parent.getData()) {
					succ = parent;
					parent = parent.getLeft();
				}
				else //else if current node is in the right subtree, we move right.
					parent = parent.getRight();
			}
			
			return succ; //either be null or have a node
			
		}
		
	}
	
	
	
	
	/**private method that locates predecessor. predecessor is the rightmost left in
	 * the left subtree.
	 * @param entry - desired data value user wants to find the predecessor of
	 * @return root - the address of the smallest node value. */   
	public BinaryNode getPredecessor(int entry) {
		root = getPredecessor(root, entry);
		return root;
	}
	
	
	
	/**private method that locates successor. successor is the leftmost right in
	 * the right subtree.
	 * @param entry - desired value user wants the predecessor of
	 * @return node - returns location of the address of the node that is predecessor of entry */
	private BinaryNode getPredecessor(BinaryNode node, int entry) {
		BinaryNode current = getEntry(entry);
		if(current == null)
			return null;
		if(current.getLeft()!=null)
			return rightMostLeft(current.getRight());
		else {
			BinaryNode succ = null;
			BinaryNode parent = node;
			while(parent != current) {
				if(current.getData() > parent.getData()) {
					succ = parent;
					parent = parent.getRight();
				}
				else
					parent = parent.getLeft();
			}
			
			return succ;
			
		}
		
	}
	

	/** method calls private print method */
	public void inorderTraverse() {
		inorderTraverse(root);
	}
	
	/** method prints out the inorder traversal method
	 * @param node - traverses with this node (orginally the root)*/
	private void inorderTraverse(BinaryNode node) {
		if(node != null)
		{
			inorderTraverse(node.getLeft());
			System.out.print(node.getData() + " "); 
			inorderTraverse(node.getRight());
		}
		
	}
	
	
	/** method calls private print method */
	public void preorderTraverse() {
		preorderTraverse(root);
	}
	
	
	
	/** method prints out the pre order traversal method
	 * @param node - traverses with this node (orginally the root)*/
	private void preorderTraverse(BinaryNode node) {
		if(node != null) 
		{
			System.out.print(node.getData()+ " ");
			preorderTraverse(node.getLeft());
			preorderTraverse(node.getRight());
		}
	}
	
	
	
	/** method calls private print method */
	public void postOrderTraverse() {
		postOrderTraverse(root);
	}
	
	
	
	/** method prints out the postorder traversal method
	 * @param node - traverses with this node (orginally the root)*/
	private void postOrderTraverse(BinaryNode node) {
		
		if(node != null)
		{
			postOrderTraverse(node.getLeft());
			postOrderTraverse(node.getRight());
			System.out.print(node.getData() + " ");
		}

	}
}