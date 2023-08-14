package net.sytes.botg.plotlify.elements;

public class AspectRatio {
	
	private double x = 1.0;
	private double y = 1.0;
	private double z = 1.0;
	
	public AspectRatio() {
		
	}
	
	public AspectRatio x(double x) {
		this.x = x;
		return this;
	}
	
	public AspectRatio y(double y) {
		this.y = y;
		return this;
	}
	
	public AspectRatio z(double z) {
		this.z = z;
		return this;
	}

	public double x() {
		return this.x;
	}

	public double y() {
		return this.y;
	}

	public double z() {
		return this.z;
	}
	
}
