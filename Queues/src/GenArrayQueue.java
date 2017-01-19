
public class GenArrayQueue <T>{
	public static final int DEFAULT_SIZE = 100;
	private T[] queue; //generic array
	//default constructor
	public GenArrayQueue()
	{
		queue = (T[]) new Object[DEFAULT_SIZE];
		tailIndex = 0;
	}
	//creates a queue with parameterized size
	public GenArrayQueue(int size)
	{
		queue = (T[]) new Object[size];
		tailIndex = 0;
	}
	
	//tail index stores the index of the first null value of the list
	private int tailIndex;
	
	public void enqueue(T data)
	{
		if(tailIndex == queue.length)
		{
			System.out.println("Queue full");
			return;
		}
		queue[tailIndex]=data; //inputs data to tail index
		tailIndex++; //tail index is moved over by one
	}
	
	public T dequeue() 
	{
		T retData = queue[0]; // first object in the list is always the first object to be queued
		for(int i = 0; i<queue.length - 1; i++)
		{
			queue[i] = queue[i+1]; //moves each queue value over by one
		}
		queue[queue.length - 1] = null;
		tailIndex--; // tail index is moved over by one
		return retData;
	}
	
	public T peek() {return queue[0];}
	
	public void showQueue(){
		for (T node:queue)
		{
			if(node==null)
			{
				break;
			}
			System.out.println(node.toString());
		}
	}	
}
