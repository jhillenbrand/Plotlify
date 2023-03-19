package net.sytes.botg.plotlify.elements;

import java.util.ArrayList;
import java.util.List;

public class Animation {

	private List<Frame> frames = new ArrayList<Frame>();
	private String plotId;
	
	public Animation(String plotId) {
		this.plotId = plotId;
	}
	
	public void add(Frame frame) {
		this.frames.add(frame);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("var animationData = ").append(frames.toString()).append(";\n")
			.append("var f = 0;")
			.append("function update(){\n\t")
			.append("Plotly.animate('").append(this.plotId).append("', {\n\t\t")
			.append("data: [animationData[f]]\n\t")
			.append("}, {\n\t\t")
			.append("transition: {\n\t\t")
			.append("duration: 0\n\t")
			.append("},\n\t)")
			.append("frame: {\n\t\t")
			.append("duration: 0,\n\t\t")
			.append("redraw: false\n\t")
			.append("}\n\t")
			.append("});\n")
			.append("f = f + 1;\n")
			.append("\n")
			.append("requestAnimationFrame(update);\n")
			.append("}\n")
			.append("requestAnimationFrame(update);");
		
		return sb.toString();
	}
	
}
