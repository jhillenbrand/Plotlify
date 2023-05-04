package net.sytes.botg.plotlify;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sytes.botg.plotlify.elements.Animation;
import net.sytes.botg.plotlify.elements.Plotly;
import net.sytes.botg.plotlify.elements.Trace;

public class PlotlyDocument {

	private Document doc = null;
	
	private List<Plotly> plotlys = new ArrayList<Plotly>();
	
	//private List<Animation> animations = new ArrayList<Animation>(); 
	Animation animation = null;
	
	private static final String PLOTLY_TEMPLATE = "PLOTLY_TEMPLATE.html";
	private static final String PLOTLY_ANIMATION_TEMPLATE = "PLOTLY_ANIMATION_TEMPLATE.html";
	
	private static final Logger logger = LoggerFactory.getLogger(PlotlyDocument.class);
	
	/**
	 * default value is -1, and no action is taken, otherwise numeric values in Plotly arrays are rounded to {@code PRECISION} decimal places
	 */
	private static int PRECISION = -1;
	
	public PlotlyDocument() {
	}
	
	public PlotlyDocument(Plotly plotly) {
		this.addPlotly(plotly);
	}

	public void addPlotly(Plotly plotly) {
		if (plotly != null) {
			this.plotlys.add(plotly);
		} else {
			throw new IllegalArgumentException("Specified plotly was NULL");
		}
	}
	
	private void generateDoc() throws IOException {
		InputStream is;
		if (this.animation != null) {
			is = this.getClass().getResourceAsStream(PLOTLY_ANIMATION_TEMPLATE);
		} else {
			is = this.getClass().getResourceAsStream(PLOTLY_TEMPLATE);
		}
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
			throw new IOException("Could not find Plotly HTML Template");
		}		
		for (Plotly plotly : this.plotlys) {
			
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
			
			// check if precision must be forced
			if (PRECISION >= 0) {
				for (Trace t : plotly.traces()) {
					t.forcePrecision(PRECISION);
				}
			}
			
			// create script tag
			Element script = this.doc.body().appendElement("script");
			script.html(plotly.toScript());
		
		}
		
		if (this.animation != null) {
			Element script = this.doc.createElement("script");
			script.html(this.animation.toString());
			this.doc.body().lastElementChild().before(script);
		}
		
	}
	
	public static PlotlyDocument fromHTML(String filePath) {
		try {
			List<String> lines = Files.readAllLines(Paths.get(filePath));
			String htmlStr = String.join("\n", lines);
			
			Document doc = Jsoup.parse(htmlStr);
			
			PlotlyDocument pDoc = new PlotlyDocument();
			
			String title = doc.head().getElementsByTag("title").get(0).text();
			
			Element bodyElem = doc.body();
			List<Node> bodyChildren = bodyElem.childNodes();
			
			for (Node node : bodyChildren) {
				//System.out.println(node.nodeName());
				
				// each <div> element
				if (node.nodeName().contentEquals("div")) {
					
				}
			}
			
			Plotly plotly = new Plotly();
			
			plotly.layout().title(title);
			
			pDoc.addPlotly(plotly);
			
			return pDoc;
		} catch (IOException e) {
			logger.error("Could not read plotly file under " + filePath);
			return null;
		}
	}
	
	public void toFile() throws IOException {
		this.toFile("plotly.html", true);
	}
	
	public void toFile(String filePath) throws IOException {
		this.toFile(filePath, true);
	}
	
	public void toFile(String filePath, boolean openInBrowser) throws IOException {
		this.generateDoc();
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

	public List<Plotly> plotlys() {
		return this.plotlys;
	}

	public Animation animation() {
		return this.animation;
	}

	public void animation(Animation animation) {
		this.animation = animation;
	}

	/**
	 * default value is -1, and no action is taken, otherwise numeric values in Plotly arrays are rounded to {@code precision} decimal places
	 * @param precision
	 */
	public static void setPrecision(int precision) {
		PRECISION = precision;
	}
	
}
