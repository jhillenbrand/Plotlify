package net.sytes.botg.plotlify;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.sytes.botg.array.Ar;
import net.sytes.botg.array.geometry.Plane;
import net.sytes.botg.array.geometry.SemiSphere;
import net.sytes.botg.array.math.Vec;
import net.sytes.botg.plotlify.elements.AngleRef;
import net.sytes.botg.plotlify.elements.Color;
import net.sytes.botg.plotlify.elements.Mode;
import net.sytes.botg.plotlify.elements.PlotType;
import net.sytes.botg.plotlify.elements.Plotly;
import net.sytes.botg.plotlify.elements.Symbol;
import net.sytes.botg.plotlify.elements.TextPosition;
import net.sytes.botg.plotlify.elements.Trace;

public class Plotlify { 
	
	/**
	 * creates a line plot based on the double array passed with {@code y}
	 * @param y
	 * @throws IOException
	 */
	public static PlotlyDocument line(double[] y) throws IOException {
		return line(null, y, "trace1", null, null, null);
	}
		
	/**
	 * creates a line plot based on the double arrays passed with {@code x} and {@code y}
	 * @param x
	 * @param y
	 * @throws IOException 
	 */
	public static PlotlyDocument line(double[] x, double[] y) throws IOException {
		return line(x, y, "trace1", null, null, null);
	}
	
	/**
	 * creates a line plot based on the double arrays passed with {@code x} and {@code y}
	 * <br>{@code title} can be used to specify the plot's title
	 * @param x
	 * @param y
	 * @param title
	 * @throws IOException 
	 */
	public static PlotlyDocument line(double[] x, double[] y, String title) throws IOException {
		return line(x, y, "trace1", title, null, null);
	}
	
	/**
	 * creates a line plot based on the double arrays passed with {@code x} and {@code y}
	 * <br>{@code traceName} can be used to specify the legend entry for the specified data
	 * <br>{@code title} can be used to specify the plot's title
	 * <br>{@code xLabel} and {@code yLabel} can be used to specify the plot's axis labels
	 * @param x
	 * @param y
	 * @param traceName
	 * @param title
	 * @param xLabel
	 * @param yLabel
	 * @throws IOException 
	 */
	public static PlotlyDocument line(double[] x, double[] y, String traceName, String title, String xLabel, String yLabel) throws IOException {
		
		Plotly p = new Plotly();
		
		p.layout().title(title);
		p.layout().xAxis().title(xLabel);
		p.layout().yAxis().title(yLabel);
		
		p.trace(traceName).type(PlotType.SCATTER);
		p.trace(traceName).mode(Mode.LINES);
		p.trace(traceName).x(x);
		p.trace(traceName).y(y);
		
		PlotlyDocument pDoc = new PlotlyDocument(p);
				
		return pDoc;
	}
	
	/**
	 * create 3D line plot based on the double arrays passed with {@code x}, {@code y} and {@code z}
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
	public static PlotlyDocument line(double[] x, double[] y, double[] z) throws IOException {
		return line(x, y, z, "trace1", null, null, null, null);
	}
	
	/**
	 * create 3D line plot based on the double arrays passed with {@code x}, {@code y} and {@code z}
	 * <br>{@code traceName} can be used to specify the legend entry for the specified data
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
	public static PlotlyDocument line(double[] x, double[] y, double[] z, String traceName) throws IOException {
		return line(x, y, z, traceName, null, null, null, null);
	}
	
	/**
	 * create 3D line plot based on the double arrays passed with {@code x}, {@code y} and {@code z}
	 * <br>{@code traceName} can be used to specify the legend entry for the specified data
	 * <br>{@code title} can be used to specify the plot's title
	 * <br>{@code xLabel}, {@code xLabel} and {@code zLabel} can be used to specify the plot's axis labels
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
	public static PlotlyDocument line(double[] x, double[] y, double[] z, String traceName, String title, String xLabel, String yLabel, String zLabel) throws IOException {

		Plotly p = new Plotly();
		
		p.layout().title(title);
		p.layout().scene().getXAxis().title(xLabel);
		p.layout().scene().getYAxis().title(yLabel);
		p.layout().scene().getZAxis().title(zLabel);
		
		p.trace(traceName).type(PlotType.SCATTER3D);
		p.trace(traceName).mode(Mode.LINES);
		p.trace(traceName).x(x);
		p.trace(traceName).y(y);
		p.trace(traceName).z(z);		
		
		PlotlyDocument pDoc = new PlotlyDocument(p);
				
		return pDoc;
	}
	
	/**
	 * plots multiple lines {@code y}
	 * @param y multiple double[] arrays of same length
	 * @throws IOException 
	 */
	public static PlotlyDocument lines(double[] ... y) throws IOException {		
		return lines(null, y, null, "Plotly", null, null);
	}
	
