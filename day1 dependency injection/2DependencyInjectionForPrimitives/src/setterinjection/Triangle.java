package setterinjection;

public class Triangle {
	public String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void drawn() {
		System.out.println("Shape is triangle. Type is " + this.getType());
	}
}
