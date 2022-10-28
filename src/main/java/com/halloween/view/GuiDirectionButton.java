package com.halloween.view;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GuiDirectionButton {
  JPanel panelForDirectionButtonsWithOtherButtons;




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
    JButton southButton = new JButton("S");
    southButton.setBounds(45, 90, 46, 46);
    southButton.setFocusable(false);
    JButton westButton = new JButton("W");
    westButton.setBounds(0, 45, 46, 46);
    westButton.setFocusable(false);
    JButton eastButton = new JButton("E");
    eastButton.setBounds(90, 45, 46, 46);
    eastButton.setFocusable(false);

    JButton getButton = new JButton("Get");
    getButton.setBounds(180, 40, 90, 40);
    getButton.setFocusable(false);
    JButton useButton = new JButton("Use");
    useButton.setBounds(180, 100, 90, 40);
    useButton.setFocusable(false);
    JButton knockButton = new JButton("Knock");
    knockButton.setBounds(180, 160, 90, 40);
    knockButton.setFocusable(false);

    panelForDirectionButton.add(northButton);
    panelForDirectionButton.add(southButton);
    panelForDirectionButton.add(westButton);
    panelForDirectionButton.add(eastButton);
    panelForDirectionButtonsWithOtherButtons.add(getButton);
    panelForDirectionButtonsWithOtherButtons.add(useButton);
    panelForDirectionButtonsWithOtherButtons.add(knockButton);
    panelForDirectionButtonsWithOtherButtons.add(panelForDirectionButton);
  }

  public JPanel getPanelForDirectionButtonsWithOtherButtons() {
    return panelForDirectionButtonsWithOtherButtons;
  }
}
