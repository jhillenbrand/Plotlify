package net.sytes.botg.plotlify.templates;

public interface ITemplate3D {

	public void setZLabel(String zLabel);
	
	public void setData(double[] x, double[] y, double[] z, String name);
	public void addData(double[] x, double[] y, double[] z, String name);
	
}
