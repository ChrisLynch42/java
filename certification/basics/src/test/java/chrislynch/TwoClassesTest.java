/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chrislynch;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertThat;
import org.junit.Assert;
import static org.junit.matchers.JUnitMatchers.both;
import static org.junit.matchers.JUnitMatchers.containsString;
import static org.junit.matchers.JUnitMatchers.everyItem;
import static org.junit.matchers.JUnitMatchers.hasItems;
import org.junit.Test;

/**
 *
 * @author chris
 */
public class TwoClassesTest {
    
  @Test
  public void booleanDefaultTest() {
    TwoClasses twoClasses = new TwoClasses();
    twoClasses.notAvailable = 1;
    Assert.assertEquals("Default boolean value was not false", false, twoClasses.trueFalse);
  }
    
    
}
