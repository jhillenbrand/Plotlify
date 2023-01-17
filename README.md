# Plotlify

is a Java Utility Project for visualizing data generated in Java in Plotly.js plots

## Function

based on a HTML Template for plotly.js, the Plotlify.java Class contains static methods for<br>
populating this template with actual data and to export those templates to a HTML file, that can be shared with and viewed by anybody with a browser.

```javascript
@Test
public void test00() {
		
	double[] x = {1.0, 1.4, 1.5, 1.9, 2.0};
	double[] y = {12.234, 43.122, 34.1234, 18.9122, 22.923};
		
	String filePath = "C:\\Users\\*****\\Downloads\\test\\test.html";
	String title = "Test0";
		
	Plotlify.line(filePath, x, y, title);
		
}

 
@Test
public void test01() {
		
	double[] x = {1.0, 1.4, 1.5, 1.9, 2.0};
	double[] y = {12.234, 43.122, 34.1234, 18.9122, 22.923};
	double[] z = {2.234, 4.122, 3.1234, 1.9122, 2.923};
		
	String filePath = "C:\\Users\\*****\\Downloads\\test\\test.html";
	String title = "Test1";
		
	Plotlify.scatter3D(filePath, x, y, z, title);
		
}
```
