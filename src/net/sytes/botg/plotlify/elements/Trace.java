package net.sytes.botg.plotlify.elements;

import com.google.gson.Gson;

import net.sytes.botg.array.Ar;
import net.sytes.botg.array.math.Scalar;
import net.sytes.botg.array.math.Vec;

public class Trace {
	
	private Object[] x;
	private Object[] y;
	private Object[] z;
		
	private String mode = null;	
	private String type = null;	
	private String name = null;	
	private Line line = null;	
	private String[] text = null;	
	private TextFont font = null;
	private String textposition = null;	
	private Marker marker = null;	
	private double opacity = 1.0;
	
	/**
	 * ----- properties for cone -------
	 * additional coordinate data objects, controlling e.g. cones / directional vectors
	 */
	private Object[] u;
	private Object[] v;
	private Object [] w;
	
	/**
	 * used for hiding colorbar in case of cone
	 */
	private boolean showscale = false;
	
	/**
	 * to set the colors of the cone, if unicolor than set first and second element to same rgb colors
	 */
	private Object[] colorscale;
	
	/**
	 * axis names in case of subplot functionality
	 */
	protected String xaxis = null;
	protected String yaxis = null;
	protected String zaxis = null;
	
	private static int TRACE_NUM = 0;
		
	public Trace() {
		++TRACE_NUM;
		this.name = "trace" + TRACE_NUM;
	}
	
	public Object[] x() {
		return this.x;
	}

	public Trace x(Object[] x) {
		this.x = x;
		return this;
	}
	
	public Trace x(double[] x) {
		this.x = Ar.wrap(x);
		return this;
	}

	public Object[] y() {
		return this.y;
	}

	public Trace y(Object[] y) {
		this.y = y;
		return this;
	}
	
	public Trace y(double[] y) {
		this.y = Ar.wrap(y);
		return this;
	}

	public Object[] z() {
		return this.z;
	}

	public Trace z(Object[] z) {
		this.z = z;
		return this;
	}
	
	public Trace z(double[] z) {
		this.z = Ar.wrap(z);
		return this;
	}
	
	public Trace z(double[][] z) {
		this.z = new Object[z.length];
		for (int i = 0; i < z.length; i++) {
			this.z[i] = Ar.toObjects(Ar.wrap(z[i])); 
		}
		return this;		
	}
	
	public void forcePrecision(int precision) {
		if (this.x != null) {
			for (int i = 0; i < this.x.length; i++) {
				this.x[i] = Scalar.roundToDecimals((double) this.x[i], precision);
			}
		}
		if (this.y != null) {
			for (int i = 0; i < this.y.length; i++) {
				this.y[i] = Scalar.roundToDecimals((double) this.y[i], precision);
			}
		}
		if (this.z != null) {
			if (Vec.isArray(this.z[0])) {
				for (int i = 0; i < this.z.length; i++) {
					Object[] objs = (Object[]) this.z[i];
					for (int j = 0; j < objs.length; j++) {
						objs[j] = Scalar.roundToDecimals((double) objs[j], precision);
					}
					this.z[i] = objs;
				}
			} else {
				for (int i = 0; i < this.z.length; i++) {
					this.z[i] = Scalar.roundToDecimals((double) this.z[i], precision);
				}
			}
		}
	}
	
	public Object[] u() {
		return this.u;
	}

	public Trace u(Object[] u) {
		this.u = u;
		return this;
	}
	
	public Trace u(double[] u) {
		this.u = Ar.wrap(u);
		return this;
	}	

	public Object[] v() {
		return this.v;
	}

	public Trace v(Object[] v) {
		this.v = v;
		return this;
	}
	
	public Trace v(double[] v) {
		this.v = Ar.wrap(v);
		return this;
	}

	public Object[] w() {
		return this.z;
	}

	public Trace w(Object[] w) {
		this.w = w;
		return this;
	}
	
	public Trace w(double[] w) {
		this.w = Ar.wrap(w);
		return this;
	}

	public Trace colorscale(Object[] colorscale) {
		this.colorscale = colorscale;
		return this;
	}
	
	public String mode() {
		return this.mode;
	}

	public Trace mode(Mode mode) {
		this.mode = mode.toString();
		return this;
	}

	public String type() {
		return this.type;
	}

	public Trace type(PlotType type) {
		this.type = type.toString();
		return this;
	}

	public String name() {
		return this.name;
	}

	public Trace name(String name) {
		this.name = name;
		return this;
	}

	public String[] text() {
		return text;
	}

	public Trace text(String[] text) {
		this.text = text;
		return this;
	}

	public TextFont font() {
		if (this.font == null) {
			this.font = new TextFont();
		}
		return font;
	}

	public Trace font(TextFont font) {
		this.font = font;
		return this;
	}

	public String textPosition() {
		return this.textposition;
	}

	public Trace textPosition(TextPosition textposition) {
		this.textposition = textposition.toString();
		return this;
	}

	/**
	 * returns the {@code Line} object within {@code Trace},
	 * <br>if no {@code Line} was created so far, a new one is instantiated and returned
	 * @return
	 */
	public Line line() {
		if (this.line == null) {
			this.line = new Line();
		}
		return this.line;
	}
	
	public Trace line(Line line) {
		this.line = line;
		return this;
	}
	
	public Marker marker() {
		if (this.marker == null) {
			this.marker = new Marker();
		}
		return marker;
	}

	public Trace marker(Marker marker) {
		this.marker = marker;
		return this;
	}
	
	public double opacity() {
		return this.opacity; 
	}
	
	/**
	 * sets the transparency of a trace
	 * <br>opacity = 0.0, completely transparent / invisible
	 */
	public Trace opacity(double opacity) {
		if (opacity > 1.0 || opacity < 0.0) {
			throw new IllegalArgumentException("opacity must be in range of 0.0 to 1.0");
		}
		this.opacity = opacity;
		return this;
	}
	
	public String toJson() {
		return new Gson().toJson(this);
	}

}
