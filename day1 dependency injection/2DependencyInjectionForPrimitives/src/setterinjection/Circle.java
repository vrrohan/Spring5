package setterinjection;

public class Circle {

	public String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void drawn() {
		System.out.println("Shape is circle. Type is " + this.getType());
	}
}
