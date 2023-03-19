package net.sytes.botg.plotlify.elements;

public enum LineShape {

	LINEAR("linear"), SPLINE("spline"), VHV("vhv"), HVH("hvh"), HV("hv"), VH("vh");
	
	private final String type;
	
	private LineShape(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return this.type;
	}
	
}
