package com.halloween.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.Buffer;
import java.util.Set;

public class TextParser {

  private Reader reader;
  private BufferedReader buffer;
  private static Set<String> DIRECTIONS = Set.of(
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

      inputArray = input.split("\\s+");

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
      if (input[0].equals("quit") || input[0].equals("help") || input[0].equals("knock") || input[0].equals("inventory") || input[0].equals("map") || input[0].equals("save")) {
        return true;
      }
    } else {
      if(input[0].equals("go") && DIRECTIONS.contains(input[1])){
        return true;
      } else if (input[0].equals("get") && input[1].equals("item")) {
        return true;
      } else if (input[0].equals("knock")) {
        return true;
      } else if (input[0].equals("new") && input[1].equals("game")) {
        return true;
      } else if (input[0].equals("load") && input[1].equals("game")) {
        return true;
      } else if (input[0].equals("help")) {
        return true;
      } else if (input[0].equals("quit")) {
        return true;
      } else if (input[0].equals("inventory")) {
        return true;
      } else if (input[0].equals("use")) {
        return true;
      } else if (input[0].equals("map")){
        return true;
      } else if (input[0].equals("save")){
        return true;
      }else if (input[0].equals("start") && input[1].equals("music")) {
        return true;
      } else if (input[0].equals("stop") && input[1].equals("music")) {
        return true;
      } else if (input[0].equals("increase") && input[1].equals("volume")) {
        return true;
      } else if (input[0].equals("decrease") && input[1].equals("volume")) {
        return true;
      } else if (input[0].equals("mute") && input[1].equals("fx")) {
        return true;
      } else if (input[0].equals("unmute") && input[1].equals("fx")) {
        return true;
      }
    }

    System.out.println("WARNING: Invalid input!");
    return valid;
  }
}
