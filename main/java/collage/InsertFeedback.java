package collage;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import access.DataBase;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/insertfeed")
public class InsertFeedback extends GenericServlet {
	public void service(ServletRequest req, ServletResponse res) {
		try {
			Connection con = DataBase.getCon();
			PreparedStatement ptsm = con.prepareStatement("INSERT INTO FEEDBACK VALUES (?,?,?,?)");
			ptsm.setString(1, req.getParameter("name"));	
			ptsm.setString(2, req.getParameter("contact"));
			ptsm.setString(3, req.getParameter("fav"));
			ptsm.setString(4, req.getParameter("sug"));
			ptsm.executeUpdate();
			PrintWriter pw = res.getWriter();
			pw.println("<html><style>body{background-color:#020b1a;}h1,h3{color:white;}</style><body><br><br><br><br><br><br><br><br><br><br><br>");
			pw.println("<center><h3> Form Submited </h3>");
			pw.println("<h1><u> Thank You </u></h1></center>");
			pw.println("</body></html>");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
