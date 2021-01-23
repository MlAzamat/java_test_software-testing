package ru.stqa.pft.sandbox;

import java.awt.*;

public class MyFirstProgram {
    public static void main(String[] args) {
		hello("Hello");

    	Square s = new Square(4);
		System.out.println("Square = " + s.area());

		Rectangle r = new Rectangle(4, 6);
		System.out.println("Rectangle = " + r.area());

    	hello("Bye");

	}

	public static void hello(String somebody) {
		System.out.println(somebody + " ______ " + "!!!");
	}



}