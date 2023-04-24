package plotlify;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.google.gson.Gson;

import net.sytes.botg.array.geometry.Circle;
import net.sytes.botg.array.math.Vec;
import net.sytes.botg.plotlify.PlotlyDocument;
import net.sytes.botg.plotlify.elements.Layout;
import net.sytes.botg.plotlify.elements.Mode;
import net.sytes.botg.plotlify.elements.PlotType;
import net.sytes.botg.plotlify.elements.Plotly;
import net.sytes.botg.plotlify.elements.Trace;

public class UnitTest_Plotly {

	@Test
	public void test000() {
		
		Trace t = new Trace();
		
		//t.setName("t1");
		t.x(new double[] {1.0, 2.0, 3.0, 4.0});
		t.y(new double[] {1.0, 1.1, 1.2, 1.3});
		
		System.out.println(new Gson().toJson(t));
		
		Trace t2 = new Trace();
	
		t2.x(new double[] {1.0, 2.0, 3.0, 4.0});
		t2.y(new double[] {1.0, 1.1, 1.2, 1.3});
		
		System.out.println(new Gson().toJson(t2));
		//System.out.println(t2.toString());
	}
	
	@Test
	public void test010() {
		
		Plotly p = new Plotly();
	
		Trace t = new Trace();
		
		t.x(new double[] {1.0, 2.0, 3.0, 4.0});
		t.y(new double[] {1.0, 1.1, 1.2, 1.3});
		
		p.traces().add(t);
		
		System.out.println(p.toString());
		
	}
	

	@Test
	public void test020() throws IOException {
		
		Plotly p = new Plotly();
	
		Trace t = new Trace();
		
		t.x(new double[] {1.0, 2.0, 3.0, 4.0});
		t.y(new double[] {1.0, 1.1, 1.2, 1.3});
		
		p.traces().add(t);
		
		System.out.println(p.toString());
		
		PlotlyDocument pDoc = new PlotlyDocument(p);
		
		pDoc.toFile("test3.html");
		
	}
	
	@Test
	public void test021() throws IOException {
		
		Plotly p = new Plotly();
		
		Trace t = new Trace();
		
		t.x(new double[] {1.0, 2.0, 3.0, 4.0});
		t.y(new double[] {1.0, 1.1, 1.2, 1.3});
		
		t.type(PlotType.SCATTER);
		t.mode(Mode.LINES_MARKERS);
		
		p.traces().add(t);
		
		Layout layout = new Layout();
		layout.height(800); 
		layout.width(1600);
		
		p.layout(layout);
		
		System.out.println(p.toString());
		
		PlotlyDocument pDoc = new PlotlyDocument(p);
		
		pDoc.toFile("test3.html");
		
	}
	
	@Test
	public void test030() throws IOException {
		
		Circle c = new Circle.Builder()
				.D(20.0)
				.x_0(10.0)
				.y_0(5.0)
				.build();
		
		double[] t = Vec.linspace(0.0, 1.0, 100);
		
		c.create(t);
		
		double[] x = c.x();
		double[] y = c.y();
		
		Plotly p = new Plotly();
		
		Trace tr = new Trace();
		
		tr.x(x);
		tr.y(y);
		
		tr.type(PlotType.SCATTER);
		tr.mode(Mode.LINES_MARKERS);
		
		p.traces().add(tr);
		
		p.layout().equalAxis();
		
		PlotlyDocument pDoc = new PlotlyDocument(p);
				
		pDoc.toFile("test3.html");
	}
	
	@Test
	public void test031() throws IOException {
		
		Circle c = new Circle.Builder()
				.D(20.0)
				.x_0(10.0)
				.y_0(5.0)
				.build();
		
		double[] t = Vec.linspace(0.0, 1.0, 100);
		
		c.create(t);
		
		double[] x = c.x();
		double[] y = c.y();
		
		Plotly p = new Plotly();
		
		Trace tr = new Trace();
		
		tr.x(x);
		tr.y(y);
		
		tr.type(PlotType.SCATTER);
		tr.mode(Mode.LINES_MARKERS);
		
		p.traces().add(tr);
		
		Circle c2 = new Circle.Builder()
				.D(10.0)
				.x_0(8.0)
				.y_0(8.0)
				.build();
		
		double[] t2 = Vec.linspace(0.0, 1.0, 100);
		
		c2.create(t2);
		
		double[] x2 = c2.x();
		double[] y2 = c2.y();
				
		Trace tr2 = new Trace();
		
		tr2.x(x2);
		tr2.y(y2);
		
		tr2.type(PlotType.SCATTER);
		tr2.mode(Mode.LINES_MARKERS);
		
		p.traces().add(tr2);
		
		p.layout().equalAxis();
		
		PlotlyDocument pDoc = new PlotlyDocument(p);
				
		pDoc.toFile("test3.html");
	}
	
	
}
