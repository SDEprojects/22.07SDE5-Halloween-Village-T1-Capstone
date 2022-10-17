package com.halloween.controller;

import com.halloween.model.House;
import com.halloween.model.Neighborhood;
import com.halloween.model.Player;
import com.halloween.model.State;
import com.halloween.view.View;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.simple.parser.ParseException;

public class Game {
  private State state;
  private View display = new View();
  private Player player = new Player();
  private Neighborhood neighborhood = new Neighborhood();

  public Game() throws IOException, ParseException {
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
    if (house.getHouseItems().isEmpty()) {
      display.noItem(player.getPosition());
    } else {
      display.greet(player.getPosition());
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
}
