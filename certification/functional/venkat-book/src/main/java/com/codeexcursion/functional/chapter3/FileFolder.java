/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.functional.chapter3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

/**
 *
 * @author lynchcs
 */
public class FileFolder {
  
  
  public static void main(String[] args) throws IOException {
    System.out.println("List files and directories");
    Files.list(Paths.get(".")).forEach(System.out::println);
    
    System.out.println("List directories");
    Files.list(Paths.get(".")).filter(Files::isDirectory).forEach(System.out::println);
    
    System.out.println("List java files");
    Files.list(Paths.get("./src/main/java/com/codeexcursion/functional/chapter3")).filter(path -> path.toString().endsWith(".java")).forEach(System.out::println);
    
    System.out.println("List java files alternative");
    Files.newDirectoryStream(Paths.get("./src/main/java/com/codeexcursion/functional/chapter3"), path -> path.toString().endsWith(".java")).forEach(System.out::println);
    
    System.out.println("List files in subdirectories.");
    List<File> subfiles = Stream.of((new File(".")).listFiles())
            .flatMap(file -> file.listFiles() == null ?  Stream.of(file) : Stream.of(file.listFiles())).collect(toList());
    
    System.out.println("Flatmap " + subfiles);
    
    
    System.out.println("Recursive " );
    listFiles(new File(".")).forEach(System.out::println);
  }
  
  private static final Stream<File> listFiles(File file) {
    if(file.isDirectory()) {
      return Stream.of(file.listFiles()).flatMap(FileFolder::listFiles);
    } else {
      return Stream.of(file);
    }
  }  
}
