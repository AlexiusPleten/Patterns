package com.figures.test;

public class Triangle extends FigureFabric {
	public Triangle() {
		vertex = 3;
	}
	
	@Override
	public void draw() {;
		String res = "Triangle\n"
				+ "   /\\\n"
				+ "  /  \\\n"
				+ " /----\\";
		System.out.println(res + "\n\n");
	}

}
