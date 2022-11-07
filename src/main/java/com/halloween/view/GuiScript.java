package com.halloween.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GuiScript {
  JScrollPane scrollPane;


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
    panelForScript.setBounds(20, 125, 675, 310);
    panelForScript.setLayout(new BorderLayout());
    panelForScript.setOpaque(false);
    panelForScript.setBackground(new Color(0, 0, 0, 120));

    textAreaForScript.setEditable(false);
    textAreaForScript.setLineWrap(true);
    textAreaForScript.setWrapStyleWord(true);
    textAreaForScript.setFont(new Font("Bold", Font.BOLD, 16));
    textAreaForScript.setForeground(Color.white);
    textAreaForScript.setMargin(new Insets(20,20,20,20));
    textAreaForScript.setOpaque(false);

    scrollPane = new JScrollPane(textAreaForScript);
    scrollPane.getViewport().setOpaque(false);
    scrollPane.setBorder(BorderFactory.createEmptyBorder());
    scrollPane.setOpaque(false);
    scrollPane.setBackground(new Color(0, 0, 0, 120));

    panelForScript.add(scrollPane);
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
