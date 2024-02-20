package dovantrung.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import dovantrung.beans.Product;
import dovantrung.conn.ConnectionUtils;
import dovantrung.utils.ProductUtils;

/**
 * Servlet implementation class ProductEditServlet
 */
@WebServlet("/productEdit")
public class ProductEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Lay du lieu tren from
				String code = (String) request.getParameter("code");
				Connection conn = null;
		        String errorString = null;
		        Product product = null;

		        try {
		            conn = ConnectionUtils.getMSSQLConnection();
		            product = ProductUtils.findProduct(conn, code);

		            if (product == null) {
		                errorString = "Product not found with code: " + code;
		            }
		        } catch (ClassNotFoundException | SQLException  e) {
		            e.printStackTrace();
		            errorString = e.getMessage();
		        } finally {
		            try {
		                if (conn != null) {
		                    conn.close();
		                }
		            } catch (Exception e) {
		                e.printStackTrace();
		            }
		        }

		        if (errorString != null) {
		            request.setAttribute("errorString", errorString);
		            RequestDispatcher dispatcher = request.getServletContext()
		                    .getRequestDispatcher("/WEB-INF/views/productEdit.jsp");
		            dispatcher.forward(request, response);
		        } else {
		            request.setAttribute("product", product);
		            RequestDispatcher dispatcher = request.getServletContext()
		                    .getRequestDispatcher("/WEB-INF/views/productEdit.jsp");
		            dispatcher.forward(request, response);
		        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String errorString = null;
		
		//Lay du lieu tren from
		String code = (String) request.getParameter("code");
		String name = (String) request.getParameter("name");
		String priceStr = (String) request.getParameter("price");
		float price = 0;
		try {
			price = Float.parseFloat(priceStr);
		} catch (Exception e) {
			errorString = e.getMessage();
		}
		Product product = new Product(code,name,price);
		//Kiem tra code it nhat 1 ky tu
		String regex = "\\w+";
		if(code == null || !code.matches(regex)) {
			errorString = "Product code invalid!";
		}
		
		if(errorString != null) {
			request.setAttribute("errorString", errorString);
			request.setAttribute("product", product);
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/productEdit.jsp");
			
			dispatcher.forward(request, response);
			return;
		}
		Connection conn = null;
		try {
			conn = ConnectionUtils.getMSSQLConnection();
			ProductUtils.updateProduct(conn, product);
			response.sendRedirect(request.getContextPath()+"/productList");
			
		} catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/productEdit.jsp");
			dispatcher.forward(request, response);
		}
	}

}

