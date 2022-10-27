package com.halloween.view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class StartGameGUI {
//  private static JFrame frame;
//  private static JPanel panel;
//  private static JPanel redPanel;
//  private static JPanel bluePanel;
//
//  private static JLabel userLabel;
//  private static JLabel passwordLabel;
//  private static JLabel successfulLogin;
//  private static JLabel titleLabel;
//
//  private static JTextField userText;
//  private static JPasswordField passwordText;
//  private static JButton button;

  public static void main(String[] args) {
    // New Game Button
    JButton newGameBtn = new JButton("New Game");
    newGameBtn.setFont(new Font("Arial", Font.PLAIN, 40));
    newGameBtn.setBounds(175, 60, 250, 50);

    // Quit Button
    JButton quitBtn = new JButton("Quit");
    quitBtn.setFont(new Font("Arial", Font.PLAIN, 40));
    quitBtn.setBounds(175, 60, 250, 50);

    JMenuBar menu = new JMenuBar();
    menu.setPreferredSize(new Dimension(1200, 400));

    JPanel redPanel = new JPanel();
    redPanel.setBackground(Color.red);
    redPanel.setBounds(0, 0, 1200, 600);

    JPanel bluePanel = new JPanel();
    bluePanel.setBackground(Color.blue);
//    bluePanel.setBounds(0, 600, 1200, 200);
    bluePanel.setBounds(0, 600, 600, 200);
//    bluePanel.setLayout(new BorderLayout());
    bluePanel.setLayout(null);

    JPanel greenPanel = new JPanel();
    greenPanel.setBackground(Color.green);
    greenPanel.setBounds(600, 600, 600, 200);
    greenPanel.setLayout(null);

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(null);
    frame.setSize(1200, 800);
//    frame.setResizable(false);
    frame.setTitle("Halloween Village");
    frame.setVisible(true);
    frame.add(redPanel);
    frame.add(bluePanel);
    frame.add(greenPanel);
    frame.add(menu);
//    frame.add(titleLabel);
    System.out.println(frame.getSize());

    bluePanel.add(newGameBtn);
    greenPanel.add(quitBtn);


    // set window icon
    URL iconLocation = StartGameGUI.class.getClassLoader().getResource("pumpkinIcon1.png");
    ImageIcon img = new ImageIcon(iconLocation);
    frame.setIconImage(img.getImage());






//
//  panel = new JPanel();
//  frame = new JFrame();
//
//  frame.setSize(1200, 800);
//  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//  frame.setTitle("Halloween Village");
//
//  // set background color
//  panel.setBackground(new Color (255,255,102));
//
//  // set Title
//  titleLabel = new JLabel("Halloween Village");
//  titleLabel.setBounds(100, 150, 500, 150);
//  panel.add(titleLabel);
//
//  // set window icon
//  URL iconLocation = StartGameGUI.class.getClassLoader().getResource("pumpkinIcon1.png");
//  ImageIcon img = new ImageIcon(iconLocation);
//  frame.setIconImage(img.getImage());
//
//  frame.add(panel);
//  panel.setLayout(null);
//  frame.setResizable(false);
//  frame.setVisible(true);
  }
}
