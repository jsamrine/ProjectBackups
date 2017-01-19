
public class ArrayBSTree<T extends Comparable<T>> {
	private T[] dataArr;
	private static final int ARR_SIZE = 100;

	public ArrayBSTree() {
		dataArr = (T[]) (new Comparable[ARR_SIZE]);
	}

	public ArrayBSTree(int size) {
		if (size <= 0)
			return;
		dataArr = (T[]) (new Comparable[ARR_SIZE]);

	}

	public void insert(T data) {
		if (dataArr[0] == null) {
			dataArr[0] = data;
		} else {
			insert(0, data);
		}

	}

	public void insert(int index, T data) {
		if (dataArr[index] == null) {
			dataArr[index] = data;
		} else if (data.compareTo(dataArr[index]) < 0) // go left
		{
			if (index * 2 + 1 < dataArr.length)
				insert(index * 2 + 1, data);

		} else if (data.compareTo(dataArr[index]) >= 0) // go right
		{
			if (index * 2 + 1 < dataArr.length)
				insert(index * 2 + 2, data);
		}
	}

	public boolean recursiveSearch(T data) {
		return recursiveSearch(0, data);
	}

	public boolean recursiveSearch(int index, T data) {
		if (index >= dataArr.length || dataArr[index] == null) {
			return false;
		}
		if (dataArr[index].compareTo(data) == 0) {
			return true;
		} else if (data.compareTo(dataArr[index]) < 0) // go left
		{
			return recursiveSearch(index * 2 + 1, data);
		} else // if(data.compareTo(dataArr[index])>0) GO RIGHT
		{
			return recursiveSearch(index * 2 + 2, data);
		}
	}

	public void printInOrder() {
		if (dataArr[0] != null) {
			printIOHelper(0);
		}
	}

	private void printIOHelper(int index) {
		if (dataArr[index * 2 + 1] != null) {
			printIOHelper(index * 2 + 1);
		}
		System.out.println(dataArr[index]);
		if (dataArr[index * 2 + 2] != null) {
			printIOHelper(index * 2 + 2);
		}

	}

	public void printBreadthOrder() {
		for (T val : dataArr)
			if (val != null) {
				System.out.println(val.toString());
			} else {
				//System.out.println("Null");
			}
	}

	public int getDepth(T value) {
		return getDepth(0, value, 0);
	}

	private int getDepth(int index, T value, int depth) {
		if (dataArr[index] == null) {
			return -1;
		}
		if (dataArr[index] == value) {
			return depth;
		}

		if (value.compareTo(dataArr[index]) < 0) {
			depth++;
			return getDepth(index * 2 + 1, value, depth);
		} else // if(value.compareTo(dataArr[index])>=0)
		{
			depth++;
			return getDepth(index * 2 + 2, value, depth);
		}
	}

	public void delete(T value) {
		delete(value, 0);
	}

	private void delete(T value, int index) {
		if (dataArr[index] == null || index >= dataArr.length) {
			return; // value not found
		}

		if (value.compareTo(dataArr[index]) < 0) // go left
		{
			if (index * 2 + 1 < dataArr.length)
				delete(value, index * 2 + 1);
			else
				return;
		} else if (value.compareTo(dataArr[index]) >= 0) // go left
		{
			if (index * 2 + 2 < dataArr.length)
				delete(value, index * 2 + 2);
			else
				return;
		} else { // value has been found

			if (index * 2 + 1 < dataArr.length 
					&& index * 2 + 2 < dataArr.length 
					&& dataArr[index * 2 + 2] == null) // check	for right children, may have one child or none
			{
				// TODO move left subtree
				moveLeftSubtree(index);
				return;
			} else if (index*2+2 < dataArr.length 
					&& dataArr[index * 2 + 1] == null) // check for left childre
				
			{
				moveRightSubtree(index);
				return;
			}
			else //IT HAS TWO CHILDREN
			{
				//TODO replace current index with min in right subtree
				dataArr[index] = findMinInTree(index);
				
				//TODO delete min from tree
			}

		}
	}

	private void moveLeftSubtree(int index) {
		if(index >= dataArr.length)
		{
			return;
		}
		boolean isLeft = index%2!=0;//checks if odd
		if(isLeft || index == 0)//left child or root
		{
			if(index*2+1 < dataArr.length)
			{
				//replace current with left
				dataArr[index] = dataArr[index*2+1];
			}
			else
			{
				//Replace with null and return b/c no kids
				dataArr[index]=null;
				return;
			}
		}
		else//right child
		{
			if((index-1)*2+2<dataArr.length)//index sibling
			{
				dataArr[index] = dataArr[(index-1)*2+2];
			}
			else 
			{
				dataArr[index] = null;
				return;
			}
			
		}
		moveLeftSubtree(index*2+1);
		moveLeftSubtree(index*2+2);

	}
	
	private void moveRightSubtree(int index)
	{
		if(index >= dataArr.length)
		{
			return;
		}
		boolean isLeft = (index%2!=0);
		if(!isLeft || index==0)
		{
			if(index*2+2 < dataArr.length)
			{
				//replace current index with right
				dataArr[index] = dataArr[index*2+2];
			}
			else
			{
				dataArr[index]=null;
				return;
			}
		}
		else//left child
		{
			if((index+1)*2+1<dataArr.length)
			{
				dataArr[index] = dataArr[(index+1)*2+1];
			}
			else
			{
				dataArr[index] = null;
				return;
			}
		}
		
		moveRightSubtree(index*2+2); //process right first, then left
		moveRightSubtree(index*2+1);
		
	}
	
	public T findMinInTree(int index)
	{
		if(index*2+1>=dataArr.length || dataArr[index]==null)
			return null;
		if(index*2+1>=dataArr.length || dataArr[index*2+1]==null)
		{
			return dataArr[index];
		}
		else
			return findMinInTree(index*2+1);
	}
	
	public void deleteMinFromTRee(int index)
	{
		if(index>=dataArr.length)
			return;
		if(index*2+1 < dataArr.length && dataArr[index*2+1] == null)
		{
			if(index*2+2 < dataArr.length && dataArr[])
		}
			
		
	}
}
