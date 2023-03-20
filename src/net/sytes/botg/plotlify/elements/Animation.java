package net.sytes.botg.plotlify.elements;

import java.util.ArrayList;
import java.util.List;

public class Animation {

	private List<Frame> frames = new ArrayList<Frame>();
	private String plotId;
	private int traceNum;
	
	public Animation(String plotId, int traceNum) {
		this.plotId = plotId;
		this.traceNum = traceNum;
	}
	
	public void add(Frame frame) {
		this.frames.add(frame);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("var traceNum = " + this.traceNum + ";\n");
		sb.append("var animationData = ").append(this.frames.toString()).append(";\n");		
		return sb.toString();
	}
	
}
