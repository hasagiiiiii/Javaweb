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
import Utils.AccountUtils;

/**
 * Servlet implementation class DeleteAccServlet
 */
@WebServlet("/DeleteAcc")
public class DeleteAccServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAccServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id_Acc = (String) request.getParameter("id");
		Connection conn = null;
        String errorString = null;

        try {
            conn = ConnectionUtils.getMSSQLConnection();
            AccountUtils.deleteAccount(conn, id_Acc);
        } catch (ClassNotFoundException | SQLException  e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }

        if (errorString != null) {
        } else {
            response.sendRedirect(request.getContextPath()+"/Account");
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
