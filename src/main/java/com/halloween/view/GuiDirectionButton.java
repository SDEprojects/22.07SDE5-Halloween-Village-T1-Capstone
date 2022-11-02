package com.halloween.view;

import com.halloween.controller.Game;
import com.halloween.controller.GuiController;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GuiDirectionButton {

  private Consumer<String> knockListener;
  private Consumer<String> directionListener;

  private Consumer<String> getListener;
  JPanel panelForDirectionButtonsWithOtherButtons;

  GuiController controller;

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
    northButton.setActionCommand("north");
    northButton.setFocusable(false);
    northButton.addActionListener(e ->
        directionListener.accept(northButton.getActionCommand()));

    JButton southButton = new JButton("S");
    southButton.setBounds(45, 90, 46, 46);
    southButton.setActionCommand("south");
    southButton.setFocusable(false);
    southButton.addActionListener(e ->
          directionListener.accept(southButton.getActionCommand()));


    JButton westButton = new JButton("W");
    westButton.setBounds(0, 45, 46, 46);
    westButton.setFocusable(false);
    westButton.setActionCommand("west");
    westButton.addActionListener(e ->
        directionListener.accept(westButton.getActionCommand()));


    JButton eastButton = new JButton("E");
    eastButton.setBounds(90, 45, 46, 46);
    eastButton.setFocusable(false);
    eastButton.setActionCommand("east");
    eastButton.addActionListener(e ->
        directionListener.accept(eastButton.getActionCommand()));


    JButton getButton = new JButton("Get");
    getButton.setBounds(180, 40, 90, 40);
    getButton.setFocusable(false);
    getButton.addActionListener(e -> {
      getListener.accept(getButton.getActionCommand());
    });


    JButton useButton = new JButton("Use");
    useButton.setBounds(180, 100, 90, 40);
    useButton.setFocusable(false);


    JButton knockButton = new JButton("Knock");
    knockButton.setBounds(180, 160, 90, 40);
    knockButton.setFocusable(false);

    knockButton.addActionListener(e -> {
      knockListener.accept(knockButton.getActionCommand());
    });



    panelForDirectionButton.add(northButton);
    panelForDirectionButton.add(southButton);
    panelForDirectionButton.add(westButton);
    panelForDirectionButton.add(eastButton);
    panelForDirectionButtonsWithOtherButtons.add(getButton);
    panelForDirectionButtonsWithOtherButtons.add(useButton);
    panelForDirectionButtonsWithOtherButtons.add(knockButton);
    panelForDirectionButtonsWithOtherButtons.add(panelForDirectionButton);
  }


  // updating knock button with new current location value.
  // new value is received from GUI controller -> PlayGameGui -> GuiDirectionButton
  // when this button is clicked, the current location value will be sent back to
  // controller so that controller knows which door the user is knocking.
  public void updateDirectionButtons(String location){
    panelForDirectionButtonsWithOtherButtons.removeAll();
    JButton knockButton = new JButton(location);
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

  public void setDirectionListener(Consumer<String> listener) {
    directionListener = listener;
  }

  public void setGetListener(Consumer<String> listener) {
    getListener = listener;
  }




}
