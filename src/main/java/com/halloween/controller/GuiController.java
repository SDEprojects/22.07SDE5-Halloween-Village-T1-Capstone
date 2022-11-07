package com.halloween.controller;

import static com.halloween.view.SoundEffects.playSound;

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
            playGameGUI.getUserLocationInventoryMove().updatePossibleMove(game.showValidMoves(player.getPosition()));
            playGameGUI.setBackgroundImage(player.getPosition());
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
//            String newItem = item.toLowerCase();
            System.out.println(item + player.getItems());

            if(house.isKnocked()){
              player.setItems(game.useItem(house, item, player.getItems()));
              playGameGUI.getUserLocationInventoryMove().updateInventory(player.getItems());

              if (house.getHouseName().equals("dracula's mansion")){
                if(item.equals("TOOTH")){
                  playGameGUI.getScript().displayDialogue(display.getNpcResponse("draculas_tooth"));
                }else{
                  playGameGUI.getScript().displayDialogue(display.getNpcResponse("draculas_incorrect_item"));
                }
              }
              else if (house.getHouseName().equals("karen's house")){
//                player.setItems(game.useItem(house, item, player.getItems()));
//                playGameGUI.getUserLocationInventoryMove().updateInventory(player.getItems());
                if(item.equals("BADGE")){
                  playGameGUI.getScript().displayDialogue(display.noItem("karen's house"));
                }else if(item.equals("POTION")){
                  playGameGUI.getScript().displayDialogue(display.getNpcResponse("karen_defeated_potion"));

                }else if(item.equals("RUBY")){
                  playGameGUI.getScript().displayDialogue(display.getNpcResponse("karen_defeated_ruby"));
                }else{
                  playGameGUI.getScript().displayDialogue(display.getNpcResponse("karen_incorrect_item"));
                }
              }else if (house.getHouseName().equals("witch's den")){
                playGameGUI.getScript().displayDialogue(display.getNpcResponse("remove_item"));
                if(item.equals("CAT-HAIR") || item.equals("BEER") || item.equals("DENTURES")) {
                  playGameGUI.getScript()
                      .displayDialogue(display.getNpcResponse("give_witch_ingredient"));
                } else{
                  playGameGUI.getScript().displayDialogue(display.getNpcResponse("incorrect_witch_ingredient"));
                }
                if(house.getHouseItems().contains("CAT-HAIR") && house.getHouseItems().contains("BEER") && house.getHouseItems().contains("DETURES")){
                  playGameGUI.getScript().displayDialogue(display.getNpcResponse("complete_witch_potion"));
              }}} else{
              playGameGUI.getScript().displayDialogue(display.getNpcResponse("knock_to_use_item"));
            }

        });
    state = game.getState();

    // user input
    playGameGUI.getUserInput().setUserInputListener(
        userInput -> {
          if (userInput.isEmpty()) {
            player.setName("stranger");
            playGameGUI.getScript().displayDialogue(
                "Hi, stranger!" + display.getImportantDisplay("backstory") + "\n");
          } else {
            player.setName(userInput);
            playGameGUI.getScript().displayDialogue(
                "Hi, " + player.getName() + "!" + display.getImportantDisplay("backstory") + "\n");
          }
          playGameGUI.getDirectionButton().getPanelForDirectionButtonsWithOtherButtons()
              .setVisible(true);
          playGameGUI.getDefaultButton().getPanelForDefaultButtons().setVisible(true);
          playGameGUI.getUserLocationInventoryMove().getPanelForLocationInventoryMove()
              .setVisible(true);
        }
    );
  }


  public void playGame(){
    Thread thread = new Thread();

    boolean run;
    do {
      setUpHandlers();
      run = runGame();
    }while (run);
    try {
      thread.sleep(7000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    displayGameResult();
//    try {
//      thread.sleep(7000);
//    } catch (InterruptedException e) {
//      throw new RuntimeException(e);
//    }
//    quitGame();
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
