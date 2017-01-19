
public class Circle extends Shape {
	public double radius;
	public double area;
	public Circle(int aRadius)
	{
		this.radius = aRadius;
		this.area = getArea();
	}
	
	public double getArea()
	{
		return Math.PI*(this.radius*this.radius);
	}
	
	public int compareTo(Shape aShape)
	{
		return Double.compare(this.area, aShape.getArea());
	}
	
	public String toString()
	{
		return "Circle Radius: " + radius + " Area: " + area;
	}
	
}
