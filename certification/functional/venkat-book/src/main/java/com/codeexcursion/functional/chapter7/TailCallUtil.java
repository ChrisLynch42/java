/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.functional.chapter7;

/**
 *
 * @author lynchcs
 */
public class TailCallUtil {

  public static <T> TailCall<T> done(final T value) {
    return new TailCall<T>() {
      @Override
      public boolean isComplete() {
        return true;
      }

      @Override
      public T getResult() {
        return value;
      }

      @Override
      public TailCall<T> apply() {
        throw new Error("apply not implemented");
      }
    };
  }

  public static <T> TailCall<T> call(final TailCall<T> nextCall) {
    return nextCall;
  }

}
