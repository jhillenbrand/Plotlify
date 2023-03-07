package net.sytes.botg.plotlify;

public class Line {

	private String dash = null;
	private int width = 3;
	private String shape = null;
	private String color = null;
	
	public Line() {
		
	}
	
	public String dash() {
		return this.dash;
	}
	
	public void dash(DashType dashType) {
		this.dash = dashType.toString();
	}
	
	public int width() {
		return this.width;
	}
	
	public void width(int width) {
		this.width = width;
	}
	
	public String shape() {
		return this.shape;
	}
	
	public void shape(LineShape lineShape) {
		this.shape = lineShape.toString();
	}
	
	public String color() {
		return this.color;
	}
	
	public void color(Color color) {
		this.color = color.toString();
	}
	
}
