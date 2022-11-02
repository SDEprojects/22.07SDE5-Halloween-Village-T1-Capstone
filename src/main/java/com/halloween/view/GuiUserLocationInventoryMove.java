package com.halloween.view;

import java.awt.Color;
import java.util.List;
import java.util.function.Consumer;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GuiUserLocationInventoryMove {
  JPanel panelForLocationInventoryMOve;
  JPanel itemPanel;
//  JLabel itemLabel = new JLabel();
  JButton itemBtn;

  Consumer<String> inventoryListener;

  public GuiUserLocationInventoryMove() {

    JTextArea textAreaForLocation = new JTextArea("Location:");
    textAreaForLocation.setEditable(false);
    textAreaForLocation.setBorder(BorderFactory.createLineBorder(Color.black));
    textAreaForLocation.setBounds(2, 2, 215, 245);


    //inventory
    itemPanel = new JPanel();
    itemPanel.setBorder(BorderFactory.createLineBorder(Color.black));
    itemPanel.setBounds(222, 2, 215, 245);
    itemPanel.setLayout(null);
    itemPanel.setBackground(Color.blue);



    JTextArea textAreaForPossibleMove = new JTextArea("Possible Moves:");
    textAreaForPossibleMove.setBorder(BorderFactory.createLineBorder(Color.black));
    textAreaForPossibleMove.setBounds(442, 2, 215, 245);

    panelForLocationInventoryMOve = new JPanel();
    panelForLocationInventoryMOve.setBackground(Color.LIGHT_GRAY);
    panelForLocationInventoryMOve.setBounds(5, 435, 660, 250);
    panelForLocationInventoryMOve.setLayout(null);

    panelForLocationInventoryMOve.add(textAreaForLocation);
    panelForLocationInventoryMOve.add(itemPanel);
    panelForLocationInventoryMOve.add(textAreaForPossibleMove);
  }

  public JPanel getPanelForLocationInventoryMOve() {
    return panelForLocationInventoryMOve;
  }


  public void updateInventory(List<String> inventory) {
      itemPanel.invalidate();
      itemPanel.setBackground(Color.red);

    for (int i = 0; i < inventory.size(); i++) {
      JButton itemButton = new JButton(inventory.get(i));
      itemButton.setSize(90, 40);
      itemButton.setFocusable(false);
      itemButton.setActionCommand(inventory.get(i));
      itemPanel.add(itemButton);
      itemButton.addActionListener((e ->
          inventoryListener.accept(itemButton.getActionCommand())));
    }
  }

  public void setInventoryListener(Consumer<String> listener){
    inventoryListener = listener;
  }

}
