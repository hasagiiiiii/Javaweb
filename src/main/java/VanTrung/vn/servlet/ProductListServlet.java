package VanTrung.vn.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VanTrung.vn.beans.Product;
import VanTrung.vn.conn.ConnectionUtils;
import VanTrung.vn.utils.ProductUtils;

@WebServlet("/productList") // config http URL = /productList
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	protected void doGet (HttpServletRequest request,HttpServletResponse response) throws ServletException , IOException{
		
		String errorString = null;
		List<Product> productList = null;
		try {
			Connection conn = ConnectionUtils.getMySQLConnection();
			
			try {
				productList = ProductUtils.queryProduct(conn);
			}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
				errorString = e.getMessage();
			}
			// Lưu thông tin vào request Attribute , trước khi chuyển tiếp đến view
			request.setAttribute("errorString", errorString);
			request.setAttribute("productList", productList);
			
			// Chuyển tiếp tới /WEB-INF/view/product.jsp
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/view/product.jsp");
			
			dispatcher.forward(request, response);
		}catch(ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
			errorString = e1.getMessage();
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/product");
			dispatcher.forward(request, response);
		}
	}
}
