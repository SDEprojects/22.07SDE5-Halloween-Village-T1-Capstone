package com.halloween.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;
import java.util.function.Consumer;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
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
//    itemPanel.setLayout(new GridLayout(2,2));
    itemPanel.setLayout(null);
    itemPanel.setBackground(Color.white);

    JTextArea titleForLocation = new JTextArea("Inventory");
    titleForLocation.setBounds(2,2,215,20);
    itemPanel.add(titleForLocation);



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
      itemPanel.repaint();
      JTextArea titleForLocation = new JTextArea("Inventory");
      titleForLocation.setBounds(2,2,215,20);
      itemPanel.add(titleForLocation);

    for (int i = 0; i < inventory.size(); i++) {
      System.out.println(inventory.get(i) + " inventory i printing ");
      itemBtn = new JButton(inventory.get(i));
      itemBtn.setBounds(30, (i+1)*25, 160, 30);
      itemBtn.setFocusable(false);
      itemBtn.setActionCommand(inventory.get(i));
      System.out.println(itemBtn.getActionCommand() + " getting action command right away");
      itemPanel.add(itemBtn);
      if (itemBtn.getActionCommand().isEmpty()){
//        itemBtn.setVisible(false);
        itemBtn.getParent().remove(itemBtn);
        itemBtn.setVisible(false);
      }else{
        itemBtn.setVisible(true);
      }
//      itemBtn.setVisible(true);
      itemBtn.addActionListener(e -> {
        System.out.println(e.getActionCommand() + " action comand");
        useItemListener.accept(e.getActionCommand());

//        itemBtn.getParent().remove(itemBtn);
      });


    }
  }

  public void setUseItemListener(Consumer<String> listener){
    useItemListener = listener;
  }

}





