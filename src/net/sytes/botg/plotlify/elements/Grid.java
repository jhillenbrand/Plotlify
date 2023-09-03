package net.sytes.botg.plotlify.elements;

import com.google.gson.Gson;

public class Grid {

	private int rows = 1;
	private int columns = 1;
	
	private String pattern = "coupled"; // "coupled" / "independent"
		
	public String toJson() {
		return new Gson().toJson(this);
	}

	public int rows() {
		return this.rows;
	}

	public Grid rows(int rows) {
		this.rows = rows;
		return this;
	}

	public int columns() {
		return this.columns;
	}

	public Grid columns(int columns) {
		this.columns = columns;
		return this;
	}

	public String pattern() {
		return pattern;
	}

	public Grid pattern(String pattern) {
		this.pattern = pattern;
		return this;
	}
	
}
