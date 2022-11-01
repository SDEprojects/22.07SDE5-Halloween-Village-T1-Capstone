package com.halloween.view;

import com.halloween.controller.Game;
import com.halloween.controller.GuiController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;
import javax.swing.JFileChooser;

public class ActionHandler implements ActionListener {

  private Consumer<String> consumer;

  public ActionHandler(Consumer<String> consumer){
    this.consumer = consumer;
  }

  public GuiController controller = new GuiController();
  @Override
  public void actionPerformed(ActionEvent e) {
    knockOnDoor(controller.getCurrentLocation());



  }

  public void knockOnDoor(String location){
    Game game = new Game();
    game.knockOnDoor(location);
  }

}
