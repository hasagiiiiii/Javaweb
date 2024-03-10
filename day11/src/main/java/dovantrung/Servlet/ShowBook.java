package dovantrung.Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dovantrung_2110900043.beans.Book;
import dovantrung_2110900043.conn.ConnectionUltis;
import dovantrung_2110900043.utils.BookUtils;

/**
 * Servlet implementation class ShowBook
 */

public class ShowBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		String errorString = null;
		String successString = "Ok roi";
		List<Book> list = null;
		try {
			conn = ConnectionUltis.getMSSQLConnection();
			try {
				list = BookUtils.queryBook(conn);
			} catch (Exception e) {
				e.printStackTrace();
				errorString = e.getMessage();
			}
			
			request.setAttribute("errorString", errorString);
			for (Book book : list) {
				successString = book.getBookId();
			}
			request.setAttribute("successString", successString);
			request.setAttribute("bookList", list);
			
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/ShowBook.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException| SQLException e1) {
			e1.printStackTrace();
			errorString = e1.getMessage();
			
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/ShowBook.jsp");
			request.setAttribute("errorString", errorString);
			dispatcher.forward(request, response);
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
