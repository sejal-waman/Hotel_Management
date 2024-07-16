//Main GUI 


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelManagementApp extends JFrame {

    private JPanel panel;
    private JButton viewRoomsButton, makeReservationButton;

    public HotelManagementApp() {
        setTitle("Hotel Management System");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        viewRoomsButton = new JButton("View Rooms");
        makeReservationButton = new JButton("Make a Reservation");

          viewRoomsButton.addActionListener(new ActionListener() 
		  {
           public void actionPerformed(ActionEvent e) 
		   {
            ViewRooms.displayRooms();
           }
          });

              makeReservationButton.addActionListener(new ActionListener() 
			  {
                    public void actionPerformed(ActionEvent e) 
				   {
                    new MakeReservation();
                   }
              });

        panel.add(viewRoomsButton);
        panel.add(makeReservationButton);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new HotelManagementApp();
    }
}