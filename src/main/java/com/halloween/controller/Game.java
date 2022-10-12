package com.halloween.controller;

import com.halloween.view.View;

public class Game {
  private View display;

  public Game() {
    this.display = new View();
  }



  public void showTitle() {
    System.out.println(display.TITLE);
  }
  public void showBackstory() {
    System.out.println(display.BACKSTORY);
  }
  public void showInstructions() {
    System.out.println(display.INSTRUCTIONS);
  }

}
