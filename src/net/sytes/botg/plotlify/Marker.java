package net.sytes.botg.plotlify;

import com.google.gson.Gson;

public class Marker {

	private int size = 12;	
	private String color = null;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public String toJson() {
		return new Gson().toJson(this);
	}
	
}
