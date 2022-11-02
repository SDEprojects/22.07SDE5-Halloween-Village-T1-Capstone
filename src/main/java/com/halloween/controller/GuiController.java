package com.halloween.controller;

import com.halloween.model.House;
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
    System.out.println("your current Location isss " + currentLocation);
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
          game.knockOnDoor(currentLocation);
          House house = neighborhood.getNeighborhood().get(currentLocation);
          house.setKnocked(true);
          if(house.getHouseName() != null) {
            setCurrentLocation(house.getHouseName());
          }
        });

    playGameGUI.getDirectionButton().setDirectionListener(
        direction-> {
          String newLocation = game.movePlayer(direction, currentLocation);
          if(!newLocation.isEmpty()) {
            setCurrentLocation(newLocation);
          }
        }
    );

    playGameGUI.getDirectionButton().setGetListener(
        item-> {
          House house = neighborhood.getNeighborhood().get(currentLocation);
          inventory = game.getItem(house, inventory);
          playGameGUI.getUserLocationInventoryMove().updateInventory(inventory);
          if (house.isKnocked() && !house.getHouseItems().isEmpty()){
            house.removeItem();
            house.setKnocked(false);
            System.out.println(inventory);
          }
        }
    );

    }

//  public void knockOnDoor(){
//    game.knockOnDoor(currentLocation);
//  }
  public Game getGame() {
    return game;
  }



}
