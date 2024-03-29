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
@SuppressWarnings("serial")
@WebServlet("/resultbca")
public class ResultBCA extends GenericServlet {
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		try {
			Connection con = DataBase.getCon();
			PreparedStatement pstm = con.prepareStatement("select * from BCA_STUDENT ORDER BY Roll_No");
			ResultSet rs = pstm.executeQuery();
			PrintWriter pw = res.getWriter();
			pw.println("<html><head><title>BCA Result</title>");
			pw.println("<style> td{ width:100px;}#td1{width:250px;}</style>");
			pw.println("</head><body bgcolor=#6d756f text=black>");
			pw.println("<center><h1>" + "Student Details of BCA" + "</h1><h1 style=color:white;>Dashboard</h1></center><hr><br>");
			pw.println("<table border=0> <tr style=color:red;>");
			pw.println("<td> Name </td>");
			pw.println("<td> Surname </td>");
			pw.println("<td> Roll No </td>");
			pw.println("<td> Class </td>");
			pw.println("<td id='td1'> Mail-Id </td>");
			pw.println("<td> Java </td>");
			pw.println("<td> Python </td>");
			pw.println("<td> eCommerce </td>");
			pw.println("<td> Software Engineering </td>");
			pw.println("<td> Artificial Intiligence </td>");
			pw.println("</tr></table><hr>");
			while (rs.next()) {
				pw.println("<table border=0> <tr>");
				pw.println("<td>" + rs.getString(1) + "</td>");
				pw.println("<td>" + rs.getString(2) + "</td>");
				pw.println("<td>" + rs.getString(3) + "</td>");
				pw.println("<td>" + rs.getString(4) + "</td>");
				pw.println("<td id='td1'>" + rs.getString(5) + "</td>");
				pw.println("<td>" + Integer.parseInt(rs.getString(6)) + "</td>");
				pw.println("<td>" + Integer.parseInt(rs.getString(7)) + "</td>");
				pw.println("<td>" + Integer.parseInt(rs.getString(8)) + "</td>");
				pw.println("<td>" + Integer.parseInt(rs.getString(9)) + "</td>");
				pw.println("<td>" + Integer.parseInt(rs.getString(10)) + "</td>");
				pw.println("</tr></table>");
				pw.println("</body></html>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}