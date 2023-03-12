package net.sytes.botg.plotlify;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlotlyDocument {

	private Document doc = null;
	
	private List<Plotly> plotlys = new ArrayList<Plotly>();
	
	private static final String PLOTLY_TEMPLATE = "PLOTLY_TEMPLATE.html";
	
	private static final Logger logger = LoggerFactory.getLogger(PlotlyDocument.class);
	
	public PlotlyDocument() throws IOException {
		this(null);
	}
	
	public PlotlyDocument(Plotly plotly) throws IOException{
		InputStream is = this.getClass().getResourceAsStream(PLOTLY_TEMPLATE);
		String html = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line;
		StringBuilder sb = new StringBuilder();
		while ((line = br.readLine()) != null) {
			sb.append(line + System.lineSeparator());
		}
		html = sb.toString();
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
		if (plotly.layout() != null) {
			if (plotly.layout().title() != null) {
				Element titleElem = getElementByTag(this.doc.head(), "title", false);
				titleElem.text(plotly.layout().title());
			}
		}
		
		// create div tag with plot id and attributes
		Element plotDiv = this.doc.body().appendElement("div");
		plotDiv.attributes().put("id", plotly.plotId());
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
	
	private static Element getElementByTag(Element elem, String tagName, boolean recursive) {
		//System.out.println(elem.html());
		Element foundElem = null;
		if (elem.tagName().contentEquals(tagName)) {
			return elem;
		} else {
			if (recursive) {
				for (Element childElem : elem.children()) {
					foundElem = getElementByTag(childElem, tagName, true);
					if (foundElem != null) {
						return foundElem;
					}
				}
			} else {
				for (Element childElem : elem.children()) {
					if (childElem.tagName().contentEquals(tagName)) {
						return childElem;
					}
				}
			}
		}
		return null;
	}
	
}
