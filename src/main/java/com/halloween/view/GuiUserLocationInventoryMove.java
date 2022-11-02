package com.halloween.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;
import java.util.function.Consumer;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GuiUserLocationInventoryMove {
  JPanel panelForLocationInventoryMOve;
  JPanel itemPanel;
  JButton itemBtn;
  Consumer<String> useItemListener;

  public GuiUserLocationInventoryMove() {

    JTextArea textAreaForLocation = new JTextArea("Location:");
    textAreaForLocation.setEditable(false);
    textAreaForLocation.setBorder(BorderFactory.createLineBorder(Color.black));
    textAreaForLocation.setBounds(2, 2, 215, 245);


    //inventory
    itemPanel = new JPanel();
    itemPanel.setBounds(222, 2, 215, 245);
    itemPanel.setLayout(new GridLayout(2,2));


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
      itemPanel.removeAll();
      itemPanel.revalidate();
      itemPanel.setBackground(Color.red);

    for (int i = 0; i < inventory.size(); i++) {
      System.out.println(i);
      itemBtn = new JButton(inventory.get(i));
      itemBtn.setSize( 200, 30);
      itemBtn.setFocusable(false);
      itemBtn.setActionCommand(inventory.get(i));
      itemPanel.add(itemBtn);
      itemBtn.setVisible(true);
      itemBtn.addActionListener(e -> {
        useItemListener.accept(itemBtn.getText());
      });
    }
  }

  public void setUseItemListener(Consumer<String> listener){
    useItemListener = listener;
  }

}





