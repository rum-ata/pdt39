package ru.stqa.ptf.sandbox;

public class MyFirstProgram {

	public static void main (String[] arg) {
		hello("world");
		hello("user");
		hello("Lesha");

		double l = 5.0;

    System.out.println("Площадь квадрата со стороной " + l + " = " + area(l));

    double a=4, b=6;

    System.out.println("Площадь прямоугольника со сторонами " + a + " и " + b + " равна " + area(a,b));

  }

	public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }

  public static double area (double len){
	  return len*len;
  }

  public static double area (double a, double b){
    return a*b;
  }
}