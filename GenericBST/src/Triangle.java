
public class Triangle extends Shape{
	public double base, height, area;
	public Triangle(int aBase, int aHeight)
	{
		this.base = aBase;
		this.height = aHeight;
		this.area = getArea();
	}
	
	public double getArea()
	{
		return (this.base*this.height)/2;
	}
	
	public int compareTo(Shape aShape)
	{
		return Double.compare(this.area, aShape.getArea());
	}
	
	public String toString()
	{
		return "Triange Side 1: " + base + " Side 2: " + height + " Area: " + area;
	}
}
