
public class Point {
	public int pointX;
	public int pointY;

	public int getPointX() {
		return pointX;
	}

	public void setPointX(int pointX) {
		this.pointX = pointX;
	}

	public int getPointY() {
		return pointY;
	}

	public void setPointY(int pointY) {
		this.pointY = pointY;
	}

	@Override
	public String toString() {
		return "{" + pointX + "," + pointY + "}";
	}

}
