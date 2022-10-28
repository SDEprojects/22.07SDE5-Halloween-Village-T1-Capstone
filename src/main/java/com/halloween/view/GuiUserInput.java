package com.halloween.view;

import com.halloween.controller.Game;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class GuiUserInput {
  JFrame frame;
  JPanel panelForUserInput;
  JLabel labelForUserInput;
  JTextField userTextField;
  JButton buttonForUserInput;
  JTextArea textArea;

  public GuiUserInput() {
    frame = new JFrame();
    frame.setTitle("Halloween-Village");
    frame.getContentPane().setBackground(Color.cyan);
    frame.setSize(new Dimension(1000, 800));
    frame.setLayout(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//   ---------------------------------------------------------------------------------------------

    JPanel panelForDirectionButtonsWithOtherButtons = new JPanel();
    panelForDirectionButtonsWithOtherButtons.setBackground(Color.lightGray);
    panelForDirectionButtonsWithOtherButtons.setBounds(675, 435, 300, 250);
    panelForDirectionButtonsWithOtherButtons.setLayout(null);

    JPanel panelForDefaultButtons = new JPanel();
    panelForDefaultButtons.setBackground(Color.lightGray);
    panelForDefaultButtons.setBounds(825, 130, 150, 280);
    panelForDefaultButtons.setLayout(null);

    JPanel panelForDirectionButton = new JPanel();
    panelForDirectionButton.setBackground(Color.lightGray);
    panelForDirectionButton.setBounds(20, 60, 136, 136);
    panelForDirectionButton.setLayout(null);

    JPanel panelForLocationInventoryMOve = new JPanel();
    panelForLocationInventoryMOve.setBackground(Color.LIGHT_GRAY);
    panelForLocationInventoryMOve.setBounds(5, 435, 660, 250);
    panelForLocationInventoryMOve.setLayout(null);

//    JPanel panelForTitleWithImg = new JPanel();
//    panelForTitleWithImg.setBackground(Color.LIGHT_GRAY);
//    panelForTitleWithImg.setBounds(7, 5, 970, 100);
//    panelForTitleWithImg.setLayout(new FlowLayout());

//    JLabel labelForTitle = new JLabel("Title");
//    panelForTitleWithImg.add(labelForTitle);

    JLabel labelForScript = new JLabel("Script");

    JPanel panelForScript = new JPanel();
    panelForScript.setBackground(Color.LIGHT_GRAY);
    panelForScript.setBounds(10, 120, 800, 300);
    panelForScript.setLayout(new FlowLayout());
    panelForScript.add(labelForScript);


    JTextArea textAreaForLocation = new JTextArea("Location:");
    textAreaForLocation.setBorder(BorderFactory.createLineBorder(Color.black));
    textAreaForLocation.setBounds(2, 2, 215, 245);
    JTextArea textAreaForInventory = new JTextArea("Inventory:");
    textAreaForInventory.setBorder(BorderFactory.createLineBorder(Color.black));
    textAreaForInventory.setBounds(222, 2, 215, 245);
    JTextArea textAreaForPossibleMove = new JTextArea("Possible Moves:");
    textAreaForPossibleMove.setBorder(BorderFactory.createLineBorder(Color.black));
    textAreaForPossibleMove.setBounds(442, 2, 215, 245);


    panelForLocationInventoryMOve.add(textAreaForLocation);
    panelForLocationInventoryMOve.add(textAreaForInventory);
    panelForLocationInventoryMOve.add(textAreaForPossibleMove);

    JButton button1 = new JButton("N");
    button1.setBounds(45, 0, 46, 46);
    button1.setFocusable(false);
    JButton button2 = new JButton("S");
    button2.setBounds(45, 90, 46, 46);
    button2.setFocusable(false);
    JButton button3 = new JButton("W");
    button3.setBounds(0, 45, 46, 46);
    button3.setFocusable(false);
    JButton button4 = new JButton("E");
    button4.setBounds(90, 45, 46, 46);
    button4.setFocusable(false);

    JButton button5 = new JButton("Get");
    button5.setBounds(180, 40, 90, 40);
    button5.setFocusable(false);
    JButton button6 = new JButton("Use");
    button6.setBounds(180, 100, 90, 40);
    button6.setFocusable(false);
    JButton button7 = new JButton("Knock");
    button7.setBounds(180, 160, 90, 40);
    button7.setFocusable(false);

    JButton button8 = new JButton("Map");
    button8.setBounds(30, 30, 90, 40);
    button8.setFocusable(false);
    JButton button9 = new JButton("Mute");
    button9.setBounds(30, 90, 90, 40);
    button9.setFocusable(false);
    JButton button10 = new JButton("Help");
    button10.setBounds(30, 150, 90, 40);
    button10.setFocusable(false);
    JButton button11 = new JButton("Quit");
    button11.setBounds(30, 210, 90, 40);
    button11.setFocusable(false);

    panelForDefaultButtons.add(button8);
    panelForDefaultButtons.add(button9);
    panelForDefaultButtons.add(button10);
    panelForDefaultButtons.add(button11);

    panelForDirectionButton.add(button1);
    panelForDirectionButton.add(button2);
    panelForDirectionButton.add(button3);
    panelForDirectionButton.add(button4);
    panelForDirectionButtonsWithOtherButtons.add(button5);
    panelForDirectionButtonsWithOtherButtons.add(button6);
    panelForDirectionButtonsWithOtherButtons.add(button7);
    panelForDirectionButtonsWithOtherButtons.add(panelForDirectionButton);

    frame.add(panelForDirectionButtonsWithOtherButtons);
    frame.add(panelForDefaultButtons);
    frame.add(panelForLocationInventoryMOve);
//    frame.add(panelForTitleWithImg);
    frame.add(panelForScript);

//   ---------------------------------------------------------------------------------------------

    panelForUserInput = new JPanel();
    panelForUserInput.setBounds(5, 695, 970, 60);
    panelForUserInput.setLayout(null);
    panelForUserInput.setBackground(Color.lightGray);

    labelForUserInput = new JLabel();
    labelForUserInput.setText("User Input");
    labelForUserInput.setBounds(15, 0, 100, 25);

    userTextField = new JTextField();
    userTextField.setBounds(15, 25, 230, 25);
    panelForUserInput.add(userTextField);

    buttonForUserInput = new JButton();
    buttonForUserInput.setText("Go");
    buttonForUserInput.setBounds(250, 25, 55, 25);
    buttonForUserInput.setFocusable(false);
    buttonForUserInput.addActionListener(e -> System.out.println(userTextField.getText()));

    panelForUserInput.add(labelForUserInput);
    panelForUserInput.add(buttonForUserInput);
    frame.add(panelForUserInput);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
//   ---------------------------------------------------------------------------------------------

  }
  public void displayTitle() {

  }

  public static void main(String[] args) {
    new GuiUserInput();
  }
}
