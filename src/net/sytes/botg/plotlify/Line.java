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
	
	public Line dash(DashType dashType) {
		this.dash = dashType.toString();
		return this;
	}
	
	public int width() {
		return this.width;
	}
	
	public Line width(int width) {
		this.width = width;
		return this;
	}
	
	public String shape() {
		return this.shape;
	}
	
	public Line shape(LineShape lineShape) {
		this.shape = lineShape.toString();
		return this;
	}
	
	public String color() {
		return this.color;
	}
	
	public Line color(Color color) {
		this.color = color.toString();
		return this;
	}
	
}
