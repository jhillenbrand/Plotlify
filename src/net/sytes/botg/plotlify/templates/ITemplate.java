package net.sytes.botg.plotlify.templates;

import net.sytes.botg.plotlify.PlotlifyUtils.ModeType;
import net.sytes.botg.plotlify.PlotlifyUtils.PlotType;

public interface ITemplate {

	public void load();
	public void export(String filePath);
		
	public void setTitle(String title);
	public void setXLabel(String xLabel);
	public void setYLabel(String yLabel);
	public void setModeType(ModeType modeType);
	public void setPlotType(PlotType plotType);
	
	public void injectDefault();
	
}
