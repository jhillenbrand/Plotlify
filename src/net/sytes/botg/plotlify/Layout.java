package net.sytes.botg.plotlify;

import java.awt.Dimension;
import java.awt.Toolkit;

import com.google.gson.Gson;

public class Layout {

	private Axis xaxis = null;
	private Axis yaxis = null;
	private Axis zaxis = null;
	
	private int height = 0;
	private int width = 0;
	
	private Legend legend = null;
	private boolean showlegend = false;
	
	private String title = null;

	private Grid grid = null;
	
	private Margin margin = null;
	
	private boolean autosize = true;
	
	
	public Layout() {
		// preset the plot size
		/*
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.width = (int) (screenSize.getWidth() * 0.98);
		this.height = (int) (screenSize.getHeight() * 0.80);
		*/
	}
	
	/**
	 * sets the scale of the axes to be equal
	 */
	public void equalAxis() {
		if (this.yaxis == null) {
			this.yaxis = new Axis();
		}
		this.yaxis.setScaleAnchor("x");
		this.yaxis.setScaleRatio(1);
	}
	
	/**
	 * return this {@code Axis}
	 * <br>if no {@code Axis} was specified yet, a new one is created and returned
	 * @return
	 */
	public Axis getXAxis() {
		if (this.xaxis == null) {
			this.xaxis = new Axis();
		}
		return this.xaxis;
	}

	public void setXAxis(Axis xAxis) {
		this.xaxis = xAxis;
	}

	/**
	 * return this {@code Axis}
	 * <br>if no {@code Axis} was specified yet, a new one is created and returned
	 * @return
	 */
	public Axis getYAxis() {
		if (this.yaxis == null) {
			this.yaxis = new Axis();
		}
		return this.yaxis;
	}

	public void setYAxis(Axis yAxis) {
		this.yaxis = yAxis;
	}
	
	/**
	 * return this {@code Axis}
	 * <br>if no {@code Axis} was specified yet, a new one is created and returned
	 * @return
	 */
	public Axis getZAxis() {
		if (this.zaxis == null) {
			this.zaxis = new Axis();
		}
		return this.zaxis;
	}

	public void setZAxis(Axis zAxis) {
		this.zaxis = zAxis;
	}

	public Legend getLegend() {
		return legend;
	}

	public void setLegend(Legend legend) {
		this.legend = legend;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getHeight() {
		return this.height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return this.width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public boolean isShowlegend() {
		return showlegend;
	}

	public void setShowlegend(boolean showlegend) {
		this.showlegend = showlegend;
	}

	/**
	 * return this {@code Grid}
	 * <br>if no {@code Grid} was specified yet, a new one is created and returned
	 * @return
	 */
	public Grid getGrid() {
		if (this.grid == null) {
			this.grid = new Grid();
		}
		return this.grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	/**
	 * return this {@code Margin}
	 * <br>if no {@code Margin} was specified yet, a new one is created and returned
	 * @return
	 */
	public Margin getMargin() {
		if (this.margin == null) {
			this.margin = new Margin();
		}
		return this.margin;
	}

	public void setMargin(Margin margin) {
		this.margin = margin;
	}

	public boolean isAutosize() {
		return autosize;
	}

	public void setAutosize(boolean autosize) {
		this.autosize = autosize;
	}

	public String toJson() {
		return new Gson().toJson(this);
	}
	
}
