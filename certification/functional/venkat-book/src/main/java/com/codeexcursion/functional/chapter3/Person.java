/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.functional.chapter3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.reducing;
import static java.util.Comparator.comparing;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author lynchcs
 */
public class Person {

  final Function<Person, String> byName = person -> person.getName();

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

    final Function<Person, Integer> byAge = person -> person.getAge();
    final Function<Person, String> byTheirName = person -> person.getName();

    List<Person> ascendingAge = people.stream()
            .sorted((person1, person2) -> person1.ageDifference(person2))
            .collect(toList());

    ascendingAge.stream().forEach(System.out::println);

    people.stream()
            .min(Person::ageDifference)
            .ifPresent(youngest -> System.out.println("Youngest: " + youngest));

    people.stream()
            .max(Person::ageDifference)
            .ifPresent(eldest -> System.out.println("Eldest: " + eldest));

    List<Person> ageName = people.stream()
            .sorted(comparing(byAge).thenComparing(byTheirName))
            .collect(toList());

    ageName.stream().forEach(System.out::println);

    Map<Integer, List<Person>> peopleByAge
            = people.stream().collect(Collectors.groupingBy(Person::getAge));
    System.out.println("Grouped by age:" + peopleByAge);

    Map<Integer, List<String>> nameOfPeopleByage
            = people.stream().collect(Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, toList())));

    System.out.println("Grouped names by age:" + nameOfPeopleByage);

    Map<Integer, List<String>> nameOfPeopleByAscendingAge
            = people.stream().collect(Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, toList())));

    System.out.println("Grouped names by age ascending:" + nameOfPeopleByage);

    Function<Person, Character> firstLetter = person -> person.getName().charAt(0);
    Comparator<Person> compareAge = Comparator.comparing(Person::getAge);

    Map<Character, Optional<Person>> oldestPersonByLetter
            = people.stream().collect(Collectors.groupingBy(firstLetter, Collectors.reducing(BinaryOperator.maxBy(compareAge))));

    System.out.println("Grouped oldest by letter:" + oldestPersonByLetter);

  }
}
