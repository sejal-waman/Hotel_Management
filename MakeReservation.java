import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MakeReservation extends JFrame {

    private JTextField guestNameField, roomNumberField, checkInDateField, checkOutDateField;

    public MakeReservation() {
        setTitle("Make a Reservation");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel guestNameLabel = new JLabel("Guest Name:");
        JLabel roomNumberLabel = new JLabel("Room Number:");
        JLabel checkInDateLabel = new JLabel("Check-In Date (YYYY-MM-DD):");
        JLabel checkOutDateLabel = new JLabel("Check-Out Date (YYYY-MM-DD):");

        guestNameField = new JTextField();
        roomNumberField = new JTextField();
        checkInDateField = new JTextField();
        checkOutDateField = new JTextField();

        JButton submitButton = new JButton("Submit");

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String guestName = guestNameField.getText();
                String roomNumber = roomNumberField.getText();
                String checkInDate = checkInDateField.getText();
                String checkOutDate = checkOutDateField.getText();

                try 
				{
					  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management","root","root");
                      Statement statement = con.createStatement();
                      PreparedStatement preparedStatement = con.prepareStatement(
                             "INSERT INTO reservations (guest_name, room_id, check_in_date, check_out_date) " +
                             "VALUES (?, (SELECT id FROM rooms WHERE room_number = ?), ?, ?)");

                    preparedStatement.setString(1, guestName);
                    preparedStatement.setString(2, roomNumber);
                    preparedStatement.setString(3, checkInDate);
                    preparedStatement.setString(4, checkOutDate);

                    preparedStatement.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Reservation Successful!");

                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

        panel.add(guestNameLabel);
        panel.add(guestNameField);
        panel.add(roomNumberLabel);
        panel.add(roomNumberField);
        panel.add(checkInDateLabel);
        panel.add(checkInDateField);
        panel.add(checkOutDateLabel);
        panel.add(checkOutDateField);
        panel.add(submitButton);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MakeReservation();
    }
}