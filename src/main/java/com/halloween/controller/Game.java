package com.halloween.controller;

import com.halloween.model.House;
import com.halloween.model.Neighborhood;
import com.halloween.model.Player;
import com.halloween.view.View;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.simple.parser.ParseException;

public class Game {
  private View display = new View();
  private Player player = new Player();
  private Neighborhood neighborhood = new Neighborhood();

  public Game() throws IOException, ParseException {
    setUpNeighborhood();
    player.setPosition("your house");
  }

  public void setUpNeighborhood() {
    HashMap<String, House> villageMap = new HashMap<>();
    ArrayList<String> items0 = new ArrayList<>();

    ArrayList<String> items1 = new ArrayList<>();
    items1.add("dracula\'s tooth");
    villageMap.put("amityville mansion", new House("amityville mansion", items1, new String[]{"ghost"}, null, "saw house", "addam\'s family house", null));

    ArrayList<String> items2 = new ArrayList<>();
    items2.add("thing");
    villageMap.put("saw house", new House("saw house", items2, new String[]{"jigsaw"}, null, "neighbor\'s house", "mayor\'s house", "amityville mansion"));

    ArrayList<String> items3 = new ArrayList<>();
    items3.add("candy");
    villageMap.put("neighbor\'s house", new House("neighbor\'s house", items3, new String[]{"neighbor"}, null, "karen\'s house", "your house", "saw house"));

    villageMap.put("karen\'s house", new House("karen\'s house", items0, new String[]{"karen"}, null, "dracula\'s mansion", "freddy & jason\'s house", "neighbor\'s house"));

    villageMap.put("dracula\'s mansion", new House("dracula\'s mansion", items0, new String[]{"dracula"}, null, "grandma\'s house", "witch\'s den", "karen\'s house"));

    ArrayList<String> items4 = new ArrayList<>();
    items4.add("dentures");
    villageMap.put("grandma\'s house", new House("grandma\'s house", items4, new String[]{"grandma"}, null, null, "haunted house", "dracula\'s mansion"));

    villageMap.put("addam\'s family house", new House("addam\'s family house", items0, new String[]{"wednesday addams"}, "amityville mansion", "mayor\'s house", null, null));

    ArrayList<String> items5 = new ArrayList<>();
    items5.add("deputy mayor badge");
    villageMap.put("mayor\'s house", new House("mayor\'s house", items5, new String[]{"mayor"}, "saw house", "your house", null, "addam\'s family house"));

    villageMap.put("your house", new House("your house", items0, new String[]{},"neighbor\'s house",  "freddy & jason\'s house", null, "mayor\'s house"));

    ArrayList<String> items6 = new ArrayList<>();
    items6.add("beer");
    villageMap.put("freddy & jason\'s house", new House("freddy & jason\'s house", items6, new String[]{"freddy", "jason"}, "karen\'s house", "witch\'s den", null, "your house"));

    ArrayList<String> items7 = new ArrayList<>();
    items7.add("potion");
    villageMap.put("witch\'s den", new House("witch\'s den", items7, new String[]{"witch"}, "dracula\'s mansion", "haunted house", null, "freddy & jason\'s house"));

    ArrayList<String> items8 = new ArrayList<>();
    items8.add("black cat hair");
    villageMap.put("haunted house", new House("haunted house", items8, new String[]{"zombie"}, "grandma\'s house", null, null, "witch\'s den"));

    neighborhood.setNeighborhood(villageMap);
  }

  public void greetPlayer() throws IOException {
    BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Hello there! What is your name?");
    player.setName(buffer.readLine().trim());
    System.out.printf("Welcome to Halloween Village, %s!%n", player.getName());
  }
  public void showStatus() {
    House currentPosition =  neighborhood.getNeighborhood().get(player.getPosition());
    String north = currentPosition.getNorth() != null ? "\nnorth: " + currentPosition.getNorth() : "";
    String east = currentPosition.getEast() != null ? "\neast: " + currentPosition.getEast(): "";
    String south = currentPosition.getSouth() != null ? "\nsouth: " + currentPosition.getSouth() : "";
    String west = currentPosition.getWest() != null ? "\nwest: " + currentPosition.getWest() : "";

    String playerItems = player.getItems() == null ? "nothing" : player.getItems().toString();
    String houseItems = currentPosition.getHouseItems().isEmpty() ? "a whole lot of nothing" : currentPosition.getHouseItems().toString();

    System.out.printf("\nIt looks like %s has %s", currentPosition.getHouseName(), houseItems);
    System.out.printf("\n%s is in %s and currently has %s in their inventory.\n", player.getName(), player.getPosition(), playerItems);
    System.out.println(north + east + south + west);
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
      // showValidMoves();
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

  public void getItem(String item) {
    House house =  neighborhood.getNeighborhood().get(player.getPosition());

    if (house.getHouseItems().size() > 0) {
      String temp = house.getHouseItems().get(0);
      player.addItem(temp);
      house.removeItem();
      System.out.println("You added a " + temp + " to your items!");
    } else {
      System.out.println("Error: no items available at this location!");
    }
  }

}
