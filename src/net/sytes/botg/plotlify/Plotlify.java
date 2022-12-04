package net.sytes.botg.plotlify;

import java.io.IOException;

import net.sytes.botg.array.ArUtils;
import net.sytes.botg.array.geometry.SemiSphere;
import net.sytes.botg.plotlify.templates.SurfaceTemplate;

public class Plotlify { 
		
	public static void line(String filePath, double[] y) throws IOException {
		double[] x = ArUtils.linspace(y.length);
		line(filePath, x, y, "trace1", null, null, null);
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
