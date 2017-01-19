
public class ArrayHeapTester {

	public static void main(String[] args) {
		System.out.println("Populating");
		ArrayHeap aHeap = new ArrayHeap(10);
		//int[] list = {21,37,49,11,23,1,13,16,33,17};
		int[] list = {21, 27, 49, 11, 23, 1, 13, 16, 33, 17};
		for(int i = 0; i<list.length; i++)
		{
			System.out.println(list[i]);
			aHeap.insert(list[i]);
		}
		System.out.println("Printing array");
		aHeap.printHeap();
		System.out.println("Printing heap sort");
		aHeap.heapSort();
		System.out.println("deleting " + aHeap.peek());
		aHeap.remove();
		System.out.println("Printing new heap with " +aHeap.peek() + " at head");
		aHeap.printHeap();
		
		aHeap.remove();
		System.out.println("Printing new heap with " +aHeap.peek() + " at head");
		aHeap.printHeap();
	}
	

}
