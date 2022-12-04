package net.sytes.botg.plotlify;

import java.util.ArrayList;
import java.util.List;

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
	
	public Plotly(String id) {
		if (id == null) {
			throw new IllegalArgumentException("id of " + this.getClass().getSimpleName() + " must not be null");
		}
		this.plotId = id;
		++PLOTLY_NUM;
	}

	/**
	 * returns the javascript text for a script tag to insert this Plotly into a HTML Document
	 */
	public String toString() {
		
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
			if (i == this.traces.size() && i != 1) {
				traceSb.append(", trace").append(i);
			} else if(i != 1) {
				traceSb.append(", trace").append(i);
			} else {
				traceSb.append("trace").append(i);
			}
			sb.append("var trace").append(i).append(" = ").append(t.toJson()).append(";");
			sb.append("\n").append("\n");
			++i;
		}
		
		// add data
		sb.append("var data = [").append(traceSb.toString()).append("];");
		sb.append("\n").append("\n");
		
		// add layout
		if (this.layout != null) {
			sb.append("var layout = ").append(this.layout.toJson()).append(";");
			sb.append("\n").append("\n");
		} else {
			sb.append("var layout = {};");
			sb.append("\n").append("\n");
		}
		
		// add plot
		sb.append("Plotly.newPlot('").append(this.plotId).append("', data, layout, {responsive: true});");
		
		return sb.toString();
	}
	
	/**
	 * returns the {@code Trace} with {@code name}
	 * <br>if no {@code Trace} with this {@code name} exists, then a new one is created and returned
	 * @param name
	 * @return
	 */
	public Trace getTrace(String name) {
		for (Trace t : this.traces) {
			if (t.getName().contentEquals(name)) {
				return t;
			}
		}
		Trace t = new Trace();
		t.setName(name);
		this.traces.add(t);
		return this.getTrace(name);
	}
	
	public void setTrace(String name, Trace t) {
		int i = 0;
		for (Trace tr : this.traces) {
			if (tr.getName().contentEquals(name)) {
				this.traces.remove(i);
				this.traces.add(i, t);
				return;
			}
			++i;
		}
		logger.warn("Could not find " + t.toJson() + " in this " + this.getClass().getSimpleName());
	}
	
	public List<Trace> getTraces() {
		return this.traces;
	}
	
	public void setTraces(List<Trace> traces) {
		this.traces = traces;
	}
	
	/**
	 * return this {@code Layout}
	 * <br>if no {@code Layout} was specified yet, a new one is created and returned
	 * @return
	 */
	public Layout getLayout() {
		if (this.layout == null) {
			this.layout = new Layout();
		}
		return this.layout;
	}
	
	public void setLayout(Layout layout) {
		this.layout = layout;
	}

	public String getPlotId() {
		return this.plotId;
	}	
}
