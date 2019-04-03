import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

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

	@Resource
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
		System.out.println("Circle with radius " + radius + "cm at center (" + center.getpX() + "," + center.getpY() + ")");
	}
	
	@PostConstruct
	public void initializeCircle() {
		System.out.println("Initializing Circle Bean...");
	}

	@PreDestroy
	public void destroyCircle() {
		System.out.println("Destroying Circle Bean...");
	}
}
