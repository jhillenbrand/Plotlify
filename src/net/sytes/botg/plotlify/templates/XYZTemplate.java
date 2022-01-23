package net.sytes.botg.plotlify.templates;

import java.io.File;

import net.sytes.botg.plotlify.PlotlifyUtils;
import net.sytes.botg.plotlify.PlotlifyUtils.ModeType;
import net.sytes.botg.plotlify.PlotlifyUtils.PlotType;

public class XYZTemplate extends XYTemplate implements ITemplate3D {

	static {
		TEMPLATE_FILE = "res" + File.separator + "html" + File.separator + "XYZ_TEMPLATE.html";
	}
	
	protected static final String ZDATA_ID = "#ZDATA";
	protected static final String ZAXIS_TITLE = "#ZAXIS_TITLE";	

	@Override
	public void setData(double[] x, double[] y, double[] z, String name) {
		PlotlifyUtils.checkDimensions(x, y, z);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addData(double[] x, double[] y, double[] z, String name) {
		PlotlifyUtils.checkDimensions(x, y, z);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setZLabel(String zLabel) {
		if (zLabel != null) {
			this.inject(ZAXIS_TITLE, zLabel);
		}
	}

	/**
	 * overwrites the TEMPLATE ID in the loaded template by their default values, if they have not been provided before
	 */
	@Override
	public void injectDefault() {
		this.setData(null, null, null, "trace" + this.numberOfTraces);
		this.setPlotType(PlotType.SCATTER);
		this.setModeType(ModeType.MARKERS);
		this.setXLabel("X");
		this.setYLabel("Y");
		this.setZLabel("Z");
		this.setTitle("trace" + this.numberOfTraces);
	}
	
	@Override
	public void setData(double[] x, double[] y, String name) {
		throw new UnsupportedOperationException("setData for 2D input is not applicable for 3D plot Template");
	}

	@Override
	public void addData(double[] x, double[] y, String name) {
		throw new UnsupportedOperationException("setData for 2D input is not applicable for 3D plot Template");
	}
}
