/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.functional.chapter7;

import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 *  
 * @author lynchcs
 */
@FunctionalInterface
public interface TailCall<T> {
  
  
  
  TailCall<T> apply();
  
  default boolean isComplete() { return false; }

  default T getResult() { throw new Error("getResult Not implemented"); }
  
  
  final Consumer<TailCall> printer
          = (TailCall tailCall) -> {
            System.out.println(tailCall.hashCode());
            System.out.println(tailCall.isComplete());
          };
  default T getFinal() {
    //Stream.iterate(this, TailCall::apply).forEach(printer);    
    return Stream.iterate(this, TailCall::apply)
            .filter(TailCall::isComplete)
            .findFirst().get().getResult();
  }

}
