package com.halloween.view;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GuiUserInput {
  JFrame frame;
  JPanel panelForUserInput;
  JLabel labelForUserInput;
  JTextField userTextField;
  JButton buttonForUserInput;

  public GuiUserInput() {
    frame = new JFrame();
    panelForUserInput = new JPanel();
    labelForUserInput = new JLabel();
    userTextField = new JTextField();
    buttonForUserInput = new JButton();

    frame.setTitle("Halloween-Village");
    frame.getContentPane().setBackground(Color.cyan);
    frame.setSize(500, 500);
    frame.setLayout(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    panelForUserInput.setBounds(0, 400, 500, 50);
    panelForUserInput.setLayout(null);
    panelForUserInput.setBackground(Color.lightGray);

    labelForUserInput.setText("User Input");
    labelForUserInput.setBounds(15, 0, 100, 25);

    userTextField.setBounds(15, 25, 165, 25);
    panelForUserInput.add(userTextField);

    buttonForUserInput.setText("Go");
    buttonForUserInput.setBounds(180, 25, 55, 25);
    buttonForUserInput.setFocusable(false);
    buttonForUserInput.addActionListener(e -> System.out.println(userTextField.getText()));

    panelForUserInput.add(labelForUserInput);
    panelForUserInput.add(buttonForUserInput);
    frame.add(panelForUserInput);
    frame.setVisible(true);

  }

  public static void main(String[] args) {
    new GuiUserInput();
  }
}
