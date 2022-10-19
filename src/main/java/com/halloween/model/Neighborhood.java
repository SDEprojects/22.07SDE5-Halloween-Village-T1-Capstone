package com.halloween.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Neighborhood {
  private HashMap<String, House> neighborhood;

  public Neighborhood() {
    BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("map.json")));
    Gson gson = new Gson();
    Type collectionType = new TypeToken<ArrayList<House>>(){}.getType();
    ArrayList<House> houses = gson.fromJson( reader, collectionType);
    neighborhood = (HashMap<String, House>) houses.stream().collect(Collectors.toMap(House::getHouseName, house -> house));
  }

  public HashMap<String, House> getNeighborhood() {
    return neighborhood;
  }

  public void setNeighborhood(HashMap<String, House> neighborhood) {
    this.neighborhood = neighborhood;
  }

  public static void main(String[] args){
    Neighborhood neighborhood1 = new Neighborhood();
    System.out.println(neighborhood1.getNeighborhood().get("amityville mansion").getResidents()[0]);
    System.out.println(neighborhood1.getNeighborhood().get("freddy & jason's house").getResidents()[0]);
    System.out.println(neighborhood1.getNeighborhood().get("freddy & jason's house").getResidents()[1]);
  }
}
