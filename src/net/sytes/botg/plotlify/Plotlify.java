package net.sytes.botg.plotlify;

import java.io.IOException;

import net.sytes.botg.array.geometry.SemiSphere;
import net.sytes.botg.array.math.Mat;
import net.sytes.botg.array.math.Vec;

public class Plotlify { 
	
	/**
	 * creates a line plot based on the double array passed with {@code y} and exports it as html file under current path as plotly.html
	 * @param y
	 * @throws IOException
	 */
	public static void line(double[] y) throws IOException {
		line("plotly.html", null, y, "trace1", null, null, null);
	}
	
	/**
	 * creates a line plot based on the double arrays passed with {@code x} and {@code y} and exports it as html file under current path as plotly.html
	 * @param x
	 * @param y
	 * @throws IOException 
	 */
	public static void line(double[] x, double[] y) throws IOException {
		line("plotly.html", x, y, "trace1", null, null, null);
	}
	
	/**
	 * creates a line plot based on the double array passed with {@code y} and exports it as html file under specified {@code filePath}
	 * @param filePath
	 * @param y
	 * @throws IOException
	 */
	public static void line(String filePath, double[] y) throws IOException {
		line(filePath, null, y, "trace1", null, null, null);
	}
	
	/**
	 * creates a line plot based on the double arrays passed with {@code x} and {@code y} and exports it as html file under specified {@code filePath}
	 * @param filePath
	 * @param x
	 * @param y
	 * @throws IOException 
	 */
	public static void line(String filePath, double[] x, double[] y) throws IOException {
		line(filePath, x, y, "trace1", null, null, null);
	}
	
