package com.halloween.view;

import com.halloween.Main;
import com.halloween.controller.Game;
import com.halloween.controller.GuiController;
import com.halloween.model.Player;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.function.Consumer;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GuiDirectionButton {

  private Consumer<String> knockListener;
  JPanel panelForDirectionButtonsWithOtherButtons;

  GuiController controller;
  Game game = new Game();
//  Player player = new Player();
  GuiUserLocationInventoryMove guiForInventory = new GuiUserLocationInventoryMove();



  public GuiDirectionButton() {

    panelForDirectionButtonsWithOtherButtons = new JPanel();
    panelForDirectionButtonsWithOtherButtons.setBackground(Color.lightGray);
    panelForDirectionButtonsWithOtherButtons.setBounds(675, 435, 300, 250);
    panelForDirectionButtonsWithOtherButtons.setLayout(null);

    JPanel panelForDirectionButton = new JPanel();
    panelForDirectionButton.setBackground(Color.lightGray);
    panelForDirectionButton.setBounds(20, 60, 136, 136);
    panelForDirectionButton.setLayout(null);

    JButton northButton = new JButton("N");
    northButton.setBounds(45, 0, 46, 46);
    northButton.setFocusable(false);
//    northButton.addActionListener(new ActionListener() {
//      @Override
//      public void actionPerformed(ActionEvent e) {
//        controller.getGame().movePlayer("north");
//      }
//    });

    JButton southButton = new JButton("S");
    southButton.setBounds(45, 90, 46, 46);
    southButton.setFocusable(false);
//    southButton.addActionListener(new ActionListener() {
//      @Override
//      public void actionPerformed(ActionEvent e) {
//        game.movePlayer("south");
//      }
//    });

    JButton westButton = new JButton("W");
    westButton.setBounds(0, 45, 46, 46);
    westButton.setFocusable(false);
//    westButton.addActionListener(new ActionListener() {
//      @Override
//      public void actionPerformed(ActionEvent e) {
//        game.movePlayer("west");
//      }
//    });

    JButton eastButton = new JButton("E");
    eastButton.setBounds(90, 45, 46, 46);
    eastButton.setFocusable(false);
//    eastButton.addActionListener(new ActionListener(e) {
//      @Override
//    public void actionPerformed(ActionEvent e) {
//      game.movePlayer("east");
//    }
//
//    });


    JButton getButton = new JButton("Get");
    getButton.setBounds(180, 40, 90, 40);
    getButton.setFocusable(false);
//    getButton.addActionListener(new ActionListener() {
//      @Override
//      public void actionPerformed(ActionEvent e) {
//        game.getItem();
//      }
//    });

    JButton useButton = new JButton("Use");
    useButton.setBounds(180, 100, 90, 40);
    useButton.setFocusable(false);
//    useButton.addActionListener(new ActionListener() {
//      @Override
//      public void actionPerformed(ActionEvent e) {
//        game.useItem();
//      }
//    });

//    JButton knockButton = new JButton("Knock");
////    knockButton.setActionCommand();
//    knockButton.setBounds(180, 160, 90, 40);
//    knockButton.setFocusable(false);

//    knockButton.addActionListener(e -> {
//      knockListener.accept(knockButton.getActionCommand());
//    });
//    knockButton.addActionListener(new ActionListener() {
//      @Override
//      public void actionPerformed(ActionEvent e) {
//
//
//      }
//    });

//    String currentLocation = controller.getCurrentLocation();
//    knockButton.addActionListener(game.knockOnDoor(currentLocation));
//    knockButton.addActionListener(e -> {
//      String location = e.getActionCommand();
//      knockListener.accept(location);

//    });



//    Consumer<String> consumer = (String text) -> {
//
//    }
//    knockButton.addActionListener(new ActionHandler(consumer));

//    knockButton.addActionListener(new ActionListener() {
//      @Override
//      public void actionPerformed(ActionEvent e) {
//        game.knockOnDoor();
//      }
//    });

    panelForDirectionButton.add(northButton);
    panelForDirectionButton.add(southButton);
    panelForDirectionButton.add(westButton);
    panelForDirectionButton.add(eastButton);
    panelForDirectionButtonsWithOtherButtons.add(getButton);
    panelForDirectionButtonsWithOtherButtons.add(useButton);
//    panelForDirectionButtonsWithOtherButtons.add(knockButton);
    panelForDirectionButtonsWithOtherButtons.add(panelForDirectionButton);
  }


  // updating knock button with new current location value.
  // new value is received from GUI controller -> PlayGameGui -> GuiDirectionButton
  // when this button is clicked, the current location value will be sent back to
  // controller so that controller knows which door the user is knocking.
  public void updateButton(String location){
    panelForDirectionButtonsWithOtherButtons.removeAll();
    JButton knockButton = new JButton(location);
//    knockButton.setActionCommand();
    knockButton.setBounds(180, 160, 90, 40);
    knockButton.setFocusable(false);
    panelForDirectionButtonsWithOtherButtons.add(knockButton);
    knockButton.addActionListener(e ->
        knockListener.accept(location));
  }

  public JPanel getPanelForDirectionButtonsWithOtherButtons() {
    return panelForDirectionButtonsWithOtherButtons;
  }

  public void setKnockListener(Consumer<String> listener) {
    knockListener = listener;


  }


}
