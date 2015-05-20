/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.functional.chapter7;

import java.util.function.Supplier;

/**
 *
 * @author lynchcs
 */
public class RecursiveUtil {
  public static <T> Recursive<T> done(final T value) {
    return new Recursive<T>() {
      @Override
      public Recursive<T> apply() {
        throw new Error("apply error");
      }

    };
  }  
}
