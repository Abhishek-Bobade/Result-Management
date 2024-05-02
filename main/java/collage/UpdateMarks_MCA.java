package collage;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import access.DataBase;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/upmarksmca")
public class UpdateMarks_MCA extends GenericServlet {
	Connection con;

	public void service(ServletRequest req, ServletResponse res) {
		try {
			HttpServletRequest request = (HttpServletRequest)req;
			HttpSession session = request.getSession();
			String value = (String) session.getAttribute("key");
			con = DataBase.getCon();
			PreparedStatement ptsm = con.prepareStatement(DataBase.getUpdate_MCA_STUDENT_Details());
			ptsm.setString(1, req.getParameter("java"));
			ptsm.setString(2, req.getParameter("dsa"));
			ptsm.setString(3, req.getParameter("oose"));
			ptsm.setString(4, req.getParameter("os"));
			ptsm.setString(5, req.getParameter("nt"));
			ptsm.setString(6, value);
			int x = ptsm.executeUpdate();
			PrintWriter pw = res.getWriter();
			pw.println("<html><body>");
			if (x > 0) {
				pw.println("<h3> Marks Updated for <u style=color:#3CB41B;>" +  value + "</u></h3>");
				req.getRequestDispatcher("Update_MCA.html").include(req, res);
			} else {
				pw.println("<h3> Error for <u style=color:red;>" + value+ "</u></h3>");
				req.getRequestDispatcher("Update_MCA.html").include(req, res);
			}
			pw.println("</body></html>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}