package ServletAdmin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Conn.ConnectionUtils;
import Entity.AccountEntity;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie[] cookies = request.getCookies();
		String username = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                // Kiểm tra tên của cookie mà bạn muốn lấy
                if (cookie.getName().equals("username")) {
                    // Lấy giá trị của cookie
                     username = cookie.getValue();
                    break; // Kết thúc vòng lặp sau khi tìm thấy cookie cần
                }
            }
        }
        if(username!=null) {
        	response.sendRedirect(request.getContextPath()+"/home");
        	
        }else {
        	RequestDispatcher dispatcher = request.getServletContext()
    				.getRequestDispatcher("/WEB-INF/Admin/Login.jsp");
    		dispatcher.forward(request, response);
        }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String errorString = null;
		Connection conn = null;
		String username = (String) request.getParameter("username");
		String passwordPara = (String) request.getParameter("password");
		String role = null;
		int idAccount = 0;
		try {
			String query = "SELECT id_Account , firstName , lastName,userName,password,ImgUser ,role_id FROM Account where userName =? and password=? ";
			conn = ConnectionUtils.getMSSQLConnection();
			AccountEntity acc = null;
			PreparedStatement pstm = conn.prepareStatement(query);
	        pstm.setString(1, username);
	        pstm.setString(2, passwordPara);
	        ResultSet rs = pstm.executeQuery();

	        while (rs.next()) {
				int id_Account = rs.getInt("id_Account");
				String firstName = rs.getString("firstName");
				String lastName= rs.getString("lastName");
				String userName= rs.getString("userName");
				String password= rs.getString("password");
				String ImgUser= rs.getString("ImgUser");
				String role_id = rs.getString("role_id");
				idAccount = rs.getInt("id_Account");
				acc = new AccountEntity(id_Account,firstName,lastName,userName,password,ImgUser,role_id);					
			}
				
				if(acc != null) {
				Cookie cookie = new Cookie("username", username);
				Cookie cookie2 = new Cookie("id_Account",Integer.toString(idAccount) );
				cookie.setMaxAge(3600);
				cookie2.setMaxAge(3600);
				response.addCookie(cookie);
				response.addCookie(cookie2);
				HttpSession session = request.getSession();
	            session.setAttribute("username", username);
	            
	            System.out.print(acc.getRole_id());
					if( acc.getRole_id().equals("admin")) {
						response.sendRedirect("Account");
						return;
							
					}else {
						response.sendRedirect("home");
							return;
					}
				
				}else {
				String errorLogin="Tên tài khoản hoặc mật khẩu sai";
				request.setAttribute("errorLogin", errorLogin);
//				response.sendRedirect(request.getContextPath() + "/Login");
				RequestDispatcher dispatcher = request.getServletContext()
	    				.getRequestDispatcher("/WEB-INF/Admin/Login.jsp");
	    		dispatcher.forward(request, response);
			}	
			
		}catch(Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}
	}

}
