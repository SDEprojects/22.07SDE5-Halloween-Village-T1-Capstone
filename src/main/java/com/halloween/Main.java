package com.halloween;

import com.halloween.controller.Game;
import com.halloween.controller.TextParser;
import com.halloween.model.State;
import com.halloween.view.PlayMusic;
import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {
    Game game = new Game();
    TextParser textParser = new TextParser();

    boolean startNewGame = false;
    while (!startNewGame) {

      game.showMenu();

      String[] userInput = textParser.userInput();

      if (userInput[0].equals("quit")) {
        game.quitGame();
      } else if (userInput[0].equals("new") && userInput[1].equals("game")) {
        startNewGame = true;
        game.setState(State.PLAY);
      }
    }

    // Initialize the game object and get username
    game.showTitle();
    game.showBackstory();
    game.showInstructions();
    game.greetPlayer();

    // Play game until user wins, loses, or quits
    playGame(game, textParser);

  }

  private static void playGame(Game game, TextParser textParser) {

    // start the music
    game.startMusic();

    String[] input;

    while (!game.getState().isTerminal()) {

      game.showStatus();
      input = textParser.userInput();

      if (input[0].equals("quit")) {
        game.quitGame();
      } else if (input[0].equals("help")) {
        game.showHelp();
      } else if (input[0].equals("go")) {
        game.movePlayer(input[1]);
      } else if (input[0].equals("get")) {
        game.getItem();
      } else if (input[0].equals("knock")) {
        game.knockOnDoor();
      } else if (input[0].equals("use") && input[1] != null) {
        game.useItem(input[1]);
        System.out.println(input[1]);
      } else if (input[0].equals("inventory")) {
        game.showInventory();
      } else if (input[0].equals("start") && input[1].equals("music")) {
        game.startMusic();
      } else if (input[0].equals("stop") && input[1].equals("music")) {
        game.stopMusic();
      }

    }
  }


}
