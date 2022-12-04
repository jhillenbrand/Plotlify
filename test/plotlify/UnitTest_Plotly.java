package plotlify;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import net.sytes.botg.array.ArUtils;
import net.sytes.botg.array.geometry.Circle;
import net.sytes.botg.json.JSONClient;
import net.sytes.botg.plotlify.Layout;
import net.sytes.botg.plotlify.Mode;
import net.sytes.botg.plotlify.PlotType;
import net.sytes.botg.plotlify.PlotlifyUtils;
import net.sytes.botg.plotlify.Plotly;
import net.sytes.botg.plotlify.PlotlyDocument;
import net.sytes.botg.plotlify.Trace;

public class UnitTest_Plotly {

	@Test
	public void test000() {
		
		Trace t = new Trace();
		
		//t.setName("t1");
		t.setX(new double[] {1.0, 2.0, 3.0, 4.0});
		t.setY(new double[] {1.0, 1.1, 1.2, 1.3});
		
		System.out.println(JSONClient.convertObjectToJSON(t));
		
		Trace t2 = new Trace();
	
		t2.setX(new double[] {1.0, 2.0, 3.0, 4.0});
		t2.setY(new double[] {1.0, 1.1, 1.2, 1.3});
		
		System.out.println(JSONClient.convertObjectToJSON(t2));
	}
	
	@Test
	public void test010() {
		
		Plotly p = new Plotly();
	
		Trace t = new Trace();
		
		t.setX(new double[] {1.0, 2.0, 3.0, 4.0});
		t.setY(new double[] {1.0, 1.1, 1.2, 1.3});
		
		p.getTraces().add(t);
		
		System.out.println(p.toString());
		
	}
	

	@Test
	public void test020() throws IOException {
		
		Plotly p = new Plotly();
	
		Trace t = new Trace();
		
		t.setX(new double[] {1.0, 2.0, 3.0, 4.0});
		t.setY(new double[] {1.0, 1.1, 1.2, 1.3});
		
		p.getTraces().add(t);
		
		System.out.println(p.toString());
		
		PlotlyDocument pDoc = new PlotlyDocument();
		
		pDoc.addPlotly(p);
		
		pDoc.toFile("test3.html");
		
		PlotlifyUtils.openInBrowser("test3.html");
		
	}
	
	@Test
	public void test021() throws IOException {
		
		Plotly p = new Plotly();
		
		Trace t = new Trace();
		
		t.setX(new double[] {1.0, 2.0, 3.0, 4.0});
		t.setY(new double[] {1.0, 1.1, 1.2, 1.3});
		
		t.setType(PlotType.SCATTER);
		t.setMode(Mode.LINES_MARKERS);
		
		p.getTraces().add(t);
		
		Layout layout = new Layout();
		layout.setHeight(800); 
		layout.setWidth(1600);
		
		p.setLayout(layout);
		
		System.out.println(p.toString());
		
		PlotlyDocument pDoc = new PlotlyDocument();
		
		pDoc.addPlotly(p);
		
		pDoc.toFile("test3.html");
		
		PlotlifyUtils.openInBrowser("test3.html");
		
	}
	
	@Test
	public void test030() throws IOException {
		
		Circle c = new Circle.Builder()
				.D(20.0)
				.x_0(10.0)
				.y_0(5.0)
				.build();
		
		double[] t = ArUtils.linspace(0.0, 1.0, 100);
		
		c.create(t);
		
		double[] x = c.x();
		double[] y = c.y();
		
		Plotly p = new Plotly();
		
		Trace tr = new Trace();
		
		tr.setX(x);
		tr.setY(y);
		
		tr.setType(PlotType.SCATTER);
		tr.setMode(Mode.LINES_MARKERS);
		
		p.getTraces().add(tr);
		
		p.getLayout().equalAxis();
		
		PlotlyDocument pDoc = new PlotlyDocument();
		
		pDoc.addPlotly(p);
		
		pDoc.toFile("test3.html");
		
		PlotlifyUtils.openInBrowser("test3.html");
	}
	
	@Test
	public void test031() throws IOException {
		
		Circle c = new Circle.Builder()
				.D(20.0)
				.x_0(10.0)
				.y_0(5.0)
				.build();
		
		double[] t = ArUtils.linspace(0.0, 1.0, 100);
		
		c.create(t);
		
		double[] x = c.x();
		double[] y = c.y();
		
		Plotly p = new Plotly();
		
		Trace tr = new Trace();
		
		tr.setX(x);
		tr.setY(y);
		
		tr.setType(PlotType.SCATTER);
		tr.setMode(Mode.LINES_MARKERS);
		
		p.getTraces().add(tr);
		
		Circle c2 = new Circle.Builder()
				.D(10.0)
				.x_0(8.0)
				.y_0(8.0)
				.build();
		
		double[] t2 = ArUtils.linspace(0.0, 1.0, 100);
		
		c2.create(t2);
		
		double[] x2 = c2.x();
		double[] y2 = c2.y();
				
		Trace tr2 = new Trace();
		
		tr2.setX(x2);
		tr2.setY(y2);
		
		tr2.setType(PlotType.SCATTER);
		tr2.setMode(Mode.LINES_MARKERS);
		
		p.getTraces().add(tr2);
		
		p.getLayout().equalAxis();
		
		PlotlyDocument pDoc = new PlotlyDocument();
		
		pDoc.addPlotly(p);
		
		pDoc.toFile("test3.html");
		
		PlotlifyUtils.openInBrowser("test3.html");
	}
	
	
}
