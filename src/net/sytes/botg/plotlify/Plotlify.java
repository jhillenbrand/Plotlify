package net.sytes.botg.plotlify;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.sytes.botg.array.ArUtils;
import net.sytes.botg.array.geometry.SemiSphere;
import net.sytes.botg.plotlify.PlotlifyUtils.ModeType;
import net.sytes.botg.plotlify.PlotlifyUtils.PlotType;
import net.sytes.botg.plotlify.templates.SurfaceTemplate;
import net.sytes.botg.plotlify.templates.XYTemplate;
import net.sytes.botg.plotlify.templates.XYZTemplate;

public class Plotlify {
	
	public static void line(String filePath, double[] y) {
		double[] x = ArUtils.linspace(y.length);
		line(filePath, x, y, null, null, null, null);
	}
	
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
		template.setTitle(title);
		template.setXLabel(xLabel);
		template.setYLabel(yLabel);
		template.setPlotType(PlotType.SCATTER);
		template.setModeType(ModeType.LINES);
		template.setData(x, y, traceName);
		template.export(filePath);
		PlotlifyUtils.openInBrowser(filePath);
	}
	
	/**
	 * create 3D line plot based on the double arrays passed with {@code x}, {@code y} and {@code z} and exports it as html file under specified {@code filePath}
	 * <br>{@code traceName} can be used to specify the legend entry for the specified data
	 * <br>{@code title} can be used to specify the plot's title
	 * <br>{@code xLabel}, {@code xLabel} and {@code zLabel} can be used to specify the plot's axis labels
	 * @param fil ePath
	 * @param x
	 * @param y
	 * @param z
	 * @param traceName
	 * @param title
	 * @param xLabel
	 * @param yLabel
	 * @param zLabel
	 */
	public static void line(String filePath, double[] x, double[] y, double[] z, String traceName, String title, String xLabel, String yLabel, String zLabel) {
		XYZTemplate template = new XYZTemplate();
		template.load();
		template.setData(x, y, z, traceName);
		template.setTitle(title);
		template.setXLabel(xLabel);
		template.setYLabel(yLabel);
		template.setZLabel(zLabel);
		template.setPlotType(PlotType.SCATTER3D);
		template.setModeType(ModeType.LINES);
		template.export(filePath);
		PlotlifyUtils.openInBrowser(filePath);
	}
	
	/**
	 * create 3D line plot based on the double arrays passed with {@code x}, {@code y} and {@code z} and exports it as html file under specified {@code filePath}
	 * <br>{@code traceName} can be used to specify the legend entry for the specified data
	 * <br>{@code title} can be used to specify the plot's title
	 * <br>{@code xLabel}, {@code xLabel} and {@code zLabel} can be used to specify the plot's axis labels
	 * @param fil ePath
	 * @param x
	 * @param y
	 * @param z
	 * @param traceName
	 * @param title
	 * @param xLabel
	 * @param yLabel
	 * @param zLabel
	 */
	public static void line(String filePath, double[] x, double[] y, double[] z, String traceName) {
		XYZTemplate template = new XYZTemplate();
		template.load();
		template.setData(x, y, z, traceName);
		template.setTitle("3D Line");
		template.setXLabel("X");
		template.setYLabel("Y");
		template.setZLabel("Z");
		template.setPlotType(PlotType.SCATTER3D);
		template.setModeType(ModeType.LINES);
		template.export(filePath);
		PlotlifyUtils.openInBrowser(filePath);
	}
	
	/**
	 * adds a new line trace to plot html and opens the file in browser
	 * @param filePath
	 * @param x
	 * @param y
	 */
	public static void addLine(String filePath, double[] x, double[] y) {
		addLine(filePath, x, y, "trace-" + new SimpleDateFormat("HHmmss").format(new Date()), null, null, null);
	}

	/**
	 * adds a new line trace to plot html and opens the file in browser
	 * @param filePath
	 * @param x
	 * @param y
	 * @param traceName
	 * @param title
	 * @param xLabel
	 * @param yLabel
	 */
	public static void addLine(String filePath, double[] x, double[] y, String traceName, String title, String xLabel, String yLabel) {
		XYTemplate template = new XYTemplate();
		template.load(filePath);
		template.addData(x, y, traceName, ModeType.LINES, PlotType.SCATTER);
		if (title != null) {
			template.setTitle(title);
		}
		if (xLabel != null) {
			template.setXLabel(xLabel);
		}
		if (yLabel != null) {
			template.setYLabel(yLabel);
		}
		template.export(filePath);
		PlotlifyUtils.openInBrowser(filePath);
	}
	
	/**
	 * adds a new line trace to 3d plot html and opens the file in browser
	 * @param filePath
	 * @param x
	 * @param y
	 * @param z
	 * @param traceName
	 */
	public static void addLine(String filePath, double[] x, double[] y, double[] z, String traceName) {
		addLine(filePath, x, y, z, traceName, null, null, null, null);
	}
	
	/**
	 * adds a new line trace to 3d plot html and opens the file in browser
	 * @param filePath
	 * @param x
	 * @param y
	 * @param z
	 * @param traceName
	 * @param title
	 * @param xLabel
	 * @param yLabel
	 */
	public static void addLine(String filePath, double[] x, double[] y, double[] z, String traceName, String title, String xLabel, String yLabel, String zLabel) {
		XYZTemplate template = new XYZTemplate();
		template.load(filePath);
		template.addData(x, y, z, traceName, ModeType.LINES, PlotType.SCATTER3D);
		if (title != null) {
			template.setTitle(title);
		}
		if (xLabel != null) {
			template.setXLabel(xLabel);
		}
		if (yLabel != null) {
			template.setYLabel(yLabel);
		}
		if (zLabel != null) {
			template.setZLabel(zLabel);
		}
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
	 * adds a new scatter trace to plot html and opens the file in browser
	 * @param filePath
	 * @param x
	 * @param y
	 */
	public static void addScatter(String filePath, double[] x, double[] y) {
		addScatter(filePath, x, y, "trace-" + new SimpleDateFormat("HHmmss").format(new Date()), null, null, null);
	}
	
	/**
	 * adds a new scatter trace to plot html and opens the file in browser
	 * @param filePath
	 * @param x
	 * @param y
	 * @param traceName
	 * @param title
	 * @param xLabel
	 * @param yLabel
	 */
	public static void addScatter(String filePath, double[] x, double[] y, String traceName, String title, String xLabel, String yLabel) {
		XYTemplate template = new XYTemplate();
		template.load(filePath);
		template.addData(x, y, traceName, ModeType.MARKERS, PlotType.SCATTER);
		if (title != null) {
			template.setTitle(title);
		}
		if (xLabel != null) {
			template.setXLabel(xLabel);
		}
		if (yLabel != null) {
			template.setYLabel(yLabel);
		}
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
	
	/**
	 * creates a surface plot based on {@code x}, {@code y} and {@code z}, where {@code z} = [m x n] with {@code x} = [n] and {@code y} = [m]
	 * @param filePath
	 * @param x
	 * @param y
	 * @param z
	 */
	public static void surface(String filePath, double[] x, double[] y, double[][] z) {
		surface(filePath, x, y, z, "surf1", "Surface Plot", "X", "Y", "Z");
	}
	
	/**
	 * creates a surface plot based on {@code x}, {@code y} and {@code z}, where {@code z} = [m x n] with {@code x} = [n] and {@code y} = [m]
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
	public static void surface(String filePath, double[] x, double[] y, double[][] z, String traceName, String title, String xLabel, String yLabel, String zLabel) {
		SurfaceTemplate template = new SurfaceTemplate();
		template.load();
		template.setData(x, y, z, traceName);
		template.setTitle(title);
		template.setXLabel(xLabel);
		template.setYLabel(yLabel);
		template.setYLabel(zLabel);
		template.export(filePath);
		PlotlifyUtils.openInBrowser(filePath);
	}
	
	public static void mesh3d(String filePath, double[] x, double[] y, double[] z, String traceName, String title, String xLabel, String yLabel, String zLabel) {
		SurfaceTemplate template = new SurfaceTemplate();
		template.load();
		template.setPlotType(PlotType.MESH3D);
		template.setData(x, y, z, traceName);
		template.setTitle(title);
		template.setXLabel(xLabel);
		template.setYLabel(yLabel);
		template.setYLabel(zLabel);
		template.export(filePath);
		PlotlifyUtils.openInBrowser(filePath);
	}
	
	public static void sphere(String filePath, double D, double x_0, double y_0, double z_0, int res) {
		
		SemiSphere ss1 = new SemiSphere.Builder()
				.D(D)
				.x_0(x_0)
				.y_0(y_0)
				.z_0(z_0)
				.top(true)
				.build();
		
		SemiSphere ss2 = new SemiSphere.Builder()
				.D(D)
				.x_0(x_0)
				.y_0(y_0)
				.z_0(z_0)
				.top(false)
				.build();
		
		double[] t1 = ArUtils.linspace(0.0, 1.0, res);
		double[] t2 = ArUtils.linspace(0.0, 1.0, res);
		
		ss1.create(t1, t2);
		ss2.create(t1, t2);
		
		double[] x1 = ss1.x();
		double[] y1 = ss1.y();
		double[] z1 = ss1.z();
		
		double[] x2 = ss2.x();
		double[] y2 = ss2.y();
		double[] z2 = ss2.z();
		
		SurfaceTemplate template = new SurfaceTemplate();
		template.load();
		template.setPlotType(PlotType.MESH3D);
		template.setData(x1, y1, z1, "");
		template.addData(x2, y2, z2, "", null, PlotType.MESH3D);
		template.setXLabel("X");
		template.setYLabel("Y");
		template.setYLabel("Z");
		template.export(filePath);
		PlotlifyUtils.openInBrowser(filePath);
	}
	
}
