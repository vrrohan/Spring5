
public class Line {
	public PointB pb;

	public PointB getPb() {
		return pb;
	}

	public void setPb(PointB pb) {
		this.pb = pb;
	}

	@Override
	public String toString() {
		return "Line is drawn [pb=" + pb + "]";
	}

}
