

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AppDAO;

/**
 * Servlet implementation class PasswordRecovery
 */
@WebServlet("/password_recovery")
public class PasswordRecovery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasswordRecovery() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get username from form
		String username = request.getParameter("userName");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		//get username from form
		String username = request.getParameter("userName");
		AppDAO dao = AppDAO.getInstance(); //instantiating object from appDAO class in order to check password again DB
		
		//check if username is valid.  If so, print password (we're top security experts here).  If not, let user know.
		try {
			if(dao.userExists(username)) {
				String password = dao.getUserObject(username).getPassword();
				String email = dao.getUserObject(username).getEmail();
				String content = "The password for account " + username + " is: " + password;
				SendMail.send(email, "Password Recovery", content);
				PrintWriter writer = response.getWriter();
				writer.write("A recovery email containing your password has been sent to the email address on file for " + username + ".");
				RequestDispatcher req = request.getRequestDispatcher("password_recovery.jsp");
				response.setContentType("text/html");
				req.include(request, response);
			} else {
				PrintWriter writer = response.getWriter();
				writer.write(username + " does not exist in the database.  Try creating a new account!");
				RequestDispatcher req = request.getRequestDispatcher("password_recovery.jsp");
				response.setContentType("text/html");
				req.include(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
