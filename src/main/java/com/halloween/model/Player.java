package com.halloween.model;

import java.util.ArrayList;

public class Player {
  private String name;
  private String position;
  private ArrayList<String> items;

  // player constructor with name, current location, and inventory
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

  // add item to inventory
  public void addItem(String item){
    items.add(item);
  }

  // remove item from inventory
  public boolean removeItem(String item) {
    if (items.contains(item)) {
      // remove the item
      items.remove(item);
      // return true if we successfully use the item
      return true;
    } else {
      // return false if we could not use the item
      return false;
    }
  }

}
