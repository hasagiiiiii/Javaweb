package dovantrung.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData {
	public static void main(String[] args)
		throws ClassNotFoundException ,SQLException
	{
		// Tao Ket Noi
		Connection connection =  ConnectionUtils.getMySQLConnection();
		
		Statement state = connection.createStatement();
		// Tao truy van them
		String sql = "INSERT INTO product(ProID,ProName,ProQty,ProPrice) "; 
		sql += "VALUES(2,'HP Pavilion dv6609wm - BTO',120,2200)";
		
		int rowCount = state.executeUpdate(sql);
		System.out.println("Da them 1 ban ghi" + rowCount);
	}

}
