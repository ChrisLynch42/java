/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.functional.chapter7;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 *
 * @author lynchcs
 */
public class Factorial {

  public int nonOptimized(final int n) {
    if (n == 1) {
      return n;
    } else {
      return n * nonOptimized(n - 1);
    }
  }


  final Consumer<Recursive<Integer>> recursivePrinter
          = (Recursive<Integer> recursive) -> {
            System.out.println(recursive.hashCode());
          };
  
  
  public Recursive<Integer> useRecursive(final Integer the_number) {
    if (the_number.compareTo(1) <= 0) {
      return RecursiveUtil.done(the_number);
    } else {
      return () -> useRecursive(the_number - 1);
    }
  }
  
  public void printRecursive(final Integer the_number) {
    Stream.iterate(useRecursive(the_number), Recursive::apply).forEach(recursivePrinter);
  }
  
  
  final Consumer<TailCall<BigInteger>> tailCallPrinter
          = (TailCall<BigInteger> tailCall) -> {
            System.out.println(tailCall.hashCode());
            System.out.println(tailCall.isComplete());
          };


  public TailCall<BigInteger> useTailCall(final BigInteger result, final BigInteger the_number) {
    if (the_number.equals(BigInteger.ONE)) {
      return TailCallUtil.done(result);
    } else {
      return () -> useTailCall(result.multiply(the_number), the_number.subtract(BigInteger.ONE));
    }
  }

  public TailCall<BigInteger> useTailCall(final BigInteger the_number) {
    TailCall<BigInteger> returnValue = useTailCall(BigInteger.ONE, the_number);
    //Stream.iterate(returnValue, TailCall::apply).forEach(tailCallPrinter);
    return returnValue;
  }

  public static void main(String[] args) {
    Factorial factorial = new Factorial();
    System.out.println("nonOptimized 5");
    System.out.println(factorial.nonOptimized(5));
    System.out.println("useTailCall 5");
    System.out.println(factorial.useTailCall(BigInteger.valueOf(5)).getFinal());
    System.out.println("useTailCall 20000");
    System.out.println(factorial.useTailCall(BigInteger.valueOf(20000)).getFinal());
    System.out.println("printRecursive 5");
    factorial.printRecursive(5);
  }

}
