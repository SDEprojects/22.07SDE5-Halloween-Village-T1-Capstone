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

  JLabel labelForLocation;
  JTextArea textAreaForLocation;
  JLabel labelForPossibleMoves;
  JTextArea textAreaForPossibleMoves;
  JPanel panelForInventory;
  JPanel panelForLocationInventoryMove;
  JButton itemBtn;
  Consumer<String> useItemListener;

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
//    panelForInventory.setLayout(new GridLayout());
    panelForInventory.setLayout(new GridLayout(4, 2));

//    JTextArea titleForLocation = new JTextArea("Inventory");
//    titleForLocation.setBounds(2,2,215,20);
//    itemPanel.add(titleForLocation);



    JTextArea textAreaForPossibleMove = new JTextArea("Possible Moves:");
    textAreaForPossibleMove.setBorder(BorderFactory.createLineBorder(Color.black));
    textAreaForPossibleMove.setBounds(442, 2, 215, 245);

    panelForLocationInventoryMove = new JPanel();
    panelForLocationInventoryMove.setBackground(Color.LIGHT_GRAY);
    panelForLocationInventoryMove.setBounds(5, 435, 660, 250);
    panelForLocationInventoryMove.setLayout(new GridLayout(1, 3));

    panelForLocationInventoryMove.add(textAreaForLocation);
    panelForLocationInventoryMove.add(textAreaForPossibleMove);
    panelForLocationInventoryMove.add(panelForInventory);
  }

  public JPanel getPanelForLocationInventoryMove() {
    return panelForLocationInventoryMove;
  }


  public void updateInventory(List<String> inventory) {

    panelForInventory.removeAll();
    panelForInventory.revalidate();
    panelForInventory.repaint();
    panelForInventory.setBackground(Color.white);

//    itemPanel.removeAll();
//      itemPanel.revalidate();
//      itemPanel.repaint();
//      JTextArea titleForLocation = new JTextArea("Inventory");
//      titleForLocation.setBounds(2,2,215,20);
//      itemPanel.add(titleForLocation);


    for (int i = 0; i < inventory.size(); i++) {
      itemBtn = new JButton(inventory.get(i));
      itemBtn.setBounds(30, (i+1)*25, 160, 30);
      itemBtn.setFocusable(false);
      itemBtn.setActionCommand(inventory.get(i));
      panelForInventory.add(itemBtn);
      itemBtn.setVisible(true);
     if (itemBtn.getActionCommand().isEmpty()){
//      itemBtn.setVisible(false);
        itemBtn.getParent().remove(itemBtn);
        itemBtn.setVisible(false);
      }else{
        itemBtn.setVisible(true);
      }
//      itemBtn.setVisible(true);
      itemBtn.addActionListener(e -> {
        useItemListener.accept(e.getActionCommand());

//        itemBtn.getParent().remove(itemBtn);
      });
    }
  }


  public void updateLocation(String dialogue) {
    textAreaForLocation.removeAll();
    textAreaForLocation.revalidate();
    textAreaForLocation.repaint();
    textAreaForLocation.setText("\nYour Current Location:\n\n" + dialogue);
  }
  public void updatePossibleMove(String dialogue) {

    textAreaForPossibleMoves.removeAll();
    textAreaForPossibleMoves.revalidate();
    textAreaForPossibleMoves.repaint();
    textAreaForPossibleMoves.setText("\nPossible Moves:" + dialogue);
  }

  public void setInventoryListener(Consumer<String> listener) {
    inventoryListener = listener;

  }
  public void setUseItemListener(Consumer<String> listener){
    useItemListener = listener;
  }


}





