package com.halloween.model;

import java.util.ArrayList;

public class Player {
  private String name;
  private String position;
  private ArrayList<String> items;

  public Player(String name, String position, ArrayList<String> items) {
    this.name = name;
    this.position = position;
    this.items = new ArrayList<>();
  }

  public Player() {
    this.items = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public ArrayList<String> getItems() {
    return items;
  }

  public void setItems(ArrayList<String> items) {
    this.items = items;
  }

  public void addItem(String item){
    items.add(item);
  }

  public boolean removeItem(String item) {
    if(items.contains(item) || (items.size() == 1 && item.equals("item"))) {
      System.out.println("You used a " + item + ". This item is now removed from your inventory.");
      if(!item.equals("item")){
        // if the is name is in the array, then remove it
        items.remove(item);
      } else {
        // otherwise, remove the only item from the list
        items.remove(0);
      }
      // return true if we successfully use the item
      return true;
    } else {
      System.out.println("Warning: Can NOT use " + item + " because it not in your inventory.");
      // return false if we could not use the item
      return false;
    }
  }

}
