public class GenLLQueue<T> {
	private class Node {
		private T data;
		private Node link;
		//creates node class
		public Node() {
			this.data = null;
			this.link = null;
		}
	}

	private Node head, tail;
	//creates empty list
	public GenLLQueue() {
		head = null;
		tail = null;
	}

	public void enqueue(T aData) {
		Node newNode = new Node();
		newNode.data = aData; //sets data of new node with parameterized T input
		if (head == null) {
			head = tail = newNode; //both head and tail are shallow copies of NewNode
			return;
		}
		tail.link = newNode; //takes the link of the previous node and sets it to the newNode
		tail = tail.link; //new node becomes link
	}

	public T dequeue() {
		if (head == null) { //only way to trigger is if list is uninitialized
			System.out.println("List Empty");
			return null;
		}
		T retData = head.data; //returns data at head
		head = head.link; //Next item in list becomes head
		return retData;
	}

	public T peek() {
		T retData = head.data;
		return retData; //returns data at head of list
	} 
	
	public void showQueue() 
	 {
		 Node current = head; //creates local variable current which iterates through the list
		 while(current.link != null)
		 {
			 System.out.println(current.data);
			 current = current.link;
		}
		System.out.println(tail.data);//prints last value of queue, while loop does not print tail data
	 }
}