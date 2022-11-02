package plotlify;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import net.sytes.botg.plotlify.PlotlifyUtils;

public class UnitTest_PlotlifyUtils {

	@Test
	public void test00() {
		
		PlotlifyUtils.downloadPlotlyLibrary("C:\\Users\\****\\Downloads\\test");
		
	}
	
	@Test
	public void test010() {
		
		double[] x = {1.0, 2.0, 3.0, Double.NaN, 4.0, 5.0};		
		double[] y = {1.0, 2.0, 3.0, Double.NaN, 4.0, 5.0};
		
		System.out.println(Arrays.toString(x));
		
	}
	
}
