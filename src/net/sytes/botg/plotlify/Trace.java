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
	
	private String[] text = null;
	
	private TextFont font = null;
	private String textposition = null;
	
	private Marker marker = null;
	
	private double opacity = 0.0;
	
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
		return type;
	}

	public Trace setType(PlotType type) {
		this.type = type.toString();
		return this;
	}

	public String getName() {
		return name;
	}

	public Trace setName(String name) {
		this.name = name;
		return this;
	}

	public String[] getText() {
		return text;
	}

	public Trace setText(String[] text) {
		this.text = text;
		return this;
	}

	public TextFont getFont() {
		return font;
	}

	public Trace setFont(TextFont font) {
		this.font = font;
		return this;
	}

	public String getTextPosition() {
		return textposition;
	}

	public Trace setTextPosition(String textposition) {
		this.textposition = textposition;
		return this;
	}

	public Marker getMarker() {
		return marker;
	}

	public Trace setMarker(Marker marker) {
		this.marker = marker;
		return this;
	}
	
	public double getOpacity() {
		return this.opacity; 
	}
	
	public Trace setOpacity(double opacity) {
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
