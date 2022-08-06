package net.sytes.botg.plotlify.templates;

public interface ITemplateSurface {

	public void setData(double[] x, double[] y, double[][] z, String name);
	
	public void addData(double[] x, double[] y, double[][] z, String name);
	
}
