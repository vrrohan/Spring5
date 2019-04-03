import org.springframework.beans.factory.annotation.Required;

public class Circle {
	
	public Point center;
	public int radius;

	public Circle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Point getCenter() {
		return center;
	}

	@Required
	public void setCenter(Point center) {
		this.center = center;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "Circle at center=" + center + ", with radius=" + radius + "cm";
	}
	
	public void draw() {
		System.out.println("Circle with radius " + radius + "cm at center" + center.getpX() + "," + center.getpY());
	}

}
