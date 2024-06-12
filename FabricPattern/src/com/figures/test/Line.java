package com.figures.test;

public class Line extends FigureFabric {
	public Line() {
		vertex = 2;
	}
	
	@Override
	public void draw() {
		System.out.println("Line\n" + drawSymbol+drawSymbol+drawSymbol+drawSymbol + "\n\n");
	}

}
