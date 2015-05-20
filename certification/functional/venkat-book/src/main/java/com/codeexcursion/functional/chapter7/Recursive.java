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
@FunctionalInterface
public interface Recursive<T> {
  Recursive<T> apply();
  
}
