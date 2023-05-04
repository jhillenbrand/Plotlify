package plotlify;

import java.io.File;

import org.junit.jupiter.api.Test;

import net.sytes.botg.plotlify.PlotlyDocument;

public class UnitTest_PlotlyDocument {

	@Test
	public void test000() {
		
		PlotlyDocument pDoc = PlotlyDocument.fromHTML("res" + File.separator + "html" + File.separator + "ExampleSurfaceChart.html");
		
		
		
	}
	
}
