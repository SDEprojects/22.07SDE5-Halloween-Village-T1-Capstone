package com.halloween;

import com.halloween.controller.Game;
import com.halloween.model.Player;
import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {
    Game game = new Game();


    game.showTitle();
    game.showBackstory();
    game.showInstructions();
    game.greetPlayer();
    game.showStatus();
  }

}
