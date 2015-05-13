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
@FunctionalInterface
public interface IDatabaseQuery<T, X extends Throwable> {
  public void accept(T instance) throws X;
}