	/**
	 * creates a line plot based on the double arrays passed with {@code x} and {@code y} and exports it as html file under specified {@code filePath}
	 * <br>{@code title} can be used to specify the plot's title
	 * @param filePath
	 * @param x
	 * @param y
	 * @param title
	 * @throws IOException 
	 */
	public static void line(String filePath, double[] x, double[] y, String title) throws IOException {
		line(filePath, x, y, "trace1", title, null, null);
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
	 * @throws IOException 
	 */
	public static void line(String filePath, double[] x, double[] y, String traceName, String title, String xLabel, String yLabel) throws IOException {
		
		Plotly p = new Plotly();
		
		p.getLayout().setTitle(title);
		p.getLayout().getXAxis().setTitle(xLabel);
		p.getLayout().getYAxis().setTitle(yLabel);
		
		p.getTrace(traceName).type(PlotType.SCATTER);
		p.getTrace(traceName).setMode(Mode.LINES);
		p.getTrace(traceName).setX(x);
		p.getTrace(traceName).setY(y);
		
		PlotlyDocument pDoc = new PlotlyDocument();
		pDoc.addPlotly(p);
		
		pDoc.toFile(filePath);
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
	 * @throws IOException 
	 */
	public static void line(String filePath, double[] x, double[] y, double[] z, String traceName) throws IOException {
		line(filePath, x, y, z, traceName, null, null, null, null);
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
	 * @throws IOException 
	 */
	public static void line(String filePath, double[] x, double[] y, double[] z, String traceName, String title, String xLabel, String yLabel, String zLabel) throws IOException {

		Plotly p = new Plotly();
		
		p.getLayout().setTitle(title);
		p.getLayout().getScene().getXAxis().setTitle(xLabel);
		p.getLayout().getScene().getYAxis().setTitle(yLabel);
		p.getLayout().getScene().getZAxis().setTitle(zLabel);
		
		p.getTrace(traceName).type(PlotType.SCATTER3D);
		p.getTrace(traceName).setMode(Mode.LINES);
		p.getTrace(traceName).setX(x);
		p.getTrace(traceName).setY(y);
		p.getTrace(traceName).setZ(z);		
		
		PlotlyDocument pDoc = new PlotlyDocument();
		pDoc.addPlotly(p);
		
		pDoc.toFile(filePath);
	}
	
	/**
	 * plots multiple lines {@code y}
	 * @param y multiple double[] arrays of same length
	 * @throws IOException 
	 */
	public static void lines(double[] ... y) throws IOException {		
		lines("plotly.html", null, y, null, "Plotly", null, null);
	}
	
	/**
	 * plots multiple lines {@code y}
	 * @param y multiple double[] arrays of same length
	 * @throws IOException 
	 */
	public static void lines(double[][] x, double[][] y) throws IOException {		
		lines("plotly.html", x, y, null, "Plotly", null, null);
	}
	
	/**
	 * plots multiple lines defined by coordinates {@code x} and {@code y} and exports it as html file under specified {@code filePath}
	 * <br>{@code traceNames} can be used to specify the legend entries for the specified lines
	 * <br>{@code title} can be used to specify the plot's title
	 * <br>{@code xLabel} and {@code xLabel} can be used to specify the plot's axis labels
	 * @param filePath
	 * @param x
	 * @param y
	 * @param traceNames
	 * @param title
	 * @param xLabel
	 * @param yLabel
	 * @throws IOException
	 */
	public static void lines(String filePath, double[][] x, double[][] y, String[] traceNames, String title, String xLabel, String yLabel) throws IOException {
		if (x != null) {
			// check for correct dimensions
			// a) same rows
			if (x.length != y.length) {
				throw new IllegalArgumentException("coordinate arrays x(" + x.length + ") and y(" + y.length + ") do not have same number of rows");
			}
			// b) same number of entries per row
			for (int i = 0; i < x.length; i++) {
				if (x[i].length != y[i].length) {
					throw new IllegalArgumentException("row " + i + " (" + x[i].length + ") of x does not have the same number of entries as row " + i + " (" + y[i].length + ") in y.");
				}
			}
		}
		if (x == null) {
			Vec.checkForEqualDimensions(y);
		}
		// populate traceNames if nothing specified
		if (traceNames == null) {
			traceNames = new String[y.length];
			for (int t = 0; t < y.length; t++) {
				traceNames[t] = "trace" + t;
			}
		}
		if (traceNames.length != y.length) {
			throw new IllegalArgumentException("specified traceNames (" + traceNames.length + ") and specified line coordinate dimensions (" + y.length + ") not match");
		}
		
		Plotly p = new Plotly();
		
		p.getLayout().setTitle(title);
		p.getLayout().getXAxis().setTitle(yLabel);
		p.getLayout().getYAxis().setTitle(yLabel);
		
		int m = y.length;
		for (int i = 0; i < m; i++) {
			p.getTrace(traceNames[i])
				.type(PlotType.SCATTER)
				.setMode(Mode.LINES)
				.setY(y[i]);
			if (x != null) {
				p.getTrace(traceNames[i]).setX(x[i]);
			}
		}
				
		PlotlyDocument pDoc = new PlotlyDocument();
		pDoc.addPlotly(p);
		pDoc.toFile(filePath);
	}
	
	/**
	 * creates a scatter plot based on the double arrays passed with {@code x} and {@code y} and exports it as html file under specified {@code filePath}
	 * @param filePath
	 * @param x
	 * @param y
	 * @throws IOException 
	 */
	public static void scatter(String filePath, double[] x, double[] y) throws IOException {
		scatter(filePath, x, y, "trace1", null, null, null);
	}
	
	/**
	 * creates a scatter plot based on the double arrays passed with {@code x} and {@code y} and exports it as html file under specified {@code filePath}
	 * <br>{@code title} can be used to specify the plot's title
	 * @param filePath
	 * @param x
	 * @param y
	 * @param title
	 * @throws IOException 
	 */
	public static void scatter(String filePath, double[] x, double[] y, String title) throws IOException {
		scatter(filePath, x, y, "trace1", title, null, null);
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
	 * @throws IOException 
	 */
	public static void scatter(String filePath, double[] x, double[] y, String traceName, String title, String xLabel, String yLabel) throws IOException {
		
		Plotly p = new Plotly();
		
		p.getLayout().setTitle(title);
		p.getLayout().getXAxis().setTitle(xLabel);
		p.getLayout().getYAxis().setTitle(yLabel);
		
		p.getTrace(traceName).type(PlotType.SCATTER);
		p.getTrace(traceName).setMode(Mode.MARKERS);
		p.getTrace(traceName).setX(x);
		p.getTrace(traceName).setY(y);
		
		PlotlyDocument pDoc = new PlotlyDocument();
		pDoc.addPlotly(p);
		
		pDoc.toFile(filePath);
	}
	
	/**
	 * creates a scatter 3D plot based on the double arrays passed with {@code x}, {@code y} and {@code z} and exports it as plotly.html in current directory
	 * @param filePath
	 * @param x
	 * @param y
	 * @param z
	 * @throws IOException 
	 */
	public static void scatter3D(double[] x, double[] y, double[] z) throws IOException {
		scatter3D("plotly.html", x, y, z, "trace1", null, null, null, null);
	}
	
	/**
	 * creates a scatter 3D plot based on the double arrays passed with {@code x}, {@code y} and {@code z} and exports it as html file under specified {@code filePath}
	 * @param filePath
	 * @param x
	 * @param y
	 * @param z
	 * @throws IOException 
	 */
	public static void scatter3D(String filePath, double[] x, double[] y, double[] z) throws IOException {
		scatter3D(filePath, x, y, z, "trace1", null, null, null, null);
	}
	
	/**
	* creates a scatter 3D plot based on the double arrays passed with {@code x}, {@code y} and {@code z} and exports it as html file under specified {@code filePath}
	 * <br>{@code title} can be used to specify the plot's title
	 * @param filePath
	 * @param x
	 * @param y
	 * @param z
	 * @param title
	 * @throws IOException 
	 */
	public static void scatter3D(String filePath, double[] x, double[] y, double[] z, String title) throws IOException {
		scatter3D(filePath, x, y, z, "trace1", title, null, null, null);
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
	 * @throws IOException 
	 */
	public static void scatter3D(String filePath, double[] x, double[] y, double[] z, String traceName, String title, String xLabel, String yLabel, String zLabel) throws IOException {
		
		Plotly p = new Plotly();
		
		p.getLayout().setTitle(title);
		p.getLayout().getScene().getXAxis().setTitle(xLabel);
		p.getLayout().getScene().getYAxis().setTitle(yLabel);
		p.getLayout().getScene().getZAxis().setTitle(zLabel);
		
		p.getTrace(traceName).type(PlotType.SCATTER3D);
		p.getTrace(traceName).setMode(Mode.MARKERS);
		p.getTrace(traceName).setX(x);
		p.getTrace(traceName).setY(y);
		p.getTrace(traceName).setZ(z);		
		
		PlotlyDocument pDoc = new PlotlyDocument();
		pDoc.addPlotly(p);
		
		pDoc.toFile(filePath);
		
	}
	
	/**
	 * creates a surface plot based on {@code x}, {@code y} and {@code z}, where {@code z} = [m x n] with {@code x} = [n] and {@code y} = [m]
	 * @param filePath
	 * @param x
	 * @param y
	 * @param z
	 * @throws IOException 
	 */
	public static void surface(String filePath, double[] x, double[] y, double[][] z) throws IOException {
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
	 * @throws IOException 
	 */
	public static void surface(String filePath, double[] x, double[] y, double[][] z, String traceName, String title, String xLabel, String yLabel, String zLabel) throws IOException {
		
		Plotly p = new Plotly();
		
		p.getLayout().setTitle(title);
		p.getLayout().getScene().getXAxis().setTitle(xLabel);
		p.getLayout().getScene().getYAxis().setTitle(yLabel);
		p.getLayout().getScene().getZAxis().setTitle(zLabel);
		
		p.getTrace(traceName).type(PlotType.SURFACE);
		p.getTrace(traceName).setX(x);
		p.getTrace(traceName).setY(y);
		p.getTrace(traceName).setZ(z);		
		
		PlotlyDocument pDoc = new PlotlyDocument();
		pDoc.addPlotly(p);
		
		pDoc.toFile(filePath);
		
	}
	
	/**
	 * creates a 3D mesh of the inserted coordinates {@code x, y, z}
	 * @param x
	 * @param y
	 * @param z
	 * @throws IOException 
	 */
	public static void mesh3d(double[] x, double[] y, double[] z) throws IOException {
		mesh3d("plotly.html", x, y, z, null, null, null, null, null);
	}
	
	/**
	 * creates a 3D mesh of the inserted coordinates {@code x, y, z} with {@code traceName} and {@code title} and exports it under {@code filePath}
	 * <br>axis labels are specified by {@code xLabel, yLabel, zLabel}
	 * @param filePath
	 * @param x
	 * @param y
	 * @param z
	 * @param traceName
	 * @param title
	 * @param xLabel
	 * @param yLabel
	 * @param zLabel
	 * @throws IOException
	 */
	public static void mesh3d(String filePath, double[] x, double[] y, double[] z, String traceName, String title, String xLabel, String yLabel, String zLabel) throws IOException {
		
		if (traceName == null) {
			traceName = "mesh0";
		}
		if (title == null) {
			title = "Mesh";
		}
		if (xLabel == null) {
			xLabel = "x";
		}
		if (yLabel == null) {
			yLabel = "y";
		}
		if (zLabel == null) {
			zLabel = "z";
		}
		
		Plotly p = new Plotly();
		
		p.getLayout().setTitle(title);
		p.getLayout().getScene().getXAxis().setTitle(xLabel);
		p.getLayout().getScene().getYAxis().setTitle(yLabel);
		p.getLayout().getScene().getZAxis().setTitle(zLabel);
		
		p.getTrace(traceName).type(PlotType.MESH3D);
		p.getTrace(traceName).setX(x);
		p.getTrace(traceName).setY(y);
		p.getTrace(traceName).setZ(z);		
		
		PlotlyDocument pDoc = new PlotlyDocument();
		pDoc.addPlotly(p);
		
		pDoc.toFile(filePath);
		
	}
	
	public static void sphere(String filePath, double D, double x_0, double y_0, double z_0, int res) throws IOException {
		
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
		
		double[] t1 = Vec.linspace(0.0, 1.0, res);
		double[] t2 = Vec.linspace(0.0, 1.0, res);
		
		ss1.create(t1, t2);
		ss2.create(t1, t2);
		
		double[] x1 = ss1.x();
		double[] y1 = ss1.y();
		double[] z1 = ss1.z();
		
		double[] x2 = ss2.x();
		double[] y2 = ss2.y();
		double[] z2 = ss2.z();
		
		Plotly p = new Plotly();
		
		p.getLayout().getXAxis().setTitle("X");
		p.getLayout().getYAxis().setTitle("Y");
				
		p.getTrace("s1").type(PlotType.MESH3D);
		p.getTrace("s1").setX(x1);
		p.getTrace("s1").setY(y1);
		p.getTrace("s1").setZ(z1);
		
		p.getTrace("s2").type(PlotType.MESH3D);
		p.getTrace("s2").setX(x2);
		p.getTrace("s2").setY(y2);
		p.getTrace("s2").setZ(z2);
		
		PlotlyDocument pDoc = new PlotlyDocument();
		pDoc.addPlotly(p);
		
		pDoc.toFile(filePath);
		
	}
	
}
