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
		
		Date date  = new Date(System.currentTimeMillis());
		
		String logString = req.getParameter("input");
		String titleString = req.getParameter("title");
		String timestamp = new Timestamp(date.getTime()).toString();
				
		User user = new User();
		user.setTS(timestamp);
		user.setContent(logString);
		user.setTitle(titleString);
		
		ApplicationDao dao = new ApplicationDao();
		
		int rows = dao.addUsers(user);
		String message;
		if(rows==0) {
			message="an error occurred";
		} else {
			message = "User added successfully. " + rows + " rows affected";
		}
		writer.write("<html><h2>" + message + "</h2></html>");
		
		
	}

}
