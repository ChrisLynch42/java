/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeexcursion.functional.chapter5;

import java.io.IOException;

/**
 *
 * @author lynchcs
 */
public class FakeDatabaseHandler {

  private final String connectionInfo;

  private FakeDatabaseHandler(final String connectionInfo) {
    this.connectionInfo = connectionInfo;
    connect();
  }

  private void connect() {
    System.out.println("connected to database. " + connectionInfo);
  }

  public void runSQL(String query) {
    System.out.println("Run " + query);
  }

  private void close() throws IOException {
    System.out.println("closed database connection");
  }

  public static void runSQL(String connectionInfo, IDatabaseQuery<FakeDatabaseHandler, IOException> block) throws IOException {
    final FakeDatabaseHandler handler = new FakeDatabaseHandler(connectionInfo);
    try {
      block.accept(handler);
    } finally {
      handler.close();
    }

  }
  
  public static void main(String[] args) throws IOException {
    FakeDatabaseHandler.runSQL("name=chris;password=none;999.999.999.999", database -> database.runSQL("Select * from User_"));
  }
  
}
