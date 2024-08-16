package ServletAdmin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import Conn.ConnectionUtils;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String username = request.getParameter("username");
		String password =request.getParameter("password");
		Connection conn = null;
		String error = null;
		try {
			conn = ConnectionUtils.getMSSQLConnection();
			String query = "Insert into Account (firstName, lastName,userName , password,role_id) values (?,?,?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(query);
	        pstm.setString(1, firstName);
	        pstm.setString(2, lastName);
	        pstm.setString(3, username);
	        pstm.setString(4, password);
	        pstm.setString(5, "guest");
	        pstm.execute();
	        response.sendRedirect(request.getContextPath() + "/Login");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
