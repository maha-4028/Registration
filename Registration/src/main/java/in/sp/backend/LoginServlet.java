package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String pass = req.getParameter("pass");
		String url ="jdbc:mysql://localhost:3306/register";
		String user="root";
		String password="Root@4321";
		
		PrintWriter out = resp.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			PreparedStatement ps = con.prepareStatement("select * from login where name=? AND pass=?");
			ps.setString(1, name);
			ps.setString(2, pass);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				HttpSession session = req.getSession();
				session.setAttribute("session_name", rs.getString("name"));
				RequestDispatcher rd= req.getRequestDispatcher("/Profile.jsp");
				rd.forward(req, resp);
				
			}
			else {
				
				resp.setContentType("text/html");
				out.println("<h3 style='color:white'>incorrect login detail</h3>");
				RequestDispatcher rd= req.getRequestDispatcher("/Login.jsp");
				rd.include(req, resp);			}

	}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			//resp.setContentType("text/html");
			//out.println("<h3 style='color:red'>incorrect login detail</h3>");
			//RequestDispatcher rd= req.getRequestDispatcher("/Login.jsp");
			//rd.include(req, resp);	
		}
	}
}
