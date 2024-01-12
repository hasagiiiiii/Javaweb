package dovantrung.jdbc;

import java.sql.*;

public class QueryDataUltils {
	public static ResultSet getAll(String sql)
		throws SQLException,
ClassNotFoundException{
		// Lấy ra đối tượng Connection kết nối vào DB.
		Connection connection = (Connection) ConnectionUtils.getMySQLConnection();
		// Tạo đối tượng Statement.
		Statement statement = connection.createStatement();
		// Thực thi câu lệnh SQL trả vê dối tượng ResulSet.
		ResultSet rs = statement.executeQuery(sql);
		return rs;
	}
}
