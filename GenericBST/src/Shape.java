//shape uses the shape interface, laying out basic methods to be used by circle, triangle and square base classes
public class Shape implements shapeInterface{
	public double area;
	public Shape()
	{
		this.area = 0.0;
	}
	
	public double getArea()
	{
		return this.area;
	}
	
	public void setArea(double anArea)
	{
		this.area = anArea;
	}
	//shapes will compare based on area, returning an integer value of the difference between to double valued areas
	public int compareTo(Shape aShape)
	{
		return Double.compare(this.area, aShape.getArea());
	}
}

