package com.halloween.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GuiScript {
  JPanel panelForScript = new JPanel();
  JTextArea textAreaForScript = new JTextArea();
  public GuiScript() {
    panelForScript.setBackground(Color.LIGHT_GRAY);
    panelForScript.setBounds(10, 120, 800, 300);
    panelForScript.setLayout(new BorderLayout());
    textAreaForScript.setEditable(false);
    textAreaForScript.setLineWrap(true);
    textAreaForScript.setWrapStyleWord(true);
    textAreaForScript.setFont(new Font("Bold", Font.ITALIC, 18));
    textAreaForScript.setForeground(Color.blue);
    panelForScript.add(textAreaForScript);
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.add(panelForScript);
  }
  public JPanel getPanelForScript() {
    return panelForScript;
  }
  public void displayKnock(String dialogue) {
    System.out.println(dialogue + " from line 38 in guiscript");
    textAreaForScript.removeAll();
    textAreaForScript.revalidate();
    textAreaForScript.repaint();
    textAreaForScript.setText(dialogue);
  }
  //  public void printScript(String key){
//    Consumer<String> print = x -> textAreaForScript.append(x);
//    print.accept(view.getImportantDisplay("backstory"));
//  }
}
