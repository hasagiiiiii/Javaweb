package Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.AccountEntity;
import Entity.OrderProductEntity;

public class OrderProductUtils {
	public static List<OrderProductEntity> getAllOrder(Connection conn) throws SQLException {
		String sql = "SELECT id_Order , id_Account , id_Product,quantity,Address,Zip  FROM OrderProduct";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<OrderProductEntity> list = new ArrayList<OrderProductEntity>();
		while (rs.next()) {
			int id_Order = rs.getInt("id_Order");
			int id_Account = rs.getInt("id_Account");
			int id_Product= rs.getInt("id_Product");
			int quantity= rs.getInt("quantity");
			String Address= rs.getString("Address");
			String Zip= rs.getString("Zip");
			OrderProductEntity order = new OrderProductEntity();
			order.setId_Account(id_Account);
			order.setId_Order(id_Order);
			order.setId_Product(id_Product);
			order.setQuantity(quantity);
			order.setAddress(Address);
			order.setZip(Zip);
			list.add(order);
		}
		return list;
	}
	public static void addOrder(Connection conn, OrderProductEntity order) throws SQLException {
	    String sql = "INSERT INTO OrderProduct ( id_Account , id_Product,quantity,Address,Zip) VALUES (?, ?, ?, ?, ?)";
	    try (PreparedStatement pstm = conn.prepareStatement(sql)) {
	        pstm.setInt(1, order.getId_Account());
	        pstm.setInt(2, order.getId_Product());
	        pstm.setInt(3, order.getQuantity());
	        pstm.setString(4, order.getAddress());
	        pstm.setString(5, order.getZip());
	        pstm.executeUpdate();
	        
	    }
	    
	}
}
