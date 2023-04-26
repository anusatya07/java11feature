package com.v2;
public class Java16PatternMatchingScopeTest {

  public static void main(String[] args) {
    new Java16PatternMatchingScopeTest().processObject("Happy Coding!");
  }

  private String s = "Hello, world!";

  private void processObject(Object obj) {
    System.out.println(s);           // Prints "Hello, world!"
    if (obj instanceof String s) {
      System.out.println(s);         // Prints "Happy Coding!"
      System.out.println(this.s);    // Prints "Hello, world!"
    }
  }
}