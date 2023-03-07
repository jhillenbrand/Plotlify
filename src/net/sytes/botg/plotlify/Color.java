package net.sytes.botg.plotlify;

public class Color {

	private int r = 0;
	private int g = 0;
	private int b = 0;
	
	public static final Color RED = new Color(255, 0, 0);
	public static final Color GREEN = new Color(0, 255, 0);
	public static final Color BLUE = new Color(0, 0, 255);
	public static final Color YELLOW = new Color(255, 255, 0);
	public static final Color BLACK = new Color(0, 0, 0);
	public static final Color WHITE = new Color(255, 255, 255);
	public static final Color GRAY = new Color(128, 128, 128);
	
	public Color(int r, int g, int b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("rgb(").append(r).append(", ").append(g).append(", ").append(b).append(")");
		return sb.toString();
	}
	
}
