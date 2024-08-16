package ServletAdmin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class CheckIsLogin
 */
@WebServlet("/CheckIsLogin")
public class CheckIsLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckIsLogin() {
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
	     String redirectPage;
	     Boolean isLogin = false;
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
	        

	        if (username != null) {
	            redirectPage =request.getContextPath() + "/home";
	            isLogin = true;
	        } else {
	            redirectPage =request.getContextPath() + "/Login";
	        }
	        String jsonResponse = "{\"redirect\": \"" + redirectPage + "\", \"isLogin\": " + isLogin + "}";

	        // Thiết lập tiêu đề phản hồi và gửi phản hồi
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        PrintWriter out = response.getWriter();
	        out.print(jsonResponse);
	        out.flush();
	    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
