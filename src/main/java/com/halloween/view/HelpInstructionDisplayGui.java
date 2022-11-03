package com.halloween.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class HelpInstructionDisplayGui {
  View view = new View();
  JDialog helpDialog;
  JTextArea helpText;
  public HelpInstructionDisplayGui() {
    helpDialog = new JDialog(new JFrame(), true);
    helpDialog.setBounds(50, 50, 800, 700);
    JPanel helpPanel = new JPanel(new GridLayout());
    helpText = new JTextArea();
    helpText.setEditable(false);
    helpText.setFont(new Font("Bold", Font.ITALIC, 18));
    helpText.setLineWrap(true);
    helpText.setWrapStyleWord(true);
    helpPanel.add(helpText, BorderLayout.CENTER);
    JScrollPane scrollPane1 = new JScrollPane(helpPanel);
    helpDialog.add(scrollPane1);
  }

  public void updateDialogBox(String dialogue) {
    System.out.println(dialogue + " from line 86 in GuiLOcationInventoryMove");
    helpText.removeAll();
    helpText.revalidate();
    helpText.setText(view.getImportantDisplay(dialogue));
    helpDialog.setVisible(true);

  }

}
