package net.sytes.botg.plotlify.elements;

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
