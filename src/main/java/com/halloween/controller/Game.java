package com.halloween.controller;

import com.halloween.model.House;
import com.halloween.model.Neighborhood;
import com.halloween.model.Player;
import com.halloween.model.State;
import com.halloween.view.PlayMusic;
import com.halloween.view.View;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Game {
  private State state;
  private View display = new View();
  private Player player = new Player();
  private Neighborhood neighborhood = new Neighborhood();

  private PlayMusic musicPlayer = new PlayMusic();

  public Game() throws IOException {
    player.setPosition("your house");
  }

  public void greetPlayer() throws IOException {
    BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    System.out.println(display.getNpcResponse("ask_name"));
    player.setName(buffer.readLine().trim());
    System.out.printf(display.getNpcResponse("welcome"), player.getName());
  }
  public void showStatus() {
    House currentPosition =  neighborhood.getNeighborhood().get(player.getPosition());
    String playerItems = player.getItems() == null ? "nothing" : player.getItems().toString();
    String houseItems = currentPosition.getHouseItems().isEmpty() ? "a whole lot of nothing" : currentPosition.getHouseItems().toString();

    System.out.printf(display.getNpcResponse("house_item"), currentPosition.getHouseName(), houseItems);
    System.out.printf(display.getNpcResponse("item_in_inventory"), player.getName(), player.getPosition(), playerItems);
    showValidMoves();
  }

  public void showMenu(){
    System.out.println(display.getMenu());;
  }
  public void showTitle() {
    System.out.println(display.getTitle());
  }
  public void showBackstory() {
    System.out.println(display.getBackstory());
  }
  public void showInstructions() {
    System.out.println(display.getInstructions());
  }
  public void showHelp() {
    System.out.println(display.getHelp());
  }
  public void showInventory() {
    System.out.printf(display.getNpcResponse("show_inventory"), player.getItems());
  }
  public void showMap(){
    System.out.println(display.getMap());
  }


  public void movePlayer(String direction) {
    House currentPosition =  neighborhood.getNeighborhood().get(player.getPosition());
    String playersMove = neighborhood.isValidDirection(direction, currentPosition);

    // set the previous house knocked to false before moving
    currentPosition.setKnocked(false);

    if (playersMove.isEmpty()){
      System.out.printf(display.getNpcResponse("invalid_direction"), direction);
      showValidMoves();
    } else {
      player.setPosition(playersMove);
      System.out.printf( display.getNpcResponse("players_move"), player.getName(), direction, player.getPosition());
    }
  }

  public void showValidMoves() {
    House currentPosition =  neighborhood.getNeighborhood().get(player.getPosition());
    String north = currentPosition.getNorth() != null ? "\nnorth: " + currentPosition.getNorth() : "";
    String east = currentPosition.getEast() != null ? "\neast: " + currentPosition.getEast(): "";
    String south = currentPosition.getSouth() != null ? "\nsouth: " + currentPosition.getSouth() : "";
    String west = currentPosition.getWest() != null ? "\nwest: " + currentPosition.getWest() : "";
    System.out.println(north + east + south + west);
  }

  public void getItem() {
    House house =  neighborhood.getNeighborhood().get(player.getPosition());
    if (house.isKnocked()) {
      if (house.getHouseItems().size() > 0) {
        String temp = house.getHouseItems().get(0);
        player.addItem(temp);
        house.removeItem();
        System.out.printf(display.getNpcResponse("get_items"), temp);
      } else {
        System.out.println(display.getNpcResponse("no_item_error"));
      }
    } else {
      System.out.println(display.getNpcResponse("knock_door_first"));
      System.out.println(display.getNpcResponse("knock_door"));
    }
    house.setKnocked(false);
  }

  public void knockOnDoor() {
    House house =  neighborhood.getNeighborhood().get(player.getPosition());
    house.setKnocked(true);
    ArrayList<String> playerItems = player.getItems();
    // If we knock on karen's house or the saw house we need to have check for specific items in our inventory
    // If we do not have the items, then we lose the game
    if (house.getHouseName().equals("karen's house") || house.getHouseName().equals("saw house")){
      // If we knock on karen's door
      if (house.getHouseName().equals("karen's house")) {
        // if we have a badge, potion, or ruby, then do nothing
        if (playerItems.contains("badge") || playerItems.contains("potion") || playerItems.contains("ruby")) {
          System.out.println(display.getNpcResponse("karen_calling_cops"));
        }
        // if we don't have a badge, potion, or ruby we lose the game
        else {
          display.greet(player.getPosition());
          System.out.println(display.getNpcResponse("player_arrested"));
          setState(State.LOSE);
        }
      }
      // if knock on the saw house
      if (house.getHouseName().equals("saw house")) {
        // check for "thing" in not in our items then we lose the game
        if (!playerItems.contains("thing")){
          display.noItem(player.getPosition());
          setState(State.LOSE);
        } // otherwise, thing will free us from the trap, and be removed from the inventory
        else {
          // System.out.println("Suddenly, thing jumps from your candy bag, and frees you! RUN WHILE YOU CAN!");
          display.greet(player.getPosition());
          player.removeItem("thing");
        }
      }
    } else {
      // for all other houses (besides karen's house and saw house) we do the following
      if (house.getHouseItems().isEmpty()) {
        display.noItem(player.getPosition());
      } else {
        display.greet(player.getPosition());
      }
    }
  }

  public void quitGame() {
    System.out.println(display.getNpcResponse("exit_game"));
    System.exit(0);
  }
  public State getState() {
    return state;
  }

  public void setState(State state) {
    this.state = state;
  }

  public void useItem(String item) {
    // get the house the player is currently at
    House house = neighborhood.getNeighborhood().get(player.getPosition());

    // if the house is knocked then try to use the item
    if (house.isKnocked()) {
      showInventory();
      boolean successfullyUsedItem = player.removeItem(item);

      String response = successfullyUsedItem ? "remove_item" : "warning_remove_item";
      System.out.printf(display.getNpcResponse(response), item);

//      if (successfullyUsedItem){
//        System.out.println("You used a " + item + ". This item is now removed from your inventory.");
//      } else {
//        System.out.println("Warning: Can NOT use " + item + " because it not in your inventory.");
//      }

      // if we use the badge at karen's house then we win the game
      if (house.getHouseName().equals("karen's house") && item.equals("badge")
          && successfullyUsedItem && house.isKnocked()) {
        System.out.println(display.getNpcResponse("karen_defeated_badge"));
        setState(State.WIN);
      } else if (house.getHouseName().equals("karen's house") && item.equals("potion") && successfullyUsedItem) {
        System.out.println(display.getNpcResponse("karen_defeated_potion"));
        setState(State.WIN);
      } else if (house.getHouseName().equals("karen's house") && item.equals("ruby") && successfullyUsedItem) {
        System.out.println(display.getNpcResponse("karen_defeated_ruby"));
        setState(State.WIN);
      } else if (house.getHouseName().equals("dracula's mansion") && item.equals("tooth") && successfullyUsedItem) {
        System.out.println(display.getNpcResponse("draculas_tooth"));
        // added dracula's ruby to our inventory
        // NOTE: dracula's tooth is a hidden item, so we don't store it in the house
        player.addItem("ruby");
      } else if (house.getHouseName().equals("witch's den")) {
        if (item.equals("cat-hair") || item.equals("beer") || item.equals("dentures")) {
          System.out.printf(display.getNpcResponse("give_witch_ingredient"), item);
          house.addItem(item);
          ArrayList<String> witchHouseItems = house.getHouseItems();
          if (witchHouseItems.contains("cat-hair") && witchHouseItems.contains("beer") && witchHouseItems.contains("dentures")) {
            System.out.println(display.getNpcResponse("complete_witch_potion"));
            // NOTE: potion is a hidden item, so we don't store it in the house
            player.addItem("potion");
          }
        } else {
          System.out.printf(display.getNpcResponse("incorrect_witch_ingredient"), item);
        }
      }
    } else {
      System.out.println(display.getNpcResponse("knock_to_use_item"));
    }
  }

  public void startMusic() {
    String musicName = "/darkess.wav";
    musicPlayer.play(musicName);
  }

  public void stopMusic() {
    musicPlayer.stop();
  }

  public void increaseVolume() {
    musicPlayer.increaseVolume();
  }

  public void decreaseVolume() {
    musicPlayer.decreaseVolume();
  }

}
