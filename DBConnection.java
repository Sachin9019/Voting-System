package sachin_voting_swing;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	    public static Connection getConnection() throws Exception {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        return DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/voting_db_gui",
	                "root",
	                "Yashwanth@2005"
	        );
	    }
	}

