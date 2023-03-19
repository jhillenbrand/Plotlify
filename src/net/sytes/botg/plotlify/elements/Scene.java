package net.sytes.botg.plotlify.elements;

public class Scene {

	private Axis xaxis = null;
	private Axis yaxis = null;
	private Axis zaxis = null;

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
	
}
