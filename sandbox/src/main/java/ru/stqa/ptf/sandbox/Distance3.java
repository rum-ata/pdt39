package ru.stqa.ptf.sandbox;

/**
 * Created by Константин on 12.03.2017.
 */
public class Distance3 {
  public static void main (String[] arg){

    Pointer p1 = new Pointer(0,0); // экземпляр первой точки
    Pointer p2 = new Pointer(10,20); // экземпляр второй точки

    //вывод рассчитанной дистанции
    System.out.println("расстояние между точкой Р1 с координатами (" + p1.x + ", " + p1.y + ") и точкой P2 с координатами (" + p2.x + ", "+ p2.y + ")");
    System.out.println("равно " + p1.distance(p2));

  }
}
