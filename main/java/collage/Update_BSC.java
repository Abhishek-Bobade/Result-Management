package collage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import access.DataBase;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/upbsc")
public class Update_BSC extends GenericServlet {
	Connection con;
		public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException{	
		try {
			con = DataBase.getCon();
			String s1 = req.getParameter("roll"); 
			PreparedStatement ptsm = con.prepareStatement("select * from BSC_STUDENT where ROLL_NO=?");
			ptsm.setString(1, s1);
			ResultSet rs = ptsm.executeQuery();
			PrintWriter pw = res.getWriter();
			if (rs.next()) {
				pw.println(
						"<html><head><title>Update Result</title><style>#i1{width: 30%; height:4%}#i2{width: 15%; height:4%}</style></head><body bgcolor=#ABB2B9><center><br><br><br><div style=\"border-style: solid; width: 800px; background: #D5DBDB\">");
				pw.println("<h2 style=width:30%; height:4%>General Information</h2><hr>");
				pw.println("First Name: <input id=i1 type=text value=" + rs.getString(1) + " disabled>"
						+ "Last Name: <input id=i1  type=text value=" + rs.getString(2) + " disabled><br/><br/>"
						+ "Roll No: <input id=i1 type=text value=" + rs.getString(3) + " disabled>"
						+ "Class: <input id=i1 type=text value=" + rs.getString(4) + " disabled> <br/><br/>"
						+ "Mail Id: <input id=i1 type=text  value=" + rs.getString(5) + " disabled> <br/><br/>");
				pw.println("<div style='border-style: solid; width: 800px; background: #283747' <br><h2 style=color:white>Update The Marks Of Student</h2><hr><br><br>");
				pw.println("<form action='upmarksbsc' method='post'>");
				pw.println("<input id='i2' type='text' placeholder='Java Programming' name='cf' value="+rs.getString(6)+" autocomplete='off' required> "
						+ "<input id='i2' type='text' placeholder='Computer Network' name='dbms' value="+rs.getString(7)+" autocomplete='off' required> "
						+ "<input id='i2' type='text' placeholder='DB Operation' name='os' value="+rs.getString(8)+" autocomplete='off' required> "
						+ "<input id='i2' type='text' placeholder='Data Structure' name='html' value="+rs.getString(9)+" autocomplete='off' required> "
						+ "<input id='i2' type='text' placeholder='Operating System' name='nt' value="+rs.getString(10)+" autocomplete='off' required> 	<br></br></br></br> ");
				pw.println("By clicking on <input type=submit style='background-color: green; color: white;'> button information will be Update in the DataBase.  <br>	<br></form>");
				HttpServletRequest request = (HttpServletRequest) req; 
				HttpSession session = request.getSession();
				session.setAttribute("key", s1);
				pw.println("</div></div></center></body></html>");
			} else {
				pw.println("<html><body>");
				pw.println("<h3> Roll Number <u style=color:red;>" + s1+ "</u> Not Avaliable</h3>");
				req.getRequestDispatcher("Update_BSC.html").include(req, res);
				pw.println("</body></html>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
