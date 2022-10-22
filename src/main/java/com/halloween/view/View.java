package com.halloween.view;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.stream.Collectors;


public class View {
  private ResourceBundle instructions;
  private ResourceBundle npcResponse;
  private BufferedReader reader = new BufferedReader(
      new InputStreamReader(getClass().getClassLoader().getResourceAsStream("dialogue.json")));
  private Gson gson = new Gson();
  private Type collectionType = new TypeToken<ArrayList<HashMap<String, HashMap<String, String>>>>() {
  }.getType();
  private ArrayList<HashMap<String, HashMap<String, String>>> dialogueList = gson.fromJson(reader,
      collectionType);
  private HashMap<String, HashMap<String, String>> dialogue =
      (HashMap<String, HashMap<String, String>>)
          dialogueList
              .stream()
              .collect(Collectors
                  .toMap(map -> String.join("" , map.keySet()),
                      map -> map.get(String.join("" , map.keySet()))));

  public View() {
    instructions = ResourceBundle.getBundle("instructions");
    npcResponse = ResourceBundle.getBundle("npcResponse");
  }

  public void greet(String currentPosition) {
    System.out.println(dialogue.get(currentPosition).get("greet"));
  }

  public void noItem(String currentPosition) {
    System.out.println(dialogue.get(currentPosition).get("no item"));
  }
  public String getTitle(){
    return instructions.getString("title") + "\n";
  }
  public String getBackstory(){
    return instructions.getString("backstory") + "\n";
  }
  public String getInstructions(){
    return instructions.getString("instruction") + "\n";
  }
  public String getMenu() {
    return instructions.getString("menu") + "\n";
  }

 public String getHelp() {
   return instructions.getString("help") + "\n";
  }
  public String getNpcResponse(String key){
    return npcResponse.getString(key) + "\n";
  }
  public String getMap() {
    return instructions.getString("map") + "\n";
  }

}

