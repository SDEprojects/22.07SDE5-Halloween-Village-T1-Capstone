package com.halloween;

import com.halloween.controller.Game;
import com.halloween.controller.TextParser;
import com.halloween.model.Player;
import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {
    Game game = new Game();
    TextParser textParser = new TextParser();

    boolean startNewGame = false;
    while (!startNewGame) {

      displayMenu();

      String[] userInput = textParser.userInput();

      if(userInput[0].equals("quit")){
        quitGame();
      } else if (userInput[0].equals("new") && userInput[1].equals("game")) {
        startNewGame = true;
      }
    }

    // Initialize the game object and get user name
    game.showTitle();
    game.showBackstory();
    game.showInstructions();
    game.greetPlayer();

    // Play game until user wins, loses, or quits
    playGame(game, textParser);

  }

  private static void playGame(Game game, TextParser textParser) {

    String[] input;
    Boolean winGame = false;


    while (!winGame) {

      game.showStatus();
      input = textParser.userInput();

      if (input[0].equals("quit")) {
        quitGame();
      } else if (input[0].equals("help")) {
        game.showInstructions();
      } else if (input[0].equals("go")) {
        if (input[1].equals("north") || input[1].equals("east") || input[1].equals("south") || input[1].equals("west")){
          game.movePlayer(input[1]);
        } else {
          System.out.println("WARNING: Invalid direction. Please choose one of the following.");
          game.showValidMoves();
        }
      }


    }
  }

  private static void displayMenu() {
    System.out.println("----- MENU -----");
    System.out.println("To start game enter: new game");
    System.out.println("To quit enter: quit");
  }

  private static void quitGame() {
    System.exit(0);
  }
}
