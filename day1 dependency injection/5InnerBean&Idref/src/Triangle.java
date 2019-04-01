
public class Triangle {
	private PointA pa;
	private PointB pb;
	private PointC pc;

	public PointA getPa() {
		return pa;
	}

	public void setPa(PointA pa) {
		this.pa = pa;
	}

	public PointB getPb() {
		return pb;
	}

	public void setPb(PointB pb) {
		this.pb = pb;
	}

	public PointC getPc() {
		return pc;
	}

	public void setPc(PointC pc) {
		this.pc = pc;
	}

	@Override
	public String toString() {
		return "Triangle is drawn [pa=" + pa + ", pb=" + pb + ", pc=" + pc + "]";
	}

}
