package net.sytes.botg.plotlify.elements;

public enum Mode {
	MARKERS ("markers"), LINES ("lines"), LINES_MARKERS ("lines+markers");
	
	private final String mode;
	
	private Mode(String mode) {
		this.mode = mode;
	}
	
	@Override
	public String toString() {
		return this.mode;
	}
}
