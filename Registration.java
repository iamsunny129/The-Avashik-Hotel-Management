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
import javax.swing.ImageIcon;
class Registration implements ActionListener {
    private JFrame frame;
    private JTextField nameField, emailField;
    private JPasswordField passwordField;
	private JPasswordField confirmPassField;
	private JButton exitButton;
	private JToggleButton EyeBtn;
	private ImageIcon on;
    private ImageIcon off;

    private JComboBox<String> genderBox;

    public Registration() {
        frame = new JFrame("Registration");
        frame.setSize(1200, 600);  
		JPanel contentPane = new JPanel();
        frame.setForeground(Color.LIGHT_GRAY);
        frame.setBackground(Color.DARK_GRAY);
        frame.setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 50, 100, 30);
        frame.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 50, 200, 30);
        frame.add(nameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 100, 100, 30);
        frame.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(150, 100, 200, 30);
        frame.add(emailField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 150, 100, 30);
        frame.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 150, 200, 30);
        frame.add(passwordField);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(50, 200, 100, 30);
        frame.add(genderLabel);

        String[] genders = {"Male", "Female", "Other"};
        genderBox = new JComboBox<>(genders);
        genderBox.setBounds(150, 200, 200, 30);
        frame.add(genderBox);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(110, 250, 100, 30);
        registerButton.addActionListener(this);
        frame.add(registerButton);

        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(250, 250, 100, 30);
        clearButton.addActionListener(this);
        frame.add(clearButton);

        JLabel loginLabel = new JLabel("Already Registered? Login");
        loginLabel.setForeground(Color.BLUE);
        loginLabel.setBounds(200, 300, 200, 30);
        loginLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new Login();
            }
        });
        frame.add(loginLabel);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button.getText().equals("Register")) {
                register();
            } else if (button.getText().equals("Clear")) {
                clearFields();
            }
        }
    }

    private void register() {
        String name = nameField.getText();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        String gender = (String) genderBox.getSelectedItem();

        // Check for empty fields
        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please fill all fields!");
            return;
        }

        // Check for existing email
        if (isEmailExists(email)) {
            JOptionPane.showMessageDialog(frame, "User with this email already exists!");
            return;
        }

        User newUser = new User(name, email, password, gender);

        try {
            FileWriter writer = new FileWriter("userdata.txt", true);
            writer.write(newUser.getName() + "," + newUser.getEmail() + "," + newUser.getPassword() + "," + newUser.getGender() + "\n");
            writer.close();
            JOptionPane.showMessageDialog(frame, "Registration Successful!");
            frame.dispose();
            new Login();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private boolean isEmailExists(String email) {
        try {
            File file = new File("userdata.txt");
            if (!file.exists()) {
                return false;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[1].equals(email)) {
                    reader.close();
                    return true;
                }
            }
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private void clearFields() {
        nameField.setText("");
        emailField.setText("");
        passwordField.setText("");
        genderBox.setSelectedIndex(0);
    }
	
}
