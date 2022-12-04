package net.sytes.botg.plotlify;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import net.sytes.botg.html.HTMLParser;
import net.sytes.botg.text.TextParser;

public class PlotlyDocument {

	private Document doc = null;
	
	private static final String PLOTLY_TEMPLATE = "PLOTLY_TEMPLATE.html";
	
	public PlotlyDocument() throws IOException {
		InputStream is = this.getClass().getResourceAsStream(PLOTLY_TEMPLATE);		
		String html = TextParser.readInputStream(is);
		this.doc = Jsoup.parse(html, "UTF-16");
		if (this.doc == null) {
			throw new IOException("Could not find HTML Template " + PLOTLY_TEMPLATE);
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
		
	}
	
	public void toFile(String filePath) throws IOException {
		FileWriter fw = new FileWriter(new File(filePath));
		fw.write(this.doc.toString());
		fw.close();
	}
	
}
