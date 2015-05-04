package com.codeexcursion.functional;

import org.junit.Test;

import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;
import org.junit.Assert;


/**
 * Unit test for simple App.
 */
public class Chapter1Test 
{

  @Test
  public void aTestOfLoadEnv() {
    Chapter1 chapter1 = new Chapter1();
    chapter1.friends();
    Assert.assertTrue(true);
  }

}
