public class GenStack <T>{
	private class Node{
		private T data;
		private Node link;
		//default constructor for Node
		public Node() {
			this.data = null;
			this.link = null;
		}
	}
	private Node head, previous, current;
	//N will keep track of the list length, adding one for a push call, or substracting one for a pop call
	private int N = 0;
	
	//creates an empty stack
	public GenStack(){
		this.head = null;
		this.current = null;
	}
	//push first inserts data before the head, so the last piece of information entered is the first in the list
	public void push(T aData)
	{
		Node newNode = new Node();
		newNode.data = aData;
		newNode.link = head;
		head = newNode;
		N++;
	}
	//pop returns data at the head, and then moves the head to the node the link was pointing to
	public T pop()
	{
		T result = null;
		if(head!=null){
			result = head.data;
			head = head.link;
			N--;
			return result;			
		}
		else
		{
			return null;
		}
	}
	
	//Prints out each value in the stack in the way that it would be popped,
	//this was used for error checking on the stack
	public void printStack()
	{
		current = head;
		while(current!=null)
		{
			System.out.println(current.data);
			current = current.link;
		}
	}
	
	public int length()
	{
		return N;
	}
}
