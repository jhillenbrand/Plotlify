package net.sytes.botg.plotlify;

import net.sytes.botg.plotlify.PlotlifyUtils.ModeType;
import net.sytes.botg.plotlify.PlotlifyUtils.PlotType;

public class Plotlify {
	
	public static void lineChart(String filePath, double[] x, double[] y, String traceName, String title, String xLabel, String yLabel) {
		XYTemplate template = new XYTemplate();
		template.load();
		template.setData(x, y, traceName);
		template.setTitle(title);
		template.setXLabel(xLabel);
		template.setYLabel(yLabel);
		template.setPlotType(PlotType.SCATTER);
		template.setModeType(ModeType.LINES_MARKERS);
		template.export(filePath);
		PlotlifyUtils.openInBrowser(filePath);
	}
	
	public static void lineChart(String filePath, double[] x, double[] y) {
		lineChart(filePath, x, y, null, null, null, null);
	}
	
	public static void lineChart(String filePath, double[] x, double[] y, String title) {
		lineChart(filePath, x, y, null, title, null, null);
	}
	
	public static void scatterChart(String filePath, double[] x, double[] y, String traceName, String title, String xLabel, String yLabel) {
		XYTemplate template = new XYTemplate();
		template.setData(x, y, traceName);
		template.setTitle(title);
		template.setXLabel(xLabel);
		template.setYLabel(yLabel);
		template.setPlotType(PlotType.SCATTER);
		template.setModeType(ModeType.MARKERS);
		template.export(filePath);
		PlotlifyUtils.openInBrowser(filePath);
	}
	
	public static void scatterChart(String filePath, double[] x, double[] y) {
		scatterChart(filePath, x, y, null, null, null, null);
	}
	
	public static void scatterChart(String filePath, double[] x, double[] y, String title) {
		scatterChart(filePath, x, y, null, title, null, null);
	}
}
