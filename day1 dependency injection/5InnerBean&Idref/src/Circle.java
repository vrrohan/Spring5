
public class Circle {
	public PointB pb;

	public PointB getPb() {
		return pb;
	}

	public void setPb(PointB pb) {
		this.pb = pb;
	}

	@Override
	public String toString() {
		return "Circle is drawn [pb=" + pb + "]";
	}
	
}
