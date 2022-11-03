package com.halloween.controller;

import static com.halloween.view.SoundEffects.playSound;

import com.google.gson.Gson;
import com.halloween.model.House;
import com.halloween.model.Neighborhood;
import com.halloween.model.Player;
import com.halloween.model.State;
import com.halloween.view.PlayGameGUI;
import com.halloween.view.PlayMusic;
import com.halloween.view.View;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class Game {

  private State state;
  private View display = new View();
  private Player player = new Player();
  private Neighborhood neighborhood = new Neighborhood();
  private StoreGame storeGame = new StoreGame();
  private PlayMusic musicPlayer = new PlayMusic();
  private static PlayGameGUI playGameGUI;


  public Game() {
    player.setPosition("your house");
    state = State.PLAY;
//    System.out.println(player.getPosition());
  }

  public Game(State state, Player player, Neighborhood neighborhood) {
    this.state = State.PLAY;
    this.player = player;
    this.neighborhood = neighborhood;
  }

  public String currentLocation() {
    return player.getPosition();
  }

  // Greeting user by displaying welcome message and ask name. user can quit the game by typing "quit"
  public void greetPlayer() throws IOException {
    if (player.getName() != null) {
      System.out.println(display.getNpcResponse("welcome_back") + "\n" + player.getName());
    } else {
      BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
      System.out.println(display.getNpcResponse("ask_name"));
      player.setName(buffer.readLine().trim());
      if (player.getName().equals("quit")) {
        quitGame();
      }
      System.out.println(display.getNpcResponse("welcome"));
    }
  }

  // Display user status including user's current location, inventory items, and item in house.
  public String showStatus(String location) {
    House currentPosition = neighborhood.getNeighborhood().get(location);
    String playerItems = player.getItems().isEmpty() ? "nothing" : player.getItems().toString();
    String houseItems = currentPosition.getHouseItems().isEmpty() ? "a whole lot of nothing"
        : currentPosition.getHouseItems().toString();
    return (currentPosition.getHouseName() + "\n\nIt looks like this house has " + houseItems);
//    return (display.getNpcResponse("house_item") + currentPosition.getHouseName() +
//        houseItems);
//    System.out.printf(display.getNpcResponse("item_in_inventory"), player.getName(),
//        player.getPosition(), playerItems);
//    showValidMoves();
  }

  // Display user menu
  public void showMenu() {
    System.out.println(display.getImportantDisplay("menu"));
  }

  public void showTitle() {
    System.out.println(display.getImportantDisplay("title"));
  }

  public void showBackstory() {
    System.out.println(display.getImportantDisplay("backstory"));
  }

  public void showInstructions() {
    System.out.println(display.getImportantDisplay("instruction"));
  }

  public void showHelp() {
    System.out.println(display.getImportantDisplay("help"));
  }

  public void showInventory() {
    System.out.printf(display.getNpcResponse("show_inventory"), player.getItems());
  }

  // Display map
  public void showMap() {
    System.out.println(display.getImportantDisplay("map"));
  }

  // Display valid moves from user's current location
  public String showValidMoves(String location) {
    House currentPosition = neighborhood.getNeighborhood().get(location);
    String north =
        currentPosition.getNorth() != null ? "\n\nnorth: " + currentPosition.getNorth() : "";
    String east = currentPosition.getEast() != null ? "\n\neast: " + currentPosition.getEast() : "";
    String south =
        currentPosition.getSouth() != null ? "\n\nsouth: " + currentPosition.getSouth() : "";
    String west = currentPosition.getWest() != null ? "\n\nwest: " + currentPosition.getWest() : "";
//    System.out.println(north + east + south + west);
    return (north + east + south + west);
  }

  // Display win message
  public String showWin() {
    return display.getImportantDisplay("win");
  }

  //Display lose message
  public String showLose() {
    return display.getImportantDisplay("lose");
  }

  // Update user's current location
  public String movePlayer(String direction, String location) {
    House currentPosition = neighborhood.getNeighborhood().get(location);
    String playersMove = neighborhood.isValidDirection(direction, currentPosition);
    System.out.println("player move is " + playersMove);
    // set the previous house knocked to false before moving
    currentPosition.setKnocked(false);
    checkValidDirection(direction, playersMove);
    return playersMove;
  }

  public String checkValidDirection(String direction, String playersMove) {
    if (playersMove.isEmpty()) {
      return ("WARNING: " + direction + " is an invalid direction. Please choose one of the possible moves.");
//      showValidMoves(location);
    } else {
      player.setPosition(playersMove);
      playSound("/footsteps.wav");
      return ("You moved to "+ direction + ".");

    }
  }

  // User get item, and save it to the inventory
  public ArrayList<String> getItem(House house, ArrayList<String> inventory) {
    if (house.isKnocked() && house.getHouseItems().size() > 0) {
      String temp = house.getHouseItems().get(0);
      inventory.add(temp);
      player.setPosition(house.getHouseName());
      System.out.printf(display.getNpcResponse("get_items"), temp);
    } else if (house.isKnocked()) {
      System.out.println(display.getNpcResponse("no_item_error"));
    } else {
      System.out.println(display.getNpcResponse("knock_door_first"));
      System.out.println(display.getNpcResponse("knock_door"));
    }
    return inventory;
  }

  //  GuiScript guiScript = new GuiScript();
  // set knocked value to true when user knocks. also checks user's inventory when user knocks on Karen's house or Saw house.
  public String knockOnDoor(String location) {
    House house = neighborhood.getNeighborhood().get(location);

//    house.setKnocked(true);

    String knock = "/door-knock.wav";
    playSound(knock);

    ArrayList<String> playerItems = player.getItems();
    // If we knock on karen's house or the saw house we need to have check for specific items in our inventory
    // If we do not have the items, then we lose the game
    // If we knock on karen's door
    if (house.getHouseName().equals("karen's house")) {
      knockOnKarenHouse(playerItems);
      // if knock on the saw house
    } else if (house.getHouseName().equals("saw house")) {
      knockOnSawHouse(playerItems);
      // for all other houses (besides karen's house and saw house) we do the following
    } else if (house.getHouseItems().isEmpty()) {
//      playGameGUI.getScript().displayKnock(display.noItem(player.getPosition()));
      return display.noItem(player.getPosition());
//    } else {
////      System.out.println(display.greet(player.getPosition()));
//      return display.greet(player.getPosition());
    }
    return display.greet(player.getPosition());
  }

  // LOSE CONDITION 1
  private String knockOnSawHouse(ArrayList<String> playerItems) {
    // check for "thing" in not in our items then we lose the game
    if (!playerItems.contains("thing")) {
//      System.out.println(display.noItem(player.getPosition()));
      setState(State.LOSE);
      return display.noItem(player.getPosition());
//      setState(State.LOSE);
    } // otherwise, thing will free us from the trap, and be removed from the inventory
    else {
      // System.out.println("Suddenly, thing jumps from your candy bag, and frees you! RUN WHILE YOU CAN!");
//      System.out.println(display.greet(player.getPosition()));
      player.removeItem("thing");
      return display.greet(player.getPosition());

    }
  }

  // LOSE CONDITION 2
  // When user knock on Karen's house, if user has "badge" or "potion" or"ruby" in the inventory, Karen calls cop"
  // if not, the user lose the game.
  private String knockOnKarenHouse(ArrayList<String> playerItems) {
    // if we have a badge, potion, or ruby, then do nothing
    if (playerItems.contains("badge") || playerItems.contains("potion") || playerItems.contains(
        "ruby")) {
//      System.out.println(display.getNpcResponse("karen_calling_cops"));
      return display.getNpcResponse("karen_calling_cops");
    }
    // if we don't have a badge, potion, or ruby we lose the game
    else {
//      System.out.println(display.greet(player.getPosition()));

      try {
        TimeUnit.SECONDS.sleep(2);  // Wait 2 seconds
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      playSound("/evil-shreik.wav");
      setState(State.LOSE);
      return (display.greet(player.getPosition()) + display.getNpcResponse("player_arrested"));
    }
  }

  public void quitGame() {
    System.out.println(display.getNpcResponse("exit_game"));
    System.exit(0);
  }

  public void saveGame() {
    storeGame.saveGame(state, player, neighborhood);
  }

  public Game loadGame() {
    Gson gson = new Gson();
    State state = storeGame.loadGame("state.json", State.class, gson);
    Player player = storeGame.loadGame("player.json", Player.class, gson);
    Neighborhood neighborhood = storeGame.loadGame("neighborhood.json", Neighborhood.class, gson);
    if (state == null || player == null || neighborhood == null) {
      return new Game();
    }
    return new Game(state, player, neighborhood);
  }

  public void removeFiles() {
    storeGame.removeJsonFiles();
  }

  public State getState() {
    return state;
  }

  public void setState(State state) {
    this.state = state;
  }

 public Boolean validateItemToUse(ArrayList<String> inventory, String item){
    if (inventory.contains(item)){
      return true;
    }else{
      return false;
    }
 }

  // user uses item. if the item was used in proper places, run the associated function.
  public ArrayList<String> useItem(House house, String item, ArrayList<String> inventory) {
    boolean successfullyUsedItem = validateItemToUse(inventory, item);
    // if the house is knocked then try to use the item
    if (house.isKnocked()) {
//      showInventory();
      String response = successfullyUsedItem ? "remove_item" : "warning_remove_item";
      System.out.printf(display.getNpcResponse(response), item);
      if (!successfullyUsedItem) {
        return inventory;
      }else{
        inventory.remove(item);
      }
    } else {
      System.out.println(display.getNpcResponse("knock_to_use_item"));
      return inventory;
    }
    // if we use the badge at karen's house then we win the game
    if (house.getHouseName().equals("karen's house")) {
      inventory = karenUseItem(item, inventory);
    } else if (house.getHouseName().equals("dracula's mansion") && item.equals("tooth")) {
      System.out.println(display.getNpcResponse("draculas_tooth"));
      // added dracula's ruby to our inventory
      // NOTE: dracula's tooth is a hidden item, so we don't store it in the house
      inventory.remove(item);
      inventory.add("ruby");
      return inventory;
    } else if (house.getHouseName().equals("witch's den")) {
      String exchangedItem = witchUseItem(item, house);
      inventory.add(exchangedItem);
    }
    return inventory;
  }

  // if user knocks on the witch's house, and user has cat-hair or beer or dentures in the inventory,
  // the witch will take the items to make a potion.
  // if all the items are collected by the witch, user will get the potion.
  private String witchUseItem(String item, House house) {
    if (item.equals("cat-hair") || item.equals("beer") || item.equals("dentures")) {
      System.out.printf(display.getNpcResponse("give_witch_ingredient"), item);
      playSound("/bubbles.wav");
      house.addItem(item);
    } else {
      System.out.printf(display.getNpcResponse("incorrect_witch_ingredient"), item);
    }
    ArrayList<String> witchHouseItems = house.getHouseItems();
    if (witchHouseItems.contains("cat-hair") && witchHouseItems.contains("beer")
        && witchHouseItems.contains("dentures")) {
      System.out.println(display.getNpcResponse("complete_witch_potion"));
      // NOTE: potion is a hidden item, so we don't store it in the house
      String exchangedItem = "potion";
      playSound("/witch.wav");
      return exchangedItem;
    }
    return null;
  }

  // WIN condition
// if user use one of the items(badge, potion, ruby) to Karen, user wins the game.
  public ArrayList<String> karenUseItem(String item, ArrayList<String> inventory) {
    if (item.equals("badge")) {
      System.out.println(display.getNpcResponse("karen_defeated_badge"));
      playSound("/girl_scream.wav");
      inventory.remove(item);
    } else if (item.equals("potion")) {
      System.out.println(display.getNpcResponse("karen_defeated_potion"));
      inventory.remove(item);
    } else if (item.equals("ruby")) {
      System.out.println(display.getNpcResponse("karen_defeated_ruby"));
      inventory.remove(item);
    } else{
      return inventory;
    }
    showWin();
    setState(State.WIN);
    return inventory;
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
