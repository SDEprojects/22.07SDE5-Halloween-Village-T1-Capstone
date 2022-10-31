package com.halloween.controller;

import com.halloween.view.GuiGame;

public class GuiController {
  GuiGame guiGame;

  public void setGame(Game game) {
    this.game = game;
  }

  Game game;

  public GuiController(){
    guiGame = new GuiGame();
//    game = new Game();
  }
  public static void playGame(Game game) {
    System.out.println("GuiController");
    game.currentLocation();
  }
  public void knockOnDoor(){
    game.knockOnDoor();
  }
  public Game getGame() {
    return game;
  }
//  public void currentLocation(){
//   game.currentLocation();
//  }

}
