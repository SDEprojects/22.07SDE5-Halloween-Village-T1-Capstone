package com.halloween.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GuiScript {


  JPanel panelForScript = new JPanel();
  JLabel labelForScript = new JLabel("Script");
  public GuiScript() {
    panelForScript.setBackground(Color.LIGHT_GRAY);
    panelForScript.setBounds(10, 120, 800, 300);
    panelForScript.setLayout(new FlowLayout());
    panelForScript.add(labelForScript);
  }

  public JPanel getPanelForScript() {
    return panelForScript;
  }
}