	/**
	 * plots multiple lines {@code y}
	 * @param y multiple double[] arrays of same length
	 * @throws IOException 
	 */
	public static PlotlyDocument lines(double[][] x, double[][] y) throws IOException {		
		return lines(x, y, null, "Plotly", null, null);
	}
	
	/**
	 * plots multiple lines defined by coordinates {@code x} and {@code y}
	 * <br>{@code traceNames} can be used to specify the legend entries for the specified lines
	 * <br>{@code title} can be used to specify the plot's title
	 * <br>{@code xLabel} and {@code xLabel} can be used to specify the plot's axis labels
	 * @param x
	 * @param y
	 * @param traceNames
	 * @param title
	 * @param xLabel
	 * @param yLabel
	 * @throws IOException
	 */
	public static PlotlyDocument lines(double[][] x, double[][] y, String[] traceNames, String title, String xLabel, String yLabel) throws IOException {
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
		
		p.layout().title(title);
		p.layout().xAxis().title(yLabel);
		p.layout().yAxis().title(yLabel);
		
		int m = y.length;
		for (int i = 0; i < m; i++) {
			p.trace(traceNames[i])
				.type(PlotType.SCATTER)
				.mode(Mode.LINES)
				.y(y[i]);
			if (x != null) {
				p.trace(traceNames[i]).x(x[i]);
			}
		}
				
		PlotlyDocument pDoc = new PlotlyDocument(p);
		
		return pDoc;
	}
	
	/**
	 * creates a scatter plot based on the double arrays passed with {@code x} and {@code y}
	 * @param x
	 * @param y
	 * @throws IOException 
	 */
	public static PlotlyDocument scatter(double[] x, double[] y) throws IOException {
		return scatter(x, y, "trace1", null, null, null);
	}
	
	/**
	 * creates a scatter plot based on the double arrays passed with {@code x} and {@code y}
	 * <br>{@code title} can be used to specify the plot's title
	 * @param x
	 * @param y
	 * @param title
	 * @throws IOException 
	 */
	public static PlotlyDocument scatter(double[] x, double[] y, String title) throws IOException {
		return scatter(x, y, "trace1", title, null, null);
	}
	
	/**
	 * creates a scatter plot based on the double arrays passed with {@code x} and {@code y}
	 * <br>{@code traceName} can be used to specify the legend entry for the specified data
	 * <br>{@code title} can be used to specify the plot's title
	 * <br>{@code xLabel} and {@code xLabel} can be used to specify the plot's axis labels
	 * @param x
	 * @param y
	 * @param traceName
	 * @param title
	 * @param xLabel
	 * @param yLabel
	 * @throws IOException 
	 */
	public static PlotlyDocument scatter(double[] x, double[] y, String traceName, String title, String xLabel, String yLabel) throws IOException {
		
		Plotly p = new Plotly();
		
		p.layout().title(title);
		p.layout().xAxis().title(xLabel);
		p.layout().yAxis().title(yLabel);
		
		p.trace(traceName).type(PlotType.SCATTER);
		p.trace(traceName).mode(Mode.MARKERS);
		p.trace(traceName).x(x);
		p.trace(traceName).y(y);
		
		PlotlyDocument pDoc = new PlotlyDocument(p);
				
		return pDoc;
	}
	
