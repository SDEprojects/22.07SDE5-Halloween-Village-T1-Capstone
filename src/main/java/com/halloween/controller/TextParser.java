package com.halloween.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.Buffer;
import java.util.Set;

public class TextParser {

  private final Reader reader;
  private final BufferedReader buffer;
  private static final Set<String> DIRECTIONS = Set.of(
      "north","east","south","west"
  );

  public TextParser() {
    this.reader = new InputStreamReader(System.in);
    this.buffer = new BufferedReader(reader);
  }


  public String[] userInput() {
    String input = "";
    String[] inputArray;
    do {
      System.out.println("Enter a command: ");
      try {
        input = buffer.readLine().trim().toLowerCase();

      } catch (Exception e) {
        System.out.println("Error Exception: " + e);
      }

      inputArray = input.split(" ");

    } while (!isInputValid(inputArray));

    return inputArray;
  }

  public boolean isInputValid(String[] input) {
    boolean valid = false;

    // if input array is greater than two it is not value
    if (input.length > 2) {
      System.out.println("WARNING: Invalid input! Input can NOT be more than two words!");
      return false;
      // if input has one word it can either be help or quit otherwise false
    } else if (input.length == 1) {
      if (input[0].equals("quit") || input[0].equals("help")) {
        return true;
      }
    } else {
      if(input[0].equals("go") && DIRECTIONS.contains(input[1])){
        return true;
      } else if (input[0].equals("get") && input[1].equals("item")) {
        return true;
      } else if (input[0].equals("knock") && input[1].equals("door")) {
        return true;
      } else if (input[0].equals("new") && input[1].equals("game")){
        return true;
      } else if (input[0].equals("help")) {
        return true;
      } else if (input[0].equals("quit")) {
        return true;
      }
    }

    System.out.println("WARNING: Invalid input!");
    return valid;
  }

//  public static void main(String[] args) {
//    TextParser textParser = new TextParser();
//
//    String[] input;
//    input = textParser.userInput();
//    String verb = input[0];
//    String noun = input[1];
//
//    System.out.println("Verb: " + verb);
//
//    System.out.println("You input: " + verb + " " + noun);
//
//    System.out.println(input.length);
//  }

}
