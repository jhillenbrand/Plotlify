package net.sytes.botg.plotlify;

import net.sytes.botg.plotlify.PlotlifyUtils.ModeType;
import net.sytes.botg.plotlify.PlotlifyUtils.PlotType;

public interface ITemplate {

	public void load();
	public void export(String filePath);
	
	public void setData(double[] x, double[] y, String name);
	public void addData(double[] x, double[] y, String name);
	
	public void setTitle(String title);
	public void setXLabel(String xLabel);
	public void setYLabel(String yLabel);
	public void setModeType(ModeType modeType);
	public void setPlotType(PlotType plotType);
	
	public void injectDefault();
	
}
