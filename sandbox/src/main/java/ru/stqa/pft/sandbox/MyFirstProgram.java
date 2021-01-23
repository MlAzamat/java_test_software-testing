package ru.stqa.pft.sandbox;

import java.awt.*;

public class MyFirstProgram {
    public static void main(String[] args) {
		hello("Hello");

    	Square s = new Square(4);
		System.out.println("Square = " + area(s));

		Rectangle r = new Rectangle(4, 6);
		System.out.println("Rectangle = " + area(r));

    	hello("Bye");

	}

	public static void hello(String somebody) {
		System.out.println(somebody + " ______ " + "!!!");
	}
	public static double area(Square s){
    	return s.l * s.l;
	}
	public static double area(Rectangle r){
		return r.a * r.b;
	}

}