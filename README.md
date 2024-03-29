# Plotlify

is a Java Utility Project for visualizing data generated in Java in Plotly.js plots
<br>[Plotly](https://plotly.com/javascript/)
<br>this project was tested under Plotly v2.20.0
<br>
Disclaimer: this piece of code does not modify the plotly.js source (Licensed under MIT License), to properly work it only references the plotly.js source via cdn link in a html template

## Function

based on a HTML Template for plotly.js, the Plotlify.java Class contains static methods for<br>
populating this template with actual data and to export those templates to a HTML file, that can be shared with and viewed by anybody with a browser.

```java
@Test
public void test00() {
		
	double[] x = {1.0, 1.4, 1.5, 1.9, 2.0};
	double[] y = {12.234, 43.122, 34.1234, 18.9122, 22.923};
		
	String filePath = "test.html";
	String title = "Test0";
		
	Plotlify.line(x, y, title).toFile(filePath);
		
}

 
@Test
public void test01() {
		
	double[] x = {1.0, 1.4, 1.5, 1.9, 2.0};
	double[] y = {12.234, 43.122, 34.1234, 18.9122, 22.923};
	double[] z = {2.234, 4.122, 3.1234, 1.9122, 2.923};
		
	String filePath = "test.html";
	String title = "Test1";
		
	Plotlify.scatter3D(x, y, z, title).toFile(filePath);
		
}
```

![readme_img](/res/img/readme_img.PNG)

## Releases

## Dependencies
see [pom.xml](pom.xml)

the project also depends on [JavaArray](https://github.com/jhillenbrand/JavaArray)
```
git clone https://github.com/jhillenbrand/JavaArray.git
```
or use one of the Plotlify releases to include it into your project workspace when building an application
