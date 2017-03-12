package ru.stqa.ptf.sandbox;

/**
 * Created by Константин on 12.03.2017.
 */
//класс для координат точки на плоскости и метод для расчета расстояния между точками
public class Point {

  double x, y;

  //конструктор
  public Point(double x, double y) {
    this.x=x;
    this.y=y;
  }
  //функция расчета расстояния между точками на плоскости по двум точкам
  public static double distance (Point p1, Point p2){
    double d;
    return d = Math.sqrt(( p2.x - p1.x)*( p2.x - p1.x) + (p2.y - p1.y)*( p2.y - p1.y));

  }
}