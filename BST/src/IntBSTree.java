public class IntBSTree {
	private class Node {
		private int data;
		private Node leftChild;
		private Node rightChild;

		public Node(int aData) {
			this.data = aData;
			this.leftChild = null;
			this.rightChild = null;
		}
	}
	private Node root;

	public IntBSTree() {
		root = null;
	}

	public void insert(int data) {
		Node newNode = new Node(data);
		//checks if the tree is empty
		if (root == null) {
			root = newNode;
		} else {
			//calls helper method
			insert(root, data);
		}
	}

	public Node insert(Node aNode, int data) {
		if (aNode == null) {
			Node newNode = new Node(data);
			aNode = newNode;
		//if data is less than the data at the current node, the recursive call is made with the left child
		} else if (data  < aNode.data) {
			aNode.leftChild = insert(aNode.leftChild, data);
		//if data is greater than the data at the current node, the recursive call is made on the right child
		} else if (data >= aNode.data) {
			aNode.rightChild = insert(aNode.rightChild, data);
		}
		return aNode;
	}

	public void printInorder() {
		if (root != null) {
			printHelper(root);
		}
	}

	public void printHelper(Node aNode) {
		//recursively iterates through tree until a null left child is found
		if (aNode.leftChild != null) {
			printHelper(aNode.leftChild);
		}
		//data is printed out at that node
		/*
		 * At this point, the smallest possible value has been found,
		 */
		System.out.println(aNode.data);
		//recursively iterates through tree until a null left child is found
		if (aNode.rightChild != null) {
			printHelper(aNode.rightChild);
		}
		
	}

	public int getDepth(int value) {
		return findDepth(root, value, 0);
	}

	public int findDepth(Node aNode, int value, int depth) {
		//if the node cannot be found, -1 is returned 
		if (aNode == null) {
			return -1;
		}
		//if the value is found, returns the depth count
		if(aNode.data == value)
		{
			return depth;
		}
		//if value is less than the data at the current node, the recursive call is made on the left child
		if (value < aNode.data) {
			depth++;
			return findDepth(aNode.leftChild, value, depth);
		} 
		//if statement not included, only time this branch is reach is if the value is greater than the data at the current node
		//a recursive call is then made on the right child
		else 
		{
			depth++;
			return findDepth(aNode.rightChild, value, depth);
		}

	}

}
