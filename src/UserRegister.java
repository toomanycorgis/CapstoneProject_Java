import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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
		AppDAO dao = new AppDAO(); //instantiating db object 
		
		Date date  = new Date(System.currentTimeMillis()); //not used currently
		String timestamp = new Timestamp(date.getTime()).toString(); //not used currently 
		
		//getting input from form
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");
		String userType = req.getParameter("role");
		
		UserFactory factory = new UserFactory();
		User user = null;
		//creating user from form on the JSP file	
		user = factory.createUser(userType, userName, firstName, lastName, email, password);
		
		int rows = dao.insertNewUser(user);
		String message;
		if(rows==0) { //error message throws
			message="an error occurred";
		} else {
			message = "User added successfully. " + rows + " rows affected"; //adds user & prints console message confirming
		}
		writer.write("<html><h2>" + message + "</h2></html>");
		
		
	}

}