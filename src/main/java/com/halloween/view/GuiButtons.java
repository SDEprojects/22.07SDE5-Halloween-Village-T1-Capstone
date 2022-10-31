package com.halloween.view;

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

    JButton help = new JButton("Help");
    help.setBounds(30, 150, 90, 40);
    help.setFocusable(false);

    JButton quitButton = new JButton("Quit");
    quitButton.setBounds(30, 210, 90, 40);
    quitButton.setFocusable(false);
    quitButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });

    panelForDefaultButtons.add(mapButton);
    panelForDefaultButtons.add(muteButton);
    panelForDefaultButtons.add(help);
    panelForDefaultButtons.add(quitButton);
  }

}
