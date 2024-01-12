package dovantrung.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {

	public static void main(String[] args) 
	throws ClassNotFoundException,
	SQLException{
		System.out.print("Get connection ...");
		
		//Lấy ra đối tượng COnnection kết nối vào database.
		Connection conn = (Connection) ConnectionUtils.getMySQLConnection();
		System.out.println("Get connection" + conn);
		
		System.out.println("Done");
	
	}

}
