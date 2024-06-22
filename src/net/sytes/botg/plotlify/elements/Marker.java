package net.sytes.botg.plotlify.elements;

import com.google.gson.Gson;

public class Marker {

	private int size = 12;	
	private Object color = null;
	private String symbol = null;
	private String angleref = null;
	private Line line = null;
	
	public int size() {
		return size;
	}

	public Marker size(int size) {
		this.size = size;
		return this;
	}

	public Object color() {
		return color;
	}

	public Marker color(Color color) {
		this.color = color.toString();
		return this;
	}
	
	/**
	 * define the colors of every single marker by specifying a number between 0 to 1 representing a color from the current colorscale
	 * @param colors
	 * @return
	 */
	public Marker color(double[] colors) {
		this.color = colors;
		return this;
	}
	
	public Marker symbol(Symbol symbol) {
		this.symbol = symbol.toString();
		return this;
	}
	
	public String symbol() {
		return this.symbol;
	}
	
	public Marker angleRef(AngleRef angleRef) {
		this.angleref = angleRef.toString();
		return this;
	}
	
	public String angleRef() {
		return this.angleref;
	}
	
	public Line line() {
		if (this.line == null) {
			this.line = new Line();
		}
		return this.line;
	}
	
	public Marker line(Line line) {
		this.line = line;
		return this;
	}
		
	public String toJson() {
		return new Gson().toJson(this);
	}
	
}
