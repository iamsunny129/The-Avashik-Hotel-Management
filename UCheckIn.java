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
class UCheckIn implements ActionListener {
    private JFrame frame;
    private JTextField checkinField, checkoutField, personField;
	private JButton exitButton;
	private JToggleButton EyeBtn;
	private ImageIcon on;
    private ImageIcon off;


    public UCheckIn() {
        frame = new JFrame("Check In");
        frame.setSize(1200, 600);  
		JPanel contentPane = new JPanel();
        frame.setForeground(Color.LIGHT_GRAY);
        frame.setBackground(Color.DARK_GRAY);
        frame.setLayout(null);

        JLabel checkinLabel = new JLabel("Check In: ");
       checkinLabel.setBounds(50, 50, 100, 30);
        frame.add(checkinLabel);

       checkinField = new JTextField();
       checkinField.setBounds(150, 50, 200, 30);
        frame.add(checkinField);

        JLabel checkoutLabel = new JLabel("Checkout:");
        checkoutLabel.setBounds(50, 100, 100, 30);
        frame.add(checkoutLabel);

        checkoutField = new JTextField();
        checkoutField.setBounds(150, 100, 200, 30);
        frame.add(checkoutField);

        JLabel personLabel = new JLabel("Person:");
        personLabel.setBounds(50, 150, 100, 30);
        frame.add(personLabel);

        personField = new JTextField();
        personField.setBounds(150, 150, 200, 30);
        frame.add(personField);

        
        JButton registerButton = new JButton("Register");
        registerButton.setBounds(110, 250, 100, 30);
        registerButton.addActionListener(this);
        frame.add(registerButton);

        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(250, 250, 100, 30);
        clearButton.addActionListener(this);
        frame.add(clearButton);



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
        String checkin =checkinField.getText();
        String checkout = checkoutField.getText();
        String person = personField.getText();

        // Check for empty fields
        if (checkin.isEmpty() || checkout.isEmpty() || person.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please fill all fields!");
            return;
        }


        Check newCheck = new Check(checkin, checkout, person );

        try {
            FileWriter writer = new FileWriter("checkin.txt", true);
            writer.write(newCheck.getcheckin() + "," + newCheck.getcheckout() + "," + newCheck.getperson() +  "\n");
            writer.close();
            JOptionPane.showMessageDialog(frame, "Check In Successful!");
            frame.dispose();
            new Login();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private boolean ischeckoutExists(String checkout) {
        try {
            File file = new File("checkin.txt");
            if (!file.exists()) {
                return false;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[1].equals(checkout)) {
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
       checkinField.setText("");
        checkoutField.setText("");
        personField.setText("");
    }
	
}
