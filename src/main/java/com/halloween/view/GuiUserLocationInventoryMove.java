package com.halloween.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.List;
import java.util.function.Consumer;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class GuiUserLocationInventoryMove {

  JTextArea textAreaForLocation;
  JTextArea textAreaForPossibleMoves;
  JTextArea titleForInventory;
  JPanel panelForInventory;
  JPanel panelForLocationInventoryMove;
  JButton itemBtn;
  Consumer<String> inventoryListener;
  Consumer<String> useItemListener;

  GuiForUserInput userInputField = new GuiForUserInput();


  public GuiUserLocationInventoryMove() {

    textAreaForLocation = new JTextArea("Your Current Location:");
//    textAreaForLocation.setBorder(BorderFactory.createLineBorder(Color.green));
//    textAreaForLocation.setSize(215, 245);
    textAreaForLocation.setEditable(false);
    textAreaForLocation.setFont(new Font("Bold", Font.BOLD, 16));
    textAreaForLocation.setLineWrap(true);
    textAreaForLocation.setWrapStyleWord(true);
    textAreaForLocation.setForeground(Color.white);
    textAreaForLocation.setLayout(new BorderLayout());
    textAreaForLocation.setOpaque(false);

    textAreaForPossibleMoves = new JTextArea("Possible Moves");
//    textAreaForPossibleMoves.setBorder(BorderFactory.createLineBorder(Color.red));
//    textAreaForPossibleMoves.setSize(215, 245);
    textAreaForPossibleMoves.setEditable(false);
    textAreaForPossibleMoves.setFont(new Font("Bold", Font.BOLD, 16));
    textAreaForPossibleMoves.setLineWrap(true);
    textAreaForPossibleMoves.setWrapStyleWord(true);
    textAreaForPossibleMoves.setForeground(Color.white);
    textAreaForPossibleMoves.setLayout(new FlowLayout());
    textAreaForPossibleMoves.setOpaque(false);

    //inventory
    panelForInventory = new JPanel() {
      protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
      }
    };
//    panelForInventory.setSize(215, 245);
//    panelForInventory.setBorder(BorderFactory.createLineBorder(Color.blue));
    panelForInventory.setLayout(new GridLayout(8, 1));
//    panelForInventory.setLayout(null);
    panelForInventory.setOpaque(false);
    panelForInventory.setBackground(new Color(0, 0, 0, 5));
//    Border titleForInventory = BorderFactory.createTitledBorder("Inventory");
//    panelForInventory.setBorder(titleForInventory);

    titleForInventory = new JTextArea("Inventory:");
    titleForInventory.setEditable(false);
//    titleForInventory.setBackground(Color.white);
    titleForInventory.setFont(new Font("Bold", Font.BOLD, 16));
    titleForInventory.setOpaque(false);
    titleForInventory.setBounds(0, 0, 215, 15);
    titleForInventory.setForeground(Color.YELLOW);

    panelForInventory.add(titleForInventory);



//    panelForLocationInventoryMove = new JPanel();
    panelForLocationInventoryMove = new JPanel() {
      protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
      }
    };

    panelForLocationInventoryMove.setBounds(20, 435, 675, 255);
    panelForLocationInventoryMove.setLayout(new GridLayout(1, 3));

    panelForLocationInventoryMove.add(textAreaForLocation);
    panelForLocationInventoryMove.add(textAreaForPossibleMoves);
    panelForLocationInventoryMove.add(panelForInventory);
    panelForLocationInventoryMove.setOpaque(false);
    panelForLocationInventoryMove.setBackground(new Color(0, 0, 0, 120));
    panelForLocationInventoryMove.setVisible(false);

  }

  public JPanel getPanelForLocationInventoryMove() {
    return panelForLocationInventoryMove;
  }


  public void updateInventory(List<String> inventory) {

    panelForInventory.removeAll();
    panelForInventory.revalidate();
    panelForInventory.repaint();
    panelForInventory.add(titleForInventory);
    for (int i = 0; i < inventory.size(); i++) {
      itemBtn = new JButton(inventory.get(i).toUpperCase());
//      itemBtn.setBounds(30, (i+1)*35, 160, 30);
      itemBtn.setFont(new Font("serif", Font.BOLD, 16));
      itemBtn.setForeground(Color.white);
//      itemBtn.setForeground(Color.YELLOW);
      itemBtn.setBackground(new Color(0, 0, 0, 120));
      Border emptyBorder = BorderFactory.createEmptyBorder();
      itemBtn.setBorder(emptyBorder);
      itemBtn.setOpaque(false);
      itemBtn.setFocusPainted(false);
      itemBtn.setFocusable(false);
      itemBtn.setActionCommand(inventory.get(i));
      panelForInventory.add(itemBtn);
      itemBtn.setVisible(true);
      if (itemBtn.getActionCommand().isEmpty()) {
//      itemBtn.setVisible(false);
        itemBtn.getParent().remove(itemBtn);
        itemBtn.setVisible(false);
      } else {
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
    textAreaForLocation.setText("Current Location:\n\n" + dialogue);
    textAreaForLocation.setForeground(Color.RED);
  }

  public void updatePossibleMove(String dialogue) {

    textAreaForPossibleMoves.removeAll();
    textAreaForPossibleMoves.revalidate();
    textAreaForPossibleMoves.repaint();
    textAreaForPossibleMoves.setText("Possible Moves:" + dialogue);
    textAreaForPossibleMoves.setForeground(Color.ORANGE);
  }

  public void setInventoryListener(Consumer<String> listener) {
    inventoryListener = listener;
  }

  public void setUseItemListener(Consumer<String> listener) {
    useItemListener = listener;
  }
}