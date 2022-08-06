package net.sytes.botg.plotlify.templates;

import java.io.File;
import java.util.Arrays;

import net.sytes.botg.plotlify.PlotlifyUtils.PlotType;

public class SurfaceTemplate extends XYZTemplate implements ITemplateSurface {
	
	static {
		TEMPLATE_FILE = "res" + File.separator + "html" + File.separator + "SURFACE_TEMPLATE.html";
	}
	
	@Override
	public void injectDefault() {
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
		throw new UnsupportedOperationException("setData(double[] x, double[] y, double[] z, String name) is not implemented for " + this.getClass().getSimpleName());
	}

	@Override
	public void addData(double[] x, double[] y, double[] z, String name) {
		throw new UnsupportedOperationException("addData(double[] x, double[] y, double[] z, String name) is not implemented for " + this.getClass().getSimpleName());
	}

	@Override
	public void setData(double[] x, double[] y, double[][] z, String name) {
		
		String s = this.surfaceMatrix(x, y, z);
		
		this.inject(ZDATA_ID, s);
		
		this.inject(TRACE_NAME_ID, name);		
	}
	
	private String surfaceMatrix(double[] x, double[] y, double[][] z){
		// check dimensions
		if (z.length != y.length) {
			throw new IllegalArgumentException("1st dimension of z must be equal to length of y");
		}
		if (z[0].length != x.length) {
			throw new IllegalArgumentException("2nd dimension of z must be equal to length of x");
		}
		
		double[][] z_s = new double[y.length + 1][x.length + 1];
		
		// populate surface matrix 
		System.arraycopy(x, 0, z_s[0], 1, x.length);
		for (int i = 0; i < z.length; i++) {
			System.arraycopy(z[i], 0, z_s[i + 1], 1, x.length);
			z_s[i + 1][0] = y[i];
		}
		
		String s = Arrays.deepToString(z_s);
		
		// replace first entry with empty string
		s = s.replace("[[0.0", "[[");
		return s;
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
			sb1.append("\t\t\tvar trace").append(this.numberOfTraces).append(" = {\n")
				.append("\t\t\t\tz: ").append(this.surfaceMatrix(x, y, z)).append(",\n")
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
