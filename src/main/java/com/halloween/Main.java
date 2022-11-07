package com.halloween;

import com.halloween.controller.GuiController;
import com.halloween.model.State;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Main {

  public static void main(String[] args) throws IOException {

    GuiController guiController = new GuiController();

    guiController.playGame();


    }
  }

