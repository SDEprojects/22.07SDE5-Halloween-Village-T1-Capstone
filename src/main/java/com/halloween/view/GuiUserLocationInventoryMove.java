package com.halloween.view;

import java.awt.Color;
import java.util.List;
import java.util.function.Consumer;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GuiUserLocationInventoryMove {
  JPanel panelForLocationInventoryMove;
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

    panelForLocationInventoryMove = new JPanel();
    panelForLocationInventoryMove.setBackground(Color.LIGHT_GRAY);
    panelForLocationInventoryMove.setBounds(5, 435, 660, 250);
    panelForLocationInventoryMove.setLayout(null);

    panelForLocationInventoryMove.add(textAreaForLocation);
    panelForLocationInventoryMove.add(itemPanel);
    panelForLocationInventoryMove.add(textAreaForPossibleMove);
  }

  public JPanel getPanelForLocationInventoryMove() {
    return panelForLocationInventoryMove;
  }


  public void updateInventory(List<String> inventory) {
      itemPanel.removeAll();
      itemPanel.revalidate();
      itemPanel.repaint();
      JTextArea titleForLocation = new JTextArea("Inventory");
      titleForLocation.setBounds(2,2,215,20);
      itemPanel.add(titleForLocation);

    for (int i = 0; i < inventory.size(); i++) {
      itemBtn = new JButton(inventory.get(i));
      itemBtn.setBounds(30, (i+1)*25, 160, 30);
      itemBtn.setFocusable(false);
      itemBtn.setActionCommand(inventory.get(i));
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





