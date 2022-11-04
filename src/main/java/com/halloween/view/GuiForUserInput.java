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
    labelForUserInput.setText("User Input");
    labelForUserInput.setForeground(Color.white);
    labelForUserInput.setBounds(15, 0, 100, 25);

    userTextField = new JTextField();
    userTextField.setBounds(15, 25, 230, 25);
    userTextField.addActionListener(e -> {
      userInputListener.accept(userTextField.getText());
      System.out.println(userTextField.getText());
//      guiScript.displayDialogue(view.getImportantDisplay("backstory"));
      userTextField.setText("");
    });
    panelForUserInput.add(userTextField);

    buttonForUserInput = new JButton();
    buttonForUserInput.setText("");
    buttonForUserInput.setBounds(250, 25, 55, 25);
    buttonForUserInput.setFocusable(false);
    buttonForUserInput.addActionListener(e -> {
      userInputListener.accept(userTextField.getText());
      System.out.println(userTextField.getText());
      userTextField.setText("");
//      guiScript.displayDialogue(view.getImportantDisplay("backstory"));
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
