package net.sytes.botg.plotlify.elements;

import com.google.gson.Gson;

public class Marker {

	private int size = 12;	
	private String color = null;
	private String symbol = null;
	private String angleref = null;
	
	public enum Symbol {
		
		ARROW_UP("arrow-up"), ARROW_UP_OPEN("arrow-up-open"), ARROW_DOWN("arrow-down"), ARROW_DOWN_OPEN("arrow-down-open"),
		ARROW_LEFT("arrow-left"), ARROW_LEFT_OPEN("arrow-left-open"), ARROW_RIGHT("arrow-right"), ARROW_RIGHT_OPEN("arrow-right-open"),
		ARROW_BAR_UP("arrow-bar-up"), ARROW_BAR_UP_OPEN("arrow-bar-up-open"), ARROW_BAR_DOWN("arrow-bar-down"), ARROW_BAR_DOWN_OPEN("arrow-bar-down-open"),
		ARROW_BAR_LEFT("arrow-bar-left"), ARROW_BAR_LEFT_OPEN("arrow-bar-left-open"), ARROW_BAR_RIGHT("arrow-bar-right"),
		ARROW_BAR_RIGHT_OPEN("arrow-bar-right-open"), ARROW("arrow"), ARROW_OPEN("arrow-open"), ARROW_WIDE("arrow-wide"), ARROW_WIDE_OPEN("arrow-wide-open");
		
		private final String symbolStr;
		
		private Symbol(String symbolStr) {
			this.symbolStr = symbolStr;
		}
		
		@Override
		public String toString() {
			return this.symbolStr;
		}
		
	}
	
	public enum AngleRef {
		
		PREVIOUS("previous"), UP("up");
		
		private final String angleRefStr;
		
		private AngleRef(String angleRefStr) {
			this.angleRefStr = angleRefStr;
		}
		
		@Override
		public String toString() {
			return this.angleRefStr;
		}
		
	}

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
