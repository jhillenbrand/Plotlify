package net.sytes.botg.plotlify.elements;

public class Scene {

	private Axis xaxis = null;
	private Axis yaxis = null;
	private Axis zaxis = null;
	
	/**
	 * used to set the manual scaling mode, if same scale is required in (3D) plots
	 */
	private String aspectmode = null;
	
	/**
	 * can be used to set the axis to equal scale in (3D) plots
	 */
	private AspectRatio aspectratio = null;

	/**
	 * TODO can be used to specify the range of plot values on axes 
	 */
	private Domain domain = null;	
	
	public Scene(){
			
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

	public Scene setXAxis(Axis xAxis) {
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

	public Scene setYAxis(Axis yAxis) {
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

	public Scene setZAxis(Axis zAxis) {
		this.zaxis = zAxis;
		return this;
	}
	
	public AspectRatio aspectRatio() {
		if (this.aspectratio == null) {
			this.aspectratio = new AspectRatio();
		}
		return this.aspectratio;
	}
	
	public Scene aspectRatio(AspectRatio aspectRatio) {
		this.aspectratio = aspectRatio;
		return this;
	}
	
	public Scene aspectMode(AspectMode aspectMode) {
		this.aspectmode = aspectMode.toString();
		return this;
	}
	
	public String aspectMode() {
		return this.aspectmode;
	}
	
}
