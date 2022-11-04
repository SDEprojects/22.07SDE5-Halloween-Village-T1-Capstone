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

  JTextArea textAreaForLocation;
  JTextArea textAreaForPossibleMoves;
  JPanel panelForInventory;
  JPanel panelForLocationInventoryMove;
  JButton itemBtn;
  Consumer<String> inventoryListener;
  Consumer<String> useItemListener;


  public GuiUserLocationInventoryMove() {
    //text area for current location
    textAreaForLocation = createTextArea("Your Current Location:");
    //text area for possible moves
    textAreaForPossibleMoves = createTextArea("Possible Moves:");

    //inventory
    panelForInventory = new JPanel();
    panelForInventory.setSize(215, 245);
    panelForInventory.setBorder(BorderFactory.createLineBorder(Color.black));
//    panelForInventory.setLayout(new GridLayout());
    panelForInventory.setLayout(new GridLayout(4, 2));

//    JTextArea titleForLocation = new JTextArea("Inventory");
//    titleForLocation.setBounds(2,2,215,20);
//    itemPanel.add(titleForLocation);

    panelForLocationInventoryMove = new JPanel();
    panelForLocationInventoryMove.setBackground(Color.LIGHT_GRAY);
    panelForLocationInventoryMove.setBounds(5, 435, 660, 250);
    panelForLocationInventoryMove.setLayout(new GridLayout(1, 3));

    panelForLocationInventoryMove.add(textAreaForLocation);
    panelForLocationInventoryMove.add(textAreaForPossibleMoves);
    panelForLocationInventoryMove.add(panelForInventory);
  }

  private JTextArea createTextArea(String text) {
    JTextArea textArea = new JTextArea(text);
    textArea.setBorder(BorderFactory.createLineBorder(Color.black));
    textArea.setSize(215, 245);
    textArea.setEditable(false);
    textArea.setFont(new Font("Bold", Font.ITALIC, 16));
    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);
    textArea.setForeground(Color.blue);
    textArea.setLayout(new FlowLayout());
    return textArea;
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





