package com.halloween.controller;

import com.halloween.model.Neighborhood;
import com.halloween.model.Player;
import com.halloween.view.PlayGameGUI;
import java.util.ArrayList;

public class GuiController {
  PlayGameGUI playGameGUI;
  Player player;
  Game game;
  String currentLocation;
  ArrayList<String> inventory;
  Neighborhood neighborhood;




  public GuiController(){
    playGameGUI = new PlayGameGUI();
    game = new Game();
    neighborhood = new Neighborhood();
    currentLocation = "your house";
    inventory = new ArrayList<>();
//    playGameGUI.setKnockListener(location -> {
//      System.out.println("knocked");
//    });
  }

  public void setCurrentLocation(String currentLocation) {
    this.currentLocation = currentLocation;
  }

  public String getCurrentLocation() {
    return currentLocation;
  }

  public void setGame(Game game) {
    this.game = game;
  }


  public static void playGame(Game game) {
    System.out.println("GuiController");
    game.currentLocation();


  }

  public void updateGuiView(String location){
    playGameGUI.updateKnockButton(location);
  }



  public void setUpHandlers() {


    playGameGUI.getDirectionButton().setKnockListener(
        location -> {
          game.knockOnDoor(location);
        });
    }

  public void knockOnDoor(){
    game.knockOnDoor(currentLocation);
  }
  public Game getGame() {
    return game;
  }



}
