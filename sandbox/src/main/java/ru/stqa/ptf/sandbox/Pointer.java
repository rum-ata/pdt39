package ru.stqa.ptf.sandbox;

/**
 * Created by Константин on 12.03.2017.
 */
public class Pointer {
  double x, y;

  //конструктор
  public Pointer(double x, double y) {
    this.x=x;
    this.y=y;
  }
  //функция расчета расстояния между точками от "первой" точки до новой
  public double distance (Pointer p1){
    double d;
    return d = Math.sqrt(( this.x - p1.x)*( this.x - p1.x) + (this.y - p1.y)*( this.y - p1.y));

  }
}
