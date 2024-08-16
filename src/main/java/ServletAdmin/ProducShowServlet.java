package ServletAdmin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Conn.ConnectionUtils;
import Entity.ProductEntity;
import Utils.AccountUtils;
import Utils.ProductUtils;

/**
 * Servlet implementation class ProducShowServlet
 */
@WebServlet("/ProductAdmin")
public class ProducShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProducShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 Connection conn = null;
		 String errorString = null;
		 List<ProductEntity> pro = null;
		 try {
				conn = ConnectionUtils.getMSSQLConnection();
				
				try {
					pro = ProductUtils.getAllProduct(conn);
				} catch (SQLException e) {
					e.printStackTrace();
					errorString = e.getMessage();
				}
				request.setAttribute("errorString", errorString);
				request.setAttribute("Pro", pro);
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/Admin/ShowProduct.jsp");
				dispatcher.forward(request, response);
			} catch	(ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
				errorString = e1.getMessage();
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/Admin/ShowProduct.jsp");
				request.setAttribute("errorString", errorString);
				dispatcher.forward(request, response);
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
