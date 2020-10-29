//package capstonepackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AppDAO;

/**
 * Servlet implementation class UserLogin
 */
//@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
//		AppDAO dao = new AppDAO();
		
		if(username.isEmpty() || password.isEmpty()) {
			RequestDispatcher req = request.getRequestDispatcher("loginform.jsp");
			req.include(request, response);
		} else {
			RequestDispatcher req = request.getRequestDispatcher("register_4.jsp");
			req.forward(request, response);
		}
		
//		try {
//			if(dao.checkPassword(username, password)) {
//				RequestDispatcher req = request.getRequestDispatcher("register_4.jsp");
//				req.forward(request, response);
//
//			} else {
//				PrintWriter writer = response.getWriter();
//				writer.write("Incorrect username or password!");
//				RequestDispatcher req = request.getRequestDispatcher("loginform.jsp");
//				req.include(request, response);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ServletException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
