import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Font;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.border.*;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;


import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

class Dashboard implements ActionListener {
    private JFrame frame;
    private User user;
	 

    public Dashboard(User user) {
        this.user = user;

        frame = new JFrame("Dashboard");
        frame.setSize(1200, 600);
        frame.setLayout(null);

        JLabel welcomeLabel = new JLabel("Welcome to Avashik Hotel , " + user.getName() + "!");
        welcomeLabel.setBounds(200, 11, 1000, 78);
		welcomeLabel.setFont(new Font("Lucida Handwriting", Font.PLAIN, 35));
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setForeground(Color.GRAY);
        frame.add(welcomeLabel);
		

	
	    JButton checkInButton = new JButton("Check In");
        checkInButton.setBounds(109, 162, 170, 170);
        checkInButton.addActionListener(this);
        frame.add(checkInButton);
		
		JButton profileButton = new JButton("Profile");
        profileButton.setBounds(408, 162, 170, 170);
        profileButton.addActionListener(this);
        frame.add(profileButton);
		
		JButton checkOutButton = new JButton("Check Out");
        checkOutButton.setBounds(695, 162, 170, 170);
        checkOutButton.addActionListener(this);
        frame.add(checkOutButton);


        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(1000, 440, 85, 31);
        logoutButton.addActionListener(this);
        frame.add(logoutButton);
		
		
		JButton exitButton = new JButton("Exit");
        exitButton.setBounds(100, 440, 70, 21);
	    exitButton.addActionListener(this);
        exitButton.setFocusable(false);
		frame.add(exitButton);
		

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
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
			}else if (button.getText().equals("Profile")) {
                frame.dispose();
                new Profile();
             }else if (button.getText().equals("Check IN")) {
                frame.dispose();
                new UCheckIn();
             }
			 
        }
    }   
}
