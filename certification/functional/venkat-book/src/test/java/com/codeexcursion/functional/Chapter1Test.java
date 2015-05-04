package com.codeexcursion.functional;

import com.codeexcursion.functional.chapter1.Friends;
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
    Friends chapter1 = new Friends();
    chapter1.friends();
  }

  @Test
  public void testFriendsWhoseNameStartsWithN() {
    Friends chapter1 = new Friends();
    chapter1.friendsWhoseNameStartsWithN();
  }

}
