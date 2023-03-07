package net.sytes.botg.plotlify;

import com.google.gson.Gson;

import net.sytes.botg.array.ConvertArray;

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
	
	private static int TRACE_NUM = 0;
		
	public Trace() {
		++TRACE_NUM;
		this.name = "trace" + TRACE_NUM;
	}
	
	public Object[] getX() {
		return x;
	}

	public Trace setX(Object[] x) {
		this.x = x;
		return this;
	}
	
	public Trace setX(double[] x) {
		this.x = ConvertArray.wrap(x);
		return this;
	}

	public Object[] getY() {
		return y;
	}

	public Trace setY(Object[] y) {
		this.y = y;
		return this;
	}
	
	public Trace setY(double[] y) {
		this.y = ConvertArray.wrap(y);
		return this;
	}

	public Object[] getZ() {
		return z;
	}

	public Trace setZ(Object[] z) {
		this.z = z;
		return this;
	}
	
	public Trace setZ(double[] z) {
		this.z = ConvertArray.wrap(z);
		return this;
	}
	
	public Trace setZ(double[][] z) {
		this.z = new Object[z.length];
		for (int i = 0; i < z.length; i++) {
			this.z[i] = ConvertArray.toObjects(ConvertArray.wrap(z[i])); 
		}
		return this;		
	}

	public String getMode() {
		return this.mode;
	}

	public Trace setMode(Mode mode) {
		this.mode = mode.toString();
		return this;
	}

	public String getType() {
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
		return textposition;
	}

	public Trace textPosition(String textposition) {
		this.textposition = textposition;
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
