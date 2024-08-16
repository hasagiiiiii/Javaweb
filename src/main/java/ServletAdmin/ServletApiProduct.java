package ServletAdmin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import com.google.gson.Gson;

import Conn.ConnectionUtils;
import Entity.ProductEntity;
import Utils.ProductUtils;

/**
 * Servlet implementation class ServletApiProduct
 */
@WebServlet("/ApiProduct")
public class ServletApiProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletApiProduct() {
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
		List<ProductEntity> pro = null;
		try {
			conn = ConnectionUtils.getMSSQLConnection();
			try {
				pro = ProductUtils.getAllProduct(conn);
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		Gson gson = new Gson();
		String GsonPro = gson.toJson(pro);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(GsonPro);
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
