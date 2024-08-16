package ServletAdmin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conn.ConnectionUtils;
import Entity.AccountEntity;
import Utils.AccountUtils;

/**
 * Servlet implementation class UpdateAcc
 */
@WebServlet("/UpdateAcc")
@MultipartConfig
public class UpdateAccServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAccServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id_account = (String) request.getParameter("id");
		String errorString = null;
		AccountEntity acc = null;
		Connection conn =null;
		String sqlRole = "Select role_name from Role_manager";
		try {
			 conn = ConnectionUtils.getMSSQLConnection();
			 acc = AccountUtils.findAccount(conn, Integer.parseInt(id_account));
			 PreparedStatement pstm = conn.prepareStatement(sqlRole);
				ResultSet rs = pstm.executeQuery();
				List<String> role_Name = new ArrayList<String>();
				while(rs.next()) {
					String role = rs.getString("role_name");
					role_Name.add(role); // add role vao list
				}
				request.setAttribute("role", role_Name); // set atribute role
			if (acc == null) {
				 errorString = "Product not found with code: " + id_account;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (errorString != null) {
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/Admin/UpdateAcc.jsp");
			dispatcher.forward(request, response);
		} else {
			request.setAttribute("acc", acc);
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/Admin/UpdateAcc.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auo-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		Connection conn = null;
		String fileName = "";
		String errorString = null;
		String id_Account = (String) request.getParameter("id_Account");
		String firstName = (String) request.getParameter("firstName");
		String lastName = (String) request.getParameter("lastName");
		String userName = (String) request.getParameter("userName");
		String password = (String) request.getParameter("password");
		Part filePart = request.getPart("ImgUser");
		String role_id = (String) request.getParameter("role_id");
		if(filePart !=null) {
			fileName = Path.of(filePart.getSubmittedFileName()).getFileName().toString();
			String realPath = getServletContext().getRealPath("/img");
			filePart.write(realPath + File.separator + fileName);
			if(!Files.exists(Path.of(realPath))) {
				Files.createDirectory(Path.of(realPath));
				File imgDir = new File(realPath);
				if(!imgDir.exists()) {
					imgDir.mkdir();
				}
				filePart.write(realPath + File.separator  + fileName);
			}
		}
		int idAcc = 0;
		try {
			idAcc = Integer.parseInt(id_Account);
			
		}catch (Exception e) {
			// TODO: handle exception
			errorString = e.getMessage();
		}
		AccountEntity accountEntity = new AccountEntity(idAcc,firstName,lastName,userName,password,fileName,role_id);
		String regex = "\\w+";
		if(id_Account == null || !id_Account.matches(regex)) {
			errorString = "Account id invalid!";
		}
		
		if (errorString != null) {
			request.setAttribute("errorString", errorString);
			request.setAttribute("acc", accountEntity);
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/Admin/UpdateAcc.jsp");

			dispatcher.forward(request, response);
			return;
		}
		try {
			conn = ConnectionUtils.getMSSQLConnection();
			AccountUtils.uppdateAcc(conn, accountEntity);
			response.sendRedirect(request.getContextPath() + "/Account");

		} catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/Admin/UpdateAcc.jsp");
			dispatcher.forward(request, response);
		}
	
	}

}
