package com.halloween.view;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class HelpGui {
  View view = new View();
  JDialog helpDialog = new JDialog();
  JTextArea helpText;
  public HelpGui() {
    displayHelpMessage();
  }
  public void setVisibleHelpMenu(){
    helpDialog.setVisible(true);
  }

  private void displayHelpMessage() {
    helpDialog = new JDialog(new JFrame(), true);
    helpDialog.setTitle("Help");
    helpDialog.setBounds(50, 50, 800, 600);


    JPanel helpPanel = new JPanel(new GridLayout(1, 0));

    helpText = new JTextArea();
    helpText.setText(view.getImportantDisplay("help"));
    helpText.setEditable(false);

    helpText.setFont(new Font("Bold", Font.ITALIC, 18));
    helpText.setLineWrap(true);
    helpText.setWrapStyleWord(true);
    helpPanel.add(helpText);
    helpDialog.add(helpPanel);

  }

}
