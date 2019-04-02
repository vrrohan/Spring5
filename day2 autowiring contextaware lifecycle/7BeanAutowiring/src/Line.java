
public class Line {
	public Point pA;
	public Point pB;

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

	@Override
	public String toString() {
		return "Line points pA=" + pA + " & pB=" + pB;
	}

}
