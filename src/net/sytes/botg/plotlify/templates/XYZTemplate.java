package net.sytes.botg.plotlify.templates;

import java.util.Arrays;

import net.sytes.botg.plotlify.PlotlifyUtils;
import net.sytes.botg.plotlify.PlotlifyUtils.ModeType;
import net.sytes.botg.plotlify.PlotlifyUtils.PlotType;

public class XYZTemplate extends XYTemplate implements ITemplate3D {

	static {
		TEMPLATE_FILE = "XYZ_TEMPLATE.html";
	}
	
	protected static final String ZDATA_ID = "#ZDATA";
	protected static final String ZAXIS_TITLE = "#ZAXIS_TITLE";	

	@Override
	public void setData(double[] x, double[] y, double[] z, String name) {
		PlotlifyUtils.checkDimensions(x, y, z);
		if (x == null) {
			this.inject(XDATA_ID, "[]");
		} else {
			this.inject(XDATA_ID, Arrays.toString(x));
		}
		if (y == null) {
			this.inject(YDATA_ID, "[]");
		} else {
			this.inject(YDATA_ID, Arrays.toString(y));
		}
		if (z == null) {
			this.inject(ZDATA_ID, "[]");
		} else {
			this.inject(ZDATA_ID, Arrays.toString(z));
		}
		if (name == null) {
			this.inject(TRACE_NAME_ID, "trace" + this.numberOfTraces);
		} else {
			this.inject(TRACE_NAME_ID, name);
		}
	}

	@Override
	public void addData(double[] x, double[] y, double[] z, String traceName, ModeType modeType, PlotType plotType) {
		PlotlifyUtils.checkDimensions(x, y, z);
		if (x != null && y != null && z != null) {
			++this.numberOfTraces;			
			if (traceName == null) {
				traceName = "trace" + this.numberOfTraces;
			}
			// create the text for new trace
			StringBuilder sb1 = new StringBuilder();
			sb1.append("var trace").append(this.numberOfTraces).append(" = {\n")
				.append("\t\t\t\tx: ").append(Arrays.toString(x)).append(",\n")
				.append("\t\t\t\ty: ").append(Arrays.toString(y)).append(",\n")
				.append("\t\t\t\tz: ").append(Arrays.toString(z)).append(",\n")
				.append("\t\t\t\tmode: '").append(modeType.toString()).append("',\n")
				.append("\t\t\t\ttype: '").append(plotType.toString()).append("',\n")
				.append("\t\t\t\tname: '").append(traceName).append("'\n")
				.append("\t\t\t};\n")
				.append("\n")
				.append("\t\t\t").append(MORE_TRACES_ID);
						
			this.inject(MORE_TRACES_ID, sb1.toString());
			
			StringBuilder sb2 = new StringBuilder();
			sb2.append(", trace").append(this.numberOfTraces).append(TRACES_ID);
			this.inject(TRACES_ID, sb2.toString());
		}		
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
		this.setPlotType(PlotType.SCATTER3D);
		this.setModeType(ModeType.MARKERS);
		this.setXLabel("X");
		this.setYLabel("Y");
		this.setZLabel("Z");
		this.setTitle("trace" + this.numberOfTraces);
		this.setHeight(DEFAULT_HEIGHT);
		this.setWidth(DEFAULT_WIDTH);
	}
	
	@Override
	public void setData(double[] x, double[] y, String name) {
		throw new UnsupportedOperationException("setData for 2D input is not applicable for 3D plot Template");
	}

	@Override
	public void addData(double[] x, double[] y, String name, ModeType modeType, PlotType plotType) {
		throw new UnsupportedOperationException("setData for 2D input is not applicable for 3D plot Template");
	}
}
