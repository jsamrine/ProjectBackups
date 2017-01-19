
public class CircularLinkedList <T>{
	private class Node{
		private T player;
		private Node link;
		//default constructor for Node
		public Node() {
			this.player = null;
			this.link = null;
		}
		//parameterized construct of Node
		public Node(T aPlayer, Node aLink) {
			setPlayer(aPlayer);
			setLink(aLink);
		}
		
		public T getPlayer() {
			return player;
		}

		public void setPlayer(T aPlayer) {
			this.player = aPlayer;
		}

		public Node getLink() {
			return link;
		}

		public void setLink(Node aLink) {
			this.link = aLink;
		}
	}
	private Node head, current;
	
	//creates an empty list
	public CircularLinkedList(){
		this.head = null;
		this.current = null;
		//this.tail = null;
	}
	
	//insert takes in data of type T
	public void insert(T aPlayer){
		//creates new node
		Node newNode = new Node();
		//sets the data of the node to input
		newNode.setPlayer(aPlayer);
		if (headIsEmpty()) //in case of uninitialized list
		{
			//A circular linked list always has the last node point to head, newNode links to the head
			newNode.setLink(head);
			//sets head to newNode
			head = newNode;
			current = head;
			//breaks out of methods
			return;
		}
		current = head;
		while(current.link!=head && current.link!=null)
		{
			goToNext(); 
		}
		//link of the node that current is a shallow copy of is set to link to the new node
		current.link = newNode;
		//newNode is always the last node in the list and thus points to head
		newNode.setLink(head);
		//current becomes a shallow copy of the newNode
		current = newNode;		
	}
	//checks to see if head is null, returns boolean true is the head is null, and false if not.
	public boolean headIsEmpty()
	{
		boolean empty;
		if(head==null)
		{
			return empty = true;
		} else
		{
			return empty = false;
		}
	}
	//current iterates to the next node in the list
	public void goToNext()
	{
		if(current != null)
		{
			//previous = current; 
			current = current.link;
		}
	}
	//prints each element of the list starting from the head
	public void showList()
	{
		current = head;
		while(current.link!=head){
			this.printInfoAtCurrent();
			this.goToNext();
		}
		//because the while loop does not print the tail data, this is used to do such a thing
		this.printInfoAtCurrent();
	}
	//prints data from the current node
	public void printInfoAtCurrent()
	{
		System.out.println(getInfoAtCurrent().toString());
	}
	//returns data of type T at current node
	public T getInfoAtCurrent()
	{
		T result = null;
		if(current != null)
		{
			result = current.player;
		}
		else
		{
			System.out.println("No data present");
		}
		return result;
	}
	
	//this method is not used for 
	public void deleteNodeAfterCurrent()
	{
		current.link = current.link.link;
	}
	
	public void reset()
	{
		this.current=head;
	}
	
}
