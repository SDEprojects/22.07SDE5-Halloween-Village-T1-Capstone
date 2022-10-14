package com.halloween.view;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
      + "In order to collect, type two words: \"get <item>\"\n"
      + "For example: to collect candy, you would enter \"get candy\"\n"
      + "\n~~~~HOW TO KNOCK ON DOOR~~~~~\n"
      + "You can trick or treat by knocking on someone\'s door\n"
      + "In order to knock, type two words: \"knock door\"\n"
      + "For example: to trick or treat you would enter \"knock door\"\n"
      + "\n~~~~~~~~OTHER COMMANDS~~~~~~~~\n"
      + "Typing \"quit\" will cause you to immediately exit out of the game \n\n"
      + "Typing \"help\" will show a list of valid commands\n\n";

  private JSONParser parser = new JSONParser();

  public void greet(String currentPosition) throws IOException, ParseException {
    JSONArray dialogueArray = (JSONArray) parser.parse(new FileReader("C:\\Users\\akwarkoh\\Desktop\\JAVA\\StudentWork\\IntmJ\\22.07SDE05-Halloween-Village\\src\\main\\resources\\dialogue.json"));

    for (Object dialogue : dialogueArray) {
      JSONObject house = (JSONObject) dialogue;

      JSONObject houseDialogue = (JSONObject)house.get(currentPosition);
      String greeting = (String) houseDialogue.get("greet");
      System.out.println(greeting);

      JSONObject houseConversation = (JSONObject)house.get(currentPosition);
      String secondVisit = (String) houseConversation.get("no item");
      System.out.println(secondVisit);
    }
  }

  public static void main(String[] args) throws IOException, ParseException {
    new View().greet("amityville mansion");
  }
}
