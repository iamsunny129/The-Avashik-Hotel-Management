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

class Login implements ActionListener {
	private User user;
    private JFrame frame;
    private JTextField emailField;
    private JPasswordField passwordField;
	private JButton exitButton;
	private JToggleButton EyeBtn;
	private ImageIcon on;
    private ImageIcon off;
	

    public Login() {
		
		
        frame = new JFrame("Login");
        frame.setSize(1200, 600);
        frame.setLayout(null);
		
		JLabel LoginLblTxt = new JLabel("The Avashik Hotel");
        LoginLblTxt.setForeground(Color.LIGHT_GRAY);
        LoginLblTxt.setFont(new Font("Modern No. 20", Font.PLAIN, 54));
        LoginLblTxt.setBounds(72, 42, 604, 44);
        frame.add(LoginLblTxt);
		
        JLabel LoginTxt = new JLabel("LOGIN");
        LoginTxt.setForeground(new Color(215, 210, 203));
        LoginTxt.setFont(new Font("Verdana", Font.BOLD, 22));
        LoginTxt.setBounds(677, 79, 83, 30);
        frame.add(LoginTxt);


        JLabel emailLabel = new JLabel("Email:");
		emailLabel.setBounds(603, 141, 94, 30);
		emailLabel.setForeground(new Color(215, 210, 203));
		emailLabel.setFont(new Font("Verdana", Font.BOLD, 22));
        frame.add(emailLabel);
		
		emailField = new JTextField();
        emailField.setOpaque(false);
        emailField.setForeground(new Color(219, 226, 233));
        emailField.setFont(new Font("Times New Roman", Font.BOLD, 17));
        emailField.setBounds(603, 181, 205, 30);
        emailField.setBorder(BorderFactory.createEmptyBorder());
        Border userBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(128, 128, 128));
        emailField.setBorder(userBorder);
        frame.add(emailField);


        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setForeground(new Color(215, 210, 203));
        passwordLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        passwordLabel.setBounds(603, 223, 94, 30);
        frame.add(passwordLabel);


