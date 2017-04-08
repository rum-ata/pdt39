package ru.stqa.ptf.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Константин on 08.04.2017.
 */
public class Collections {

  public static void main(String[] arg) {

    String[] lang = {"Java", "C#", "Python", "PHP"};

    List<String> langueges = Arrays.asList("Java", "C#", "Python", "PHP");


    for (String l : langueges) {
      System.out.println("Я хочу выучить " + l);
    }
  }
}
