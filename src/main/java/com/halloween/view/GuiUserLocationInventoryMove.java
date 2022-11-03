package com.halloween.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;
import java.util.function.Consumer;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GuiUserLocationInventoryMove {

  JPanel panelForLocationInventoryMOve;
  JLabel labelForLocation;
  JTextArea textAreaForLocation;
  JLabel labelForPossibleMoves;
  JTextArea textAreaForPossibleMoves;
  JPanel panelForInventory;
  JButton itemBtn;
  Consumer<String> inventoryListener;

  public GuiUserLocationInventoryMove() {

    textAreaForLocation = new JTextArea("Your Current Location:");
    textAreaForLocation.setBorder(BorderFactory.createLineBorder(Color.black));
    textAreaForLocation.setSize(215, 245);
    textAreaForLocation.setEditable(false);
    textAreaForLocation.setFont(new Font("Bold", Font.ITALIC, 16));
    textAreaForLocation.setLineWrap(true);
    textAreaForLocation.setWrapStyleWord(true);
    textAreaForLocation.setForeground(Color.blue);
    textAreaForLocation.setLayout(new BorderLayout());

    textAreaForPossibleMoves = new JTextArea("Possible Moves:");
    textAreaForPossibleMoves.setBorder(BorderFactory.createLineBorder(Color.black));
    textAreaForPossibleMoves.setSize(215, 245);
    textAreaForPossibleMoves.setEditable(false);
    textAreaForPossibleMoves.setFont(new Font("Bold", Font.ITALIC, 16));
    textAreaForPossibleMoves.setLineWrap(true);
    textAreaForPossibleMoves.setWrapStyleWord(true);
    textAreaForPossibleMoves.setForeground(Color.blue);
    textAreaForPossibleMoves.setLayout(new FlowLayout());

    //inventory
    panelForInventory = new JPanel();
    panelForInventory.setSize(215, 245);
    panelForInventory.setBorder(BorderFactory.createLineBorder(Color.black));
    panelForInventory.setLayout(new GridLayout());
    panelForInventory.setLayout(new GridLayout(4, 2));

    panelForLocationInventoryMOve = new JPanel();
    panelForLocationInventoryMOve.setBackground(Color.LIGHT_GRAY);
    panelForLocationInventoryMOve.setBounds(5, 435, 660, 250);
    panelForLocationInventoryMOve.setLayout(new GridLayout(1, 3));

    panelForLocationInventoryMOve.add(textAreaForLocation);
    panelForLocationInventoryMOve.add(textAreaForPossibleMoves);
    panelForLocationInventoryMOve.add(panelForInventory);
  }


  public JPanel getPanelForLocationInventoryMOve() {
    return panelForLocationInventoryMOve;
  }


  public void updateInventory(List<String> inventory) {
    panelForInventory.removeAll();
    panelForInventory.revalidate();
    panelForInventory.setBackground(Color.red);

    for (int i = 0; i < inventory.size(); i++) {
      System.out.println(i);
      itemBtn = new JButton(inventory.get(i));
      itemBtn.setSize(200, 30);
      itemBtn.setFocusable(false);
      itemBtn.setActionCommand(inventory.get(i));
      panelForInventory.add(itemBtn);
      itemBtn.setVisible(true);
    }
  }

  public void updateLocation(String dialogue) {
    System.out.println(dialogue + " from line 86 in GuiLOcationInventoryMove");
    textAreaForLocation.removeAll();
    textAreaForLocation.revalidate();
    textAreaForLocation.repaint();
    textAreaForLocation.setText("\nYour Current Location:\n\n" + dialogue);
  }
  public void updatePossibleMove(String dialogue) {
    System.out.println(dialogue + " from line 93 in GuiLOcationInventoryMove");
    textAreaForPossibleMoves.removeAll();
    textAreaForPossibleMoves.revalidate();
    textAreaForPossibleMoves.repaint();
    textAreaForPossibleMoves.setText("\nPossible Moves:" + dialogue);
  }

  public void setInventoryListener(Consumer<String> listener) {
    inventoryListener = listener;
  }

}





