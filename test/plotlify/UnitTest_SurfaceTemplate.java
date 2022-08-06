package plotlify;

import org.junit.jupiter.api.Test;

import net.sytes.botg.plotlify.templates.SurfaceTemplate;

public class UnitTest_SurfaceTemplate {

	@Test
	public void test000() {
		
		double[] x = {1, 2, 3, 4};
		double[] y = {3, 5, 6, 9, 11};
		
		double[][] z = {{2, 3, 5, 0},
						{1, 1, 1, 1},
						{3, 1, 0,-1},
						{5, 0,-1,-2},
						{3, 2, 2, 1}};
		
		SurfaceTemplate st = new SurfaceTemplate();
		
		st.load();
		
		st.setData(x, y, z, "surf1");
		
		st.export("test.html");
		
	}
	
}
