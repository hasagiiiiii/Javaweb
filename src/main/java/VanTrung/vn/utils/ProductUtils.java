package VanTrung.vn.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import VanTrung.vn.beans.Product;

public class ProductUtils {
	public static List<Product> queryProduct(Connection conn) throws SQLException {
		String sql = "SELECT CODE , NAME , PRICE FROM product";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<Product> list = new ArrayList<Product>();
		while (rs.next()) {
			String code = rs.getString("CODE");
			String name = rs.getString("NAME");
			Float price = rs.getFloat("PRICE");
			Product product = new Product();
			product.setCode(code);
			product.setName(name);
			product.setPrice(price);
			list.add(product);
		}
		return list;
	}

	// Search for CODE

	public static Product findProduct(Connection conn, String code) throws SQLException {
		String sql = "SELECT CODE , NAME , PRICE FROM product where CODE = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, code);
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			String name = rs.getString("NAME");
			float price = rs.getFloat("PRICE");
			Product product = new Product(code, name, price);
			return product;
		}
		return null;
	}

	// ADD NEW Product


	  public static void InsertProduct (Connection conn,Product product) throws SQLException{ 
		  String sql ="INSERT into Product(CODE,NAME,PRICE) values(?,?,?)"; 
		  PreparedStatement pstm= conn.prepareStatement(sql);
		  pstm.setString(1, product.getCode());
		  pstm.setString(2, product.getName());
		  pstm.setFloat(3, product.getPrice());
		  pstm.executeUpdate();
		  
	  }
	// UPDATE A PRODUCT
	  public static void updateProduct(Connection conn , Product product) throws SQLException {
		String sql = "Update Product set NAME = ?, PRICE = ?,WHERE CODE = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, product.getName());
		pstm.setFloat(2, product.getPrice());
		pstm.executeUpdate();
	}
	// DELETE A PRODUCT
	  public static void deleteProduct(Connection conn , String code) throws SQLException {
		String sql = "DELETE FROM product WHERE CODE = ? ";
		PreparedStatement pstm = conn .prepareStatement(sql);
		pstm.setString(1,code);
		pstm.executeUpdate();
	}
	  
	
}
