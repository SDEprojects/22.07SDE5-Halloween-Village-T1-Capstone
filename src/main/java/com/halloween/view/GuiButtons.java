package com.halloween.view;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GuiButtons {
  JPanel panelForDefaultButtons;

  public JPanel getPanelForDefaultButtons() {
    return panelForDefaultButtons;
  }

  public GuiButtons(){

    panelForDefaultButtons = new JPanel();
    panelForDefaultButtons.setBackground(Color.lightGray);
    panelForDefaultButtons.setBounds(825, 130, 150, 280);
    panelForDefaultButtons.setLayout(null);
    JButton mapButton = new JButton("Map");
    mapButton.setBounds(30, 30, 90, 40);
    mapButton.setFocusable(false);
    JButton muteButton = new JButton("Mute");
    muteButton.setBounds(30, 90, 90, 40);
    muteButton.setFocusable(false);
    JButton help = new JButton("Help");
    help.setBounds(30, 150, 90, 40);
    help.setFocusable(false);
    JButton button11 = new JButton("Quit");
    button11.setBounds(30, 210, 90, 40);
    button11.setFocusable(false);
    panelForDefaultButtons.add(mapButton);
    panelForDefaultButtons.add(muteButton);
    panelForDefaultButtons.add(help);
    panelForDefaultButtons.add(button11);
  }

}
