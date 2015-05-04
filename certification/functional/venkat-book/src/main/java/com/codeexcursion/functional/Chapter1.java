package com.codeexcursion.functional;

import java.util.*;

/**
 * Hello world!
 *
 */
public class Chapter1 {

  private final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

  public void friends() {
    StopWatch stopWatch = new StopWatch("Old Friends");
    for (int i = 0; i < friends.size(); i++) {
      System.out.println(friends.get(i));
    }
    stopWatch.stop();

    stopWatch = new StopWatch("Recent Friends");
    for (String name : friends) {
      System.out.println(name);
    }
    stopWatch.stop();

    stopWatch = new StopWatch("New Friends");
    friends.forEach(name -> System.out.println(name));
    stopWatch.stop();
    
    stopWatch = new StopWatch("Many Friends");
    friends.parallelStream().forEach(name -> System.out.println(name));
    stopWatch.stop();
    

  }

}
