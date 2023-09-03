package net.sytes.botg.plotlify.elements;

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
	public static final Color ORANGE = new Color(255, 150, 0);
	
	public Color(int r, int g, int b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	public Color(String hexColor) {
		if (hexColor.length() == 7) {
			if (hexColor.startsWith("#")) {
				this.r = Integer.valueOf(hexColor.substring(1, 3), 16);
			    this.g = Integer.valueOf(hexColor.substring(3, 5), 16);
			    this.b = Integer.valueOf(hexColor.substring(5, 7), 16);
			} else {
				throw new IllegalArgumentException("Color String passed must be HEX Format");
			}
		} else if(hexColor.length() == 6) {
			this.r = Integer.valueOf(hexColor.substring(0, 2), 16);
		    this.g = Integer.valueOf(hexColor.substring(2, 4), 16);
		    this.b = Integer.valueOf(hexColor.substring(4, 6), 16);
		} else {
			throw new IllegalArgumentException("Color String passed must be HEX Format");
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("rgb(").append(this.r).append(", ").append(this.g).append(", ").append(this.b).append(")");
		return sb.toString();
	}
	
}
