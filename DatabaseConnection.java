import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection
 {
    public static void main(String args[]) throws SQLException
	{
		
		try
	  {
              Class.forName("com.mysql.cj.jdbc.Driver");
              Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management","root","root");
	
	    if(con!=null)
		{
			System.out.println("connection establish");
		}
		else
		{
			System.out.println("connection is not establish");
		}
	  }
	  
	   catch(ClassNotFoundException e)
	  {
	     System.out.println("JDBC Driver not found:");  
	  }
	  
	  catch(SQLException e)
	  {
		System.out.println("connection failed:");  
	  }
	}

}