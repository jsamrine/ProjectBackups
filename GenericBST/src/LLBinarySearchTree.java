
public class LLBinarySearchTree<T extends Comparable<T>> {
	private class Node {
		private T data;
		private Node leftChild;
		private Node rightChild;

		public Node(T aData) {
			this.data = aData;
			this.leftChild = null;
			this.rightChild = null;
		}
	}

	private Node root;

	public LLBinarySearchTree() {
		root = null;
	}

	public void insert(T data) {
		Node newNode = new Node(data);
		// checks if the tree is empty
		if (root == null) {
			root = newNode;
		} else {
			// calls helper method
			insert(root, data);
		}
	}

	public Node insert(Node aNode, T data) {
		if (aNode == null) {
			Node newNode = new Node(data);
			aNode = newNode;
			// if data is less than the data at the current node, the recursive
			// call is made with the left child
		} else if (data.compareTo(aNode.data) < 0) {
			aNode.leftChild = insert(aNode.leftChild, data);
			// if data is greater than the data at the current node, the
			// recursive call is made on the right child
		} else if (data.compareTo(aNode.data) >= 0) {
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
		// recurs through tree until a null left child is found
		if (aNode.leftChild != null) {
			printHelper(aNode.leftChild);
		}
		// data is printed out at that node
		/*
		 * At this point, the smallest possible value has been found,
		 */
		System.out.println(aNode.data.toString());
		// recursively iterates through tree until a null left child is found
		if (aNode.rightChild != null) {
			printHelper(aNode.rightChild);
		}

	}

	public int getDepth(T value) {
		return findDepth(root, value, 0);
	}

	public int findDepth(Node aNode, T value, int depth) {
		// if the node cannot be found, -1 is returned
		if (aNode == null) {
			return -1;
		}
		// if the value is found, returns the depth count
		if (aNode.data == value) {
			return depth;
		}
		// if value is less than the data at the current node, the recursive
		// call is made on the left child
		if (value.compareTo(aNode.data) < 0) {
			depth++;
			return findDepth(aNode.leftChild, value, depth);
		}
		// if statement not included, only time this branch is reach is if the
		// value is greater than the data at the current node
		// a recursive call is then made on the right child
		else {
			depth++;
			return findDepth(aNode.rightChild, value, depth);
		}

	}

	public T find(T data) {
		return find(root, data);
	}

	// iterates through children using the basics of a BST to find the specified value
	public T find(Node aNode, T data) {
		if (data.compareTo(aNode.data) < 0) // go left
		{
			find(aNode.leftChild, data);
		} else if (data.compareTo(aNode.data) > 0) // go right
		{
			find(aNode.rightChild, data);
		}
		if (aNode == null) {
			return null;
		}
		return aNode.data;
	}

	public T findMax() {
		return findMax(root);

	}

	// finds max by iterating through right children until a null right child is
	// found
	public T findMax(Node aNode) {
		if (aNode.rightChild == null) {
			return aNode.data;
		} else {
			return findMax(aNode.rightChild);
		}
	}

	public T findMin() {
		return findMax(root);
	}

	// finds min by iterating through left children
	public T findMin(Node aNode) {
		if (aNode.leftChild == null) {
			return aNode.data;
		} else {
			return findMin(aNode.leftChild);
		}
	}

	public void delete(T data) {
		delete(data, root);
	}

	public Node delete(T data, Node aNode) {
		if (aNode != null) {
			if (data.compareTo(aNode.data) < 0) {
				aNode.leftChild = delete(data, aNode.leftChild);// recurs left or right until the value has been found
			} else if (data.compareTo(aNode.data) > 0) {
				aNode.rightChild = delete(data, aNode.rightChild);// go right
			} else { //value has been found
				//note: I wasn't sure about the actual implementation code of deletion
				//so this code is a conglomeration of various searches from online
				if (aNode.leftChild == null) // node has one or no children
				{
					// if left child is null
					return aNode.rightChild;
				}
				else if(aNode.rightChild == null) {
					return aNode.leftChild;
				}
				if (aNode.leftChild != null && aNode.rightChild != null) // node has two children
				{
					//finds the minimum value in the right tree to replace the node
					aNode.data = findMin(aNode.rightChild);
					//deletes the swapped node
					aNode.rightChild = delete(aNode.data, aNode.rightChild);
				}

			}

		}
		return aNode;
	}

	public void deleteValuesGreaterThan(T value) {
		//While a value in the tree is larger than the specified value, the value is deleted
		while (this.findMax().compareTo(value) > 0) {
			delete(this.findMax(), root);
		}
	}

	public void printPreOrder() {
		this.printPreOrder(root);
	}

	// prints data by printing data at the node, first printing all data withing
	// the left subtrees, then printing all the data in the right subtrees
	public void printPreOrder(Node aNode) {
		if (aNode != null) {
			//prints data at current node
			System.out.println(aNode.data.toString());
			//then goes to through left children printing data until a null left child is found
			printPreOrder(aNode.leftChild);
			//repeated for right children, alternating between printing data and recurring through children
			printPreOrder(aNode.rightChild);
		}
	}

	public void printPostOrder() {
		this.printPostOrder(root);
	}

	// prints data by printing all the leaves, then working up to the parents
	public void printPostOrder(Node aNode) {
		if (aNode != null) {
			printPostOrder(aNode.leftChild);
			printPostOrder(aNode.rightChild);
			//data printed only once rightchildren on the left subtree are found
			System.out.println(aNode.data.toString());
		}
	}
}
