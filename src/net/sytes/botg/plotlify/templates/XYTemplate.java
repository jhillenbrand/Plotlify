package net.sytes.botg.plotlify.templates;

import java.io.File;

import net.sytes.botg.plotlify.PlotlifyUtils.ModeType;
import net.sytes.botg.plotlify.PlotlifyUtils.PlotType;

public class XYTemplate extends Template {

	static {
		TEMPLATE_FILE = "res" + File.separator + "html" + File.separator + "XY_TEMPLATE.html";
	}

	/**
	 * overwrites the TEMPLATE ID in the loaded template by their default values, if they have not been provided before
	 */
	@Override
	public void injectDefault() {
		this.setData(null, null, "trace" + this.numberOfTraces);
		this.setPlotType(PlotType.SCATTER);
		this.setModeType(ModeType.LINES);
		this.setXLabel("X");
		this.setYLabel("Y");
		this.setTitle("trace" + this.numberOfTraces);
	}
}
