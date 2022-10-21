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
  private final ResourceBundle instructions;
  private ResourceBundle npcResponse;
  private final BufferedReader reader = new BufferedReader(
      new InputStreamReader(getClass().getClassLoader().getResourceAsStream("dialogue.json")));
  private final Gson gson = new Gson();
  private final Type collectionType = new TypeToken<ArrayList<HashMap<String, HashMap<String, String>>>>() {
  }.getType();
  private final ArrayList<HashMap<String, HashMap<String, String>>> dialogueList = gson.fromJson(reader,
      collectionType);
  private final HashMap<String, HashMap<String, String>> dialogue =
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
    return instructions.getString("title");
  }
  public String getBackstory(){
    return instructions.getString("backstory");
  }
  public String getInstructions(){
    return instructions.getString("instruction");
  }
  public String getMenu() {
    return instructions.getString("menu");
  }

  public String getHelp() {
    return instructions.getString("help");

  }
  public String getNpcResponse(String key){
    return npcResponse.getString(key);
  }
}

