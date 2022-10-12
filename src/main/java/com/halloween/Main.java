package com.halloween;

import com.halloween.controller.Game;

public class Main {

  public static void main(String[] args) {
    Game game = new Game();


    game.showTitle();
    game.showBackstory();
    game.showInstructions();
  }

}
