package com.halloween.model;

import java.util.ArrayList;

public class House {
  private String houseName;
  private ArrayList<String> houseItems;
  private String[] residents;
  private String north;
  private String east;
  private String south;
  private String west;
  private boolean knocked;

  public House(String houseName, ArrayList<String> houseItems, String[] residents, String north,
      String east, String south, String west) {
    this.houseName = houseName;
    this.houseItems = houseItems;
    this.residents = residents;
    this.north = north;
    this.east = east;
    this.south = south;
    this.west = west;
    this.knocked = false;
  }

  public String getHouseName() {
    return houseName;
  }

  public ArrayList<String> getHouseItems() {
    return houseItems;
  }

  public String[] getResidents() {
    return residents;
  }

  public String getNorth() {
    return north;
  }

  public String getEast() {
    return east;
  }

  public String getSouth() {
    return south;
  }

  public String getWest() {
    return west;
  }

  public void removeItem() {
    houseItems.remove(0);
  }

  public void addItem(String item) {
    houseItems.add(item);
  }

  public boolean isKnocked() {
    return knocked;
  }

  public void setKnocked(boolean knocked) {
    this.knocked = knocked;
  }
}
