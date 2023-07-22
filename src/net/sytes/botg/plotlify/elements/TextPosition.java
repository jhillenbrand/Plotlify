package net.sytes.botg.plotlify.elements;

public enum TextPosition {

	TOP("top"), BOTTOM("bottom"), LEFT("left"), RIGHT("right"), CENTER("center"), TOP_LEFT("top left"), TOP_CENTER("top center"), TOP_RIGHT("top right"), MIDDLE_LEFT("middle left"), MIDDLE_CENTER("middle center"), MIDDLE_RIGHT("middle right");
	
	private final String textPosition;
	
	private TextPosition(String textPosition) {
		this.textPosition = textPosition;
	}
	
	@Override
	public String toString() {
		return this.textPosition;
	}
	
}
