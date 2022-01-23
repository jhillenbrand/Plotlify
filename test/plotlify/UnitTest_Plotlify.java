package plotlify;

import org.junit.Test;

import net.sytes.botg.plotlify.Plotlify;

public class UnitTest_Plotlify {

	@Test
	public void test00() {
		
		double[] x = {1.0, 1.4, 1.5, 1.9, 2.0};
		double[] y = {12.234, 43.122, 34.1234, 18.9122, 22.923};
		
		String filePath = "C:\\Users\\hillenbrand\\Downloads\\test\\test.html";
		String title = "Test1";
		
		Plotlify.line(filePath, x, y, title);
		
	}
	
}