        passwordField = new JPasswordField();
        passwordField.setOpaque(false);
        passwordField.setForeground(new Color(219, 226, 233));
        passwordField.setFont(new Font("Verdana", Font.BOLD, 17));
        passwordField.setEchoChar('*');
        passwordField.setBorder(BorderFactory.createEmptyBorder());
        Border passBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(128, 128, 128));
        passwordField.setBorder(passBorder);
        passwordField.setBounds(603, 276, 205, 30);
        frame.add(passwordField);
		
        
        

        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		loginButton.setBounds(653, 345, 153, 40);
		loginButton.setFocusable(false);
        loginButton.addActionListener(this);
        frame.add(loginButton);
		


        JButton registerButton = new JButton("Register");
        registerButton.setBounds(637, 410, 189, 30);
		registerButton.setForeground(new Color(220, 20, 60));
		registerButton.setBorder(BorderFactory.createEmptyBorder());  
	    registerButton.setFont(new Font("Calibri", Font.BOLD, 14));
		registerButton.setBackground(Color.DARK_GRAY);
		registerButton.setFocusable(false);
        registerButton.addActionListener(this);
        frame.add(registerButton);
		
		
		
		
		/* JLabel imageLabel = new JLabel();
        imageLabel.setBounds(50,400,500,500);
        ImageIcon image = new ImageIcon("image//loginBackround.png");
        Image reImage = image.getImage();
        Image newImage = reImage.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_FAST);
        ImageIcon scaledImage = new ImageIcon(newImage);
        imageLabel.setIcon(scaledImage);
		    frame.add(imageLabel);*/
		
		//frame.setLocationRelativeTo(null);
        
	
		
       	//JLabel imageLabel = new JLabel();	
        //imageLabel.setBounds(300,300,500,500);
        //ImageIcon image = new ImageIcon("image//loginBackround.png");
        //Image reImage = image.getImage();
        //Image newImage = reImage.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_FAST);
        //ImageIcon scaledImage = new ImageIcon(newImage);
        //imageLabel.setIcon(scaledImage);
		//frame.add(imageLabel);
               
               
        
            

        
		
        //BufferedImage imgOn = null;
            /* BufferedImage imgOff = null;
        try 
	    {
            // Read in the image files from resources
            imgOn = ImageIO.read(Objects.requireNonNull(Login.class.getResourceAsStream("/images/show.png")));
            imgOff = ImageIO.read(Objects.requireNonNull(Login.class.getResourceAsStream("/images/hide.png")));

        } catch (IOException e) 
		{
        Print the stack trace if an IOException occurs
            e.printStackTrace();
        }

        // Check that the images have been loaded successfully
        if (imgOn == null || imgOff == null) 
		{
            System.err.println("Error: One or both of the images could not be loaded.");
            System.exit(1);
        }

        // Scale the images and store them as Icons
        Image imgON = imgOn.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        Image imgOFF = imgOff.getScaledInstance(40, 40, Image.SCALE_SMOOTH);

        ImageIcon on = new ImageIcon(imgON);
        ImageIcon off = new ImageIcon(imgOFF);*/
		
    
		
		
		//EyeBtn = new JToggleButton();
        //EyeBtn.setOpaque(false);
        //EyeBtn.setForeground(Color.DARK_GRAY);
        //EyeBtn.setBackground(Color.DARK_GRAY);
        //EyeBtn.setBounds(818, 276, 44, 30);
        //EyeBtn.setFocusable(false);
        //frame.add(EyeBtn);
		
		
		exitButton = new JButton("Exit");
        exitButton.setBounds(809, 486, 70, 21);
	    exitButton.addActionListener(this);
        exitButton.setFocusable(false);
		frame.add(exitButton);
		//frame.getContentPane().setBackground(Color.BLACK);
	
        /*panel.setBackground(Color.MAGENTA); 
	    label.setOpaque(true); 
	    frame.pack(); 
	    ImageIcon image = new ImageIcon("image//loginBackround.png");
	    JLabel imglabel = new JLabel(); //create a label
		imglabel.setText("bro, do you even code?"); //set text of label
		imglabel.setIcon(image);
		imglabel.setBounds(100, 100, 250, 250);
		frame.add(imglabel);*/

        frame.setVisible(true);
		frame.getContentPane().setBackground(new Color(105,105,105));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
		
		
        if (e.getActionCommand().equals("Exit")) {
            System.exit(0);
		}
		
		
		
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button.getText().equals("Login")) {
                login();
            } else if (button.getText().equals("Register")) {
                frame.dispose();
                new Registration();
            }
        }
		
    }

    private void login() {
		
		
		
		
		        String email = emailField.getText();
        String password = new String(passwordField.getPassword());

        // Check if admin login
        if (email.equals("admin") && password.equals("admin123")) {
            JOptionPane.showMessageDialog(frame, "Admin Login Successful!");
            frame.dispose();
            new AdminDashboard();
            return;
        }

        // Proceed with regular user login
        User user = authenticateUser(email, password);
        if (user != null) {
            JOptionPane.showMessageDialog(frame, "Login Successful!");
            frame.dispose();
            new Dashboard(user);
        } else {
            JOptionPane.showMessageDialog(frame, "Invalid email or password!");
        }
    }

    private User authenticateUser(String email, String password) {
        try {
            File file = new File("userdata.txt");
            if (!file.exists()) {
                JOptionPane.showMessageDialog(frame, "No user registered yet!");
                return null;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[1].equals(email) && parts[2].equals(password)) {
                    reader.close();
                    return new User(parts[0], parts[1], parts[2], parts[3]);
                }
            }
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
		
		
       /* String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        User user = null;

        try {
            File file = new File("userdata.txt");
            if (!file.exists()) {
                JOptionPane.showMessageDialog(frame, "No user registered yet!");
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            boolean loggedIn = false;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[1].equals(email) && parts[2].equals(password)) {
                    loggedIn = true;
                    user = new User(parts[0], parts[1], parts[2], parts[3]);
                    break;
                }
            }
            reader.close();

            if (loggedIn) {
                JOptionPane.showMessageDialog(frame, "Login Successful!");
                frame.dispose();
                new Dashboard(user);
			else if(userName.equals("admin")&&passWord.equals("admin"))
            {
                new PanelAdmin(userList,rentList);
            
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid email or password!");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }*/
}
