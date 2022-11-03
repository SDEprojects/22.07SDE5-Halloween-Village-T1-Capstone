package com.halloween.controller;

import com.halloween.model.House;
import com.halloween.model.Neighborhood;
import com.halloween.model.Player;
import com.halloween.model.State;
import com.halloween.view.PlayGameGUI;
import java.util.ArrayList;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class GuiController {

  public static final String STARTING_HOUSE = "your house";
  PlayGameGUI playGameGUI;

  Player player;
  Game game;
  String currentLocation;
  ArrayList<String> inventory;
  Neighborhood neighborhood;
  State state;


  public GuiController() {
    playGameGUI = new PlayGameGUI();
    game = new Game();
    neighborhood = new Neighborhood();
    currentLocation = STARTING_HOUSE;
    inventory = new ArrayList<>();
    state = game.getState();
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


  public Boolean runGame(){
    if (!game.getState().equals(State.PLAY)){
      return false;
    }else{
      return true;
    }
  }

  public void setUpHandlers() {
    // knock
    playGameGUI.getDirectionButton().setKnockListener(
        location -> {
          playGameGUI.getScript().displayKnock(game.knockOnDoor(currentLocation));
          House house = neighborhood.getNeighborhood().get(currentLocation);
          house.setKnocked(true);
          setCurrentLocation(house.getHouseName());
          System.out.println(game.getState() + "this is from handler 61");

          if(house.getHouseName() != null) {
            setCurrentLocation(house.getHouseName());
          }
        });

    // move to different direction
    playGameGUI.getDirectionButton().setDirectionListener(
        direction-> {
          String newLocation = game.movePlayer(direction, currentLocation);
          playGameGUI.getScript().displayKnock(game.checkValidDirection(direction, newLocation));

          if(!newLocation.isEmpty()) {
            setCurrentLocation(newLocation);
            playGameGUI.getUserLocationInventoryMove().updateLocation(currentLocation);
            playGameGUI.getUserLocationInventoryMove().updatePossibleMove(game.showValidMoves(currentLocation));
          }
        }
    );

    //get item
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
        });

    //use item
    playGameGUI.getUserLocationInventoryMove().setUseItemListener(
        item-> {
          House house = neighborhood.getNeighborhood().get(currentLocation);
          inventory = game.useItem(house, item, inventory);
          playGameGUI.getUserLocationInventoryMove().updateInventory(inventory);
//          state = game.getState();
        });

    }
    public void displayGameResult(){

      if(game.getState().equals(State.WIN)){
        game.showWin();

      }else{
        game.showLose();
      }
    }
    public void quitGame(){
    game.quitGame();
    }

}
