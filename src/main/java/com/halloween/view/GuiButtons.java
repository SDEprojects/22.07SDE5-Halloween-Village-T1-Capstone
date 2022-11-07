package com.halloween.view;

import com.halloween.controller.Game;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class GuiButtons {

  JPanel panelForDefaultButtons;
  HelpInstructionDisplayGui helpInstructionGui = new HelpInstructionDisplayGui();
  SoundEffects soundEffects = new SoundEffects();

  Game game = new Game();
  JButton mapButton;
  JButton muteButton;
  JButton quitButton;
  JButton instructionButton;



  public JPanel getPanelForDefaultButtons() {
    return panelForDefaultButtons;
  }

  public GuiButtons() {
    game.startMusic();
    soundEffects.playSound("/silent_quarter_second.wav");

    // create new gridlayout
    GridLayout gridLayout = new GridLayout(4, 1);
    gridLayout.setVgap(20);
    // panel for default buttons with grid layout
    panelForDefaultButtons = new JPanel(gridLayout);
    panelForDefaultButtons.setBackground(Color.lightGray);
    panelForDefaultButtons.setOpaque(false);
    panelForDefaultButtons.setBounds(780, 180, 125, 230);
    panelForDefaultButtons.setVisible(false);

    // map button
    mapButton = createButton("map.png");
    mapButton.addActionListener(e -> displayMap());

    // quit button
    quitButton = createButton("quit.png");
    quitButton.addActionListener(e -> System.exit(0));

    // instruction button
    instructionButton = createButton("instruction.png");
    instructionButton.addActionListener(e -> helpInstructionGui.updateDialogBox("instruction"));

    // mute unmute button
    muteButton = new JButton();
    ImageIcon unmuteIcon = createImageIcon("unmute.png");
    ImageIcon muteIcon = createImageIcon("mute.png");
    muteButton.setIcon(muteIcon);
    muteButton.setBackground(new Color(0, 0, 0, 120));
    Border emptyBorder = BorderFactory.createEmptyBorder();
    muteButton.setBorder(emptyBorder);
    muteButton.setOpaque(false);
    muteButton.setFocusPainted(false);
    muteButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if(muteButton.getIcon().equals(muteIcon)) {
          game.stopMusic();
          soundEffects.muteSoundEffects();
          muteButton.setIcon(unmuteIcon);
        } else {
          game.startMusic();
          soundEffects.unmuteSoundEffects();
          muteButton.setIcon(muteIcon);
        }
      }
    });

    // add all buttons to panel
    panelForDefaultButtons.add(mapButton);
    panelForDefaultButtons.add(muteButton);
    panelForDefaultButtons.add(instructionButton);
    panelForDefaultButtons.add(quitButton);
  }

  // method to create buttons
  JButton createButton(String imageName) {
    JButton button = new JButton();
    ImageIcon imageIcon = createImageIcon(imageName);
    button.setIcon(imageIcon);
    button.setBackground(new Color(0, 0, 0, 120));
    Border emptyBorder = BorderFactory.createEmptyBorder();
    button.setBorder(emptyBorder);
    button.setOpaque(false);
    button.setFocusPainted(false);
    return button;
  }

  // method to create image icon
  public ImageIcon createImageIcon(String name) {
    URL image = GuiButtons.class.getClassLoader().getResource(name);
    ImageIcon imageIcon = new ImageIcon(image);
    return imageIcon;
  }

  // method to display map frame
  private void displayMap() {
    JFrame mapFrame = new JFrame();
    URL mapImageLocation = GuiButtons.class.getClassLoader()
        .getResource("halloween-village-map.png");
    mapFrame.add(new JLabel(new ImageIcon(mapImageLocation)));
    mapFrame.pack();
    mapFrame.setVisible(true);
  }

  public JButton getMapButton() {
    return mapButton;
  }
}
