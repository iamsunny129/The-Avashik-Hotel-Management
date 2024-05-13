import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class AddRoom implements ActionListener {
    private JFrame frame;
    private JTextField titleField, room_noField, authorField, priceField, quantityField;

    public AddRoom() {
        frame = new JFrame("Add room");
        frame.setSize(600, 400);
        frame.setLayout(null);

        JLabel titleLabel = new JLabel("Add room");
        titleLabel.setBounds(250, 20, 100, 30);
        frame.add(titleLabel);

        JLabel titleLabel2 = new JLabel("Title:");
        titleLabel2.setBounds(50, 60, 100, 30);
        frame.add(titleLabel2);

        titleField = new JTextField();
        titleField.setBounds(150, 60, 200, 30);
        frame.add(titleField);

        JLabel room_noLabel = new JLabel("Room_No:");
        room_noLabel.setBounds(50, 100, 100, 30);
        frame.add(room_noLabel);

        room_noField = new JTextField();
        room_noField.setBounds(150, 100, 200, 30);
        frame.add(room_noField);

        JLabel authorLabel = new JLabel("Author:");
        authorLabel.setBounds(50, 140, 100, 30);
        frame.add(authorLabel);

        authorField = new JTextField();
        authorField.setBounds(150, 140, 200, 30);
        frame.add(authorField);

        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setBounds(50, 180, 100, 30);
        frame.add(priceLabel);

        priceField = new JTextField();
        priceField.setBounds(150, 180, 200, 30);
        frame.add(priceField);

        JLabel quantityLabel = new JLabel("Quantity:");
        quantityLabel.setBounds(50, 220, 100, 30);
        frame.add(quantityLabel);

        quantityField = new JTextField();
        quantityField.setBounds(150, 220, 200, 30);
        frame.add(quantityField);

        JButton addButton = new JButton("Add");
        addButton.setBounds(250, 280, 100, 30);
        addButton.addActionListener(this);
        frame.add(addButton);

        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(360, 280, 100, 30);
        clearButton.addActionListener(this);
        frame.add(clearButton);
		JButton backButton = new JButton("Back");
        backButton.setBounds(50, 300, 100, 30);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        frame.add(backButton);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button.getText().equals("Add")) {
                addroom();
            } else if (button.getText().equals("Clear")) {
                clearFields();
            }
        }
    }

    private void addroom() {
        String title = titleField.getText();
        String room_no = room_noField.getText();
        String author = authorField.getText();
        String priceStr = priceField.getText();
        String quantityStr = quantityField.getText();

        if (title.isEmpty() || room_no.isEmpty() || author.isEmpty() || priceStr.isEmpty() || quantityStr.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please fill all fields!");
            return;
        }

        try {
            double price = Double.parseDouble(priceStr);
            int quantity = Integer.parseInt(quantityStr);

            // Check if the room_no already exists in the file
            if (isroom_noExists(room_no)) {
                JOptionPane.showMessageDialog(frame, "room with the same room_no already exists!");
                clearFields(); // Clear all fields
                return;
            }

            room newroom = new room(title, room_no, author, price, quantity);

            FileWriter writer = new FileWriter("rooms.txt", true);
            writer.write(newroom.getTitle() + "," + newroom.getroom_no() + "," + newroom.getAuthorName() + "," + newroom.getUnitPrice() + "," + newroom.getQuantity() + "\n");
            writer.close();

            JOptionPane.showMessageDialog(frame, "room added successfully!");
            frame.dispose(); // Close the add room window
        } catch (NumberFormatException | IOException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid price or quantity format!");
        }
    }

    private void clearFields() {
        titleField.setText("");
        room_noField.setText("");
        authorField.setText("");
        priceField.setText("");
        quantityField.setText("");
    }

    private boolean isroom_noExists(String room_no) {
        try {
            File file = new File("rooms.txt");
            if (!file.exists()) {
                return false;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 1 && parts[1].equals(room_no)) {
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
}
