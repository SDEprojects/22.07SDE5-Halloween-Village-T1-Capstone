package com.halloween.view;

import java.awt.Color;
import java.awt.Font;
import java.net.URL;
import java.util.function.Consumer;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class GuiForUserInput {

  JPanel panelForUserInput;
  JLabel labelForUserInput;
  JTextField userTextField;
  JButton buttonForUserInput;
  GuiScript guiScript;
  View view;
  private Consumer<String> userInputListener;

  public GuiForUserInput() {

    panelForUserInput = new JPanel();
    panelForUserInput.setBounds(50, 500, 970, 75);
    panelForUserInput.setLayout(null);
    panelForUserInput.setBackground(Color.lightGray);
    panelForUserInput.setOpaque(false);


    labelForUserInput = new JLabel();
    labelForUserInput.setText("Type your name");
    labelForUserInput.setForeground(Color.white);
    labelForUserInput.setBounds(15, 0, 100, 30);

    userTextField = new JTextField();
    userTextField.setBounds(15, 25, 300, 40);
    userTextField.setBackground(new Color(255,154, 0));
    userTextField.setForeground(Color.black);
    userTextField.addActionListener(e -> {
      userInputListener.accept(userTextField.getText());
      userTextField.setText("");
      panelForUserInput.setVisible(false);
    });
    panelForUserInput.add(userTextField);

    buttonForUserInput = new JButton();
    buttonForUserInput.setBounds(320, 25, 80, 40);
    URL playImage = GuiButtons.class.getClassLoader().getResource("play.png");
    ImageIcon playIcon = new ImageIcon(playImage);
    buttonForUserInput.setIcon(playIcon);
    buttonForUserInput.setBackground(new Color(0, 0, 0, 120));
    Border emptyBorder = BorderFactory.createEmptyBorder();
    buttonForUserInput.setBorder(emptyBorder);
    buttonForUserInput.setOpaque(false);
    buttonForUserInput.setFocusPainted(false);
    buttonForUserInput.addActionListener(e -> {
      userInputListener.accept(userTextField.getText());
      userTextField.setText("");
      panelForUserInput.setVisible(false);
    });
    panelForUserInput.add(labelForUserInput);
    panelForUserInput.add(buttonForUserInput);
  }

  public String userInput() {
    return userTextField.getText();
  }
  public void setUserInputListener(Consumer<String> listener) {
    userInputListener = listener;
  }

  public JPanel getPanelForUserInput() {
    return panelForUserInput;
  }



}
