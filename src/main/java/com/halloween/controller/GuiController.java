package com.halloween.controller;

import com.halloween.model.House;
import com.halloween.model.Neighborhood;
import com.halloween.model.Player;
import com.halloween.model.State;
import com.halloween.view.PlayGameGUI;
import com.halloween.view.View;
import java.io.IOException;

public class GuiController {

  public static final String STARTING_HOUSE = "your house";
  PlayGameGUI playGameGUI;
  private View display = new View();

  Player player = new Player();
  Game game;
  String currentLocation;
  Neighborhood neighborhood;
  State state;


  public GuiController() {
    playGameGUI = new PlayGameGUI();
    game = new Game();
    neighborhood = new Neighborhood();
    state = game.getState();
    player.setPosition(STARTING_HOUSE);
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

  public void setState(State state) {
    this.state = state;
  }

  public State getState() {
    return state;
  }

  public Boolean runGame() {
    if (!game.getState().equals(State.PLAY)) {
      return false;
    } else {
      return true;
    }
  }

  public void setUpHandlers() {

    // knock
    playGameGUI.getDirectionButton().setKnockListener(
        location -> {
          House house = neighborhood.getNeighborhood().get(player.getPosition());
          System.out.println(player.getItems() + "1111111");
          playGameGUI.getScript().displayDialogue(game.knockOnDoor(house, player));
          house.setKnocked(true);
          setCurrentLocation(house.getHouseName());
        });

    // move to different direction
    playGameGUI.getDirectionButton().setDirectionListener(
        direction -> {
          String newLocation = game.movePlayer(direction, player.getPosition());
          playGameGUI.getScript().displayDialogue(game.checkValidDirection(direction, newLocation));
        if(!newLocation.isEmpty()) {
            player.setPosition(newLocation);
            playGameGUI.getUserLocationInventoryMove().updateLocation(player.getPosition());
            playGameGUI.getUserLocationInventoryMove()
                .updatePossibleMove(game.showValidMoves(player.getPosition()));
          }
        }
    );


      //get item
      playGameGUI.getDirectionButton().setGetListener(
          item -> {
            House house = neighborhood.getNeighborhood().get(player.getPosition());
            System.out.println(house.getHouseName() + "house name");
            if (house.isKnocked() && !house.getHouseItems().isEmpty()) {
              player.setItems(game.getItem(house, player.getItems()));
              playGameGUI.getUserLocationInventoryMove().updateInventory(player.getItems());
              house.removeItem();
              house.setKnocked(false);
              playGameGUI.getScript().displayDialogue(display.getNpcResponse("get_items"));
            }else if(house.isKnocked()){
              playGameGUI.getScript().displayDialogue(display.getNpcResponse("no_item_error"));
            }else{
              playGameGUI.getScript().displayDialogue(display.getNpcResponse("knock_door_first"));
            }
          });

      //use item
      playGameGUI.getUserLocationInventoryMove().setUseItemListener(
          item -> {
            House house = neighborhood.getNeighborhood().get(player.getPosition());
            System.out.println(house.isKnocked());
            System.out.println(house.getHouseName());
            if(house.isKnocked() && !house.getHouseName().equals("dracula's mansion")) {
              player.setItems(game.useItem(house, item, player.getItems()));
              playGameGUI.getUserLocationInventoryMove().updateInventory(player.getItems());
              playGameGUI.getScript().displayDialogue(display.getNpcResponse("remove_item"));
            }else if(house.isKnocked() && house.getHouseName().equals("dracula's mansion")){
              player.setItems(game.useItem(house, item, player.getItems()));
              playGameGUI.getUserLocationInventoryMove().updateInventory(player.getItems());
              playGameGUI.getScript().displayDialogue(display.getNpcResponse("draculas_tooth"));
            }else{
              playGameGUI.getScript().displayDialogue(display.getNpcResponse("knock_to_use_item"));
            }
//          state = game.getState();
        });
    state = game.getState();

    // user input
    playGameGUI.getUserInput().setUserInputListener(
        userInput -> {
          if (userInput.isEmpty()) {
            player.setName("stranger");
            playGameGUI.getScript().displayDialogue(
                "Hi, stranger!" + display.getImportantDisplay("backstory") + "\n"
                    + player.getName());
          } else {
            player.setName(userInput);
          }
          playGameGUI.getDirectionButton().getPanelForDirectionButtonsWithOtherButtons()
              .setVisible(true);
          playGameGUI.getDefaultButton().getPanelForDefaultButtons().setVisible(true);
          playGameGUI.getUserLocationInventoryMove().getPanelForLocationInventoryMove()
              .setVisible(true);

        }
    );
  }

  public void greetPlayer() throws IOException {
//      if (player.getName() != null) {
//        playGameGUI.getScript().displayDialogue(display.getNpcResponse("welcome_back") + "\n" + player.getName());
//      } else {
//        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
//        playGameGUI.getScript().displayDialogue(display.getNpcResponse("ask_name"));
    playGameGUI.getUserInput().setUserInputListener(
        userInput -> {
          playGameGUI.getScript().displayDialogue(playGameGUI.getUserInput().userInput());
          player.setName(userInput);
        }
    );
//        player.setName(buffer.readLine().trim());
//        if (player.getName().equals("quit")) {
//          quitGame();
//        }
    System.out.println(display.getNpcResponse("welcome"));
//      }
  }


  public void displayGameResult() {

    if (game.getState().equals(State.WIN)) {
      playGameGUI.getScript().displayDialogue(game.showWin());

    } else {
      playGameGUI.getScript().displayDialogue(game.showLose());
    }
  }

  public void quitGame() {
    game.quitGame();
  }

}
