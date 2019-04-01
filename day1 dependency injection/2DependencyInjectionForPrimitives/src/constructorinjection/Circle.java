package constructorinjection;

public class Circle {

	public String type;
	public int radius;

	public Circle(String type) {
		System.out.println("(String) is called");
		this.type = type;
	}

	public Circle(String type, int radius) {
		System.out.println("(String,int) is called");
		this.type = type;
		this.radius = radius;
	}

	public String getType() {
		return type;
	}

	public int getRadius() {
		return radius;
	}

	public void drawn() {
		System.out.println("Shape is circle. Type is " + this.getType() + ", Height is " + this.getRadius());
	}

	public Circle(int radius) {
		System.out.println("(int) is called");
		this.radius = radius;
	}

	public Circle(int radius, String type) {
		System.out.println("(int,String) is called");
		this.type = type;
		this.radius = radius;
	}
	
	
}
