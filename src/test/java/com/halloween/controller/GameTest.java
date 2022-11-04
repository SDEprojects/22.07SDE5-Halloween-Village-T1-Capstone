package com.halloween.controller;


import com.halloween.model.Neighborhood;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameTest {
  private Game game;

  @Before
  public void setUp() throws Exception {

    Neighborhood neighborhood = new Neighborhood();
    game = new Game();

  }

  @Test
  public void checkValidDirection_should_return_warning_when_go_to_wrong_direction() {

    //act
    String warning = game.checkValidDirection("south", "");

    //assert
    Assert.assertEquals("WARNING: south is an invalid direction. Please choose one of the possible moves.", warning);

  }

  @Test
  public void checkValidDirection_should_return_message_with_moving_direction_when_go_to_right_direction() {

    //act
    String message = game.checkValidDirection("south", "your house");

    //assert
    Assert.assertEquals("You moved to south.", message);

  }
}