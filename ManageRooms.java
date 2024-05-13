import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ManageRooms implements ActionListener {
    private JFrame frame;

    public ManageRooms() {
        frame = new JFrame("Manage Rooms");
        frame.setSize(600, 600);
        frame.setLayout(null);

        JLabel titleLabel = new JLabel("Manage rooms");
        titleLabel.setBounds(220, 20, 200, 30);
        frame.add(titleLabel);

        JButton displayroomsButton = new JButton("Display Rooms");
        displayroomsButton.setBounds(50, 80, 200, 30);
        displayroomsButton.addActionListener(this);
        frame.add(displayroomsButton);

        JButton addroomButton = new JButton("Add Room");
        addroomButton.setBounds(50, 130, 200, 30);
        addroomButton.addActionListener(this);
        frame.add(addroomButton);

        JButton updateroomButton = new JButton("Update Room");
        updateroomButton.setBounds(350, 80, 200, 30);
        updateroomButton.addActionListener(this);
        frame.add(updateroomButton);

        JButton searchroomButton = new JButton("Search Room");
        searchroomButton.setBounds(350, 130, 200, 30);
        searchroomButton.addActionListener(this);
        frame.add(searchroomButton);

        JButton deleteroomButton = new JButton("Delete Room");
        deleteroomButton.setBounds(200, 180, 200, 30);
        deleteroomButton.addActionListener(this);
        frame.add(deleteroomButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(50, 180, 100, 30);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new AdminDashboard();
            }
        });
        frame.add(backButton);

        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(500, 20, 80, 30);
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Login();
            }
        });
        frame.add(logoutButton);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button.getText().equals("Display rooms")) {
                displayrooms();
            } else if (button.getText().equals("Add room")) {
                new Addroom();
            } else if (button.getText().equals("Update room")) {
                updateroom();
            } else if (button.getText().equals("Search room")) {
                searchroom();
            } else if (button.getText().equals("Delete room")) {
                deleteroom();
            }
        }
    }

    public void displayrooms() {
        try {
            File file = new File("rooms.txt");
            if (!file.exists()) {
                JOptionPane.showMessageDialog(frame, "No rooms available!");
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            StringBuilder roomsInfo = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String roomInfo = String.format("Title: %s, ISBN: %s, Author: %s, Price: $%.2f, Quantity: %s\n", parts[0], parts[1], parts[2], Double.parseDouble(parts[3]), parts[4]);
                roomsInfo.append(roomInfo);
            }
            reader.close();

            JTextArea textArea = new JTextArea(roomsInfo.toString());
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(400, 300));
            JOptionPane.showMessageDialog(frame, scrollPane, "Available rooms", JOptionPane.PLAIN_MESSAGE);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void updateroom() {
        String ISBN = JOptionPane.showInputDialog(frame, "Enter ISBN of the room to update:");
        if (ISBN == null || ISBN.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "ISBN cannot be empty!");
            return;
        }
		frame.dispose();
		new Updateroom(ISBN, new Managerooms());
       /* String[] lines = new String[100]; // Assuming a maximum of 100 lines/rooms
        int count = 0;

        try {
            File file = new File("rooms.txt");
            if (!file.exists()) {
                JOptionPane.showMessageDialog(frame, "No rooms available!");
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[1].equals(ISBN)) {
                    String title = JOptionPane.showInputDialog(frame, "Enter new title:");
                    String author = JOptionPane.showInputDialog(frame, "Enter new author:");
                    double price = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter new unit price:"));
                    int quantity = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter new quantity:"));
                    line = String.join(",", title, ISBN, author, Double.toString(price), Integer.toString(quantity));
                }
                lines[count++] = line;
            }
            reader.close();

            FileWriter writer = new FileWriter(file);
            for (int i = 0; i < count; i++) {
                writer.write(lines[i] + "\n");
            }
            writer.close();

            JOptionPane.showMessageDialog(frame, "room information updated successfully!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }*/
    }

    private void searchroom() {
        String ISBN = JOptionPane.showInputDialog(frame, "Enter ISBN of the room to search:");
        if (ISBN == null || ISBN.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "ISBN cannot be empty!");
            return;
        }

        try {
            File file = new File("rooms.txt");
            if (!file.exists()) {
                JOptionPane.showMessageDialog(frame, "No rooms available!");
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            StringBuilder roomInfo = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[1].equals(ISBN)) {
                    roomInfo.append(String.format("Title: %s, ISBN: %s, Author: %s, Price: $%.2f, Quantity: %s\n", parts[0], parts[1], parts[2], Double.parseDouble(parts[3]), parts[4]));
                    break;
                }
            }
            reader.close();

            if (roomInfo.length() > 0) {
                JOptionPane.showMessageDialog(frame, roomInfo.toString(), "room Details", JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "room not found!");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void deleteroom() {
        String ISBN = JOptionPane.showInputDialog(frame, "Enter ISBN of the room to delete:");
        if (ISBN == null || ISBN.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "ISBN cannot be empty!");
            return;
        }

        String[] lines = new String[100]; // Assuming a maximum of 100 lines/rooms
        int count = 0;

        try {
            File file = new File("rooms.txt");
            if (!file.exists()) {
                JOptionPane.showMessageDialog(frame, "No rooms available!");
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (!parts[1].equals(ISBN)) {
                    lines[count++] = line;
                }
            }
            reader.close();

            FileWriter writer = new FileWriter(file);
            for (int i = 0; i < count; i++) {
                writer.write(lines[i] + "\n");
            }
            writer.close();

            JOptionPane.showMessageDialog(frame, "room deleted successfully!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
