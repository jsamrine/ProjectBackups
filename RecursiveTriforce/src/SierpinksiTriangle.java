import java.applet.*;//Needed to create the window
import java.awt.*;//Needed for drawing
import java.util.*;
//Julian Amrine
public class SierpinksiTriangle extends Applet {

	private Image display;// Used as the flat image
	private Graphics drawingArea;// Used to draw item in the image

	public void init() {

		// gets the height of the triangle using pythagorean theorem.
		//tan60 = o/a
		//a = base
		//tan60 = sqrt(3)
		//so base * sqrt(3) would give the correct height of the equilateral triangle
		double root = (getSize().width / 2) * ((Math.sqrt(3)));

		// sets dimensions
		int width = getSize().width;
		int height = getSize().height;
		
		// Creates an image using the height and width in the applet
		display = createImage(width, height);
		// Sets up the drawing area for the image above to be drawn on
		drawingArea = display.getGraphics();
		//because sqrt gives decimal value, root must be typecast to integer
		//NOTE THAT IN THIS CASE AND ALL FURTHER CASES THE DECIMAL POINTS ARE DROPPED, may lead to greater and greater inaccuracies
		height = (int) root;
		// these set the coordinates for the black triangle
		int[] x = { 0, width / 2, width };
		int[] y = { height, 0, height };
		// draws the black triangle with the coordinates
		drawTriangle(x, y, width, drawingArea);
		//takes coordinates for the new recursive triangles by using midpoint formula
		//Similiar equations are used for the three recursive triangle calls
		drawSieve(new int[] { (x[0] + x[1]) / 2, (x[2] + x[0]) / 2, (x[2] + x[1]) / 2 },
				new int[] { (y[0] + y[1]) / 2, (y[2] + y[0]) / 2, (y[2] + y[1]) / 2 }, width, drawingArea);
		
	}

	public void paint(Graphics g) {
		g.drawImage(display, 0, 0, null);
	}
	//method for drawing black triangle
	public void drawTriangle(int[] x, int[] y, int width, Graphics g) {
		g.fillPolygon(x, y, 3);
	}

	public static void drawSieve(int[] x, int[] y, int side, Graphics g) {
		// Divides width by two, since the total width is equal to 2*height of the new triangles
		// sub will set limit for pixel count
		int sub = side / 3;
		//changes the fill of the triangles to white
		g.setColor(Color.white);
		//this is the process that actually draws the triangle out. the next three recursive calls only set the coordinates
		g.fillPolygon(x, y, 3);
		// If it hasn't reached the pixel limit the call the function
		// recursively on the 3 triangles.
		if (sub >= 4) {
			//each recursive call generates coordinates based on the midpoint formula
			//Triangle1 uses coordinates relative to last set of x,y coordinates + length of a line(which would be the offset of the point)
			//this principle applies for each of the three recursive calls
			drawSieve(
								//midpoint of x1 x3 plus the half length of the line between x1 and x2, the respective y coordinates follow the same method
					new int[] { (x[2] + x[1]) / 2 + (x[1] - x[0]) / 2, 
								(x[2] + x[1]) / 2 + (x[2] - x[0]) / 2,
								(x[2] + x[1]) / 2 },
					new int[] { (y[2] + y[1]) / 2 + (y[1] - y[0]) / 2, 
								(y[2] + y[1]) / 2 + (y[2] - y[0]) / 2,
								(y[2] + y[1]) / 2 },
					sub, g);
			

			// Triangle2 uses coordinates to find the midpoint between first and last sets of coordinates
			drawSieve(
					new int[] { (x[0] + x[2]) / 2 + (x[2] - x[1]) / 2, 
								(x[0] + x[2]) / 2 + (x[0] - x[1]) / 2,
								(x[0] + x[2]) / 2 },
					new int[] { (y[0] + y[2]) / 2 + (y[2] - y[1]) / 2, 
								(y[0] + y[2]) / 2 + (y[0] - y[1]) / 2,
								(y[0] + y[2]) / 2 },
					sub, g);
			
			// Triangle3 uses 
			drawSieve(
					new int[] { (x[0] + x[1]) / 2 + (x[1] - x[2]) / 2, 
								(x[0] + x[1]) / 2 + (x[0] - x[2]) / 2,
								(x[0] + x[1]) / 2 },
					new int[] { (y[0] + y[1]) / 2 + (y[1] - y[2]) / 2, 
								(y[0] + y[1]) / 2 + (y[0] - y[2]) / 2,
								(y[0] + y[1]) / 2 },
					sub, g); 
		}
	}
}
