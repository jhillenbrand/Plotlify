package net.sytes.botg.plotlify.elements;

import com.google.gson.Gson;

import net.sytes.botg.array.Ar;

public class Frame {

	private Object[] x;
	private Object[] y;
	private Object[] z;
	
	public Frame(Object[] x, Object[] y, Object[] z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Frame(double[] x, double[] y, double[] z) {
		this.x = Ar.toObjects(x);
		this.y = Ar.toObjects(y);
		this.z = Ar.toObjects(z);
	}
	
	public Frame(double x, double y, double z) {
		this.x = new Object[] {x};
		this.y = new Object[] {y};
		this.z = new Object[] {z};
	}
	
	@Override
	public String toString() {
		return this.toJson();
	}
	
	public String toJson() {
		return new Gson().toJson(this);
	}
	
}
