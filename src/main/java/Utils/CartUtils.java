package Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.CartEntity;

public class CartUtils {
	public static List<CartEntity> getAllCart(Connection conn) throws SQLException {
		String sql = "select idCart,idAcount,Cart.idProduct,Quantity,Product.nameProduct,Product.price,Product.sale,Product.imgPro from Cart inner join Product on Cart.idProduct = Product.idProduct";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<CartEntity> list = new ArrayList<CartEntity>();
		while (rs.next()) {
			int idCart = rs.getInt("idCart");
			int idAcount = rs.getInt("idAcount");
			int idProduct= rs.getInt("idProduct");
			int Quantity = rs.getInt("Quantity");
			String Productname= rs.getString("nameProduct");
			float price= rs.getFloat("price");
			int sale= rs.getInt("sale");
			String img = rs.getString("imgPro");
			CartEntity cart = new CartEntity();
			cart.setIdCart(idCart);
			cart.setIdAcount(idAcount);
			cart.setIdProduct(idProduct);
			cart.setName(Productname);
			cart.setQuantity(Quantity);
			cart.setPrice(price);
			cart.setSale(sale);
			cart.setImgProduct(img);
			list.add(cart);
		}
		return list;
	}
	public static List<CartEntity> getAllCartInAccount(Connection conn,int id) throws SQLException {
		String sql = "select id_Cart,id_Account,Cart.id_Product,quantitty,Product.nameProduct,Product.price,Product.sale,Product.imgPro from Cart inner join Product on Cart.id_Product = Product.id_product where Cart.id_Account=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1,id );
		ResultSet rs = pstm.executeQuery();
		List<CartEntity> list = new ArrayList<CartEntity>();
		while (rs.next()) {
			int idCart = rs.getInt("id_Cart");
			int idAcount = rs.getInt("id_Account");
			int idProduct= rs.getInt("id_Product");
			int Quantity = rs.getInt("quantitty");
			String Productname= rs.getString("nameProduct");
			float price= rs.getFloat("price");
			int sale= rs.getInt("sale");
			String img = rs.getString("imgPro");
			CartEntity cart = new CartEntity();
			cart.setIdCart(idCart);
			cart.setIdAcount(idAcount);
			cart.setIdProduct(idProduct);
			cart.setName(Productname);
			cart.setQuantity(Quantity);
			cart.setPrice(price);
			cart.setSale(sale);
			cart.setImgProduct(img);
			list.add(cart);
		}
		return list;
	}
	public static void deleteCart(Connection conn, String id) throws SQLException {
		String sql = "delete from Cart where id_Cart = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, id);
		pstm.executeUpdate();
	}
}
