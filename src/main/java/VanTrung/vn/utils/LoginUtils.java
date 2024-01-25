package VanTrung.vn.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import VanTrung.vn.beans.UserAcount;

public class LoginUtils {
	public static UserAcount findAcount (Connection conn,String userName,String password) throws SQLException{
		String sql = "Select USER_NAME, PASSWORD , GENDER from user_acc + Where USER_NAME = ? and PASSWORD=?";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);
		pstm.setString(2,password);
		ResultSet rs = pstm.executeQuery(); // thực hiện truy vấn 
		if(rs.next()) { // nếu rs có giá trị
			String gender = rs.getString("GENDER");
			UserAcount user = new UserAcount(); // gọi Model UserAount;
			user.setUserName(userName);
			user.setGENDER(gender);
			user.setPassword(password);
			return user;
		}
		
		return null;
	}
	public static UserAcount confirmPasword (Connection conn, String userName) throws SQLException{
		String sql = "Select USER_NAME, PASSWORD , GENDER from user_acc + Where USER_NAME = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);
		ResultSet rs = pstm.executeQuery(); // thực hiện truy vấn 
		if(rs.next()) { // nếu rs có giá trị
			String gender = rs.getString("GENDER");
			String password = rs.getString("PASSWORD");
			UserAcount user = new UserAcount(); // gọi Model UserAount;
			user.setUserName(userName);
			user.setPassword(password);
			user.setGENDER(gender);
			return user;
		}
		
		return null;
	}
}
