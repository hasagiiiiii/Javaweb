package ServletAdmin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.List;

import Conn.ConnectionUtils;
import Entity.CartEntity;
import Entity.OrderProductEntity;
import Utils.CartUtils;
import Utils.OrderProductUtils;

/**
 * Servlet implementation class Order
 */
@WebServlet("/order")
public class Order extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Order() {
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
		String address = request.getParameter("address");
		String zip = request.getParameter("zip");
			Cookie[] cookies = request.getCookies();
			 String username = null;
			 String idAccountValue = null;
		Connection conn = null;
		String errorString = null;
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
			  
			 conn = ConnectionUtils.getMSSQLConnection();
			 List<CartEntity> cart = CartUtils.getAllCartInAccount(conn, Integer.parseInt(idAccountValue));
			for (CartEntity item : cart) {
				OrderProductEntity oder = new OrderProductEntity();
				oder.setId_Account(item.getIdAcount());
				oder.setId_Product(item.getIdProduct());
				oder.setQuantity(item.getQuantity());
				oder.setAddress(address);
				oder.setZip(zip);
				
				OrderProductUtils.addOrder(conn, oder);
				
			}		
			String query = "Delete From Cart where id_Account = ?";
			if(idAccountValue!=null) {
				PreparedStatement pstm = conn.prepareStatement(query);
				pstm.setString(1, idAccountValue);
				pstm.executeUpdate();
			}
			response.sendRedirect("Cart");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
