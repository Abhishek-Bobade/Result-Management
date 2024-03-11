package collage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
@WebServlet("/insertmsc")
public class InsertDataMSC extends GenericServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	Connection con;

	public void init() throws ServletException{
		con = DataBase.getCon();
}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		try {
			PreparedStatement pstm = con.prepareStatement("insert into MSC_STUDENT values(?,?,?,?,?,?,?,?,?,?)");
			pstm.setString(1, request.getParameter("name"));
			pstm.setString(2, request.getParameter("sname"));
			pstm.setString(3, request.getParameter("roll"));
			pstm.setString(4, request.getParameter("class"));
			pstm.setString(5, request.getParameter("email"));
			pstm.setString(6, request.getParameter("java"));
			pstm.setString(7, request.getParameter("cn"));
			pstm.setString(8, request.getParameter("dao"));
			pstm.setString(9, request.getParameter("ds"));
			pstm.setString(10, request.getParameter("os"));
			int x = pstm.executeUpdate();
			PrintWriter pw = response.getWriter();
			pw.println("<html><head><title>Data Inserted</title></head<body>");
			if(x>0) {
				pw.println("<h3>Marks Inserted for Student <u style=color:red;>" + request.getParameter("name") + "</u></h3>");
				RequestDispatcher rd = request.getRequestDispatcher("Insert_MSC.html");
				rd.include(request, response);
			}else {
				pw.println("Invalid...");
			}			
			pw.println("</body></html>");
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

}
