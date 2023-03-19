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

	public String getTitle() {
		return title;
	}

	public Axis setTitle(String title) {
		this.title = title;
		return this;
	}
	
	public boolean isAutotick() {
		return autotick;
	}

	public Axis setAutotick(boolean autotick) {
		this.autotick = autotick;
		return this;
	}

	public boolean isZeroline() {
		return zeroline;
	}

	public void setZeroline(boolean zeroline) {
		this.zeroline = zeroline;
	}

	public boolean isShowline() {
		return showline;
	}

	public void setShowline(boolean showline) {
		this.showline = showline;
	}

	public boolean isShowgrid() {
		return showgrid;
	}

	public void setShowgrid(boolean showgrid) {
		this.showgrid = showgrid;
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

	public void setLinecolor(String linecolor) {
		this.linecolor = linecolor;
	}

	public String getScaleAnchor() {
		return scaleanchor;
	}

	public void setScaleAnchor(String scaleanchor) {
		this.scaleanchor = scaleanchor;
	}

	public int getScaleRatio() {
		return scaleratio;
	}

	public void setScaleRatio(int scaleratio) {
		this.scaleratio = scaleratio;
	}

	public String toJson() {
		return new Gson().toJson(this);
	}
	
}
