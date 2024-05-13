import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class AdminDashboard implements ActionListener {
    private JFrame frame;

    public AdminDashboard() {
        frame = new JFrame("Admin Dashboard");
        frame.setSize(600, 600);
        frame.setLayout(null);

        JLabel titleLabel = new JLabel("Admin Dashboard");
        titleLabel.setBounds(220, 20, 200, 30);
        frame.add(titleLabel);

        JButton manageUsersButton = new JButton("Manage Users");
        manageUsersButton.setBounds(50, 80, 200, 30);
        manageUsersButton.addActionListener(this);
        frame.add(manageUsersButton);

        JButton manageRoomsButton = new JButton("Manage Rooms");
        manageRoomsButton.setBounds(350, 80, 200, 30);
        manageRoomsButton.addActionListener(this);
        frame.add(manageRoomsButton);

        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(250, 150, 100, 30);
        logoutButton.addActionListener(this);
        frame.add(logoutButton);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button.getText().equals("Manage Users")) {
                frame.dispose(); // Close Admin Dashboard
				new ManageUsers();
            } else if (button.getText().equals("Manage Rooms")) {
                frame.dispose(); // Close Admin Dashboard
				new ManageRooms();
            } else if (button.getText().equals("Logout")) {
                frame.dispose();
                new Login();
            }
        }
    }
}