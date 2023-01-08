package net.sytes.botg.plotlify;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import net.sytes.botg.html.HTMLParser;
import net.sytes.botg.text.TextParser;

public class PlotlyDocument {

	private Document doc = null;
	
	private List<Plotly> plotlys = new ArrayList<Plotly>();
	
	private static final String PLOTLY_TEMPLATE = "PLOTLY_TEMPLATE.html";
	
	public PlotlyDocument() throws IOException {
		this(null);
	}
	
	public PlotlyDocument(Plotly plotly) throws IOException{
		InputStream is = this.getClass().getResourceAsStream(PLOTLY_TEMPLATE);		
		String html = TextParser.readInputStream(is);
		this.doc = Jsoup.parse(html, "UTF-16");
		if (this.doc == null) {
			throw new IOException("Could not find HTML Template " + PLOTLY_TEMPLATE);
		}
		if (plotly != null) {
			this.addPlotly(plotly);
		}
	}

	public void addPlotly(Plotly plotly) {
		// set doc title if available
		if (plotly.getLayout() != null) {
			if (plotly.getLayout().getTitle() != null) {
				Element titleElem = HTMLParser.getElementByTag(this.doc.head(), "title");
				titleElem.text(plotly.getLayout().getTitle());
			}
		}
		
		// create div tag with plot id and attributes
		Element plotDiv = this.doc.body().appendElement("div");
		plotDiv.attributes().put("id", plotly.getPlotId());
		plotDiv.attributes().put("style", "width:100%; height:100%;");
		
		// create script tag
		Element script = this.doc.body().appendElement("script");
		script.html(plotly.toString());
		
		// add to list
		this.plotlys.add(plotly);
	}
	
	public void toFile(String filePath) throws IOException {
		this.toFile(filePath, true);
	}
	
	public void toFile(String filePath, boolean openInBrowser) throws IOException {
		FileWriter fw = new FileWriter(new File(filePath));
		fw.write(this.doc.toString());
		fw.close();
		if (openInBrowser) {
			PlotlifyUtils.openInBrowser(filePath);
		}
	}
	
}
