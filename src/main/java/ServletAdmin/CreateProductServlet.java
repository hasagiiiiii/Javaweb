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
import java.util.ArrayList;
import java.util.List;

import Conn.ConnectionUtils;
import Entity.ProductEntity;
import Utils.ProductUtils;

/**
 * Servlet implementation class CreateProductServlet
 */
@WebServlet("/CreateProduct")
@MultipartConfig
public class CreateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sqlColor = "Select color from Color";
		String sqlTrademark = "Select name_trademark from Trademark";
		try {
			Connection conn = ConnectionUtils.getMSSQLConnection();
			PreparedStatement pstmColor = conn.prepareStatement(sqlColor);
			PreparedStatement pstmTrademark= conn.prepareStatement(sqlTrademark);
			ResultSet rsColor = pstmColor.executeQuery();
			ResultSet rsTrademark = pstmTrademark.executeQuery();
			List<String> color = new ArrayList<String>();
			List<String> trademark = new ArrayList<String>();
			while(rsColor.next()) {
				String colors = rsColor.getString("color");
				color.add(colors);
			}
			while(rsTrademark.next()) {
				String trade = rsTrademark.getString("name_trademark");
				trademark.add(trade);
			}
			System.out.print("this is"+ trademark);
			request.setAttribute("Tradmark", trademark);
			request.setAttribute("Color", color);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/Admin/CreateProduct.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String errorString = null;
		Connection conn=null;
		String nameProduct = (String) request.getParameter("nameProduct");
		String price = (String) request.getParameter("price");
		String sale = (String) request.getParameter("sale");
		String description = (String) request.getParameter("description");
		String trademark = (String) request.getParameter("trademark");
		String quantityPro = (String) request.getParameter("quantityPro");
		Part imgPart =  request.getPart("imgPro");
		String fileName = Path.of(imgPart.getSubmittedFileName()).getFileName().toString();
		String colorPro = (String) request.getParameter("colorPro");
		
		
		
		try {
			conn = ConnectionUtils.getMSSQLConnection();
			float PriceConvert =Float.parseFloat(price);
			int saleConvert = Integer.parseInt(sale);
			int quantity = Integer.parseInt(quantityPro);
			
			ProductEntity pro = new ProductEntity(1,nameProduct,0,PriceConvert,saleConvert,description,trademark,quantity,fileName,colorPro);
			ProductUtils.addProduct(conn, pro);
			String realPath = getServletContext().getRealPath("/img");
			System.out.print(realPath);
			File imgDir = new File(realPath);
			if(!Files.exists(Path.of(realPath))) {
	    		 Files.createDirectory(Path.of(realPath));
	    	 }
	    	 Paths.get(realPath, fileName).toString();
	    	 imgPart.write(realPath + File.separator  + fileName);
	    	 response.sendRedirect(request.getContextPath() + "/ProductAdmin");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
	    	 request.setAttribute("errorString", errorString);
	    	 RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/Admin/CreateProduct.jsp");
			 dispatcher.forward(request, response);
		}
	}

}
