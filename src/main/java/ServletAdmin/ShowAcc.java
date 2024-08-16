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
import Entity.AccountEntity;
import Utils.AccountUtils;


/**
 * Servlet implementation class ShowAcc
 */
@WebServlet("/Account")
public class ShowAcc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAcc() {
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
		List<AccountEntity> list = null;
		try {
			conn = ConnectionUtils.getMSSQLConnection();
			
			try {
				list = AccountUtils.getAllAccount(conn);
			} catch (SQLException e) {
				e.printStackTrace();
				errorString = e.getMessage();
			}
			request.setAttribute("errorString", errorString);
			request.setAttribute("Acc", list);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/Admin/ShowAllAccount.jsp");
			dispatcher.forward(request, response);
		} catch	(ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
			errorString = e1.getMessage();
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/Admin/ShowAllAccount.jsp");
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
