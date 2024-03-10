package dovantrung_2110900043.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUltis {
	public static Connection getMSSQLConnection() 
			throws SQLException,
			ClassNotFoundException {
				
				String hostName = "localhost";
				String dbName = "DoVanTrung_2110900043_BookStore";
				String UserName = "sa";
				String Password = "1234$";
				String sqlInstanceName  ="";
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				String connectionURL = "jdbc:sqlserver://" + hostName + ":1433;instance=" + sqlInstanceName + ";databaseName="
						+ dbName + ";encrypt=true;trustServerCertificate=true";
				Connection conn = DriverManager.getConnection(connectionURL, UserName, Password);
				
				return conn;
			}
	
	
	public static void closeQuietly(Connection conn) {
		try {
			conn.close();
		}catch(Exception e) {
		}
	};
	
	public static void rollbackQuietly(Connection conn) {
		try {
			conn.rollback();
		}catch(Exception e) {
			
		}
	}
	
}