package dovantrung.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
public class UpdateData {
	public static void main(String[] arsg)
		throws ClassNotFoundException, SQLException
	{
		// Connect
		Connection connection = ConnectionUtils.getMySQLConnection();
		
		//Query
		String sql = "UPDATE product"
				+ " SET ProName = ?,"
				+ " ProQty = ?," // pstm.setInt(2,150);
				+ " ProPrice =? "
				+ " WHERE ProID = ? ";
		PreparedStatement pstm= connection.prepareStatement(sql);
		
				// gán giá trị cho các biến tham số
		
				pstm.setString(1,"Tung AN lz");
				pstm.setInt(2, 150);
				pstm.setFloat(3, 2500);
				pstm.setInt(4, 2);
				
				// Thực thi câu lệnh truy vấn
				
				int rowCount = pstm.executeUpdate();
				System.out.println("Đã cập nhật bản ghi: " + rowCount);
	}
}
