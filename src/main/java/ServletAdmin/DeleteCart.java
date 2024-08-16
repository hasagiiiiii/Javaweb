package ServletAdmin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import Conn.ConnectionUtils;
import Utils.CartUtils;

/**
 * Servlet implementation class DeleteCart
 */
@WebServlet("/deleteCart")
public class DeleteCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idCart = (String) request.getParameter("id");
		Connection conn = null;
		String errorString = null;
		try {
            conn = ConnectionUtils.getMSSQLConnection();
            CartUtils.deleteCart(conn, idCart);
        } catch (ClassNotFoundException | SQLException  e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }

        if (errorString != null) {
        } else {
            response.sendRedirect(request.getContextPath()+"/Cart");
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
