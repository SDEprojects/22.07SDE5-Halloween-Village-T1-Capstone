package com.halloween.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Neighborhood {
  private HashMap<String, House> neighborhood;
  public HashMap<String, House> getNeighborhood() {
    return neighborhood;
  }

  public void setNeighborhood(HashMap<String, House> neighborhood) {
    this.neighborhood = neighborhood;
  }

}
