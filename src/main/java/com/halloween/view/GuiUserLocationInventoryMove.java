package com.halloween.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
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
//    itemPanel = new JPanel(new BorderLayout());
    itemPanel = new JPanel();
//    itemPanel.setBorder(BorderFactory.createLineBorder(Color.black));
    itemPanel.setBounds(222, 2, 215, 245);
    itemPanel.setLayout(new GridLayout(2,2));
//    itemPanel.setBackground(Color.blue);



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
//      itemPanel.repaint();
      itemPanel.setBackground(Color.red);
//      JButton[] itemBtn = new JButton[inventory.size()];


//      JButton itemButton = new JButton(item);
//      itemButton.setSize(200, 30);
//      itemButton.setActionCommand(item);

//      itemPanel.add(itemButton);
//      itemButton.addActionListener((e -> inventoryListener.accept(itemButton.getActionCommand())));
//      itemPanel.setLayout(new GridLayout(2,2));
//    JPanel panel = new JPanel();
//    System.out.println(inventory + "here 59" + inventory.size());

    for (int i = 0; i < inventory.size(); i++) {
      System.out.println(i);
      itemBtn = new JButton(inventory.get(i));
//      itemBtn = new JButton(inventory.get(i));
      itemBtn.setSize( 200, 30);
//      itemButton.setSize(200,30);
      itemBtn.setFocusable(false);
      itemBtn.setActionCommand(inventory.get(i));
      itemPanel.add(itemBtn);
      itemBtn.setVisible(true);
    }



//
//
//      itemButton.setActionCommand(inventory.get(i));
//      System.out.println(itemButton.getActionCommand());
//
//      itemPanel.add(itemButton);
//      itemButton.addActionListener((e ->
//          inventoryListener.accept(itemButton.getActionCommand())));
//    }

  }

  public void setInventoryListener(Consumer<String> listener){
    inventoryListener = listener;
  }

}
