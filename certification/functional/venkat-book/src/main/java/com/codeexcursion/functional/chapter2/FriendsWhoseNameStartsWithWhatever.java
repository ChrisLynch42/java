package com.codeexcursion.functional.chapter2;

import com.codeexcursion.functional.StopWatch;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Hello world!
 *
 */
public class FriendsWhoseNameStartsWithWhatever {

  private final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
  private final Consumer<String> printer
            = (String name) -> {
              System.out.println(name);
              System.out.println(Thread.activeCount());
            };

  private final Function<String, Predicate<String>> startsWithLetter = letter -> name -> name.startsWith(letter);  
  
  public void logic() {

    StopWatch stopWatch = new StopWatch("Old N Friends");
    for (int i = 0; i < friends.size(); i++) {
      if(friends.get(i).startsWith("N")) {
        System.out.println(friends.get(i));
      }
      System.out.println(Thread.activeCount());
    }
    stopWatch.stop();

    stopWatch = new StopWatch("Recent N Friends");
    for (String name : friends) {
      if(name.startsWith("N")) {
        System.out.println(name);
      }
      System.out.println(Thread.activeCount());
    }
    stopWatch.stop();

    stopWatch = new StopWatch("New N Friends");
    friends.stream().filter(startsWithLetter.apply("N")).forEach(printer);
    stopWatch.stop();

    stopWatch = new StopWatch("Many N Friends");
    friends.parallelStream().filter(startsWithLetter.apply("N")).forEach(printer);
    stopWatch.stop();

  }  

  public static void main(String[] args) {
    FriendsWhoseNameStartsWithN friendsWhoseNameStartsWithN = new FriendsWhoseNameStartsWithN();
    friendsWhoseNameStartsWithN.logic();
    
  }
  
}
