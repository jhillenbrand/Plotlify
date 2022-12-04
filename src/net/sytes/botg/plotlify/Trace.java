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
	
	private static int TRACE_NUM = 0;
		
	public Trace() {
		++TRACE_NUM;
		this.name = "trace" + TRACE_NUM;
	}
	
	public Object[] getX() {
		return x;
	}

	public void setX(Object[] x) {
		this.x = x;
	}
	
	public void setX(double[] x) {
		this.x = ConvertArray.wrap(x);
	}

	public Object[] getY() {
		return y;
	}

	public void setY(Object[] y) {
		this.y = y;
	}
	
	public void setY(double[] y) {
		this.y = ConvertArray.wrap(y);
	}

	public Object[] getZ() {
		return z;
	}

	public void setZ(Object[] z) {
		this.z = z;
	}
	
	public void setZ(double[] z) {
		this.z = ConvertArray.wrap(z);
	}

	public String getMode() {
		return this.mode;
	}

	public void setMode(Mode mode) {
		this.mode = mode.toString();
	}

	public String getType() {
		return type;
	}

	public void setType(PlotType type) {
		this.type = type.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getText() {
		return text;
	}

	public void setText(String[] text) {
		this.text = text;
	}

	public TextFont getFont() {
		return font;
	}

	public void setFont(TextFont font) {
		this.font = font;
	}

	public String getTextPosition() {
		return textposition;
	}

	public void setTextPosition(String textposition) {
		this.textposition = textposition;
	}

	public Marker getMarker() {
		return marker;
	}

	public void setMarker(Marker marker) {
		this.marker = marker;
	}
	
	public String toJson() {
		return new Gson().toJson(this);
	}

}
