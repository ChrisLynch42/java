/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.functional.chapter3;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;
/**
 *
 * @author lynchcs
 */
public class Person {

  private final String name;
  private final int age;

  public Person(final String theName, final int theAge) {
    name = theName;
    age = theAge;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public int ageDifference(final Person other) {
    return age - other.age;
  }

  public String toString() {
    return String.format("%s - %d", name, age);
  }
  
  
  public static void main(String[] args) {
    final List<Person> people = Arrays.asList(
    new Person("John", 20),
    new Person("Sara", 21),
    new Person("Jane", 21),
    new Person("Greg", 35));
    
    List<Person> ascendingAge = people.stream()
      .sorted((person1, person2) -> person1.ageDifference(person2))
      .collect(toList());

    ascendingAge.stream().forEach(System.out::println);
    
  }
}
