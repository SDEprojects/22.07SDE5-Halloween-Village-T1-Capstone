package com.halloween;

import com.halloween.controller.GuiController;
import com.halloween.model.State;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Main {

  public static void main(String[] args) throws IOException {

    GuiController guiController = new GuiController();
    Thread thread = new Thread();


//    guiController.greetPlayer();
    boolean run;
    do {
      guiController.setUpHandlers();
      run = guiController.runGame();
    }while (run);
    try {
      thread.sleep(5000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    guiController.displayGameResult();
    try {
      thread.sleep(5000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }guiController.quitGame();





//    TimeUnit.SECONDS.sleep(3);
//      guiController.displayGameResult();
//    guiController.quitGame();
    }
}

//  Game game = new Game();
//  TextParser textParser = new TextParser();


//    boolean startGame = false;
//    while (!startGame) {
//
//      game.showMenu();
//
//      String[] userInput = textParser.userInput();
//
//      if (userInput[0].equals("quit")) {
//        game.quitGame();
//      } else if (userInput[0].equals("new") && userInput[1].equals("game")) {
//        startGame = true;
//        game.setState(State.PLAY);
//      } else if (userInput[0].equals("load") && userInput[1].equals("game")) {
//        startGame = true;
//        game = game.loadGame();
//        game.setState(State.PLAY);
//      }
//    }
//
//    // Initialize the game object and get username
//    game.showTitle();
//    game.showBackstory();
//    game.showInstructions();
//    game.greetPlayer();
//
//    // Play game until user wins, loses, or quits
//    playGame(game, textParser);
//
//  }
//
//  private static void playGame(Game game, TextParser textParser) {
//
//    // start the music
//    game.startMusic();
//
//    String[] input;
//    game.showStatus();
//    while (!game.getState().isTerminal()) {
//
//      input = textParser.userInput();
//
//      if (input[0].equals("quit")) {
//        game.quitGame();
//      } else if (input[0].equals("save")) {
//        game.saveGame();
//      } else if (input[0].equals("help")) {
//        game.showHelp();
//      } else if (input[0].equals("inventory")) {
//        game.showInventory();
//      } else if (input[0].equals("map")) {
//        game.showMap();
//      } else if (input[0].equals("start") && input[1].equals("music")) {
//        game.startMusic();
//      } else if (input[0].equals("stop") && input[1].equals("music")) {
//        game.stopMusic();
//      } else if (input[0].equals("increase") && input[1].equals("volume")) {
//        game.increaseVolume();
//      } else if (input[0].equals("decrease") && input[1].equals("volume")) {
//        game.decreaseVolume();
//      }  else if (input[0].equals("mute") && input[1].equals("fx")) {
//        muteSoundEffects();
//      } else if (input[0].equals("unmute") && input[1].equals("fx")) {
//        unmuteSoundEffects();
//      } else {
//        if (input[0].equals("go")) {
//          game.movePlayer(input[1]);
//        } else if (input[0].equals("knock")) {
//          game.knockOnDoor();
//        } else if (input[0].equals("get")) {
//          game.getItem();
//        } else if (input[0].equals("use") && input[1] != null) {
//          game.useItem(input[1]);
//        }
//        game.showStatus();
//      }
//    }
//    if (game.getState().equals(State.WIN)) {
//      game.showWin();
//      game.removeFiles();
//    } else {
//      game.showLose();
//      game.removeFiles();
//
//    }
//  }


//}