	/**
	 * creates a scatter 3D plot based on the Double arrays passed with {@code x}, {@code y} and {@code z}
	 * @param x
	 * @param y
	 * @param z
	 * @throws IOException 
	 */
	public static PlotlyDocument scatter3D(Double[] x, Double[] y, Double[] z) throws IOException {
		return scatter3D(Ar.unwrap(x), Ar.unwrap(y), Ar.unwrap(z), "trace1", null, null, null, null);
	}
	
	/**
	 * creates a scatter 3D plot based on the double arrays passed with {@code x}, {@code y} and {@code z}
	 * @param x
	 * @param y
	 * @param z
	 * @throws IOException 
	 */
	public static PlotlyDocument scatter3D(double[] x, double[] y, double[] z) throws IOException {
		return scatter3D(x, y, z, "trace1", null, null, null, null);
	}
	
	/**
	* creates a scatter 3D plot based on the double arrays passed with {@code x}, {@code y} and {@code z}
	 * <br>{@code title} can be used to specify the plot's title
	 * @param x
	 * @param y
	 * @param z
	 * @param title
	 * @throws IOException 
	 */
	public static PlotlyDocument scatter3D(double[] x, double[] y, double[] z, String title) throws IOException {
		return scatter3D(x, y, z, "trace1", title, null, null, null);
	}
	
	/**
	  * creates a scatter 3D plot based on the double arrays passed with {@code x}, {@code y} and {@code z}
	 * <br>{@code traceName} can be used to specify the legend entry for the specified data
	 * <br>{@code title} can be used to specify the plot's title
	 * <br>{@code xLabel}, {@code xLabel} and {@code zLabel} can be used to specify the plot's axis labels
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
	public static PlotlyDocument scatter3D(double[] x, double[] y, double[] z, String traceName, String title, String xLabel, String yLabel, String zLabel) throws IOException {
		
		Plotly p = new Plotly();
		
		p.layout().title(title);
		p.layout().scene().getXAxis().title(xLabel);
		p.layout().scene().getYAxis().title(yLabel);
		p.layout().scene().getZAxis().title(zLabel);
		
		p.trace(traceName).type(PlotType.SCATTER3D);
		p.trace(traceName).mode(Mode.MARKERS);
		p.trace(traceName).x(x);
		p.trace(traceName).y(y);
		p.trace(traceName).z(z);		
		
		PlotlyDocument pDoc = new PlotlyDocument(p);
				
		return pDoc;
	}
	
	/**
	 * creates a surface plot based on {@code x}, {@code y} and {@code z}, where {@code z} = [m x n] with {@code x} = [n] and {@code y} = [m]
	 * @param x
	 * @param y
	 * @param z
	 * @throws IOException 
	 */
	public static PlotlyDocument surface(double[] x, double[] y, double[][] z) throws IOException {
		return surface(x, y, z, "surf1", "Surface Plot", "X", "Y", "Z");
	}
	
	/**
	 * creates a surface plot based on {@code x}, {@code y} and {@code z}, where {@code z} = [m x n] with {@code x} = [n] and {@code y} = [m]
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
	public static PlotlyDocument surface(double[] x, double[] y, double[][] z, String traceName, String title, String xLabel, String yLabel, String zLabel) throws IOException {
		
		Plotly p = new Plotly();
		
		p.layout().title(title);
		p.layout().scene().getXAxis().title(xLabel);
		p.layout().scene().getYAxis().title(yLabel);
		p.layout().scene().getZAxis().title(zLabel);
		
		p.trace(traceName).type(PlotType.SURFACE);
		p.trace(traceName).x(x);
		p.trace(traceName).y(y);
		p.trace(traceName).z(z);		
		
		PlotlyDocument pDoc = new PlotlyDocument(p);
		return pDoc;
	}
	
	/**
	 * creates a 3D mesh of the inserted coordinates {@code x, y, z}
	 * @param x
	 * @param y
	 * @param z
	 * @throws IOException 
	 */
	public static PlotlyDocument mesh3d(double[] x, double[] y, double[] z) throws IOException {
		return mesh3d(x, y, z, null, null, null, null, null);
	}
	
