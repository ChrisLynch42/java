/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.functional.chapter5;

/**
 *
 * @author lynchcs
 */
public class Box<T> {
  
  private T t;
  
  public T get() {
    return t;
  }
  
  public void set(T t) {
    this.t=t;
  }
  
  public static void main(String[] args) {
    Box<Integer> integerBox = new Box<>();
    integerBox.set(99);
    System.out.println(" Get value " + integerBox.get());
    
  }
  
}
