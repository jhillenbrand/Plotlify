package net.sytes.botg.plotlify.templates;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sytes.botg.plotlify.PlotlifyUtils;
import net.sytes.botg.plotlify.PlotlifyUtils.ModeType;
import net.sytes.botg.plotlify.PlotlifyUtils.PlotType;
import net.sytes.botg.string.StringUtilities;
import net.sytes.botg.text.TextParser;

public abstract class Template implements ITemplate, ITemplate2D {
	
	protected static String TEMPLATE_FILE = "";
	
	protected static final String XDATA_ID = "#XDATA";
	protected static final String YDATA_ID = "#YDATA";
	protected static final String TRACE_NAME_ID = "#TRACE_NAME";
	protected static final String MORE_TRACES_ID = "//#MORE_TRACES";
	protected static final String TRACES_ID = "];//#TRACES";
	protected static final String TRACE_DECLARATION_ID = "var trace";
	protected static final String MARKER_TYPE_ID = "#MARKER_TYPE";
	protected static final String PLOT_TYPE_ID = "#PLOT_TYPE";
	protected static final String XAXIS_TITLE = "#XAXIS_TITLE";
	protected static final String YAXIS_TITLE = "#YAXIS_TITLE";	
	protected static final String TITLE_ID = "#TITLE";
	protected static final String LEGEND_ON_OFF_ID = "#LEGEND_ON_OFF";
	protected static final String HEIGHT_ID = "#HEIGHT";
	protected static final String WIDTH_ID = "#WIDTH";
	protected static final int DEFAULT_WIDTH = 700;
	protected static final int DEFAULT_HEIGHT = 500;
	
	protected String loadedTemplate = null;
	protected int numberOfTraces = 1;
	
	protected final static Logger logger = LoggerFactory.getLogger(Template.class);
	
	protected void inject(String id, String txt) {
		this.loadedTemplate = this.loadedTemplate.replace(id, txt);
	}
	
	@Override
	public void load() {
		InputStream is = this.getClass().getResourceAsStream(TEMPLATE_FILE);		
		this.loadedTemplate = TextParser.readInputStream(is);		
	}
	
	@Override
	public void load(String filePath) {
		if (new File(filePath).exists()) {
			try {
				InputStream is = new FileInputStream(new File(filePath));
				this.loadedTemplate = TextParser.readInputStream(is);
				// count number of traces, already added
				int traceCount = StringUtilities.getStringInStringCount(TRACE_DECLARATION_ID, this.loadedTemplate);
				this.numberOfTraces = traceCount;
			} catch (FileNotFoundException e) {
				logger.error("Could not load " + filePath, e);
				logger.warn("Loading template instead");
				this.load();
			}
		} else {
			this.load();
		}
	}
	
	@Override
	public void export(String filePath) {
		PlotlifyUtils.checkFilePath(filePath);
		// replace not replaced ID with default before export
		this.injectDefault();	
		TextParser.writeTextToFile(filePath, this.loadedTemplate);
	}

	@Override
	public void setData(double[] x, double[] y, String name) {
		PlotlifyUtils.checkDimensions(x, y, null);
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
		if (name == null) {
			this.inject(TRACE_NAME_ID, "trace" + this.numberOfTraces);
		} else {
			this.inject(TRACE_NAME_ID, name);
		}
	}

	@Override
	public void addData(double[] x, double[] y, String name, ModeType modeType, PlotType plotType) {
		PlotlifyUtils.checkDimensions(x, y, null);
		if (x != null && y != null) {
			++this.numberOfTraces;			
			if (name == null) {
				name = "trace" + this.numberOfTraces;
			}
			// create the text for new trace
			StringBuilder sb1 = new StringBuilder();
			sb1.append("var trace").append(this.numberOfTraces).append(" = {\n")
				.append("\t\t\t\tx: ").append(Arrays.toString(x)).append(",\n")
				.append("\t\t\t\ty: ").append(Arrays.toString(y)).append(",\n")
				.append("\t\t\t\tmode: '").append(modeType.toString()).append("',\n")
				.append("\t\t\t\ttype: '").append(plotType.toString()).append("',\n")
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
	
	@Override
	public void injectDefault() {
		// set default width and height
		this.setHeight(DEFAULT_HEIGHT);
		this.setWidth(DEFAULT_WIDTH);
	}
	
	@Override
	public void setTitle(String title) {
		if (title != null) {
			this.inject(TITLE_ID, title);
		}
	}	

	@Override
	public void setXLabel(String xLabel) {
		if (xLabel != null) {
			this.inject(XAXIS_TITLE, xLabel);
		}
	}

	@Override
	public void setYLabel(String yLabel) {
		if (yLabel != null) {
			this.inject(YAXIS_TITLE, yLabel);
		}
	}

	@Override
	public void setModeType(ModeType markerType) {
		if (markerType != null) {
			this.inject(MARKER_TYPE_ID, markerType.toString());
		}
	}

	@Override
	public void setPlotType(PlotType plotType) {
		if (plotType != null) {
			this.inject(PLOT_TYPE_ID, plotType.toString());
		}		
	}
	
	@Override
	public void setWidth(int width) {
		if (width > 0) {
			this.inject(WIDTH_ID, "" + width);
		}
	}
	
	@Override
	public void setHeight(int height) {
		if (height > 0) {
			this.inject(HEIGHT_ID, "" + height);
		}
	}	
	
	@Override
	public void setLegend(boolean onOff) {
		this.inject(LEGEND_ON_OFF_ID, "" + onOff);
	}
	
}
