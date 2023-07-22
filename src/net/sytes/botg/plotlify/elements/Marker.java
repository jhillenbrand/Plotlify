package net.sytes.botg.plotlify.elements;

import com.google.gson.Gson;

public class Marker {

	private int size = 12;	
	private String color = null;
	private String symbol = null;
	private String angleref = null;
	
	public int size() {
		return size;
	}

	public Marker size(int size) {
		this.size = size;
		return this;
	}

	public String color() {
		return color;
	}

	public Marker color(Color color) {
		this.color = color.toString();
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
	
	public String toJson() {
		return new Gson().toJson(this);
	}
	
}
