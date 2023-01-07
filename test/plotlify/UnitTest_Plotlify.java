package plotlify;

import java.io.IOException;

import org.junit.Test;

import net.sytes.botg.array.math.Vec;
import net.sytes.botg.plotlify.Plotlify;

public class UnitTest_Plotlify {

	@Test
	public void test00() throws IOException {
		
		double[] x = {1.0, 1.4, 1.5, 1.9, 2.0};
		double[] y = {12.234, 43.122, 34.1234, 18.9122, 22.923};
		
		String filePath = "test.html";
		String title = "Test1";
		
		Plotlify.line(filePath, x, y, title);
		
	}
	
	@Test
	public void test01() throws IOException {
		
		double[] x = {1.0, 1.4, 1.5, 1.9, 2.0};
		double[] y = {12.234, 43.122, 34.1234, 18.9122, 22.923};
		double[] z = {2.234, 4.122, 3.1234, 1.9122, 2.923};
		
		String filePath = "test.html";
		String title = "Test1";
		
		Plotlify.scatter3D(filePath, x, y, z, title);
		
	}
	
	@Test
	public void test02() throws IOException {
		
		double[] y = Vec.rand(100_000);
		
		String filePath = "test.html";
		
		Plotlify.line(filePath, y);
		
	}
	
	@Test
	public void test030() throws IOException {
		
		double[] x = Vec.linspace(10);
		double[] y = Vec.rand(10);

		double[] y2 = Vec.rand(10);
		
		String filePath = "test.html";
				
		Plotlify.line(filePath, x, y);
		 
		//Plotlify.addLine(filePath, x, y2);
		
	}
	
	@Test
	public void test040() throws IOException {
		
		double[] x = Vec.linspace(10);
		double[] y = Vec.rand(10);

		double[] y2 = Vec.rand(10);
		
		String filePath = "test.html";
				
		Plotlify.line(filePath, x, y);
		
		//Plotlify.addScatter(filePath, x, y2);
		
	}
	
}