package com.halloween.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GuiGame implements ActionListener {

  JFrame frame;
  GuiTitle title = new GuiTitle();
  GuiScript script = new GuiScript();
  GuiButtons defaultButton = new GuiButtons();
  GuiForUserInput userInput = new GuiForUserInput();
  GuiDirectionButton directionButton = new GuiDirectionButton();
  GuiUserLocationInventoryMove userLocationInventoryMove = new GuiUserLocationInventoryMove();

  StartGameGUI startGameGui = new StartGameGUI();

  JPanel panelForGameWindow;


  public GuiGame() {
    frame = new JFrame();
    frame.setTitle("Halloween-Village");
    frame.getContentPane().setBackground(Color.cyan);
    frame.setSize(new Dimension(1000, 800));
    frame.setLayout(null);

    panelForGameWindow = new JPanel();
    panelForGameWindow.setLayout(null);

    panelForGameWindow.add(title.getPanelForTitleWithImg());
    panelForGameWindow.add(script.getPanelForScript());
    panelForGameWindow.add(defaultButton.getPanelForDefaultButtons());
    panelForGameWindow.add(userInput.getPanelForUserInput());
    panelForGameWindow.add(directionButton.getPanelForDirectionButtonsWithOtherButtons());
    panelForGameWindow.add(userLocationInventoryMove.getPanelForLocationInventoryMOve());
    panelForGameWindow.setBackground(Color.cyan);
    panelForGameWindow.setBounds(0, 0, 1000, 800);
    frame.add(panelForGameWindow);
    panelForGameWindow.setVisible(false);

    frame.add(startGameGui.getPanelForStartWindow());
    startGameGui.newGameBtn.addActionListener(this);


    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }



  @Override
  public void actionPerformed(ActionEvent e) {
    startGameGui.getPanelForStartWindow().setVisible(false);
    panelForGameWindow.setVisible(true);
    script.greetPlayer();

  }


  public static void main(String[] args) {
    new GuiGame();
  }
}