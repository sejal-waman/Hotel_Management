import java.sql.*;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import java.awt.*;

public class ViewRooms {

    public static void displayRooms() {
        JFrame frame = new JFrame("Available Rooms");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        try 
		{
			 
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management","root","root");
             Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM rooms WHERE status = 'Available'"); 

            while (resultSet.next()) 
			{
                textArea.append("Room Number: " + resultSet.getString("room_number") + "\n");
                textArea.append("Room Type: " + resultSet.getString("room_type") + "\n");
                textArea.append("Price: $" + resultSet.getDouble("price") + "\n");
                textArea.append("Status: " + resultSet.getString("status") + "\n");
                textArea.append("------------------------------\n");
            }

        } 
		catch (Exception e) 
		{
            e.printStackTrace();
        }

        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        frame.add(panel);
        frame.setVisible(true);
    }
}