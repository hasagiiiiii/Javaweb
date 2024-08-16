package Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.ProductEntity;

public class ProductUtils {
	public static List<ProductEntity> getAllProduct(Connection conn) throws SQLException {
		String sql = "SELECT id_product , nameProduct , startProduct,price,sale,description ,trademark,quantityPro,imgPro,colorPro FROM Product";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<ProductEntity> list = new ArrayList<ProductEntity>();
		while (rs.next()) {
			int id_product = rs.getInt("id_product");
			String nameProduct = rs.getString("nameProduct");
			int startProduct= rs.getInt("startProduct");
			float price= rs.getFloat("price");
			int sale= rs.getInt("sale");
			String description= rs.getString("description");
			String trademark = rs.getString("trademark");
			int quantityPro = rs.getInt("quantityPro");
			String imgPro = rs.getString("imgPro");
			String colorPro = rs.getString("colorPro");
			ProductEntity pro = new ProductEntity();
			pro.setId_product(id_product);
			pro.setNameProduct(nameProduct);
			pro.setStartProduct(startProduct);
			pro.setPrice(price);
			pro.setSale(sale);
			pro.setDescription(description);
			pro.setTrademark(trademark);
			pro.setQuantityPro(quantityPro);
			pro.setImgPro(imgPro);
			pro.setColorPro(colorPro);
			list.add(pro);
		}
		return list;
	}
	public static void addProduct(Connection conn, ProductEntity pro) throws SQLException {
	    String sql = "INSERT INTO Product (  nameProduct , startProduct,price,sale,description ,trademark,quantityPro,imgPro,colorPro) VALUES ( ?, ?, ?, ?, ?,?,?,?,?)";
	    try (PreparedStatement pstm = conn.prepareStatement(sql)) {
	        pstm.setString(1, pro.getNameProduct());
	        pstm.setInt(2, pro.getStartProduct());
	        pstm.setFloat(3, pro.getPrice());
	        pstm.setInt(4, pro.getSale());
	        pstm.setString(5, pro.getDescription());
	        pstm.setString(6, pro.getTrademark());
	        pstm.setInt(7, pro.getQuantityPro());
	        pstm.setString(8, pro.getImgPro());
	        pstm.setString(9, pro.getColorPro());
	        pstm.executeUpdate();
	        
	    }
	    
	}
//	Find Product
	public static ProductEntity findProduct(Connection conn, int id) throws SQLException {
	    String sql = "SELECT id_product , nameProduct , startProduct,price,sale,description ,trademark,quantityPro,imgPro,colorPro FROM Product Where id_product = ? ";
	    	PreparedStatement pstm = conn.prepareStatement(sql);
	        pstm.setInt(1, id);
	        ResultSet rs = pstm.executeQuery();
	        while (rs.next()) {
	        	int id_product = rs.getInt("id_product");
				String nameProduct = rs.getString("nameProduct");
				int startProduct= rs.getInt("startProduct");
				float price= rs.getFloat("price");
				int sale= rs.getInt("sale");
				String description= rs.getString("description");
				String trademark = rs.getString("trademark");
				int quantityPro = rs.getInt("quantityPro");
				String imgPro = rs.getString("imgPro");
				String colorPro = rs.getString("colorPro");
				ProductEntity pro = new ProductEntity(id_product, nameProduct, startProduct, price, sale, description, trademark, quantityPro, imgPro,colorPro);
				return pro;
				
			}
	        return null;
	    
	}
		//	Update Product
	public static void uppdateProduct(Connection conn, ProductEntity pro) throws SQLException {
	    String sql = "update Product set  nameProduct =?, startProduct =?, price =?,sale=?,description=?,trademark=?,quantityPro=?,imgPro=?,colorPro=? where id_Product = ? ";
	    try (PreparedStatement pstm = conn.prepareStatement(sql)) {
	    	pstm.setInt(10, pro.getId_product());
	        pstm.setString(1, pro.getNameProduct());
	        pstm.setInt(2, pro.getStartProduct());
	        pstm.setFloat(3, pro.getPrice());
	        pstm.setInt(4, pro.getSale());
	        pstm.setString(5, pro.getDescription());
	        pstm.setString(6, pro.getTrademark());
	        pstm.setInt(7, pro.getQuantityPro());
	        pstm.setString(8, pro.getImgPro());
	        pstm.setString(9, pro.getColorPro());
	        pstm.executeUpdate();	        
	    }
	    
	}
//	Delet Product
	public static void deleteProduct(Connection conn, String id) throws SQLException {
		String sql = "delete from Product where id_product = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, id);
		pstm.executeUpdate();
	}
}
