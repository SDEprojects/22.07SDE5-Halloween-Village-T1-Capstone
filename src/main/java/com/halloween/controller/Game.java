package com.halloween.controller;

import com.halloween.model.House;
import com.halloween.model.Neighborhood;
import com.halloween.model.Player;
import com.halloween.model.State;
import com.halloween.view.View;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Game {
  private State state;
  private View display = new View();
  private Player player = new Player();
  private Neighborhood neighborhood = new Neighborhood();

  public Game() throws IOException {
    player.setPosition("your house");
  }

  public void greetPlayer() throws IOException {
    BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Hello there! What is your name?");
    player.setName(buffer.readLine().trim());
    System.out.printf("Welcome to Halloween Village, %s!%n", player.getName());
  }
  public void showStatus() {
    House currentPosition =  neighborhood.getNeighborhood().get(player.getPosition());
    String playerItems = player.getItems() == null ? "nothing" : player.getItems().toString();
    String houseItems = currentPosition.getHouseItems().isEmpty() ? "a whole lot of nothing" : currentPosition.getHouseItems().toString();

    System.out.printf("\nIt looks like %s has %s", currentPosition.getHouseName(), houseItems);
    System.out.printf("\n%s is in %s and currently has %s in their inventory.\n", player.getName(), player.getPosition(), playerItems);
    showValidMoves();
  }

  public void showMenu(){
    display.displayMenu();
  }
  public void showTitle() {
    System.out.println(View.TITLE);
  }
  public void showBackstory() {
    System.out.println(View.BACKSTORY);
  }
  public void showInstructions() {
    System.out.println(View.INSTRUCTIONS);
  }

  public void movePlayer(String direction) {
    House currentPosition =  neighborhood.getNeighborhood().get(player.getPosition());

    // set the previous house knocked to false before moving
    currentPosition.setKnocked(false);

    if(direction.equals("north") && currentPosition.getNorth() != null){
      player.setPosition(currentPosition.getNorth());
      System.out.println(player.getName() + " moved north. New position is " + player.getPosition());
    } else if (direction.equals("east") && currentPosition.getEast() != null) {
      player.setPosition(currentPosition.getEast());
      System.out.println(player.getName() + " moved east. New position is " + player.getPosition());
    }  else if (direction.equals("south") && currentPosition.getSouth() != null) {
      player.setPosition(currentPosition.getSouth());
      System.out.println(player.getName() + " moved south. New position is " + player.getPosition());
    }  else if (direction.equals("west") && currentPosition.getWest() != null) {
      player.setPosition(currentPosition.getWest());
      System.out.println(player.getName() + " moved west. New position is " + player.getPosition());
    } else {
      System.out.println("WARNING: " + direction + " is an invalid direction. Please choose one of the following.");
       showValidMoves();
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
        System.out.println("You added a " + temp + " to your items!");
      } else {
        System.out.println("Error: no items available at this location!");
      }
    } else {
      System.out.println("Uh Oh! You can't get trick or treat without knocking on the door first!");
      System.out.println("Try using the 'knock' command to get your treats!");
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
          System.out.println("Karen: Look a trespasser! I'm calling the cops!");
        }
        // if we don't have a badge, potion, or ruby we lose the game
        else {
          display.greet(player.getPosition());
          System.out.println("You are arrested and lose the game! Game Over!");
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
    System.out.println("See you next time");
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

      // if we use the badge at karen's house then we win the game
      if (house.getHouseName().equals("karen's house") && item.equals("badge")
          && successfullyUsedItem) {
        // TODO: add to output to view
        System.out.println("Karen is defeated using the deputy mayor badge! You win!");
        setState(State.WIN);
      } else if (house.getHouseName().equals("karen's house") && item.equals("potion") && successfullyUsedItem) {
        // TODO: add output to view
        System.out.println("Karen is defeated using the potion! You win!");
        setState(State.WIN);
      } else if (house.getHouseName().equals("karen's house") && item.equals("ruby") && successfullyUsedItem) {
        // TODO: add output to view
        System.out.println("*You throw down a red ruby, it turns into plume of smoke which Dracula appears from*");
        System.out.println("Dracula: Oh hello Karen. Do you mind if I grab a quick drink (smile and wink)?");
        System.out.println("*Karen faints*");
        System.out.println("Karen is defeated using help from Dracula! You win!");
        setState(State.WIN);
      } else if (house.getHouseName().equals("dracula's mansion") && item.equals("tooth") && successfullyUsedItem) {
        System.out.println("Dracula: Wow! You found my tooth! Thank you so much. If you run into any trouble, use this ruby and help will come!");
        // added dracula's ruby to our inventory
        // NOTE: dracula's tooth is a hidden item, so we don't store it in the house
        player.addItem("ruby");
      } else if (house.getHouseName().equals("witch's den")) {
        if (item.equals("cat-hair") || item.equals("beer") || item.equals("dentures")) {
          System.out.println("Hmmm yes, a " + item + " I can add this to my Witch's brew, and make a potion for you!");
          System.out.println("Once I have all three ingredients, my potion will be complete with an expedience!");
          house.addItem(item);

          ArrayList<String> witchHouseItems = house.getHouseItems();
          if (witchHouseItems.contains("cat-hair") && witchHouseItems.contains("beer") && witchHouseItems.contains("dentures")) {
            System.out.println("Well done young one. My potion is complete, isn't that neat!");
            System.out.println("I've added the potion to your items. Use it against any foe that wishes you harm!");
            // NOTE: potion is a hidden item, so we don't store it in the house
            player.addItem("potion");
          }
        } else {
          System.out.println("Hmmm nope! I can't use this a " + item + " in my brew, but i'll still take it from you!");
        }
      }
    } else {
      System.out.println("Uh Oh! You can't use an item without knocking on the door first!");
    }
  }

  public void showInventory() {
    System.out.println("Items in inventory: " + player.getItems());
  }
}
