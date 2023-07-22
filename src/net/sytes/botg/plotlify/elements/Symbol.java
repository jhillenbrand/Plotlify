package net.sytes.botg.plotlify.elements;

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

