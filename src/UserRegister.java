import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AppDAO;
import users.Admin;
import users.Student;
import users.Teacher;
import users.User;
import users.UserFactory;

public class UserRegister extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		AppDAO dao = AppDAO.getInstance(); //instantiating db object by accessing instance
		
		Date date  = new Date(System.currentTimeMillis()); //not used currently
		String timestamp = new Timestamp(date.getTime()).toString(); //not used currently 
		
		//getting input from form
				String userName = req.getParameter("userName");
				String password = req.getParameter("password");
				String password2 = req.getParameter("password2");
				String firstName = req.getParameter("firstName");
				String lastName = req.getParameter("lastName");
				String email = req.getParameter("email");
				String userType = req.getParameter("role");
				
				//check to make sure passwords match
				if (password.contentEquals(password2)) {
				
					UserFactory factory = new UserFactory();
					User user = null;
					user = factory.createUser(userType, userName, firstName, lastName, email, password);
					
					String message = "";
					
					try {
						if (dao.userExists(userName)){
							message = "Username already in use, new account not created.";
						} else {
							int rows = dao.insertNewUser(user);
							
							if(rows==0) { //error message throws
								message="an error occurred";
							} else {
								message = "User added successfully. " + rows + " rows affected"; //adds user & prints console message confirming
							}
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					writer.write("<html><h2>" + message + "</h2>"
							+ "<form action=\"loginform.jsp\">"
							+ "<input type=\"submit\" value=\"Back to login\" />"
							+ "</form>"
							+ "</html>");
				} else {
					writer.write("<html><h2>" + "Passwords did not match" + "</h2>"
							+ "<form action=\"loginform.jsp\">"
							+ "<input type=\"submit\" value=\"Back to login\" />"
							+ "</form>"
							+ "</html>");
				}
		
		
	} //end method doPost()

} //end class UserRegister