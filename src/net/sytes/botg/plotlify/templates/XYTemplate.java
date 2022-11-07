package net.sytes.botg.plotlify.templates;

import net.sytes.botg.plotlify.PlotlifyUtils.ModeType;
import net.sytes.botg.plotlify.PlotlifyUtils.PlotType;

public class XYTemplate extends Template {

	static {
		//TEMPLATE_FILE = "res" + File.separator + "html" + File.separator + "XY_TEMPLATE.html";
		TEMPLATE_FILE = "XY_TEMPLATE.html";
	}

	/**
	 * overwrites the TEMPLATE ID in the loaded template by their default values, if they have not been provided before
	 */
	@Override
	public void injectDefault() {
		super.injectDefault();
		this.setData(null, null, "trace" + this.numberOfTraces);
		this.setPlotType(PlotType.SCATTER);
		this.setModeType(ModeType.LINES);
	}
}
