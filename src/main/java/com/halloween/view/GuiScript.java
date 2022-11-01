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
//  Game game = new Game();
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


  public void greetPlayer(){
    textAreaForScript.append(view.getImportantDisplay("backstory"));
//        textAreaForScript.append(view.getImportantDisplay("title"));
//    textAreaForScript.append(view.getImportantDisplay("instruction"));
//    textAreaForScript.append(view.getNpcResponse("welcome"));
//    textAreaForScript.append(view.getImportantDisplay("help"));
  }



  public void printScript(String key){

    Consumer<String> print = x -> textAreaForScript.append(x);

    print.accept(view.getImportantDisplay("backstory"));

//    textAreaForScript = GuiScript.staticT

//    textAreaForScript.append(view.getImportantDisplay("backstory"));
//        textAreaForScript.append(view.getImportantDisplay("title"));
//    textAreaForScript.append(view.getImportantDisplay("instruction"));
//    textAreaForScript.append(view.getNpcResponse("welcome"));

  }
  public void displayKnock(String dialogue){
//    GuiScript gui = new GuiScript();
    System.out.println(dialogue + " from line 38 in guiscript");

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
