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
import java.nio.file.Paths;
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
 * Servlet implementation class CreateAcc
 */
@WebServlet("/CreateAccount")
@MultipartConfig
public class CreateAcc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAcc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sqlRole = "Select role_name from Role_manager";
		try {
			Connection conn = ConnectionUtils.getMSSQLConnection();
			PreparedStatement pstm = conn.prepareStatement(sqlRole);
			ResultSet rs = pstm.executeQuery();
			List<String> role_Name = new ArrayList<String>();
			while(rs.next()) {
				String role = rs.getString("role_name");
				role_Name.add(role);
			}
			request.setAttribute("role", role_Name);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/Admin/CreateAccount.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		request.setCharacterEncoding("UTF-8");
		String errorString = null;
		String firstName = (String) request.getParameter("firstName");
		String lastName = (String) request.getParameter("lastName");
		String userName = (String) request.getParameter("userName");
		String password = (String) request.getParameter("password");
		Part filePart = request.getPart("ImgUser");
		String role_id = (String) request.getParameter("role_id");
		String fileName = Path.of(filePart.getSubmittedFileName()).getFileName().toString();
		Connection conn = null;
		 try {
	    	 conn = ConnectionUtils.getMSSQLConnection();
	    	 AccountEntity accountEntity = new AccountEntity( 1,firstName,lastName,userName,password,fileName,role_id);
	    	 AccountUtils.addAcc(conn, accountEntity);
	    	 String realPath = getServletContext().getRealPath("/img");
	    	 System.out.print(realPath);
	    	 File imgDir = new File(realPath);
	    	 if(!Files.exists(Path.of(realPath))) {
	    		 Files.createDirectory(Path.of(realPath));
	    	 }
	    	 Paths.get(realPath, fileName).toString();
	    	 filePart.write(realPath + File.separator  + fileName);
	    	 response.sendRedirect(request.getContextPath() + "/Account");
	     }catch(Exception e) {
	    	 e.printStackTrace();
	    	 request.setAttribute("errorString", errorString);
	    	 RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/Admin/CreateAccount.jsp");
			 dispatcher.forward(request, response);
	     }
	    
	        
	        
//		doGet(request, response);
	}
	
}
