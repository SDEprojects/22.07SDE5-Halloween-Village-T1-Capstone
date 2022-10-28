package com.halloween.view;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GuiTitle {

  JPanel panelForTitleWithImg;
  JLabel labelForTitle;

  public GuiTitle() {
    panelForTitleWithImg = new JPanel();
    panelForTitleWithImg.setBackground(Color.LIGHT_GRAY);
    panelForTitleWithImg.setBounds(7, 5, 970, 100);
    labelForTitle = new JLabel("Title");
    panelForTitleWithImg.add(labelForTitle);
  }

  public JPanel getPanelForTitleWithImg() {
    return panelForTitleWithImg;
  }

  public JLabel getLabelForTitle() {
    return labelForTitle;
  }
}
