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

}