	/**
	 * creates a 3D mesh of the inserted coordinates {@code x, y, z} with {@code traceName} and {@code title}
	 * <br>axis labels are specified by {@code xLabel, yLabel, zLabel}
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
	public static PlotlyDocument mesh3d(double[] x, double[] y, double[] z, String traceName, String title, String xLabel, String yLabel, String zLabel) throws IOException {
		
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
		
		p.layout().title(title);
		p.layout().scene().getXAxis().title(xLabel);
		p.layout().scene().getYAxis().title(yLabel);
		p.layout().scene().getZAxis().title(zLabel);
		
		p.trace(traceName).type(PlotType.MESH3D);
		p.trace(traceName).x(x);
		p.trace(traceName).y(y);
		p.trace(traceName).z(z);		
		
		PlotlyDocument pDoc = new PlotlyDocument(p);
		
		return pDoc;
	}
	
	public static PlotlyDocument sphere(double D, double x_0, double y_0, double z_0, int res) throws IOException {
		
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
		
		p.layout().xAxis().title("X");
		p.layout().yAxis().title("Y");
				
		p.trace("s1").type(PlotType.MESH3D);
		p.trace("s1").x(x1);
		p.trace("s1").y(y1);
		p.trace("s1").z(z1);
		
		p.trace("s2").type(PlotType.MESH3D);
		p.trace("s2").x(x2);
		p.trace("s2").y(y2);
		p.trace("s2").z(z2);
		
		PlotlyDocument pDoc = new PlotlyDocument(p);
		
		return pDoc;
	}
	
	/**
	 * creates a 3D plane defined by normal vector {@code n} and {@code r0} a point on the plane
	 * @param n Example: n = new double[]{ 1, 1, 1};
	 * @param r0 Example: r0 = new double[]{ 0, 0, 1};
	 * @return
	 * @throws IOException
	 */
	public static PlotlyDocument plane(double[] n, double[] r0, double width, double length) throws IOException {
		if (n.length != 3 || r0.length != 3) {
			throw new IllegalArgumentException("vectors n and r0 must be of length 3");
		}
		
		Plane plane = new Plane.Builder()
				.nx(n[0])
				.ny(n[1])
				.nz(n[2])
				.x0(r0[0])
				.y0(r0[1])
				.z0(r0[2])
				.xmin(r0[0] - width / 2.0)
				.xmax(r0[0] + width / 2.0)
				.ymin(r0[1] - length / 2.0)
				.ymax(r0[1] + length / 2.0)
				.build();
		
		double[] t1 = Vec.linspace(0.0, 1.0, 2);
		double[] t2 = Vec.linspace(0.0, 1.0, 2);
		
		plane.create(t1, t2);
		
		Plotly p = new Plotly();
		
		p.layout().xAxis().title("X");
		p.layout().yAxis().title("Y");
		p.layout().zAxis().title("Z");
				
		p.trace("plane1").type(PlotType.MESH3D);
		p.trace("plane1").x(plane.x());
		p.trace("plane1").y(plane.y());
		p.trace("plane1").z(plane.z());
		
		PlotlyDocument pDoc = new PlotlyDocument(p);
		return pDoc;
	}
	
