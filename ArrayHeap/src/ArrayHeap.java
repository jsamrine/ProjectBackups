
public class ArrayHeap<T extends Comparable<T>> {
	private T[] heap;
	private int size;

	public ArrayHeap(int size) {
		heap = (T[]) (new Comparable[size]);
		this.size = 0;
	}

	public void insert(T value) {
		if (size >= heap.length) {
			System.out.println("Full");
			return;
		}
		//adds element to first available space
		this.heap[size] = value;
		bubbleUp();
		size++;
	}
	
	//bubble up checks to make sure the heap is balanced, always placing the smallest value at the head. 
	private void bubbleUp() {
		int index = this.size;
		while (index > 0) {
			//starting at the last index, the method cycles through parent indices
			int parentIndex = (index - 1) / 2;
			if (parentIndex >= 0 && heap[index].compareTo(heap[parentIndex]) < 0) { //method swaps if a smaller value has been found
				T temp = heap[index];
				heap[index] = heap[parentIndex];
				heap[parentIndex] = temp;
			//} else {
				//break;
			}
			index = parentIndex;

		}
	}
	//returns the minimum value in the heap
	public T peek() {
		if (heap[0] == null) {
			//System.out.println("filled");
			return null;
		}
		return heap[0];
	}
	//removes the value at index 0
	public T remove() {
		T retVal = peek();
		heap[0] = heap[size - 1];
		heap[size - 1] = null;
		size--;
		//bubble down checks to make sure the smallest value in the heap is at index 0
		bubbleDown();
		return retVal;

	}
	//bubble down finds the minimum value and places it at the root
	private void bubbleDown() {
		int index = 0;
		while (index * 2 + 1 < size) {
			int bigIndex = index * 2 + 1;
			if (index * 2 + 2 < size && heap[index * 2 + 2].compareTo(heap[bigIndex]) < 0) {
				bigIndex = index * 2 + 2;
			}
			if(heap[index].compareTo(heap[bigIndex])>0)
			{
				T temp = heap[index];
				heap[index] = heap[bigIndex];
				heap[bigIndex] = temp;
			}
			//else { break; }
			index = bigIndex;
		}

	}
	//prints each element in the array in breadth order
	public void printHeap()
	{
		for(T data : heap)
		{
			if(data ==null){	break;	}
			System.out.println(data.toString());
		}
	}
	
	public void heapSort(){
		//creates new heap and cloned heap
		ArrayHeap tempHeap = new ArrayHeap(heap.length);
		
		T[] cloneHeap = heap.clone(); //clone heap is a copy of the heap
		//inserts each element to temp heap
		for(int i = 0; i<size; i++)
		{
			tempHeap.insert(cloneHeap[i]);
		}
		//removal always reorders the heap after the root is removed, so heap sort will print the data in ascending order 
		for(int i = size; i>0; i--)
		{
			System.out.print(tempHeap.remove().toString()+" ");
		}
		System.out.println();
	}

	
}
