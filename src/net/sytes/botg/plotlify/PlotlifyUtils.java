package net.sytes.botg.plotlify;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.Desktop;

import org.apache.commons.io.FileUtils;

public class PlotlifyUtils {

	public static final String PLOTLY_NAME = "plotly";
	public static final String VERSION = "latest";
	public static final String CDN_LINK = "https://cdn.plot.ly/plotly-" + VERSION + ".min.js";
	
	public static void downloadPlotlyLibrary(String folderPath) {
		URL url = null;
		try {
			url = new URL(CDN_LINK);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		String filePath = folderPath + File.separator + PLOTLY_NAME + "-" + VERSION + ".min.js";
    		File f = new File(filePath);
    		try {
			FileUtils.copyURLToFile(url, f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void openInBrowser(String filePath) {
		File htmlFile = new File(filePath);
		try {
			Desktop.getDesktop().browse(htmlFile.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * checks whether the dimensions of the input data are equal, if not an uncaught IllegalArgumentException is thrown
	 * @param x
	 * @param y
	 * @param z
	 */
	public static void checkDimensions(double[] x, double[] y, double[] z) {
		if (x == null && y == null && z == null) {
			return;
		}
		if (z != null) {
			if (x.length != y.length || y.length != z.length) {
				throw new IllegalArgumentException("Dimension mismatch in input (x[" + x.length + "], y[" + y.length + "], z[" + z.length + "])");
			}
		} else {
			if (x.length != y.length) {
				throw new IllegalArgumentException("Dimension mismatch in input (x[" + x.length + "], y[" + y.length + "])");
			}
		}
	}

	/**
	 * checks whether the {@code filePath} exists
	 * @param filePath
	 */
	public static void checkFilePath(String filePath) {
		File f = new File(filePath);
				
		File fp = f.getParentFile();
		if (fp != null) {
			if (!fp.isDirectory()) {
				throw new IllegalArgumentException("Filepath '" + filePath + "' does not exist");
			}
		}
	}
	
}
