package net.sytes.botg.plotlify.templates;

import net.sytes.botg.plotlify.PlotlifyUtils.ModeType;
import net.sytes.botg.plotlify.PlotlifyUtils.PlotType;

public interface ITemplate3D {

	public void setZLabel(String zLabel);
	
	public void setData(double[] x, double[] y, double[] z, String traceName);
	public void addData(double[] x, double[] y, double[] z, String traceName, ModeType modeType, PlotType plotType);
	
}
