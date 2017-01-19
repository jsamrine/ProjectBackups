
public class Rectangle extends Shape{
	public double area, length, width;
	
	public Rectangle(int aLength, int aWidth)
	{
		this.length = aLength;
		this.width = aWidth;
		this.area = getArea();
	}
	
	public double getArea()
	{
		return this.length*this.width;
	}
	
	public int compareTo(Shape aShape)
	{
		return Double.compare(this.area, aShape.getArea());
	}
	
	public String toString()
	{
		return "Rectangle Side 1: " + length + " Side 2: " + width + " Area: " + area;
	}
}



