package net.sytes.botg.plotlify.elements;

import com.google.gson.Gson;

public class Legend {

	private double y = 0.0;
	
	private String yref = null;
	
	private TextFont font = null;

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public String getYref() {
		return yref;
	}

	public void setYref(String yref) {
		this.yref = yref;
	}

	/**
	 * return this {@code TextFont}
	 * <br>if no {@code TextFont} was specified yet, a new one is created and returned
	 * @return
	 */
	public TextFont getFont() {
		if (this.font == null) {
			this.font = new TextFont();
		}
		return font;
	}

	public void setFont(TextFont font) {
		this.font = font;
	}	
	
	public String toJson() {
		return new Gson().toJson(this);
	}
}
