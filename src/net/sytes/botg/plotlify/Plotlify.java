package net.sytes.botg.plotlify;

import net.sytes.botg.plotlify.PlotlifyUtils.ModeType;
import net.sytes.botg.plotlify.PlotlifyUtils.PlotType;
import net.sytes.botg.plotlify.templates.XYTemplate;
import net.sytes.botg.plotlify.templates.XYZTemplate;

public class Plotlify {

	/**
	 * creates a line plot based on the double arrays passed with {@code x} and {@code y} and exports it as html file under specified {@code filePath}
	 * @param filePath
	 * @param x
	 * @param y
	 */
	public static void line(String filePath, double[] x, double[] y) {
		line(filePath, x, y, null, null, null, null);
	}
	
	/**
	 * creates a line plot based on the double arrays passed with {@code x} and {@code y} and exports it as html file under specified {@code filePath}
	 * <br>{@code title} can be used to specify the plot's title
	 * @param filePath
	 * @param x
	 * @param y
	 * @param title
	 */
	public static void line(String filePath, double[] x, double[] y, String title) {
		line(filePath, x, y, null, title, null, null);
	}
	
	/**
	 * creates a line plot based on the double arrays passed with {@code x} and {@code y} and exports it as html file under specified {@code filePath}
	 * <br>{@code traceName} can be used to specify the legend entry for the specified data
	 * <br>{@code title} can be used to specify the plot's title
	 * <br>{@code xLabel} and {@code xLabel} can be used to specify the plot's axis labels
	 * @param filePath
	 * @param x
	 * @param y
	 * @param traceName
	 * @param title
	 * @param xLabel
	 * @param yLabel
	 */
	public static void line(String filePath, double[] x, double[] y, String traceName, String title, String xLabel, String yLabel) {
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

	/**
	 * creates a scatter plot based on the double arrays passed with {@code x} and {@code y} and exports it as html file under specified {@code filePath}
	 * @param filePath
	 * @param x
	 * @param y
	 */
	public static void scatter(String filePath, double[] x, double[] y) {
		scatter(filePath, x, y, null, null, null, null);
	}
	
	/**
	 * creates a scatter plot based on the double arrays passed with {@code x} and {@code y} and exports it as html file under specified {@code filePath}
	 * <br>{@code title} can be used to specify the plot's title
	 * @param filePath
	 * @param x
	 * @param y
	 * @param title
	 */
	public static void scatter(String filePath, double[] x, double[] y, String title) {
		scatter(filePath, x, y, null, title, null, null);
	}
	
	/**
	 * creates a scatter plot based on the double arrays passed with {@code x} and {@code y} and exports it as html file under specified {@code filePath}
	 * <br>{@code traceName} can be used to specify the legend entry for the specified data
	 * <br>{@code title} can be used to specify the plot's title
	 * <br>{@code xLabel} and {@code xLabel} can be used to specify the plot's axis labels
	 * @param filePath
	 * @param x
	 * @param y
	 * @param traceName
	 * @param title
	 * @param xLabel
	 * @param yLabel
	 */
	public static void scatter(String filePath, double[] x, double[] y, String traceName, String title, String xLabel, String yLabel) {
		XYTemplate template = new XYTemplate();
		template.load();
		template.setData(x, y, traceName);
		template.setTitle(title);
		template.setXLabel(xLabel);
		template.setYLabel(yLabel);
		template.setPlotType(PlotType.SCATTER);
		template.setModeType(ModeType.MARKERS);
		template.export(filePath);
		PlotlifyUtils.openInBrowser(filePath);
	}

	/**
	 * creates a scatter 3D plot based on the double arrays passed with {@code x}, {@code y} and {@code z} and exports it as html file under specified {@code filePath}
	 * @param filePath
	 * @param x
	 * @param y
	 * @param z
	 */
	public static void scatter3D(String filePath, double[] x, double[] y, double[] z) {
		scatter3D(filePath, x, y, z, null, null, null, null, null);
	}
	
	/**
	* creates a scatter 3D plot based on the double arrays passed with {@code x}, {@code y} and {@code z} and exports it as html file under specified {@code filePath}
	 * <br>{@code title} can be used to specify the plot's title
	 * @param filePath
	 * @param x
	 * @param y
	 * @param z
	 * @param title
	 */
	public static void scatter3D(String filePath, double[] x, double[] y, double[] z, String title) {
		scatter3D(filePath, x, y, z, null, title, null, null, null);
	}
	
	/**
	  * creates a scatter 3D plot based on the double arrays passed with {@code x}, {@code y} and {@code z} and exports it as html file under specified {@code filePath}
	 * <br>{@code traceName} can be used to specify the legend entry for the specified data
	 * <br>{@code title} can be used to specify the plot's title
	 * <br>{@code xLabel}, {@code xLabel} and {@code zLabel} can be used to specify the plot's axis labels
	 * @param filePath
	 * @param x
	 * @param y
	 * @param z
	 * @param traceName
	 * @param title
	 * @param xLabel
	 * @param yLabel
	 * @param zLabel
	 */
	public static void scatter3D(String filePath, double[] x, double[] y, double[] z, String traceName, String title, String xLabel, String yLabel, String zLabel) {
		XYZTemplate template = new XYZTemplate();
		template.load();
		template.setData(x, y, z, traceName);
		template.setTitle(title);
		template.setXLabel(xLabel);
		template.setYLabel(yLabel);
		template.setYLabel(zLabel);
		//template.setPlotType(PlotType.SCATTER3D);
		//template.setModeType(ModeType.MARKERS);
		template.export(filePath);
		PlotlifyUtils.openInBrowser(filePath);
	}
}
