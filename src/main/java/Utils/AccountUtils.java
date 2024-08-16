package Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.AccountEntity;




public class AccountUtils {
	public static List<AccountEntity> getAllAccount(Connection conn) throws SQLException {
		String sql = "SELECT id_Account , firstName , lastName,userName,password,ImgUser ,role_id FROM Account";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<AccountEntity> list = new ArrayList<AccountEntity>();
		while (rs.next()) {
			int id_Account = rs.getInt("id_Account");
			String firstName = rs.getString("firstName");
			String lastName= rs.getString("lastName");
			String userName= rs.getString("userName");
			String password= rs.getString("password");
			String imgUser= rs.getString("ImgUser");
			String role_id = rs.getString("role_id");
			AccountEntity acc = new AccountEntity();
			acc.setId_Account(id_Account);
			acc.setFirstName(firstName);
			acc.setLastName(lastName);
			acc.setUserName(userName);
			acc.setPassword(password);
			acc.setImgUser(imgUser);
			acc.setRole_id(role_id);
			list.add(acc);
		}
		return list;
	}
	public static void addAcc(Connection conn, AccountEntity Acc) throws SQLException {
	    String sql = "INSERT INTO Account ( firstName, lastName, userName,password,ImgUser,role_id) VALUES (?, ?, ?, ?, ?, ?)";
	    try (PreparedStatement pstm = conn.prepareStatement(sql)) {
	        pstm.setString(1, Acc.getFirstName());
	        pstm.setString(2, Acc.getLastName());
	        pstm.setString(3, Acc.getUserName());
	        pstm.setString(4, Acc.getPassword());
	        pstm.setString(5, Acc.getImgUser());
	        pstm.setString(6, Acc.getRole_id());
	        pstm.executeUpdate();
	        
	    }
	    
	}
	public static AccountEntity findAccount(Connection conn, int id) throws SQLException {
	    String sql = "SELECT id_Account , firstName , lastName,userName,password,ImgUser ,role_id FROM Account Where id_Account =? ";
	    	PreparedStatement pstm = conn.prepareStatement(sql);
	        pstm.setInt(1, id);
	        ResultSet rs = pstm.executeQuery();
	        while (rs.next()) {
				int id_Account = rs.getInt("id_Account");
				String firstName = rs.getString("firstName");
				String lastName= rs.getString("lastName");
				String userName= rs.getString("userName");
				String password= rs.getString("password");
				String ImgUser= rs.getString("ImgUser");
				String role_id = rs.getString("role_id");
				AccountEntity acc = new AccountEntity(id_Account,firstName,lastName,userName,password,ImgUser,role_id);
				return acc;
				
			}
	        return null;
	    
	}
	public static void uppdateAcc(Connection conn, AccountEntity Acc) throws SQLException {
	    String sql = "update Account set  firstName =?, lastName =?, userName =?,password=?,ImgUser=?,role_id=? where id_Account = ? ";
	    try (PreparedStatement pstm = conn.prepareStatement(sql)) {
	        pstm.setString(1, Acc.getFirstName());
	        pstm.setString(2, Acc.getLastName());
	        pstm.setString(3, Acc.getUserName());
	        pstm.setString(4, Acc.getPassword());
	        pstm.setString(5, Acc.getImgUser());
	        pstm.setString(6, Acc.getRole_id());
	        pstm.setInt(7,Acc.getId_Account());
	        pstm.executeUpdate();	        
	    }
	    
	}
	public static void deleteAccount(Connection conn, String id) throws SQLException {
		String sql = "delete from Account where id_Account = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, id);
		pstm.executeUpdate();
	}
}
