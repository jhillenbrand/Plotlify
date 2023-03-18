package app;

import java.io.IOException;

import net.sytes.botg.plotlify.Plotlify;

public class TestClass {

	public static void main(String[] args) throws IOException {
		double[] x = {1.0, 1.4, 1.5, 1.9, 2.0};
		double[] y = {12.234, 43.122, 34.1234, 18.9122, 22.923};
		
		String filePath = "test.html";
		String title = "Test1";
		
		Plotlify.line(x, y, title).toFile(filePath);
	}
	
}
