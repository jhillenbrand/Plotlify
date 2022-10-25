package net.sytes.botg.plotlify.templates;

import net.sytes.botg.plotlify.PlotlifyUtils.ModeType;
import net.sytes.botg.plotlify.PlotlifyUtils.PlotType;

public interface ITemplate2D {

	public void setData(double[] x, double[] y, String name);
	public void addData(double[] x, double[] y, String name, ModeType modeType, PlotType plotType);
	
}
