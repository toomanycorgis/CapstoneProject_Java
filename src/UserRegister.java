import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserRegister extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		AppDAO dao = new AppDAO();
		
		Date date  = new Date(System.currentTimeMillis()); //not used
		String timestamp = new Timestamp(date.getTime()).toString(); //not used
		
		//getting input from form
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");
		String userType = req.getParameter("role");
		
		User user = null;
		//creating user from form	
		if(userType.equals("S")) {
			user = new Student(userName, firstName, lastName, email, password);
		} else if(userType.equals("A")) {
			user = new Admin(userName, firstName, lastName, email, password);
		} else if(userType.equals("T")) {
			user = new Teacher(userName, firstName, lastName, email, password);
		}
		
		int rows = dao.insertNewUser(user);
		String message;
		if(rows==0) {
			message="an error occurred";
		} else {
			message = "User added successfully. " + rows + " rows affected";
		}
		writer.write("<html><h2>" + message + "</h2></html>");
		
		
	}

}
