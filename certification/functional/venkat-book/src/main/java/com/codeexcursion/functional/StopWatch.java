/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.functional;



/**
 *
 * @author lynchcs
 */
public class StopWatch {

  private long start;
  private long end;
  private long duration;
  private String identifier;
  private String prefix = "Stopwatch ";

  public StopWatch(String identifier) {
    this.identifier=identifier;
    System.out.println(prefix + identifier + " started.");
    start = System.nanoTime();
  }

  public void stop() {
      end = System.nanoTime();
      duration = end - start;
      System.out.println(prefix + identifier + " ended. duration(ms) " + duration );
  }

}
