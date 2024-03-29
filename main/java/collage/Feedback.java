package collage;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import access.DataBase;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/feedback")
public class Feedback extends GenericServlet {
	public void service(ServletRequest req, ServletResponse res) {
		Connection con = DataBase.getCon();
		try {
			PreparedStatement pstm = con.prepareStatement("SELECT * FROM FEEDBACK");
			ResultSet rs = pstm.executeQuery();
			PrintWriter pw = res.getWriter();
			pw.println(
					"<html><head><style>body{background-color:#434d5e; h1{color:white;}h3{color:red;}</style></head><body>");
			pw.println("<center><h1> Feedback Details </h1></center><hr><br>");
			pw.println("<table border=0> <tr>");
			pw.println("<td style=width:250px;><h3><u>Name</u></h3></td>");
			pw.println("<td style=width:100px;><h3><u>Contact</u></h3></td>");
			pw.println("<td style=width:70px;>" + "<h3><u>Satisfy<u></h3>" + "</td>");
			pw.println("<td>" + "<h3><u>Message</u></h3>" + "</td>");
			pw.println("</tr></table>");
			while (rs.next()) {
				pw.println("<table border=0> <tr>");
				pw.println("<td style=width:250px;>" + rs.getString(1) + "</td>");
				pw.println("<td style=width:100px;>" + rs.getString(2) + "</td>");
				pw.println("<td style=width:70px;>" + rs.getString(3) + "</td>");
				pw.println("<td>" + rs.getString(4) + "</td>");
				pw.println("</tr></table>");
				pw.println("</body></html>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
