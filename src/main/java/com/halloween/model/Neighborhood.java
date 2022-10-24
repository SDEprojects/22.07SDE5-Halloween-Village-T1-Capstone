package com.halloween.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Neighborhood {

  private HashMap<String, House> neighborhood;

  private String[] directions = new String[]{
      "north", "south", "east", "west"
  };

  public Neighborhood() {
    BufferedReader reader = new BufferedReader(
        new InputStreamReader(getClass().getClassLoader().getResourceAsStream("map.json")));
    Gson gson = new Gson();
    Type collectionType = new TypeToken<ArrayList<House>>() {
    }.getType();
    ArrayList<House> houses = gson.fromJson(reader, collectionType);
    neighborhood = (HashMap<String, House>) houses.stream()
        .collect(Collectors.toMap(House::getHouseName, house -> house));
  }

  public HashMap<String, House> getNeighborhood() {
    return neighborhood;
  }

  public void setNeighborhood(HashMap<String, House> neighborhood) {
    this.neighborhood = neighborhood;
  }

  public String isValidDirection(String direction, House currentPosition) {
    HashMap<String, String> possibleHouses = new HashMap<>();
    possibleHouses.put(directions[0],currentPosition.getNorth());
    possibleHouses.put(directions[1],currentPosition.getSouth());
    possibleHouses.put(directions[2],currentPosition.getEast());
    possibleHouses.put(directions[3],currentPosition.getWest());

    boolean isValidDirection = Arrays.asList(directions).contains(direction);

    if (isValidDirection && possibleHouses.get(direction)!=null){
     return possibleHouses.get(direction);
    } else {
      return "";
    }
  }
}