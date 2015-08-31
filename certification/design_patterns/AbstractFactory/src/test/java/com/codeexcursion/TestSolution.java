/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion;

import com.codeexcursion.Solution;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * -150 150000 1500000000 213333333333333333333333333333333333 -100000000000000
 *
 * @author chris
 */
public class TestSolution {

  private FileInputStream fis = null;
  private ByteArrayOutputStream baos = null;
  private PrintStream ps = null;
  private PrintStream old = null;
  private String expectedResult = null;
  private List<List <String>> allInputAndOutputFilenames = 
          Arrays.asList(
                  Arrays.asList("testinput.txt","testoutput.txt")//,
                  //Arrays.asList("testinput1.txt","testoutput1.txt")
          );
  private String baseDirectory = "./src/test/java/com/codeexcursion";
  
  private void writeResults(String outputString, String filename) {
    try {
      PrintWriter writer = new PrintWriter(baseDirectory + "/actual" + filename);
      writer.print(outputString);
      writer.close();
    } catch(FileNotFoundException fnfe) {
      System.out.println("Failed to write actual!!!!!!!!!!!!!!!");
    }
  }  
  
  private String readExpectedOutput(String outputFileName) {
    String returnValue = null;
    try {
      returnValue = new String(Files.readAllBytes(Paths.get(baseDirectory + "/" + outputFileName)), StandardCharsets.UTF_8);
    } catch(IOException ioe) {
      System.out.println("Failed to read expected output!!!!!!!!!!!!!!!");
    }
    return returnValue;
  }
  
  private void openOutputStream() {
    baos = new ByteArrayOutputStream();
    ps = new PrintStream(baos);
    old = System.out;
    System.setOut(ps);
  }

  private void closeOutputStream() {
    System.out.flush();
    System.setOut(old);
    if (ps != null) {
      ps.close();
    }
  }

  private void openInputStream(String inputFileName) {
    //System.out.println(Paths.get("./src/test/java/com/codeexcursion/token/").toAbsolutePath().normalize().toString());
    try {
      fis = new FileInputStream(new File(baseDirectory + "/" + inputFileName));
      System.setIn(fis);
    } catch (FileNotFoundException fnfe) {
      System.out.println("File read failed!!!!!!!!!!");
    } finally {
    }
  }

  private void closeInputStream() {
    if (fis != null) {
      try {
        fis.close();
      } catch (IOException ioe) {
        System.out.println("File close failed!!!!!!!!!!");
      }
    }
  }

  @Test
  public void testFunnyMatch() {
    StringBuilder input = new StringBuilder("bcxz");
    StringBuilder reversed = new StringBuilder("zxcb");
    Solution solution = new Solution();
    assertFalse("Not funny string returned true postion 0", solution.funnyMatch(input, reversed, 0));

    input = new StringBuilder("acxz");
    reversed = new StringBuilder("zxca");
    assertTrue("Funny string returned false postion 0", solution.funnyMatch(input, reversed, 0));        
  }
  
  
  @Test
  public void testisFunnyString() {
    StringBuilder input = new StringBuilder("bcxz");
    StringBuilder reversed = new StringBuilder("zxcb");
    Solution solution = new Solution();
    assertFalse("Not funny string returned true", solution.stringIsFunny(input, reversed));

    input = new StringBuilder("acxz");
    reversed = new StringBuilder("zxca");
    assertTrue("Funny string returned false", solution.stringIsFunny(input, reversed));
  }
  
  @Test
  public void testcheckForFunnyString() {
    String input = "bcxz";
    Solution solution = new Solution();
    assertEquals("Not funny string returned Funny","Not Funny", solution.checkForFunnyString(input));

    input = "acxz";
    assertEquals("Funny string returned Not Funny","Funny", solution.checkForFunnyString(input));
  }  
  

  @Test
  public void testAllInputs() {
    allInputAndOutputFilenames.stream().forEach(this::runSolution);
  }

  
  public void runSolution(List<String> inputAndOutputFilenames) {
    openInputStream(inputAndOutputFilenames.get(0));
    openOutputStream();
    try {
      Solution solution = new Solution();
      solution.read();
    } finally {
      closeInputStream();
      closeOutputStream();
    }
    String actualResult = baos.toString();
    writeResults(actualResult, inputAndOutputFilenames.get(1));
    expectedResult = readExpectedOutput(inputAndOutputFilenames.get(1));
    assertTrue("Regex results did not match.  inputFilename=" + inputAndOutputFilenames.get(0) + 
            " actual" + actualResult + "actual  expected" + expectedResult +"expected"
            , expectedResult.trim().equals(actualResult.trim()));
    
  }
  
}
