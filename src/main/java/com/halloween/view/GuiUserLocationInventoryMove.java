package com.halloween.view;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GuiUserLocationInventoryMove {
  JPanel panelForLocationInventoryMOve;

  public GuiUserLocationInventoryMove() {

    JTextArea textAreaForLocation = new JTextArea("Location:");
    textAreaForLocation.setBorder(BorderFactory.createLineBorder(Color.black));
    textAreaForLocation.setBounds(2, 2, 215, 245);
    JTextArea textAreaForInventory = new JTextArea("Inventory:");
    textAreaForInventory.setBorder(BorderFactory.createLineBorder(Color.black));
    textAreaForInventory.setBounds(222, 2, 215, 245);
    JTextArea textAreaForPossibleMove = new JTextArea("Possible Moves:");
    textAreaForPossibleMove.setBorder(BorderFactory.createLineBorder(Color.black));
    textAreaForPossibleMove.setBounds(442, 2, 215, 245);

    panelForLocationInventoryMOve = new JPanel();
    panelForLocationInventoryMOve.setBackground(Color.LIGHT_GRAY);
    panelForLocationInventoryMOve.setBounds(5, 435, 660, 250);
    panelForLocationInventoryMOve.setLayout(null);

    panelForLocationInventoryMOve.add(textAreaForLocation);
    panelForLocationInventoryMOve.add(textAreaForInventory);
    panelForLocationInventoryMOve.add(textAreaForPossibleMove);
  }

  public JPanel getPanelForLocationInventoryMOve() {
    return panelForLocationInventoryMOve;
  }

}
