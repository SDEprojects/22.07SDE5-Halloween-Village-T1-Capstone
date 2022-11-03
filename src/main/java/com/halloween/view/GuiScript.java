package com.halloween.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GuiScript {
  JPanel panelForScript = new JPanel() {
    protected void paintComponent(Graphics g)
    {
      g.setColor( getBackground() );
      g.fillRect(0, 0, getWidth(), getHeight());
      super.paintComponent(g);
    }
  };
  JTextArea textAreaForScript = new JTextArea();
  public GuiScript() {
//    panelForScript.setBackground(Color.LIGHT_GRAY);
//    panelForScript.setBounds(10, 120, 800, 300);
    panelForScript.setBounds(10, 120, 675, 300);
    panelForScript.setLayout(new BorderLayout());
    panelForScript.setOpaque(false);
    panelForScript.setBackground(new Color(0, 0, 0, 120));

    textAreaForScript.setEditable(false);
    textAreaForScript.setLineWrap(true);
    textAreaForScript.setWrapStyleWord(true);
    textAreaForScript.setFont(new Font("Bold", Font.BOLD, 16));
    textAreaForScript.setForeground(Color.white);
    textAreaForScript.setOpaque(false);
    panelForScript.add(textAreaForScript);
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.add(panelForScript);
  }
  public JPanel getPanelForScript() {
    return panelForScript;
  }

  public void displayDialogue(String dialogue) {

    textAreaForScript.removeAll();
    textAreaForScript.revalidate();
    textAreaForScript.repaint();
    textAreaForScript.setText(dialogue);
  }
}
