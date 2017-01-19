import java.io.*;
import java.util.*;

public class LLBSTTester {

	public static void main(String[] args) {
		int length, width, height, radius;
		LLBinarySearchTree tree = new LLBinarySearchTree<Shape>();
		try
		{
			//Scanner will take in lines from a file to be input to a binary tree
			Scanner reader = new Scanner(new File("shapeFile.txt"));
			System.out.println("Reading from file");
			while(reader.hasNextLine())
			{
				String fileLine = reader.nextLine();
				System.out.println(fileLine);
				String[] splitLines = fileLine.split("\t"); //array is split by tab delimeters
				if(splitLines[0].contains("Rectangle"))
				{
					//length = Integer.parseInt(splitLines[1]); 
					//width = Integer.parseInt(splitLines[2]);
					Rectangle newRect = new Rectangle(Integer.parseInt(splitLines[1]), Integer.parseInt(splitLines[2]));
					tree.insert(newRect);
				} else if(splitLines[0].contains("Right")) //&& splitLines[0].contains("Triangle"))
				{
					
					//height = Integer.parseInt(splitLines[1]); 
					//width = Integer.parseInt(splitLines[2]);
					Triangle newTri = new Triangle(Integer.parseInt(splitLines[1]), Integer.parseInt(splitLines[2]));
					tree.insert(newTri);
				} else if (splitLines[0].contains("Circle"))
				{
					//radius = Integer.parseInt(splitLines[1]);
					Circle newCircle = new Circle(Integer.parseInt(splitLines[1]));
					tree.insert(newCircle);
				}
				else
				{
					System.out.println("Ill Formed");
				}
				
			}
			reader.close();
		} catch(Exception e)
		{
			System.out.println("Exception: " +e.getMessage());
		}
		System.out.println("Printing in order");
		tree.printInorder();
		
		System.out.println("Printing post order");
		tree.printPostOrder();
		
		System.out.println("Printing pre order");
		tree.printPreOrder();
		
		System.out.println("Max area is " + tree.findMax());
		//Note that because of the nature of the binary tree storing Shapes rather than doubles a shape with the specified area to be deleted must be created		
		Shape aShape= new Shape();
		System.out.println("Deleting shape of size 14");
		aShape.setArea(14.0);
		tree.delete(aShape);
		System.out.println();
		System.out.println("Printing new list in pre order");
		tree.printPreOrder();
		
		System.out.println();
		System.out.println("Deleting values >30");
		
		
		aShape.setArea(30.0);
		tree.deleteValuesGreaterThan(aShape);
		
		System.out.println("Printing new list in pre order");
		tree.printPreOrder();
	}
}
