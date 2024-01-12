package dovantrung.jdbc;

import java.sql.*;

public class TestQuery {

	public static void main(String[] args)
		throws ClassNotFoundException,
		SQLException
	{
		// Read Data
		String sql ="Select * from Product";
		ResultSet rs = QueryDataUltils.getAll(sql);
		// Duyet tren ket qua tra ve
		while(rs.next()) {
			// Di chuyen con cho xuong ban ghi ke tiep
			int ProId = rs.getInt(1);
			String proName = rs.getString("ProName");
			int proQty = rs.getInt("ProQty");
			float proPrice = rs.getFloat("ProPrice");
			System.out.println("-------------------------------------");

			System.out.printf("%-5d",ProId);
			System.out.printf("%15s" ,proName);
			System.out.printf("%5d" ,proQty);
			System.out.printf("%10.2f" ,proPrice);
		}
		rs.close();
		

	}

}
