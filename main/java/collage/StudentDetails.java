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
@WebServlet("/studetails")
public class StudentDetails extends GenericServlet{
	int i =1;
	public void service(ServletRequest req, ServletResponse res) throws IOException, ServletException {
		try {
			Connection con = DataBase.getCon();
			PreparedStatement pstm = con.prepareStatement(DataBase.getAll_Student_Details());
			ResultSet rs = pstm.executeQuery();
			PrintWriter pw = res.getWriter();
			pw.println("<html><head><style>#roll{ width:50px} td{width:250px; height:30px; background-color:rgb(111, 117, 117);  } th{ width:250px; height:40px; background-color:#30514E; color:white;}</style><title>Student Details</title></head><body bgcolor=#F1EEEA text=black><h1>");
			pw.println("<center>" + "Student Details " + "</h1></center>" + "<hr>");
			pw.println("<center><table border=0><tr>");		
			pw.println("<th id='roll'> Sr No. </th>"+"<th> Class </th>"+"<th> Student Name </th>"+"<th> Roll Number </th>"+"<th> Mail Id </th></tr></table></center>");
			while (rs.next()) {
				int srNo = i++;
				String r1 = rs.getString(1);
				String r2 = rs.getString(2);
				String r3 = rs.getString(3);
				String r4 = rs.getString(4);
				String r5 = rs.getString(5);
				pw.println("<center><table border=0>");	
				pw.println("<tr><td id='roll'> "+srNo+"</td>"+"<td> "+r4+"</td>"+"<td> "+r1+" "+r2+"</td>"+"<td> "+r3+"</td>"+"<td> "+r5+"</td></tr>");
				pw.println("</table> </center></body></html>");
			} 
			i=1;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
