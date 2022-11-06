package com.halloween.view;

import java.awt.Color;
import java.net.URL;
import java.util.function.Consumer;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class GuiDirectionButton {

  private Consumer<String> knockListener;
  private Consumer<String> directionListener;

  private Consumer<String> getListener;
  JButton eastButton;
  JButton westButton;
  JButton northButton;
  JButton southButton;
  JPanel panelForDirectionButtonsWithOtherButtons;


  public GuiDirectionButton() {

    panelForDirectionButtonsWithOtherButtons = new JPanel();
    panelForDirectionButtonsWithOtherButtons.setBackground(Color.lightGray);
    panelForDirectionButtonsWithOtherButtons.setBounds(695, 435, 300, 250);
    panelForDirectionButtonsWithOtherButtons.setOpaque(false);
    panelForDirectionButtonsWithOtherButtons.setLayout(null);
    panelForDirectionButtonsWithOtherButtons.setVisible(false);

    JPanel panelForDirectionButton = new JPanel();
    panelForDirectionButton.setBackground(Color.lightGray);
    panelForDirectionButton.setBounds(20, 60, 136, 136);
    panelForDirectionButton.setOpaque(false);
    panelForDirectionButton.setLayout(null);

//    northButton.setBounds(45, 0, 46, 46);
//    URL northImage = GuiButtons.class.getClassLoader().getResource("north.png");
//    ImageIcon northIcon = new ImageIcon(northImage);
//    northButton.setBackground(new Color(255, 91, 25));
//    northButton.setIcon(northIcon);
//    northButton.setFocusable(false);
//    northButton.setActionCommand("north");

//    URL southImage = GuiButtons.class.getClassLoader().getResource("south.png");
//    ImageIcon southIcon = new ImageIcon(southImage);
//    southButton.setBackground(new Color(255, 91, 25));
//    southButton.setIcon(southIcon);
//    southButton.setBounds(45, 90, 46, 46);
//    southButton.setActionCommand("south");
//    southButton.setFocusable(false);

//    JButton westButton = new JButton();
//    URL westImage = GuiButtons.class.getClassLoader().getResource("west.png");
//    ImageIcon westIcon = new ImageIcon(westImage);
//    westButton.setIcon(westIcon);
//    westButton.setBackground(new Color(255, 91, 25));
//    westButton.setBounds(0, 45, 46, 46);
//    westButton.setFocusable(false);
//    westButton.setActionCommand("west");

//    URL eastImage = GuiButtons.class.getClassLoader().getResource();
//    ImageIcon eastIcon = new ImageIcon(eastImage);
//    eastButton.setIcon(eastIcon);
//    eastButton.setBackground(new Color(255, 91, 25));
//    eastButton.setBounds(90, 45, 46, 46);
//    eastButton.setFocusable(false);
//    eastButton.setActionCommand("east");

//    JButton knockButton = new JButton();
//    URL knockImage = GuiButtons.class.getClassLoader().getResource("knock.png");
//    ImageIcon knockIcon = new ImageIcon(knockImage);
//    knockButton.setIcon(knockIcon);
//    knockButton.setBounds(180, 120, 90, 40);
//    knockButton.setFocusable(false);

//    button.setBackground(new Color(0, 0, 0, 120));
//    Border emptyBorder = BorderFactory.createEmptyBorder();
//    button.setBorder(emptyBorder);
//    button.setOpaque(false);
//    button.setFocusPainted(false);

    eastButton = createDirectionButtons("east.png", "east", 90, 45);
    eastButton.addActionListener(e ->
        directionListener.accept(eastButton.getActionCommand()));

    westButton = createDirectionButtons("west.png", "west", 0, 45);
    westButton.addActionListener(e ->
        directionListener.accept(westButton.getActionCommand()));

    southButton = createDirectionButtons("south.png", "south", 45, 90);
    southButton.addActionListener(e ->
        directionListener.accept(southButton.getActionCommand()));

    JButton northButton = createDirectionButtons("north.png", "north", 45, 0);
    northButton.addActionListener(e ->
        directionListener.accept(northButton.getActionCommand()));

    JButton knockButton = creteGetKnockButton("knock.png");
    knockButton.setBounds(180, 120, 90, 40);
    knockButton.addActionListener(e -> {
      knockListener.accept(knockButton.getActionCommand());
    });

    JButton getButton = creteGetKnockButton("get.png");
    getButton.setBounds(180, 60, 90, 40);
    getButton.addActionListener(e -> {
      getListener.accept(getButton.getActionCommand());
    });

    panelForDirectionButton.add(northButton);
    panelForDirectionButton.add(southButton);
    panelForDirectionButton.add(westButton);
    panelForDirectionButton.add(eastButton);
    panelForDirectionButtonsWithOtherButtons.add(knockButton);
    panelForDirectionButtonsWithOtherButtons.add(getButton);
    panelForDirectionButtonsWithOtherButtons.add(panelForDirectionButton);
  }

  private JButton creteGetKnockButton(String image) {
    JButton button = new JButton();
    URL getImage = GuiButtons.class.getClassLoader().getResource(image);
    ImageIcon getIcon = new ImageIcon(getImage);
    button.setIcon(getIcon);
    button.setBackground(new Color(0, 0, 0, 120));
    Border emptyBorder = BorderFactory.createEmptyBorder();
    button.setBorder(emptyBorder);
    button.setOpaque(false);
    button.setFocusPainted(false);
    return button;
  }

  private JButton createDirectionButtons(String image, String command, int x, int y) {
    JButton button = new JButton();
    URL eastImage = GuiButtons.class.getClassLoader().getResource(image);
    ImageIcon eastIcon = new ImageIcon(eastImage);
    button.setIcon(eastIcon);
    button.setBackground(new Color(255, 91, 25));
    button.setBounds(x, y, 46, 46);
    button.setActionCommand(command);
    button.setFocusable(false);
    return button;
  }

  // updating knock button with new current location value.
  // new value is received from GUI controller -> PlayGameGui -> GuiDirectionButton
  // when this button is clicked, the current location value will be sent back to
  // controller so that controller knows which door the user is knocking.
  public void updateDirectionButtons(String location) {
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
