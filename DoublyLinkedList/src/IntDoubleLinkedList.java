//Julian Amrine

public class IntDoubleLinkedList {
	private class Node {
		private int data;
		private Node nextLink;
		private Node prevLink;

		public Node() {
			this.data = 0;
			this.nextLink = null;
			this.prevLink = null;
		}

		public Node(int aData, Node nxLink, Node prvLink) {
			setData(aData);
			setNextLink(nxLink);
			setPrevLink(prvLink);
		}

		public int getData() {
			return data;
		}

		public void setData(int aData) {
			this.data = aData;
		}

		public Node getNextLink() {
			return nextLink;
		}

		public void setNextLink(Node nextLink) {
			this.nextLink = nextLink;
		}

		public Node getPrevLink() {
			return prevLink;
		}

		public void setPrevLink(Node prevLink) {
			this.prevLink = prevLink;
		}

	}

	private Node head, current;

	public IntDoubleLinkedList() {
		this.head = null;
		this.current = head;
	}

	public void goToNext() {
		if (current != null) {
			current.prevLink = current;
			current = current.nextLink;
		} else if (head != null) {
			System.out
					.println("Iterated too many times or uninitialized iteration.");
			System.exit(0);
		} else {
			System.out.println("Iterating with an empty list.");
			System.exit(0);
		}
	}

	public void goToPrev() {
		if (current != null) {
			current.nextLink = current;
			current = current.prevLink;
		} else if (head != null) {
			System.out
					.println("Iterated too many times or uninitialized iteration.");
			System.exit(0);
		} else {
			System.out.println("Iterating with an empty list.");
			System.exit(0);
		}
	}

	public int getDataAtCurrent() {
		int result = 0;
		if (current != null) {
			result = current.data;
		} else {
			System.out.println("Null node. No data present");
		}
		return result;
	}

	public void setDataAtCurrent(int newData) {
		if (current != null) {
			current.data = newData;
		} else {
			System.out.println("Setting data when current is not at any node.");
			System.exit(0);
		}
	}

	// What is head pointing to?
	public void addANodeToStart(int aData) {
		head = new Node(aData, head, null);

		if ((current == head.nextLink) && (current != null)) {
			current.prevLink = head;
		}
	}

	public void insertNodeAfterCurrent(int newData) {
		Node newNode = new Node();
		newNode.data = newData;
		if (current != null) {
			newNode.prevLink = current; // links newNode to current node
			current.nextLink = newNode; // links current node to newNode
			current = current.nextLink; // moves current to newNode //wtf
		} else if (head != null) {
			System.out.println("Inserting when iterator is past all "
					+ "nodes or is not initialized.");
			System.exit(0);
		} else {
			System.out.println("Using insertNodeAfterCurrent with empty list.");
			System.exit(0);
		}
	}

	public void insert(int newData) {
		Node newNode = new Node();
		newNode.data = newData;
		if (head == null) {
			head = newNode;
			current = head;
			return;
		}
		
		current = head;
		current.prevLink = null;
		while (current != null) {
			current.prevLink = current;
			current = current.nextLink;
		}
		newNode.prevLink = current;
		current.nextLink = newNode;
		current = current.nextLink;
		
	}

	public void deleteCurrentNode() {
		if ((current != null) && (current.prevLink != null)) {
			current.prevLink = current.nextLink;
			current = current.nextLink;
		} else if ((current != null) && (current.prevLink == null)) {// At head
																		// node
			head = current.nextLink;
			current = head;
		} else {// current == null which could mean it deleted the last node or
				// at the end of the list
			reset();
		}
	}

	public void showList() {
		current = head;
		current.nextLink = head.nextLink;
		while (current != null) {
			System.out.println(current.data);
			current = current.nextLink;
		}
	}

	public void reset() {
		current = head;
		current.prevLink = null;
	}

	public boolean inList(int targetData) {
		return find(targetData) != null;
	}

	public Node find(int target) {
		boolean found = false;
		current = head;
		while ((current != null) && !found) {
			int dataAtPosition = current.data;
			if (dataAtPosition == target)
				found = true;
			else
				current = current.nextLink;
		}
		return current;
	}
	/*
	 * public void addANodeToStart(int aData) { head = new Node(aData, head,
	 * null); if((current==head.nextLink) && (current != null)) {
	 * 
	 * } }
	 */
}
