

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

 class Profile implements ActionListener {

  private JButton logoutButton;
  private JButton backButton;
  private JButton exitButton;
  private JFrame frame;
  private User user;

  public Profile() {
	 
	  

    frame = new JFrame("Login");
    frame.setSize(1200, 600);
    frame.setLayout(null);
	 frame.setVisible(true);
	 frame.getContentPane().setBackground(new Color(105,105,105));
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setLocationRelativeTo(null);







    JPanel panel = new JPanel();
    panel.setBackground(Color.DARK_GRAY);
    panel.setBounds(533, 153, 322, 224);
    frame.add(panel);
    panel.setLayout(null);

    JLabel name = new JLabel("Name : "/*+ user.getName()*/);
    name.setBounds(10, 26, 300, 50);
    panel.add(name);
    name.setForeground(new Color(142, 224, 240));
    name.setFont(new Font("Times New Roman", Font.PLAIN, 22));

    JLabel email = new JLabel("Email : "/* +user.getEmail()*/ );
    email.setBounds(10, 86, 300, 50);
    panel.add(email);
    email.setForeground(new Color(142, 224, 240));
    email.setFont(new Font("Times New Roman", Font.PLAIN, 22));

    
    exitButton = new JButton("Exit");
    exitButton.setFont(new Font("Tahoma", Font.BOLD, 10));
    exitButton.setBounds(809, 486, 70, 21);
    exitButton.setFocusable(false);
    frame.add(exitButton);

    backButton = new JButton("Back");
    backButton.setFont(new Font("Tahoma", Font.BOLD, 10));
    backButton.setBounds(10, 486, 70, 21);
    backButton.setFocusable(false);
    frame.add(backButton);

    logoutButton = new JButton("logout");
    logoutButton.setBounds(809, 10, 70, 21);
    logoutButton.setFont(new Font("Tahoma", Font.BOLD, 10));
    logoutButton.setFocusable(false);
    frame.add(logoutButton);

    JPanel panel_1 = new JPanel();
    panel_1.setBackground(new Color(140, 140, 140));
    panel_1.setBounds(0, 0, 200, 517);
    frame.add(panel_1);

    logoutButton.addActionListener(this);
    backButton.addActionListener(this);
    exitButton.addActionListener(this);

  }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Exit")) {
            System.exit(0);	
		}
		
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button.getText().equals("Logout")) {
                frame.dispose();
                new Login();
			}//else if (button.getText().equals("Back")) {
             //  frame.dispose();
             // new Dashboard();
             // }
        }
    }   
}
