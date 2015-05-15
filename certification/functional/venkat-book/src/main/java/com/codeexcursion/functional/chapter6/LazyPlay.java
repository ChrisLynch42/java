/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.functional.chapter6;

import java.util.function.Supplier;

/**
 *
 * @author lynchcs
 */
public class LazyPlay {

  private Supplier<HeavyPlay> heavyPlay = () -> createAndCache();

  public LazyPlay() {
    System.out.println("LazyPlay created");
  }

  public HeavyPlay getHeavyPlay() {
    return heavyPlay.get();
  }

  private synchronized HeavyPlay createAndCache() {
    class HeavyPlayFactory implements Supplier<HeavyPlay> {

      private final HeavyPlay heavyPlayInstance = new HeavyPlay();

      public HeavyPlay get() {
        return heavyPlayInstance;
      }
    }
    System.out.println("Here i am.");
    if (!HeavyPlayFactory.class.isInstance(heavyPlay)) {
      heavyPlay = new HeavyPlayFactory();
    }

    return heavyPlay.get();
  }

  public static void main(final String[] args) {
    final LazyPlay lazyPlay = new LazyPlay();
    System.out.println("deferring heavy creation...");
    System.out.println(lazyPlay.getHeavyPlay());
    System.out.println(lazyPlay.getHeavyPlay());
    System.out.println(lazyPlay.getHeavyPlay());
  }

}
