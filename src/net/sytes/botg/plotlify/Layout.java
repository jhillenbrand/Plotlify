package net.sytes.botg.plotlify;

import com.google.gson.Gson;

public class Layout {

	private Scene scene = null;	// required for 3D charts, containing the axis definitions, code change at least since v2.18.0
	
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
		//if (this.zaxis == null) {
		//	this.zaxis = new Axis();
		//}
		
		this.yaxis.setScaleAnchor("x");
		this.yaxis.setScaleRatio(1);
		
		//this.zaxis.setScaleAnchor("x");
		//this.zaxis.setScaleRatio(1);
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

	public Layout setXAxis(Axis xAxis) {
		this.xaxis = xAxis;
		return this;
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

	public Layout setYAxis(Axis yAxis) {
		this.yaxis = yAxis;
		return this;
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

	public Layout setZAxis(Axis zAxis) {
		this.zaxis = zAxis;
		return this;
	}
	
	public Scene getScene() {
		if (this.scene == null) {
			this.scene = new Scene();
		} 
		return this.scene;
	}

	public Legend getLegend() {
		return legend;
	}

	public Layout setLegend(Legend legend) {
		this.legend = legend;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public Layout setTitle(String title) {
		this.title = title;
		return this;
	}
	
	public int getHeight() {
		return this.height;
	}

	public Layout setHeight(int height) {
		this.height = height;
		return this;
	}

	public int getWidth() {
		return this.width;
	}

	public Layout setWidth(int width) {
		this.width = width;
		return this;
	}

	public boolean isShowlegend() {
		return showlegend;
	}

	public Layout setShowlegend(boolean showlegend) {
		this.showlegend = showlegend;
		return this;
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

	public Layout setGrid(Grid grid) {
		this.grid = grid;
		return this;
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

	public Layout setMargin(Margin margin) {
		this.margin = margin;
		return this;
	}

	public boolean isAutosize() {
		return autosize;
	}

	public Layout setAutosize(boolean autosize) {
		this.autosize = autosize;
		return this;
	}

	public String toJson() {
		return new Gson().toJson(this);
	}
	
}
