package net.sytes.botg.plotlify.templates;

import java.util.Arrays;

import net.sytes.botg.plotlify.PlotlifyUtils.ModeType;
import net.sytes.botg.plotlify.PlotlifyUtils.PlotType;

public class SurfaceTemplate extends XYZTemplate implements ITemplateSurface {
	
	static {
		TEMPLATE_FILE = "SURFACE_TEMPLATE.html";
	}
	
	@Override
	public void injectDefault() {
		this.setHeight(DEFAULT_HEIGHT);
		this.setWidth(DEFAULT_WIDTH);
		this.setPlotType(PlotType.SURFACE);
		this.setXLabel("X");
		this.setYLabel("Y");
		this.setZLabel("Z");
		this.setTitle("Surface Plot");
		this.setHeight(700);
		this.setWidth(1000);
		this.setLegend(false);
	}
	
	@Override
	public void setData(double[] x, double[] y, double[] z, String name) {
		this.inject(XDATA_ID, Arrays.toString(x));
		this.inject(YDATA_ID, Arrays.toString(y));
		this.inject(ZDATA_ID, Arrays.toString(z));
		if (name == null) {
			name = "trace1";
		}
		this.inject(TRACE_NAME_ID, name);
	}

	@Override
	public void addData(double[] x, double[] y, double[] z, String traceName, ModeType modeType, PlotType plotType) {
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
	public void setData(double[] x, double[] y, double[][] z, String name) {
		
		this.inject(XDATA_ID, Arrays.toString(x));
		this.inject(YDATA_ID, Arrays.toString(y));
		this.inject(ZDATA_ID, Arrays.deepToString(z));
		
		this.inject(TRACE_NAME_ID, name);		
	}
	
	@Override
	public void addData(double[] x, double[] y, double[][] z, String name) {
		if (x != null && y != null && z != null) {
			++this.numberOfTraces;			
			if (name == null) {
				name = "trace" + this.numberOfTraces;
			}
			// create the text for new trace
			StringBuilder sb1 = new StringBuilder();
			sb1.append("var trace").append(this.numberOfTraces).append(" = {\n")
				.append("\t\t\t\tx: ").append(Arrays.toString(x)).append(",\n")
				.append("\t\t\t\ty: ").append(Arrays.toString(y)).append(",\n")
				.append("\t\t\t\tz: ").append(Arrays.deepToString(z)).append(",\n")
				.append("\t\t\t\ttype: '").append(PLOT_TYPE_ID).append("',\n")
				.append("\t\t\t\tname: '").append(name).append("'\n")
				.append("\t\t\t};\n")
				.append("\n")
				.append("\t\t\t").append(MORE_TRACES_ID);
						
			this.inject(MORE_TRACES_ID, sb1.toString());
			
			StringBuilder sb2 = new StringBuilder();
			sb2.append(", trace").append(this.numberOfTraces).append(TRACES_ID);
			this.inject(TRACES_ID, sb2.toString());
		}		
	}

}
