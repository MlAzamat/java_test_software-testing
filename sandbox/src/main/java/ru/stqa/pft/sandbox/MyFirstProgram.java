package ru.stqa.pft.sandbox;

public class MyFirstProgram {
    public static void main(String[] args) {
		hello("Hello");
		Square s = new Square(5);
		System.out.println("Square " + s.l + " = " + s.area());
		Rectangle r = new Rectangle(4,6);
		System.out.println("Rectangle " + r.a + " and " + r.b + " = " + r.area());

		hello("Bye");

	}

	public static void hello(String somebody) {
		System.out.println(somebody + " ______ " + "!!!");
	}

}