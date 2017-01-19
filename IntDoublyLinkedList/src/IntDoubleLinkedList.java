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

		public void setData(int aData) {
			this.data = aData;
		}

		public void setNextLink(Node nextLink) {
			this.nextLink = nextLink;
		}

		public void setPrevLink(Node prevLink) {
			this.prevLink = prevLink;
		}

	}
	private Node head, current;
	private int N; //elements in list
	public boolean isEmpty() { return N==0; }
	public int size() { return N; }
	
	public IntDoubleLinkedList() {
		this.head = null;
		this.current = head;
	}
	// What is head pointing to?

	public void insert(int newData) {
		Node newNode = new Node();
		newNode.data = newData;
		if (head == null) {
			head = newNode;			
			return;
		}
		Node previous = current;
		current = head;
		while (current.nextLink != null) { //while current has data
			previous = current; //saves a copy of current
			current = current.nextLink; //current node is set to the nextLink
			current.prevLink = previous; //current node's previous location at new location points to the old node 
			previous.nextLink = current; //previous next link points to current
		}
		current.nextLink = newNode; // by this point, the node after current node is null but is now given the values of newNode
		newNode.prevLink = current; //newNode's previous link points to current node 
		current = newNode; //current is now at newNode
		
		N++;
	}
	/*
	 * current.nextLink.prevLink = current
	 * current.nextLink = 
	 */
	
	public void insertNodeAfterCurrent(int newData) {
		Node newNode = new Node();
		//Node previous = current;
		//Node next = current.nextLink;
		newNode.data = newData;
		/*if (head == null) {
			head = newNode;			
			return;
		}
		*/
		//current = head;
		if (current!= null) {
			newNode.nextLink = current.nextLink;
			current.nextLink = newNode;
			newNode.prevLink = current;
			current = current.nextLink;
			
			/*
			 * newNode.nextLink = next; // links current node to newNode
			 
				newNode.prevLink = previous; // moves current to newNode //wtf
				previous.nextLink = newNode;
				next.prevLink = newNode;
				current = newNode; // links newNode to current node
			 */
		} else if (head != null) {
			System.out.println("Inserting when iterator is past all "
					+ "nodes or is not initialized.");
			System.exit(0);
		} else {
			System.out.println("Using insertNodeAfterCurrent with empty list.");
			System.exit(0);
		}
	}
	
	public void deleteCurrentNode() {
		if ((current != null) && (current.prevLink != null)) {
			current.prevLink.nextLink = current.nextLink;
			current.nextLink.prevLink = current.prevLink;
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

	public void goToNext() {
		Node previous = current;
		if (current != null) {//checks for activated current node
			previous = current; //saves a copy of current
			current = current.nextLink; //current node is set to the nextLink
			current.prevLink = previous; //current node's previous location at new location points to the old node 
			previous.nextLink = current; //previous next link points to current
		} else if (head != null) {
			System.out.println("Iterated too many times or uninitialized iteration.");
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
	
	public void goToPrev() {
		if (current != null) {
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
	
	
	public void showList() {
		current = head;
		current.nextLink = head.nextLink;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.nextLink;
		}
		reset();
	}

	public void reset() {
		current = head;
		current.prevLink = null;
	}

	public boolean inList(int target) { return find(target) != null; }

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
	 */
	public static void main(String[] args) {
		IntDoubleLinkedList list = new IntDoubleLinkedList();
		
		for(int i=0;i<10;i++)
		{
			list.insert(i);
			//list.insert(i);
			//System.out.println(list.getDataAtCurrent());
		}
		
		list.showList();
		list.reset();
		System.out.println();
		
		for(int i=0;i<4;i++)
		{
			list.goToNext();
		}
		
		list.insertNodeAfterCurrent(22);
		list.showList();
		System.out.println();
		
		list.reset();
		
		for(int i=0;i<6;i++)
		{
			list.goToNext();
		}
		list.deleteCurrentNode();
		list.showList();
		
		for(int i=0;i<2;i++)
		{
			list.goToNext();
		}
		
		list.setDataAtCurrent(133);
		list.showList();
		list.reset();
		
		for(int i=0;i<6;i++)
		{
			list.goToNext();
		}
		list.goToPrev();
		System.out.println("Data at 6:" + list.getDataAtCurrent());
		list.goToPrev();
		System.out.println("Data at 5:" + list.getDataAtCurrent());
		list.showList();
		if(list.inList(133)) System.out.println("Found");
		/**/
		
	}
}