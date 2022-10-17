package com.halloween.model;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Neighborhood {
  private HashMap<String, House> neighborhood = new HashMap<>();
  private JSONParser parser = new JSONParser();
  URL url = getClass().getResource("/map.json");
  String path = url.getPath();

  public Neighborhood() throws IOException, ParseException {
    JSONArray houseArray = (JSONArray) parser.parse(new FileReader(path));
    for (Object house : houseArray) {
      JSONObject houseObject = (JSONObject) house;
      String name = String.join("" , houseObject.keySet());
      JSONObject houseInfo = (JSONObject) houseObject.get(name);
      ArrayList<String> items = (ArrayList<String>) houseInfo.get("items");

      JSONArray residentsJsonArray = (JSONArray) houseInfo.get("residents");
      String[] residents = new String[residentsJsonArray.size()];
      for (int i = 0; i < residentsJsonArray.size(); i++) {
        residents[i] = residentsJsonArray.get(i).toString();
      }

      String north = (String) houseInfo.get("north");
      String east = (String) houseInfo.get("east");
      String south = (String) houseInfo.get("south");
      String west = (String) houseInfo.get("west");
      String[] directions = new String[]{north, east, south, west};
      for (int i = 0; i < directions.length; i++) {
        if (Objects.equals(directions[i], "null")) {
          directions[i] = null;
        }
      }

      House houseConstructor = new House(name, items, residents, directions[0], directions[1], directions[2], directions[3]);
      neighborhood.put(name, houseConstructor);
    }

  }

  public HashMap<String, House> getNeighborhood() {
    return neighborhood;
  }

  public void setNeighborhood(HashMap<String, House> neighborhood) {
    this.neighborhood = neighborhood;
  }

//  public static void main(String[] args) throws IOException, ParseException {
//    Neighborhood neighborhood1 = new Neighborhood();
//    System.out.println(neighborhood1.getNeighborhood().get("amityville mansion").getResidents()[0]);
//    System.out.println(neighborhood1.getNeighborhood().get("freddy & jason's house").getResidents()[0]);
//    System.out.println(neighborhood1.getNeighborhood().get("freddy & jason's house").getResidents()[1]);
//  }
}
