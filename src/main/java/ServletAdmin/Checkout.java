package ServletAdmin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import Conn.ConnectionUtils;
import Entity.CartEntity;
import Utils.CartUtils;

/**
 * Servlet implementation class Checkout
 */
@WebServlet("/ThanhToan")
public class Checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Checkout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idProduct = request.getParameter("id");
		Connection conn = null;
        List<CartEntity> list = null;
		Cookie[] cookies = request.getCookies();
		 String username = null;
		 String idAccountValue = null;
	      try {
	    	  if (cookies != null) {
		            for (Cookie cookie : cookies) {
		                // Kiểm tra tên của cookie mà bạn muốn lấy
		                if (cookie.getName().equals("username")) {
		                    // Lấy giá trị của cookie
		                    username = cookie.getValue();
		                }
		                if (cookie.getName().equals("id_Account")) {	
		                     idAccountValue = cookie.getValue();
		                     System.out.print(idAccountValue);
		                    // Sử dụng giá trị idAccountValue ở đây
		                }
		            }
		        }
	      }catch (Exception e) {
			// TODO: handle exception
		}
	  	try {
	  		conn = ConnectionUtils.getMSSQLConnection();
			if (idAccountValue != null) {
				 String queryCount = "SELECT COUNT(*) AS total FROM Cart WHERE id_Account = ?";
	    	        try (PreparedStatement checkCount = conn.prepareStatement(queryCount)) {
	    	            int intIdAccount = Integer.parseInt(idAccountValue);
	    	            checkCount.setInt(1, intIdAccount);
	    	            ResultSet checkRs = checkCount.executeQuery();
	    	            while (checkRs.next()) {
							String total = checkRs.getString("total");
							request.setAttribute("total", total);
							
							list = CartUtils.getAllCartInAccount(conn,intIdAccount);
							System.out.print(intIdAccount);
						}
	    	        }catch (Exception e) {
						// TODO: handle exception
	    	        	e.printStackTrace();
					}
				request.setAttribute("listCart", list);
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/Admin/Checkout.jsp");
				dispatcher.forward(request, response);
			} else {
				response.sendRedirect("Login");
			}
		} catch (Exception e) {
			// TODO: handle exception
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
