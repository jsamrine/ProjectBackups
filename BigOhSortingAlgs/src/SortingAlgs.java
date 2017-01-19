//Julian Amrine
import java.util.*;

public class SortingAlgs {

	public static final int ARRAY_LENGTH = 1000;
	public static int[] array = new int[ARRAY_LENGTH], a1 = new int[ARRAY_LENGTH], a2 = new int[ARRAY_LENGTH],
			a3 = new int[ARRAY_LENGTH];
	public static Random RNG = new Random();
	public static int sTotCheck, bTotCheck, qTotCheck, mTotCheck, sIt, bIt, qIt, mIt;
	public static double bAvg, sAvg, qAvg, mAvg;

	public static void main(String[] args) {

		for (int j = 0; j < 20; j++) {
			// new arrays are initialized with 1000 randomly generated integers
			
			initialize();
			// print(array);

			
			System.out.println("Sorting using Selection Sort");
			sIt = selectionSort();
			print(a1);
			System.out.println("Sorting using bubble sort");
			bIt = bubbleSort();
			print(a2);
			System.out.println("Sorting using merge sort");
			mergeSort(a3);
			print(a3);
			System.out.println("Sorting using quick sort");
			qIt = quickSort(array, 0, array.length - 1);
			print(array);
			
			// increments total amount of iterations
			sTotCheck += sIt;
			bTotCheck += bIt;
			mTotCheck += mIt;
			qTotCheck += qIt;

			System.out.println("Selection sort iterations: " + sIt);
			System.out.println("Bubble sort iterations: " + bIt);
			System.out.println("Merge sort iterations: " + mIt);
			System.out.println("Quick sort iterations: " + qIt);
			// resets iterations
			sIt = 0;
			bIt = 0;
			mIt = 0;
			qIt = 0;
			System.out.println();
		}
		// calculates averages
		bAvg = bTotCheck / 20.0;
		sAvg = sTotCheck / 20.0;
		qAvg = qTotCheck / 20.0;
		mAvg = mTotCheck / 20.0;
		System.out.println(
				"The average number of checks for 20 Selection Sort, Bubble sort, merge sort, and quick sort iterations were:");

		System.out.println("Selection sort Iterations " + sAvg);
		System.out.println("Bubble sort Iterations " + bAvg);
		System.out.println("Merge sort Iterations " + mAvg);
		System.out.println("Quick sort Iterations " + qAvg);
	}

	// creates 4 "identical" arrays
	private static void initialize() {
		for (int i = 0; i < array.length; i++) {
			int value = RNG.nextInt(1000);
			array[i] = value;
			a1[i] = value;
			a2[i] = value;
			a3[i] = value;
		}
		// selection sort sorts array from least to greatest
	}

	// prints array
	private static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	private static int selectionSort() {
		for (int i = 0; i < a1.length - 1; i++) {
			// creates index at i
			int key = i;

			for (int j = i + 1; j < a1.length; j++) {
				// increments the selection sort iterations by one
				sIt++;
				// switches key index with j if a1 at j is less than the key
				// index
				if (a1[j] < a1[key]) {
					key = j;
				}
			}
			// if the key has been changed, a smaller value has been identified
			// and the values at index j and key are swapped
			if (key != i) {
				int tmp = a1[i];
				a1[i] = a1[key];
				a1[key] = tmp;
			}
		}
		return sIt;
	}

	private static int bubbleSort() {
		boolean swap = true;
		while (swap == true) {
			swap = false;

			for (int i = 0; i < a2.length - 1; i++) {
				// iterations increased by one
				bIt++;
				// checks if the value at index i is less than the value at the
				// next index
				if (a2[i] > a2[i + 1]) {
					int temp = a2[i];
					a2[i] = a2[i + 1];
					a2[i + 1] = temp;
					swap = true;
				}
			}
			// bIt++;
		}
		return bIt;
	}

	// recursively breakes an array into smaller arrays, then merges the arrays
	// together
	private static void mergeSort(int a[]) {
		int size = a.length;
		// increments merge sort iterations
		// mIt++;
		//
		if (size < 2) {
			return;
		}
		// creates midpoint
		int mid = size / 2;
		int leftSize = mid;
		int rightSize = size - mid;
		// creates left array with size thats half the length of the initial
		// array
		int[] left = new int[leftSize];
		// creates right array with size thats the difference between the size
		// and half the length of the initial array
		int[] right = new int[rightSize];
		// populates left array
		for (int i = 0; i < mid; i++) {
			left[i] = a[i];
		}
		// populates right array
		for (int i = mid; i < size; i++) {
			right[i - mid] = a[i];
		}
		// recursively breaks the left array into smaller arrays
		mergeSort(left);
		mergeSort(right);
		// once the arrays have been broken into the smallest array, the merge
		// process begins
		merge(left, right, a);
		// return mIt;
	}

	private static void merge(int[] left, int[] right, int[] a) {
		int leftSize = left.length;
		int rightSize = right.length;
		int i = 0, j = 0, k = 0;
		while (i < leftSize && j < rightSize) {
			//increments merge sort iterations
			mIt++;
			//checks for a value on the left array smaller than the value at the right array 
			if (left[i] <= right[j]) {
				//sets smaller value to index k of a
				a[k] = left[i];
				//increments left index by one
				i++;
			} else {
				//if a smaller value is found in the right array, that value is then assigned to array a
				a[k] = right[j];
				//incrememnts right index by one
				j++;
			}
			//index k of array a is incremented by 1
			k++;
		}
		//populates the array with the rest of values in left and right arrays
		while (i < leftSize) {
			a[k] = left[i];
			i++;
			k++;
		}
		while (j < rightSize) {
			a[k] = right[j];
			j++;
			k++;
		}

	}

	public static int quickSort(int[] a, int left, int right) {
		int index = partition(a, left, right);
		if (left < index - 1) {
			quickSort(a, left, index - 1);
		}
		if (index < right) {
			quickSort(a, index, right);
		}
		return qIt;
	}

	public static int partition(int[] a, int left, int right) {
		int i = left;
		int j = right;
		// pivot variable is equal to the value in the middle of the list bounds
		int pivot = a[(left + right) / 2];
		// loop runs while the indexes are left(i) and right(j) of the pivot
		// loop halts when i and j have switched passed the middle index
		while (i <= j) {
			// checks to make sure the value at index i is less than the pivot
			// value
			// loop is performed until a value on the left is greater than
			while (a[i] < pivot) {
				// if value at index i is less than the pivot, the left index is
				// moved up by one
				i++;
				qIt++;
			}
			// checks to make sure the the value at index i is greater than the
			// pivot value
			// Loop is performed until a value right of the pivot index is found
			// to be less than the pivot value
			while (a[j] > pivot) {
				j--;
				qIt++;
			}
			// checks again for an "out of bounds"
			// Not technically an out of bounds, but the i index should only
			// hold be an index less than the pivot index, and the opposite
			// should hold true for j

			if (i <= j) {
				// swaps value at index i and j
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				// index i and j are moved in
				i++;
				j--;
			}
		}
		// returns the index at which all previous numbers are less than the the
		// value at index i
		// The entire array is not sorted, but all the values on the left of the
		// list are less than the values on the right
		return i;
	}
}
