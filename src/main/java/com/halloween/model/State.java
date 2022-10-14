package com.halloween.model;

public enum State {

  WIN,
  LOSE,
  PLAY {
    @Override
    public boolean isTerminal() {
      return false;
    }
  };

  // tells game whether the state causes the game to end
  public boolean isTerminal() {
    return true;
  }

}
