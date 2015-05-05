package com.codeexcursion.functional;

import com.codeexcursion.functional.chapter2.Friends;
import com.codeexcursion.functional.chapter2.FriendsWhoseNameStartsWithN;
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
  public void testFriends() {
    Friends friends = new Friends();
    friends.logic();
  }

  @Test
  public void testFriendsWhoseNameStartsWithN() {
    FriendsWhoseNameStartsWithN friends = new FriendsWhoseNameStartsWithN();
    friends.logic();
  }

}
