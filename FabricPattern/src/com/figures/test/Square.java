package com.figures.test;

public class Square extends FigureFabric {
	public Square() {
		vertex = 4;
	}

	@Override
	public void draw() {
		String res = "Square\n"
				+ "|----|\n"
				+ "|    |\n"
				+ "|----|";
		System.out.println(res + "\n\n");		
	}

}
