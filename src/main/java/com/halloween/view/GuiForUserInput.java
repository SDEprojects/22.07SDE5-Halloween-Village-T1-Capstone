package com.halloween.view;

import java.awt.Color;
import java.util.function.Consumer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
    panelForUserInput.setBounds(5, 695, 970, 60);
    panelForUserInput.setLayout(null);
    panelForUserInput.setBackground(Color.lightGray);
    panelForUserInput.setOpaque(false);

    labelForUserInput = new JLabel();
    labelForUserInput.setText("Type your name");
    labelForUserInput.setForeground(Color.white);
    labelForUserInput.setBounds(15, 0, 100, 25);

    userTextField = new JTextField();
    userTextField.setBounds(15, 25, 230, 30);
    userTextField.addActionListener(e -> {
      userInputListener.accept(userTextField.getText());
      userTextField.setText("");
      panelForUserInput.setVisible(false);
    });
    panelForUserInput.add(userTextField);

    buttonForUserInput = new JButton();
    buttonForUserInput.setText("submit");
    buttonForUserInput.setBounds(250, 25, 70, 30);
    buttonForUserInput.setFocusable(false);
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
