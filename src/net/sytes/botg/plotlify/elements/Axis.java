package net.sytes.botg.plotlify.elements;

import com.google.gson.Gson;

public class Axis {

	private double[] range = null;
	
	private String title = null;
	
	private String scaleanchor = null;
	private int scaleratio = 0;
	
    private boolean autotick = true;
    private boolean zeroline = true;
    private boolean showline = false; 
    private boolean showgrid = true;
    private String gridcolor = null;
    private boolean showticklabels = true;
    private String mirror = null;
    
    private String linecolor = null;
	
	public Axis() {
		
	}

	public double[] getRange() {
		return range;
	}

	public Axis setRange(double[] range) {
		this.range = range;
		return this;
	}

	public String title() {
		return title;
	}

	public Axis title(String title) {
		this.title = title;
		return this;
	}
	
	public boolean autotick() {
		return autotick;
	}

	public Axis autotick(boolean autotick) {
		this.autotick = autotick;
		return this;
	}

	public boolean zeroline() {
		return this.zeroline;
	}

	public Axis zeroline(boolean zeroline) {
		this.zeroline = zeroline;
		return this;
	}

	public boolean isShowline() {
		return showline;
	}

	public void setShowline(boolean showline) {
		this.showline = showline;
	}

	public boolean showgrid() {
		return this.showgrid;
	}

	public Axis showgrid(boolean showgrid) {
		this.showgrid = showgrid;
		return this;
	}
	
	public Axis gridColor(String gridColor) {
		this.gridcolor = gridColor;
		return this;
	}
	
	public String gridColor() {
		return this.gridcolor;
	}
	
	public Axis showTickLabels(boolean showTickLabels) {
		this.showticklabels = showTickLabels;
		return this;
	}
	
	public boolean showTickLabels() {
		return this.showticklabels;
	}

	public String getMirror() {
		return mirror;
	}

	public void setMirror(String mirror) {
		this.mirror = mirror;
	}

	public String getLinecolor() {
		return linecolor;
	}

	public void linecolor(String linecolor) {
		this.linecolor = linecolor;
	}

	public String scaleAnchor() {
		return scaleanchor;
	}

	public Axis scaleAnchor(String scaleanchor) {
		this.scaleanchor = scaleanchor;
		return this;
	}

	public int getScaleRatio() {
		return scaleratio;
	}

	public Axis setScaleRatio(int scaleratio) {
		this.scaleratio = scaleratio;
		return this;
	}

	public String toJson() {
		return new Gson().toJson(this);
	}
	
}
