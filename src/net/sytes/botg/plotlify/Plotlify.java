package net.sytes.botg.plotlify;

import java.io.IOException;

import net.sytes.botg.array.geometry.SemiSphere;
import net.sytes.botg.array.math.Vec;

public class Plotlify { 
		
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
		p.getLayout().getXAxis().setTitle(yLabel);
		p.getLayout().getYAxis().setTitle(yLabel);
		
		p.getTrace(traceName).setType(PlotType.SCATTER);
		p.getTrace(traceName).setMode(Mode.LINES);
		p.getTrace(traceName).setX(x);
		p.getTrace(traceName).setY(y);
		
		PlotlyDocument pDoc = new PlotlyDocument();
		pDoc.addPlotly(p);
		
		pDoc.toFile(filePath);
		
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
		p.getLayout().getXAxis().setTitle(xLabel);
		p.getLayout().getYAxis().setTitle(yLabel);
		p.getLayout().getZAxis().setTitle(zLabel);
		
		p.getTrace(traceName).setType(PlotType.SCATTER3D);
		p.getTrace(traceName).setMode(Mode.LINES);
		p.getTrace(traceName).setX(x);
		p.getTrace(traceName).setY(y);
		p.getTrace(traceName).setZ(z);		
		
		PlotlyDocument pDoc = new PlotlyDocument();
		pDoc.addPlotly(p);
		
		pDoc.toFile(filePath);
		
		PlotlifyUtils.openInBrowser(filePath);
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
		
		p.getTrace(traceName).setType(PlotType.SCATTER);
		p.getTrace(traceName).setMode(Mode.MARKERS);
		p.getTrace(traceName).setX(x);
		p.getTrace(traceName).setY(y);
		
		PlotlyDocument pDoc = new PlotlyDocument();
		pDoc.addPlotly(p);
		
		pDoc.toFile(filePath);
		
		PlotlifyUtils.openInBrowser(filePath);
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
		p.getLayout().getXAxis().setTitle(xLabel);
		p.getLayout().getYAxis().setTitle(yLabel);
		p.getLayout().getZAxis().setTitle(zLabel);
		
		p.getTrace(traceName).setType(PlotType.SCATTER3D);
		p.getTrace(traceName).setMode(Mode.MARKERS);
		p.getTrace(traceName).setX(x);
		p.getTrace(traceName).setY(y);
		p.getTrace(traceName).setZ(z);		
		
		PlotlyDocument pDoc = new PlotlyDocument();
		pDoc.addPlotly(p);
		
		pDoc.toFile(filePath);
		
		PlotlifyUtils.openInBrowser(filePath);
		
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
		p.getLayout().getXAxis().setTitle(xLabel);
		p.getLayout().getYAxis().setTitle(yLabel);
		p.getLayout().getZAxis().setTitle(zLabel);
		
		p.getTrace(traceName).setType(PlotType.SURFACE);
		p.getTrace(traceName).setX(x);
		p.getTrace(traceName).setY(y);
		p.getTrace(traceName).setZ(z);		
		
		PlotlyDocument pDoc = new PlotlyDocument();
		pDoc.addPlotly(p);
		
		pDoc.toFile(filePath);
		
		PlotlifyUtils.openInBrowser(filePath);
		
	}
	
	public static void mesh3d(String filePath, double[] x, double[] y, double[] z, String traceName, String title, String xLabel, String yLabel, String zLabel) throws IOException {
		
		Plotly p = new Plotly();
		
		p.getLayout().setTitle(title);
		p.getLayout().getXAxis().setTitle(xLabel);
		p.getLayout().getYAxis().setTitle(yLabel);
		p.getLayout().getZAxis().setTitle(zLabel);
		
		p.getTrace(traceName).setType(PlotType.MESH3D);
		p.getTrace(traceName).setX(x);
		p.getTrace(traceName).setY(y);
		p.getTrace(traceName).setZ(z);		
		
		PlotlyDocument pDoc = new PlotlyDocument();
		pDoc.addPlotly(p);
		
		pDoc.toFile(filePath);
		
		PlotlifyUtils.openInBrowser(filePath);
		
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
				
		p.getTrace("s1").setType(PlotType.MESH3D);
		p.getTrace("s1").setX(x1);
		p.getTrace("s1").setY(y1);
		p.getTrace("s1").setZ(z1);
		
		p.getTrace("s2").setType(PlotType.MESH3D);
		p.getTrace("s2").setX(x2);
		p.getTrace("s2").setY(y2);
		p.getTrace("s2").setZ(z2);
		
		PlotlyDocument pDoc = new PlotlyDocument();
		pDoc.addPlotly(p);
		
		pDoc.toFile(filePath);
		
		PlotlifyUtils.openInBrowser(filePath);
		
	}
	
}
