package com.halloween.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.function.Consumer;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GuiScript {


  JPanel panelForScript = new JPanel();
  JLabel labelForScript = new JLabel("Script");
  JTextArea textAreaForScript = new JTextArea();
  JTextArea textAreaForHelp = new JTextArea();
  View view = new View();
  public GuiScript() {
    panelForScript.setBackground(Color.LIGHT_GRAY);
    panelForScript.setBounds(10, 120, 800, 300);
    panelForScript.setLayout(new FlowLayout());
    panelForScript.add(textAreaForScript);
    textAreaForScript.setWrapStyleWord(true);
  }

  public JPanel getPanelForScript() {
    return panelForScript;
  }





  }

  public void displayKnock(String dialogue){
//    GuiScript gui = new GuiScript();
    System.out.println(dialogue + " from line 38 in guiscript");
    textAreaForScript.removeAll();
    textAreaForScript.revalidate();
    textAreaForScript.repaint();
    textAreaForScript.setText(dialogue);
//    TextArea text = new TextArea();
////    textAreaForScript.update(textAreaForScript.getGraphics());
//    text.append(dialogue);
//    panelForScript.add(text);
//    textAreaForScript.setText("11");
//    textAreaForScript.selectAll();
//    textAreaForScript.replaceSelection(currentLocation);
  }






}