	/**
	 * create a text annotation defined at locations {@code x, y, z} with labels in {@code labels}
	 * @param x
	 * @param y
	 * @param z
	 * @param labels
	 * @return
	 */
	public static Trace annotation(double[] x, double[] y, double[] z, String[] labels) {
		if (x.length != labels.length) {
			throw new IllegalArgumentException("length of x does not match the number of labels");
		}
		
		Trace tr = new Trace();
		
		tr.x(x).y(y).z(z).mode(Mode.LINES_TEXT).text(labels).textPosition(TextPosition.TOP);
		
		if (z != null) {
			tr.type(PlotType.SCATTER3D);
		} else {
			tr.type(PlotType.SCATTER);
		}
		
		// make the line to hide it
		tr.opacity(1.0);
		
		return tr;
	}
	
	
	/**
	 * create a arrow trace based on start and end coordinates
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param color
	 * @return
	 */
	public static Trace arrow(double x1, double y1, double x2, double y2, Color color) {
		Trace tr = new Trace();		
		tr.x(new double[] {x1, x2}).y(new double[]{y1, y2});
		tr.type(PlotType.SCATTER).mode(Mode.LINES_MARKERS);
		if (color != null) {
			tr.line().color(color);
		}
		tr.marker().symbol(Symbol.ARROW).angleRef(AngleRef.PREVIOUS);
		
		return tr;
	}
	
	
	/**
	 * create a 3D arrow consisting of a line and cone trace based on start and end coordinates
	 * @param x1
	 * @param y1
	 * @param z1
	 * @param x2
	 * @param y2
	 * @param z2
	 * @param color
	 * @return
	 */
	public static List<Trace> arrow3D(double x1, double y1, double z1, double x2, double y2, double z2, Color color) {
		// compute length of vector
		double[] p1 = new double[] {x1, y1, z1};
		double[] p2 = new double[] {x2, y2, z2};
		double len = Vec.distance(p1, p2);
		
		// directional vector
		double[] dv = Vec.directionalVector(p1, p2, true);
		
		// make the arrow head / cone 2/10 of the arrow length
		double[] av = Vec.product(dv, 2.0 / 10.0 * len);
		
		// new end coordinates of line
		double[] p2_ = Vec.plus(p1, Vec.product(dv, 8.0 / 10.0 * len));
		
		Trace lineTrace = new Trace();		
		lineTrace.x(new double[] {p1[0], p2_[0]}).y(new double[]{p1[1], p2_[1]}).z(new double[] {p1[2], p2_[2]});
		lineTrace.type(PlotType.SCATTER3D).mode(Mode.LINES);
		if (color != null) {
			lineTrace.line().color(color);
		}
		
		Trace coneTrace = new Trace();
		coneTrace.x(new double[]{p2_[0]}).y(new double[]{p2_[1]}).z(new double[]{p2_[2]}).u(new double[]{av[0]}).v(new double[]{av[1]}).w(new double[]{av[2]});
		coneTrace.type(PlotType.CONE);
		
		// assemble the colorscale for unicolor cone
		Object[] colorScale = new Object[2];
		Object[] o1 = new Object[2];
		Object[] o2 = new Object[2];
		o1[0] = 0;
		o1[1] = color.toString();
		o2[0] = 1;
		o2[1] = color.toString();
		colorScale[0] = o1;
		colorScale[1] = o2;
		coneTrace.colorscale(colorScale);
		
		List<Trace> traces = new ArrayList<Trace>();
		traces.add(lineTrace);
		traces.add(coneTrace);
		return traces;
	}	
	
	/**
	 * creates traces for a coordinate system at {@code origin} defined by {@code unitVectors} and their {@code labels} of {@code length} and {@code color}
	 * @param origin
	 * @param unitVectors	3 x 3 matrix or 2 x 2 matrix, containing the unit vectors for each axis of an orthogonal coordinate system, unitVectors[0] --> x-axis, unitVectors[1] --> y-axis, unitVectors[2] --> z-axis 
	 * @param length	length of the axes arrows
	 * @param color	color of the axes arrows
	 * @return
	 */
	public static List<Trace> cos(double[] origin, double[][] unitVectors, String[] labels, double length, Color color){
		if (unitVectors == null) {
			throw new IllegalArgumentException("unitVectors must not be NULL");
		}
		if (unitVectors[0] != null) {
			throw new IllegalArgumentException("elements of unitVectors must not be NULL");
		}
		Vec.checkForEqualDimensions(origin, unitVectors[0]);
		if (origin.length != unitVectors.length) {
			throw new IllegalArgumentException("dimension of origin and unitVectors does not match");
		}

		List<Trace> traces = new ArrayList<Trace>();
		
		if (origin.length == 2) {
			
		} else if (origin.length == 3) {

			double[] e1 = Vec.plus(origin, Vec.product(unitVectors[0], length));
			double[] e2 = Vec.plus(origin, Vec.product(unitVectors[1], length));
			double[] e3 = Vec.plus(origin, Vec.product(unitVectors[2], length));
			
		} else {
			throw new IllegalArgumentException("method cos is undefined for dimension " + origin.length);
		}	
				
		return traces;
	}
	
}
