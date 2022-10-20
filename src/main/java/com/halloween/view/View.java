package com.halloween.view;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.halloween.model.House;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;


public class View {
  public static final String TITLE =
      "\n"
          + "                                              ,           ^'^  _\n"
          + "                                              )               (_) ^'^\n"
          + "         _/\\_                    .---------. ((        ^'^\n"
          + "         (('>                    )`'`'`'`'`( ||                 ^'^\n"
          + "    _    /^|                    /`'`'`'`'`'`\\||           ^'^\n"
          + "    =>--/__|m---               /`'`'`'`'`'`'`\\|\n"
          + "         ^^           ,,,,,,, /`'`'`'`'`'`'`'`\\      ,\n"
          + "                     .-------.`|`````````````|`  .   )\n"
          + "                    / .^. .^. \\|  ,^^, ,^^,  |  / \\ ((\n"
          + "                   /  |_| |_|  \\  |__| |__|  | /,-,\\||\n"
          + "        _         /_____________\\ |\")| |  |  |/ |_| \\|\n"
          + "       (\")         |  __   __  |  '==' '=='  /_______\\     _\n"
          + "      (' ')        | /  \\ /  \\ |   _______   |,^, ,^,|    (\")\n"
          + "       \\  \\        | |--| |--| |  ((--.--))  ||_| |_||   (' ')\n"
          + "     _  ^^^ _      | |__| |(\"| |  ||  |  ||  |,-, ,-,|   /  /\n"
          + "   ,' ',  ,' ',    |           |  ||  |  ||  ||_| |_||   ^^^\n"
          + ".,,|RIP|,.|RIP|,.,,'==========='==''=='==''=='=======',,....,,,,.,\n"
          + "\n====================Welcome to Halloween Village====================\n";

  public static final String BACKSTORY =
      "Welcome to Halloween Village! A community of ghosts, ghouls, goblins, \n"
      + "and terrifying beasts from all over.\n"
      + "It’s Halloween night. You must go trick or treating house-to-house \n"
          + "collecting candy and useful items. Most citizens of Halloween Village \n"
          + "are friendly, but beware, lurking somewhere in the shadows is the scariest \n"
          + "(and for sure rudest) villain of all time waiting for you! Should you \n"
          + "manage to defeat this great evil, peace and prosperity will be restored to \n"
          + "Halloween Village!"
      + "\n\tGood Luck, you'll definitely need it...\n";

  public static final String INSTRUCTIONS = "=============================Instructions=============================\n"
      + "\n~~~~~~~~~HOW TO MOVE~~~~~~~~~\n"
      + "You can walk in four different directions: north, south, east, west\n"
      + "In order to move, type two words: \"go <direction>\"\n"
      + "For example: to move west, you would enter \"go west\"\n"
      + "\n~~~~HOW TO COLLECT ITEMS~~~~~\n"
      + "You can take items by using the keyword \"get\"\n"
      + "In order to collect, type two words: \"get item\"\n"
      + "\n~~~~HOW TO KNOCK ON DOOR~~~~~\n"
      + "You can trick or treat by knocking on someone's door\n"
      + "In order to knock, type two words: \"knock\"\n"
      + "For example: to trick or treat you would enter \"knock\"\n"
      + "\n~~~~~~HOW TO USE ITEMS~~~~~~~\n"
      + "You can use items by using the keyword \"use\"\n"
      + "In order to use, type two words: \"use <item>\"\n"
      + "For example: to use your candy, you would enter \"use candy\"\n"
      + "\n~~~~~~~~OTHER COMMANDS~~~~~~~~\n"
      + "Typing \"quit\" will cause you to immediately exit out of the game \n\n"
      + "Typing \"help\" will show a list of valid commands\n\n";
  private BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("dialogue.json")));
  private Gson gson = new Gson();
  private Type collectionType = new TypeToken<ArrayList<HashMap<String, HashMap<String, String>>>>(){}.getType();
  private ArrayList<HashMap<String, HashMap<String, String>>> dialogueList = gson.fromJson( reader, collectionType);
  private HashMap<String, HashMap<String, String>> dialogue =
      (HashMap<String, HashMap<String, String>>)
          dialogueList
              .stream()
              .collect(Collectors
                  .toMap(map -> String.join("", map.keySet()) , map -> map.get(String.join("", map.keySet()))));

  public void greet(String currentPosition) {
    System.out.println(dialogue.get(currentPosition).get("greet"));
  }
  public void noItem(String currentPosition) {
    System.out.println(dialogue.get(currentPosition).get("no item"));
  }
  public void displayMenu() {
    System.out.println("..............................................................\n");
    System.out.println("\t\t\t\t~~~~~~~~~~~MENU~~~~~~~~~~~");
    System.out.println("\t\t\t\tTo start game enter: new game");
    System.out.println("\t\t\t\tTo quit enter: quit\n");
    System.out.println("...............................................................\n");
  }

  public void displayHelp(){
    System.out.println(".......................Help...................................");
    System.out.println("go <direction> : Moves you north, south, east or west");
    System.out.println("get item: adds item to your inventory");
    System.out.println("knock: interact with the house");
    System.out.println("use item: item disappears from your inventory once you use it");
    System.out.println("help: displays a list of commands " );
    System.out.println("quit: ends the game\n..............................................................");
  }
}

