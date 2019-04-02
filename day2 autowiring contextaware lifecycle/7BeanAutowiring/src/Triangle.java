
public class Triangle {
	public Point pA;
	public Point pB;
	public Point pC;

	public Point getpA() {
		return pA;
	}

	public void setpA(Point pA) {
		this.pA = pA;
	}

	public Point getpB() {
		return pB;
	}

	public void setpB(Point pB) {
		this.pB = pB;
	}

	public Point getpC() {
		return pC;
	}

	public void setpC(Point pC) {
		this.pC = pC;
	}

	@Override
	public String toString() {
		return "Triangle Points pA=" + pA + ", pB=" + pB + ", pC=" + pC;
	}

}
