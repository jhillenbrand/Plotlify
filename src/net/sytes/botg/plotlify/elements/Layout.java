package net.sytes.botg.plotlify.elements;

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
	
	private String plot_bgcolor = null;
	private String paper_bgcolor = null;
	
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
	public Layout equalAxis() {
		
		if (this.yaxis == null) {
			this.yaxis = new Axis();
		}
		//if (this.zaxis == null) {
		//	this.zaxis = new Axis();
		//}
		
		this.yaxis.scaleAnchor("x");
		this.yaxis.setScaleRatio(1);
		
		//this.zaxis.setScaleAnchor("x");
		//this.zaxis.setScaleRatio(1);
		
		return this;
	}
		
	/**
	 * sets the scale of the axes to be equal for 3D plots
	 */
	public Layout equalAxis3D() {
		
		if (this.scene == null) {
			this.scene = new Scene();
		}
		
		//this.scene.aspectMode(AspectMode.MANUAL).aspectRatio().x(1.0).y(1.0).z(1.0);
		this.scene.aspectMode(AspectMode.DATA);
		
		return this;
	}
	
	/**
	 * return this {@code Axis}
	 * <br>if no {@code Axis} was specified yet, a new one is created and returned
	 * @return
	 */
	public Axis xAxis() {
		if (this.xaxis == null) {
			this.xaxis = new Axis();
		}
		return this.xaxis;
	}

	public Layout xAxis(Axis xAxis) {
		this.xaxis = xAxis;
		return this;
	}

	/**
	 * return this {@code Axis}
	 * <br>if no {@code Axis} was specified yet, a new one is created and returned
	 * @return
	 */
	public Axis yAxis() {
		if (this.yaxis == null) {
			this.yaxis = new Axis();
		}
		return this.yaxis;
	}

	public Layout yAxis(Axis yAxis) {
		this.yaxis = yAxis;
		return this;
	}
	
	/**
	 * return this {@code Axis}
	 * <br>if no {@code Axis} was specified yet, a new one is created and returned
	 * @return
	 */
	public Axis zAxis() {
		if (this.zaxis == null) {
			this.zaxis = new Axis();
		}
		return this.zaxis;
	}

	public Layout zAxis(Axis zAxis) {
		this.zaxis = zAxis;
		return this;
	}
	
	public Scene scene() {
		if (this.scene == null) {
			this.scene = new Scene();
		} 
		return this.scene;
	}

	public Legend legend() {
		return this.legend;
	}

	public Layout legend(Legend legend) {
		this.legend = legend;
		return this;
	}

	public String title() {
		return title;
	}

	public Layout title(String title) {
		this.title = title;
		return this;
	}
	
	public int height() {
		return this.height;
	}

	public Layout height(int height) {
		this.height = height;
		this.autosize = false;
		return this;
	}

	public int width() {
		return this.width;
	}

	public Layout width(int width) {
		this.width = width;
		this.autosize = false;
		return this;
	}

	public boolean showLegend() {
		return this.showlegend;
	}

	public Layout showLegend(boolean showlegend) {
		this.showlegend = showlegend;
		return this;
	}

	/**
	 * return this {@code Grid}
	 * <br>if no {@code Grid} was specified yet, a new one is created and returned
	 * @return
	 */
	public Grid grid() {
		if (this.grid == null) {
			this.grid = new Grid();
		}
		return this.grid;
	}

	public Layout grid(Grid grid) {
		this.grid = grid;
		return this;
	}

	/**
	 * return this {@code Margin}
	 * <br>if no {@code Margin} was specified yet, a new one is created and returned
	 * @return
	 */
	public Margin margin() {
		if (this.margin == null) {
			this.margin = new Margin();
		}
		return this.margin;
	}

	public Layout margin(Margin margin) {
		this.margin = margin;
		return this;
	}

	public boolean autosize() {
		return autosize;
	}

	public Layout autosize(boolean autosize) {
		this.autosize = autosize;
		return this;
	}
	
	public Layout backgroundColor(String color) {
		this.plot_bgcolor = color;
		return this;
	}
	
	public String backgroundColor() {
		return this.plot_bgcolor;
	}
	
	public Layout paperColor(String color) {
		this.paper_bgcolor = color;
		return this;
	}
	
	public String paperColor() {
		return this.paper_bgcolor;
	}
	
	public String toJson() {
		return new Gson().toJson(this);
	}
	
}
