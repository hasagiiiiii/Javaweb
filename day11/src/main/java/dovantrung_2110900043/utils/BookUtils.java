package dovantrung_2110900043.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dovantrung_2110900043.beans.Book;

public class BookUtils {
	public static List<Book> queryBook(Connection conn) throws SQLException {
		String sql = "SELECT BookId , Title , Release,Price,Picture FROM Book";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<Book> list = new ArrayList<Book>();
		while (rs.next()) {
			String bookid = rs.getString("BookId");
			String title = rs.getString("Title");
			int Release = rs.getInt("Release");
			Float price = rs.getFloat("Price");
			String Picture = rs.getString("Picture");
			Book book = new Book();
			book.setBookId(bookid);
			book.setTitle(title);
			book.setRelease(Release);
			list.add(book);
		}
		return list;
	}
	public static Book findBook(Connection conn, String bookId) throws SQLException {
		String sql = "select a.BookId, a.Title, a.Author, a.Release, a.Price, a.Picture, a.PublisherId, a.CategoryId from Book a where a.BookId = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, bookId);
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			String title = rs.getString("Title");
			String author = rs.getString("Author");
			int release = rs.getInt("Release");
			float price = rs.getFloat("Price");
			String picture = rs.getString("Picture");
			int publisherId = rs.getInt("PublisherId");
			int categoryId = rs.getInt("CategoryId");
			Book book = new Book(bookId, title, author, release, price, picture, publisherId, categoryId);
			return book;
		}
		return null;
	}
	 public static void InsertBook (Connection conn,Book book) throws SQLException{ 
		  String sql ="INSERT into Book(BookId ,Author, Title , Release,Price,Picture) values(?,?,?,?,?,?)"; 
		  PreparedStatement pstm= conn.prepareStatement(sql);
		  pstm.setString(1, book.getBookId());
		  pstm.setString(2, book.getAuthor());
		  pstm.setString(3, book.getTitle());
		  pstm.setInt(4, book.getRelease());
		  pstm.setFloat(5, book.getPrice());
		  pstm.setString(6, book.getPicture());
		  pstm.executeUpdate();
		  
	  }
	 public static void updateBook(Connection conn , Book book) throws SQLException {
			String sql = "Update Product set Title = ?, PRICE = ?,WHERE BookId = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, book.getTitle());
			pstm.setFloat(2, book.getPrice());
			pstm.setString(3, book.getBookId());
			pstm.executeUpdate();
		}
	 public static void deleteProduct(Connection conn , String bookId) throws SQLException {
			String sql = "DELETE FROM Book WHERE BookId = ? ";
			PreparedStatement pstm = conn .prepareStatement(sql);
			pstm.setString(1,bookId);
			pstm.executeUpdate();
		}
}
