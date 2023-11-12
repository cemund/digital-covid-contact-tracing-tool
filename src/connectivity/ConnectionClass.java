package connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {
		public Connection connection;
		
		public Connection getConnection() throws SQLException {
			
			String dbName = "sample";
			String userName = "root";
			String password = "";
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				
				connection = DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,userName,password);
				
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			return connection;
		}
		
}
