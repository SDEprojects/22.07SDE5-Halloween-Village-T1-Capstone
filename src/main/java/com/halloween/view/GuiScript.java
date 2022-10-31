package com.halloween.view;

import com.halloween.controller.Game;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GuiScript {


  JPanel panelForScript = new JPanel();
  JLabel labelForScript = new JLabel("Script");
  JTextArea textAreaForScript = new JTextArea();
  View view = new View();
  Game game = new Game();
  public GuiScript() {
    panelForScript.setBackground(Color.LIGHT_GRAY);
    panelForScript.setBounds(10, 120, 800, 300);
    panelForScript.setLayout(new FlowLayout());
    panelForScript.add(textAreaForScript);
  }

  public JPanel getPanelForScript() {
    return panelForScript;
  }

  public void greetPlayer(){
    textAreaForScript.append(view.getImportantDisplay("backstory"));
//        textAreaForScript.append(view.getImportantDisplay("title"));
//    textAreaForScript.append(view.getImportantDisplay("instruction"));
//    textAreaForScript.append(view.getNpcResponse("welcome"));

  }
  public void displayKnock(String currentLocation){
    textAreaForScript.append(view.noItem(currentLocation));
  }

}
