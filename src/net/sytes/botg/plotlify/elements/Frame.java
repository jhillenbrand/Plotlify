package net.sytes.botg.plotlify.elements;

import com.google.gson.Gson;

import net.sytes.botg.array.ConvertArray;

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
		this.x = ConvertArray.toObjects(x);
		this.y = ConvertArray.toObjects(y);
		this.z = ConvertArray.toObjects(z);
	}
	
	public Frame(double x, double y, double z) {
		this.x = new Object[] {x};
		this.y = new Object[] {y};
		this.z = new Object[] {z};
	}
	
	public String toJson() {
		return new Gson().toJson(this);
	}
	
}
