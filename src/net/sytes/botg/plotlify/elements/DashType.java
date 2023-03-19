package net.sytes.botg.plotlify.elements;

public enum DashType {
	
	DASH("dash"), DOT("dot"), DASHDOT("dashdot"), SOLID("solid");
	
	private final String type;
	
	private DashType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return this.type;
	}	
	
}
