package com.codeexcursion.functional;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Hello world!
 *
 */
public class Chapter1 {

  private final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

  public void friends() {
    final Consumer<String> printer
            = (String name) -> {
              System.out.println(name);
              System.out.println(Thread.activeCount());
            };

    StopWatch stopWatch = new StopWatch("Old Friends");
    for (int i = 0; i < friends.size(); i++) {
      System.out.println(friends.get(i));
      System.out.println(Thread.activeCount());
    }
    stopWatch.stop();

    stopWatch = new StopWatch("Recent Friends");
    for (String name : friends) {
      System.out.println(name);
      System.out.println(Thread.activeCount());
    }
    stopWatch.stop();

    stopWatch = new StopWatch("New Friends");
    friends.forEach(printer);
    stopWatch.stop();

    stopWatch = new StopWatch("Many Friends");
    friends.parallelStream().forEach(printer);
    stopWatch.stop();

  }

}
