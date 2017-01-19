import java.util.*;

public class SheepHeapTester {

	public static void main(String[] args) {
		int sheepCount = 15; //modify sheep count to increase total amount of sheep
		ArrayHeap<Sheep> sheepHeap = new ArrayHeap<Sheep>(sheepCount);
		Random RNG = new Random();
		Sheep aSheep; 
		double aWeight;
		
		for (int i = 0; i < sheepCount; i++) {
			aWeight = RNG.nextInt(10)/RNG.nextDouble();
			aSheep = new Sheep("Sheep " + i, aWeight );
			sheepHeap.addSheep(aSheep);
		}
		//sorts sheep using heap sort
		System.out.println("Sheep sort");
		sheepHeap.sheepHeapSort();
		System.out.println();
		//prints sheep in breadth order
		System.out.println("Printing flock");
		sheepHeap.printSheepHeap();
		System.out.println();
		//removes 5 sheep
		System.out.println("Deleting sheep");
		for(int i = 0; i<5; i++)
		{
			
			sheepHeap.removeSheep();
		}
		System.out.println("Printing flock");
		sheepHeap.printSheepHeap();
		
	}

}
