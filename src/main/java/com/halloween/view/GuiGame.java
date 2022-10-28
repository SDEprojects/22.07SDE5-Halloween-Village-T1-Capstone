package com.halloween.view;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;

public class GuiGame {

  GuiTitle title = new GuiTitle();

  public GuiGame() {
    JFrame frame = new JFrame();
    frame.setTitle("Halloween-Village");
    frame.getContentPane().setBackground(Color.cyan);
    frame.setSize(new Dimension(1000, 800));
    frame.setLayout(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(title.getPanelForTitleWithImg());
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    new GuiGame();
  }
}
