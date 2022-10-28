package com.halloween.view;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

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
  JButton newGameBtn;
  JPanel panelForStartWindow;

  public JPanel getPanelForStartWindow() {
    return panelForStartWindow;
  }

  public StartGameGUI() {

    // New Game Button
    newGameBtn = new JButton("New Game");
    newGameBtn.setFont(new Font("Arial", Font.PLAIN, 40));
    newGameBtn.setBounds(175, 60, 250, 50);

    // Quit Button
    JButton quitBtn = new JButton("Quit");
    quitBtn.setFont(new Font("Arial", Font.PLAIN, 40));
    quitBtn.setBounds(175, 60, 250, 50);
    quitBtn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });

    JMenuBar menu = new JMenuBar();
    menu.setPreferredSize(new Dimension(1200, 400));

    JPanel redPanel = new JPanel();
    redPanel.setBackground(Color.red);
    redPanel.setBounds(0, 0, 1000, 600);

    JPanel bluePanel = new JPanel();
    bluePanel.setBackground(Color.blue);
//    bluePanel.setBounds(0, 600, 1200, 200);
    bluePanel.setBounds(0, 600, 500, 200);
//    bluePanel.setLayout(new BorderLayout());
    bluePanel.setLayout(null);
    bluePanel.add(newGameBtn);


    JPanel greenPanel = new JPanel();
    greenPanel.setBackground(Color.green);
    greenPanel.setBounds(500, 600, 500, 200);
    greenPanel.setLayout(null);
    greenPanel.add(quitBtn);

    panelForStartWindow = new JPanel();
    panelForStartWindow.setLayout(null);
    panelForStartWindow.setBounds(0, 0, 1000, 800);
    panelForStartWindow.add(redPanel);
    panelForStartWindow.add(bluePanel);
    panelForStartWindow.add(greenPanel);
    panelForStartWindow.add(menu);

//    JFrame frame = new JFrame();
//    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    frame.setLayout(null);
//    frame.setSize(1000, 800);
//    frame.setResizable(false);
//    frame.setTitle("Halloween Village");
//    frame.add(panelForStartWindow);

//    frame.add(redPanel);
//    frame.add(bluePanel);
//    frame.add(greenPanel);
//    frame.add(menu);
//    frame.add(titleLabel);
//    System.out.println(frame.getSize());
//
//    // set window icon
//    URL iconLocation = StartGameGUI.class.getClassLoader().getResource("pumpkinIcon1.png");
//    ImageIcon img = new ImageIcon(iconLocation);
//    frame.setIconImage(img.getImage());
//    frame.setVisible(true);

  }

  public static void main(String[] args) {
    new StartGameGUI();

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
