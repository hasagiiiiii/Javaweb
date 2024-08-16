package ServletAdmin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/Logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
		    for (Cookie cookie : cookies) {
		        cookie.setMaxAge(0); // Đặt thời gian sống của cookie về 0 để xóa
		        response.addCookie(cookie); // Gửi lại cookie với thời gian sống đã đặt
		    }
		}
		HttpSession session = request.getSession(false);
		if (session != null) {
		    session.invalidate(); // Xóa session và tất cả các thuộc tính của nó
		}
		response.sendRedirect(request.getContextPath() + "/Login"); // Chuyển hướng đến trang đăng nhập
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
