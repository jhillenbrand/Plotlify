package net.sytes.botg.plotlify.elements;

public enum PlotType {
	
	SCATTER("scatter"), BAR("bar"), PIE("pie"), SCATTER3D("scatter3d"), SURFACE("surface"), MESH3D("mesh3d"); 
	
	private final String type;
	
	private PlotType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return this.type;
	}
}
