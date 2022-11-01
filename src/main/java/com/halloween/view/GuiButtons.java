package com.halloween.view;

import com.halloween.controller.Game;
import java.awt.Color;
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
  Game game = new Game();
  GuiScript guiScript = new GuiScript();
  SoundEffects soundEffects = new SoundEffects();

  public JPanel getPanelForDefaultButtons() {
    return panelForDefaultButtons;
  }

  public GuiButtons(){

    panelForDefaultButtons = new JPanel();
    panelForDefaultButtons.setBackground(Color.lightGray);
    panelForDefaultButtons.setBounds(825, 130, 150, 280);
    panelForDefaultButtons.setLayout(null);

    JButton mapButton = new JButton("Map");
    mapButton.setBounds(30, 30, 90, 40);
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
    muteButton.setBounds(30, 90, 90, 40);
    muteButton.setFocusable(false);
    muteButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (muteButton.getText().equals("Mute")) {
//        game.stopMusic();
          // muteSoundEffects method may need to change to a non-static method
//          soundEffects.muteSoundEffects();
          muteButton.setText("Unmute");
        } else {
//          game.startMusic();
          // unmuteSoundEffects method may need to change to a non-static method
//          soundEffects.unmuteSoundEffects();
          muteButton.setText("Mute");
        }
      }
    });

    JButton help = new JButton("Help");
    help.setBounds(30, 150, 90, 40);
    help.setFocusable(false);

    JButton button11 = new JButton("Quit");
    button11.setBounds(30, 210, 90, 40);
    button11.setFocusable(false);

    panelForDefaultButtons.add(mapButton);
    panelForDefaultButtons.add(muteButton);
    panelForDefaultButtons.add(help);
    panelForDefaultButtons.add(button11);
  }

}
