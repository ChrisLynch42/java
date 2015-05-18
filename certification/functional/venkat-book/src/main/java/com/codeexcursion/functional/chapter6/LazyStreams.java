/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.functional.chapter6;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author lynchcs
 */
public class LazyStreams {

  private static int length(final String name) {
    System.out.println("getting length for " + name);
    return name.length();
  }

  private static String toUpper(final String name) {
    System.out.println("converting to uppercase: " + name);
    return name.toUpperCase();
  }

  public static void main(final String[] args) {
    List<String> names = Arrays.asList("Brad", "Kate", "Kim", "Jack", "Joe",
            "Mike", "Susan", "George", "Robert", "Julia", "Parker", "Benson");
    final String firstNameWith3Letters
            = names.stream()
            .filter(name -> length(name) == 3)
            .map(name -> toUpper(name))
            .findFirst()
            .get();
    System.out.println(firstNameWith3Letters);
  }

}
