package net.sytes.botg.plotlify.elements;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Wrapper class for javascript's plotly library
 * <br><a href='https://plotly.com/javascript/'>Plotly.js</a>
 * @author hillenbrand
 *
 */
public class Plotly {

	private String plotId = null;
	
	private List<Trace> traces = new ArrayList<Trace>();
	private Layout layout = null;
	
	private static int PLOTLY_NUM = 0;
	
	private static final Logger logger = LoggerFactory.getLogger(Plotly.class);
	
	public Plotly() {
		++PLOTLY_NUM;
		this.plotId = "plot" + PLOTLY_NUM;
	}

	/**
	 * returns the javascript text for a script tag to insert this Plotly into a HTML Document
	 */
	public String toScript() {
		
		if (this.traces.size() < 1) {
			throw new IllegalStateException(this.getClass().getSimpleName() + " must have at least " + Trace.class.getSimpleName());
		}
		
		StringBuilder sb = new StringBuilder();
		
		// add plot div search
		sb.append("var plotDiv").append(PLOTLY_NUM).append(" = document.getElementById('").append(this.plotId).append("');");
		sb.append("\n").append("\n");
		
		// add traces
		StringBuilder traceSb = new StringBuilder();
		int i = 1;
		for (Trace t : this.traces) {
			// do data manipulation if required for specific plotType
			if (t.type() != null) {
				/*
				switch (PlotType.valueOf(t.type().toUpperCase())) {
					case SURFACE:
						if (t.x() != null) {
							// increase matrix by one row and column at the beginning to store the x and y coordinates					
							Object[] z_old = t.z();
							int m = z_old.length;
							Object[] row0 = (Object[]) z_old[0];
							int n = row0.length;
							Object[][] z_new = new Object[m + 1][n + 1];
							// populate array
							z_new[0][0] = null;
							for (int j = 0; j < m; j++) {
								Object[] row = (Object[]) z_old[j];
								for (int k = 0; k < n; k++) {
									if (j == 0) {
										z_new[0][k + 1] = t.x()[k];
									}
									z_new[j + 1][k + 1] = row[k];
								}
								z_new[j + 1][0] = t.x()[j];
							}
							t.z(z_new);
							t.x(new double[0]);
							t.y(new double[0]);
						}
						break;
				}
				*/
			}
			if (i == this.traces.size() && i != 1) {
				traceSb.append(", trace").append(i);
			} else if(i != 1) {
				traceSb.append(", trace").append(i);
			} else {
				traceSb.append("trace").append(i);
			}
			sb.append("\tvar trace").append(i).append(" = ").append(t.toJson()).append(";");
			sb.append("\n").append("\n");
			++i;
		}
		
		// add data
		sb.append("\tvar data = [").append(traceSb.toString()).append("];");
		sb.append("\n").append("\n");
		
		// add layout
		if (this.layout != null) {
			sb.append("\tvar layout = ").append(this.layout.toJson()).append(";");
			sb.append("\n").append("\n");
		} else {
			sb.append("\tvar layout = {};");
			sb.append("\n").append("\n");
		}
		
		// add plot
		sb.append("\tPlotly.newPlot('").append(this.plotId).append("', data, layout, {responsive: true});");
		
		return sb.toString();
	}
	
	public static Plotly fromScript(String scriptStr) {
		
		return null;		
	}
	
	/**
	 * returns the {@code Trace} with {@code name}
	 * <br>if no {@code Trace} with this {@code name} exists, then a new one is created and returned
	 * @param name
	 * @return
	 */
	public Trace trace(String name) {
		for (Trace t : this.traces) {
			if (t.name().contentEquals(name)) {
				return t;
			}
		}
		Trace t = new Trace();
		t.name(name);
		this.traces.add(t);
		return this.trace(name);
	}
	
	public Plotly trace(String name, Trace t) {
		int i = 0;
		for (Trace tr : this.traces) {
			if (tr.name().contentEquals(name)) {
				this.traces.remove(i);
				this.traces.add(i, t);
				return this;
			}
			++i;
		}
		t.name(name);
		this.traces.add(i, t);
		//logger.warn("Could not find " + t.toJson() + " in this " + this.getClass().getSimpleName());
		return this;
	}
	
	public List<Trace> traces() {
		return this.traces;
	}
	
	public void traces(List<Trace> traces) {
		this.traces = traces;
	}
	
	/**
	 * return this {@code Layout}
	 * <br>if no {@code Layout} was specified yet, a new one is created and returned
	 * @return
	 */
	public Layout layout() {
		if (this.layout == null) {
			this.layout = new Layout();
		}
		return this.layout;
	}
	
	public void layout(Layout layout) {
		this.layout = layout;
	}
	
	/**
	 * prepares the {@code trace}s to be prepared for subplots (by naming all {@code trace}s except first in ascending order like x2, y2, ..., x3, y3, ...)
	 * <br>Only works if a {@code Grid} is defined in {@code Layout} aswell
	 * @return
	 */
	public Plotly subplots() {
		boolean first = true;
		int i = 2;
		for (Trace t : this.traces) {
			if (first ) {
				first = false;
			} else {
				if (t.x() != null) {
					t.xaxis = "x" + i;
				}
				if (t.y() != null) {
					t.yaxis = "y" + i;
					t.xaxis = "x" + i;
				}
				if (t.z() != null) {
					t.zaxis = "z" + i;
				}
				++i;
			}			
		}
		return this;
	}

	public String plotId() {
		return this.plotId;
	}	
}
