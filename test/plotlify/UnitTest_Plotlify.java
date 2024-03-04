package plotlify;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import net.sytes.botg.array.geometry.CoordSys;
import net.sytes.botg.array.math.Mat;
import net.sytes.botg.array.math.Vec;
import net.sytes.botg.plotlify.Plotlify;
import net.sytes.botg.plotlify.PlotlyDocument;
import net.sytes.botg.plotlify.elements.Color;
import net.sytes.botg.plotlify.elements.Mode;
import net.sytes.botg.plotlify.elements.PlotType;
import net.sytes.botg.plotlify.elements.Plotly;
import net.sytes.botg.plotlify.elements.Trace;

public class UnitTest_Plotlify {

	@Test
	public void test000() throws IOException {
		
		double[] x = {1.0, 1.4, 1.5, 1.9, 2.0};
		double[] y = {12.234, 43.122, 34.1234, 18.9122, 22.923};
		
		String filePath = "test.html";
		String title = "Test1";
		
		Plotlify.line(x, y, title).toFile(filePath);
		
	}
	
	@Test
	public void test010() throws IOException {
		
		double[] x = {1.0, 1.4, 1.5, 1.9, 2.0};
		double[] y = {12.234, 43.122, 34.1234, 18.9122, 22.923};
		
		String filePath = "test.html";
		String title = "Test1";
		
		Plotlify.scatter(x, y, title).toFile(filePath);
		
	}
	
	@Test
	public void test011() throws IOException {
		
		double[] x = {1.0, 1.4, 1.5, 1.9, 2.0};
		double[] y = {12.234, 43.122, 34.1234, 18.9122, 22.923};
		double[] z = {2.234, 4.122, 3.1234, 1.9122, 2.923};
		
		String filePath = "test.html";
		String title = "Test1";
		
		Plotlify.scatter3D(x, y, z, title).toFile(filePath);
		
	}
	
	@Test
	public void test02() throws IOException {
		
		double[] y = Vec.rand(100_000);
		
		String filePath = "test.html";
		
		Plotlify.line(y).toFile(filePath);
		
	}
	
	@Test
	public void test030() throws IOException {
		
		double[] x = Vec.linspace(10);
		double[] y = Vec.rand(10);

		double[] y2 = Vec.rand(10);
		
		String filePath = "test.html";
				
		Plotlify.line(x, y).toFile(filePath);
		 
		//Plotlify.addLine(filePath, x, y2);
		
	}
	
	@Test
	public void test040() throws IOException {
		
		double[] x = Vec.linspace(10);
		double[] y = Vec.rand(10);

		double[] y2 = Vec.rand(10);
		
		String filePath = "test.html";
				
		Plotlify.line(x, y).toFile(filePath);
		
		//Plotlify.addScatter(filePath, x, y2);
		
	}
	
	@Test
	public void test050() throws IOException {
		
		double[] x = Vec.linspace(10);
		double[] y = Vec.rand(10);

		double[] y2 = Vec.rand(10);
		
		String filePath = "test2.html";
				
		Plotlify.line(x, y, "t2", "t2", "x1", "x2").toFile(filePath);
		
		//Plotlify.addScatter(filePath, x, y2);
		
	}
	
	@Test
	public void test051() throws IOException {
		
		double[] x = Vec.linspace(10);
		double[] y = Vec.rand(10);
		double[] z = Vec.rand(10);
						
		Plotlify.line(x, y, z, "t1", "t1", "x1", "x2", "x3").toFile();
		
		//Plotlify.addScatter(filePath, x, y2);
		
	}
	
	@Test
	public void test060() throws IOException {
		
		Plotlify.plane(new double[] {1, 1, 1}, new double[] {-1, 1 ,1}, 10.0, 10.0).toFile();
		
	}
	
	@Test
	public void test070() throws IOException {
		
		Plotly plotly = new Plotly();
		
		Trace tr = Plotlify.arrow(0, 0, 1, 1, Color.RED);
		
		plotly.traces().add(tr);
		
		PlotlyDocument pDoc = new PlotlyDocument(plotly);
		
		pDoc.toFile();
		
	}
	
	@Test
	public void test071() throws IOException {
		
		Plotly plotly = new Plotly();
		
		List<Trace> traces = Plotlify.arrow3D(0, 0, 0, 1, 1, 0, Color.BLUE);
		
		plotly.traces().addAll(traces);
		
		PlotlyDocument pDoc = new PlotlyDocument(plotly);
		
		pDoc.toFile();
		
	}
	
	@Test
	public void test080() throws IOException {
		
		PlotlyDocument pDocument = Plotlify.line(new double[]{0, 1}, new double[]{0, 1});
		
		Trace tr = Plotlify.annotation(new double[]{1}, new double[]{1}, null, new String[]{"Test"}, null);
		
		pDocument.plotlys().get(0).traces().add(tr);
		
		pDocument.toFile();
		
	}
	
	@Test
	public void test081() throws IOException {
		
		PlotlyDocument pDocument = Plotlify.line(new double[]{0, 1}, new double[]{0, 1}, new double[] {0, 1});
		
		Trace tr = Plotlify.annotation(new double[]{1}, new double[]{1},  new double[]{1}, new String[]{"Test"}, null);
		
		pDocument.plotlys().get(0).traces().add(tr);
		
		pDocument.toFile();
	
	}
	
	
	@Test
	public void test090() throws IOException {
		
		Plotly plotly = new Plotly();
		
		double[] origin = new double[] {0, 0, 0};
		double[][] unitVectors = Mat.unitMatrix(3); 
		String[] labels = new String[] {"x", "y", "z"};
		
		List<Trace> traces = Plotlify.coordSys(origin, unitVectors, labels, 1, Color.BLACK);
		
		plotly.traces().addAll(traces);
		
		PlotlyDocument pDoc = new PlotlyDocument(plotly);
		
		pDoc.toFile();
		
	}
	
	@Test
	public void test091() throws IOException {
		
		Plotly plotly = new Plotly();
		
		CoordSys cos1 = CoordSys.defaultSystem();
		
		List<Trace> traces = Plotlify.coordSys(cos1.origin(), cos1.base(), cos1.labels(), 1, Color.BLACK);
		
		plotly.traces().addAll(traces);
		
		CoordSys cos2 = cos1.clone();
		cos2.labels(new String[] {"x'", "y'", "z'"});
		
		cos2.rot3(22.5);
		
		List<Trace> traces2 = Plotlify.coordSys(cos2.origin(), cos2.base(), cos2.labels(), 1, Color.BLUE);
		
		plotly.traces().addAll(traces2);
		
		Trace t1 = new Trace().type(PlotType.SCATTER3D).mode(Mode.LINES).x(new double[] {-2, 2}).y(new double[] {-2, 2}).z(new double[] {-1, 1});
		
		plotly.traces().add(t1);
		
		plotly.layout().width(1200).height(900).equalAxis3D();
		
		PlotlyDocument pDoc = new PlotlyDocument(plotly);
		
		pDoc.toFile();
		
	}
	
}