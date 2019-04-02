
public class Circle {
	public Radius rA;
	public CirclePoints cirPoints;

	public Radius getrA() {
		return rA;
	}

	public void setrA(Radius rA) {
		this.rA = rA;
	}

	public CirclePoints getCirPoints() {
		return cirPoints;
	}

	public void setCirPoints(CirclePoints cirPoints) {
		this.cirPoints = cirPoints;
	}

	@Override
	public String toString() {
		return "Circle at point " + cirPoints + " having radius " + rA;
	}

}
