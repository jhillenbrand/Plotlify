package net.sytes.botg.plotlify.elements;

public enum AspectMode {

	MANUAL("manual"), AUTO("auto"), INDEPENDENT("independent"), DATA("data"), CUBE("cube");
	
	private final String aspectModeStr;
	
	private AspectMode(String aspectMode) {
		this.aspectModeStr = aspectMode;
	}
	
	@Override
	public String toString() {
		return this.aspectModeStr;
	}
	
}
