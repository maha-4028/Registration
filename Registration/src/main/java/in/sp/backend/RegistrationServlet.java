package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/RegisterServlet")
public class RegistrationServlet extends HttpServlet {

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		
		String url ="jdbc:mysql://localhost:3306/register";
		String user="root";
		String password="Root@4321";
		
		PrintWriter out = resp.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			PreparedStatement ps = con.prepareStatement("insert into login values(?,?,?)");
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, pass);
			
			int result = ps.executeUpdate();
			if(result>0) {
				
				resp.setContentType("text/html");
				out.println("<h3 style='color:white'>user registered successfully</h3>");
				RequestDispatcher rd= req.getRequestDispatcher("/Login.jsp");
				rd.include(req, resp);
			}
			else {
				resp.setContentType("text/html");
				out.println("<h3 style='color:red'>user not registered successfully</h3>");
				RequestDispatcher rd= req.getRequestDispatcher("/index.html");
				rd.include(req, resp);
			}

		} catch (Exception e) {
			e.printStackTrace();
			 resp.setContentType("text/html");
			 out.print("<h3 style='color:red'> Exception Occured :"+e.getMessage()+"</h3>");
			 
			
			RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
			rd.include(req, resp);
			
		}

	}
}
