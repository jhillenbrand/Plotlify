package net.sytes.botg.plotlify;

import com.google.gson.Gson;

public class Grid {

	private int rows = 1;
	private int columns = 1;
	
	private String pattern = "independent";
		
	public String toJson() {
		return new Gson().toJson(this);
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	
}
