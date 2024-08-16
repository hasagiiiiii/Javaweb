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
import Utils.ProductUtils;

/**
 * Servlet implementation class DeleteProductServlet
 */
@WebServlet("/DeleteProduct")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id_Pr = (String) request.getParameter("id");
		Connection conn = null;
        String errorString = null;

        try {
            conn = ConnectionUtils.getMSSQLConnection();
            ProductUtils.deleteProduct(conn, id_Pr);
        } catch (ClassNotFoundException | SQLException  e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }

        if (errorString != null) {
        } else {
            response.sendRedirect(request.getContextPath()+"/ProductAdmin");
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
