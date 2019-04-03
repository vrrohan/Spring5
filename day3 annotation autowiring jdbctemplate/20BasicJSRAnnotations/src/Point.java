
public class Point {
	public int pX;
	public int pY;

	public Point() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getpX() {
		return pX;
	}

	public void setpX(int pX) {
		this.pX = pX;
	}

	public int getpY() {
		return pY;
	}

	public void setpY(int pY) {
		this.pY = pY;
	}

	@Override
	public String toString() {
		return "(" + pX + "," + pY + ")";
	}

}
