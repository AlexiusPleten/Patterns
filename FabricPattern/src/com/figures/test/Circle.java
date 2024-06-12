package com.figures.test;

public class Circle extends FigureFabric {
	public Circle() {
		vertex = 0;
	}
	
	@Override
	public void draw() {
		System.out.println("Circle\nO\n\n");
	}

}
