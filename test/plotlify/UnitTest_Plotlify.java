package plotlify;

import org.junit.Test;

import net.sytes.botg.array.ArUtils;
import net.sytes.botg.plotlify.Plotlify;

public class UnitTest_Plotlify {

	@Test
	public void test00() {
		
		double[] x = {1.0, 1.4, 1.5, 1.9, 2.0};
		double[] y = {12.234, 43.122, 34.1234, 18.9122, 22.923};
		
		String filePath = "test.html";
		String title = "Test1";
		
		Plotlify.line(filePath, x, y, title);
		
	}
	
	@Test
	public void test01() {
		
		double[] x = {1.0, 1.4, 1.5, 1.9, 2.0};
		double[] y = {12.234, 43.122, 34.1234, 18.9122, 22.923};
		double[] z = {2.234, 4.122, 3.1234, 1.9122, 2.923};
		
		String filePath = "C:\\Users\\****\\Downloads\\test\\test.html";
		String title = "Test1";
		
		Plotlify.scatter3D(filePath, x, y, z, title);
		
	}
	
	@Test
	public void test02() {
		
		double[] y = ArUtils.rand(100_000);
		
		String filePath = "test.html";
		
		Plotlify.line(filePath, y);
		
	}
	
	
}