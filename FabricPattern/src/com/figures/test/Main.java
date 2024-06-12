package com.figures.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String args[]) {
		List<IFigure> figures = new ArrayList<IFigure>(
				Arrays.asList(new Circle(), new Line(), new Triangle(), new Square()));
		for(IFigure f : figures) {
			f.draw();
		}
	}
}
