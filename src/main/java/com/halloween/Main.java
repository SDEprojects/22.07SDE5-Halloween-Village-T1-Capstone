package com.halloween;

import com.halloween.controller.Game;
import com.halloween.model.Player;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class Main {

  public static void main(String[] args) throws IOException, ParseException {
    Game game = new Game();


    game.showTitle();
    game.showBackstory();
    game.showInstructions();
    game.greetPlayer();
    game.showStatus();
  }

}
