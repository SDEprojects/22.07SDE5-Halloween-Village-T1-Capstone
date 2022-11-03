package com.halloween.view;

import com.halloween.controller.Game;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GuiButtons {

  JPanel panelForDefaultButtons;
  JButton help;
  GuiScript guiScript = new GuiScript();
  HelpInstructionDisplayGui helpInstructionGui = new HelpInstructionDisplayGui();
  SoundEffects soundEffects = new SoundEffects();
  Game game = new Game();


  public JPanel getPanelForDefaultButtons() {
    return panelForDefaultButtons;
  }

  public GuiButtons() {
    game.startMusic();
    SoundEffects.playSound("/silent_quarter_second.wav");

    panelForDefaultButtons = new JPanel();
    panelForDefaultButtons.setBackground(Color.lightGray);
    panelForDefaultButtons.setBounds(825, 130, 150, 280);
    panelForDefaultButtons.setLayout(new GridLayout(5, 1));

    JButton mapButton = new JButton("Map");
//    mapButton.setSize(100, 40);
//    mapButton.setBounds(30, 30, 90, 40);
    mapButton.setFocusable(false);

    mapButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JFrame mapFrame = new JFrame();
        URL mapImageLocation = GuiButtons.class.getClassLoader().getResource("halloween-village-map.PNG");
        mapFrame.add(new JLabel(new ImageIcon(mapImageLocation)));
        mapFrame.pack();
        mapFrame.setVisible(true);
      }
    });


    JButton muteButton = new JButton("Mute");
//    muteButton.setBounds(30, 90, 90, 40);
    muteButton.setFocusable(false);
    muteButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (muteButton.getText().equals("Mute")) {
          game.stopMusic();
          soundEffects.muteSoundEffects();
          muteButton.setText("Unmute");
        } else {
          game.startMusic();
          soundEffects.unmuteSoundEffects();
          muteButton.setText("Mute");
        }
      }
    });


    help = new JButton("Help");
//    help.setBounds(30, 150, 90, 40);
    help.setFocusable(false);
    help.addActionListener(e -> helpInstructionGui.updateDialogBox("help"));

    

    JButton quitButton = new JButton("Quit");
//    quitButton.setBounds(30, 210, 90, 40);
    quitButton.setFocusable(false);
    quitButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });

    JButton instructionButton = new JButton("Instruction");
//    quitButton.setBounds(30, 210, 90, 40);
    instructionButton.setFocusable(false);
    instructionButton.addActionListener(e -> helpInstructionGui.updateDialogBox("instruction"));



    panelForDefaultButtons.add(mapButton);
    panelForDefaultButtons.add(muteButton);
    panelForDefaultButtons.add(help);
    panelForDefaultButtons.add(instructionButton);
    panelForDefaultButtons.add(quitButton);
  }


}
