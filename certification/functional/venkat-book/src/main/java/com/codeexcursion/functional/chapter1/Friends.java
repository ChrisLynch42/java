package com.codeexcursion.functional.chapter1;

import com.codeexcursion.functional.StopWatch;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Hello world!
 *
 */
public class Friends {

  private final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
    final Consumer<String> printer
            = (String name) -> {
              System.out.println(name);
              System.out.println(Thread.activeCount());
            };

  public void logic() {

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
  
  public static void main(String[] args) {
    Friends friends = new Friends();
    friends.logic();
    
  }
  
}
