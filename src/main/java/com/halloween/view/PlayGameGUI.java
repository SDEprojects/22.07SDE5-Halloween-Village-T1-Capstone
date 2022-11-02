package com.halloween.view;

import com.halloween.model.Neighborhood;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PlayGameGUI implements ActionListener {

  JFrame frame;
  GuiTitle title = new GuiTitle();
  GuiScript script = new GuiScript();
  GuiButtons defaultButton = new GuiButtons();
  GuiForUserInput userInput = new GuiForUserInput();
  GuiDirectionButton directionButton = new GuiDirectionButton();
  GuiUserLocationInventoryMove userLocationInventoryMove = new GuiUserLocationInventoryMove();

  StartGameGUI startGameGui = new StartGameGUI();

  JPanel panelForGameWindow;
  PlayGameGUI guiScript;

  private Consumer<String> knockListener;

  public String currentLocation;
  public ArrayList<String> inventory;
  public Neighborhood neighborhood;


  public PlayGameGUI() {
    frame = new JFrame();
    frame.setTitle("Halloween Village");
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

    // set window icon
    URL iconLocation = StartGameGUI.class.getClassLoader().getResource("pumpkinIcon1.png");
    ImageIcon imgIcon = new ImageIcon(iconLocation);
    frame.setIconImage(imgIcon.getImage());
    frame.setVisible(true);


    frame.setLocationRelativeTo(null);
    frame.setVisible(true);

    currentLocation = "your house";

  }


  public GuiScript getScript() {
    return script;
  }

  public GuiDirectionButton getDirectionButton() {
    return directionButton;
  }

  public void updateKnockButton(String location){
    directionButton.updateDirectionButtons(location);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    startGameGui.getPanelForStartWindow().setVisible(false);
    panelForGameWindow.setVisible(true);
    script.printScript("backstory");

  }

  public void setKnockConsumer(Consumer<String> listener) {

    directionButton.setKnockListener(location -> listener.accept(location));
//    knockListener = listener;

}


  public void setDirectionConsumer(Consumer<String> listener) {
    directionButton.setDirectionListener(direction -> listener.accept(direction));
  }
  public static void main(String[] args) {
    new PlayGameGUI();
  }
}