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
@WebServlet("/upmarksbca")
public class UpdateMarks_BCA extends GenericServlet {
	Connection con;

	public void service(ServletRequest req, ServletResponse res) {
		try {
			HttpServletRequest request = (HttpServletRequest)req;
			HttpSession session = request.getSession();
			String value = (String) session.getAttribute("key");
			con = DataBase.getCon();
			PreparedStatement ptsm = con
					.prepareStatement("UPDATE BCA_STUDENT SET JAVA=?,PYTHON=?,ECOMMERCE=?,SE=?,AI=? WHERE ROLL_NO=?");
			ptsm.setString(1, req.getParameter("java"));
			ptsm.setString(2, req.getParameter("python"));
			ptsm.setString(3, req.getParameter("eCommerce"));
			ptsm.setString(4, req.getParameter("se"));
			ptsm.setString(5, req.getParameter("ai"));
			ptsm.setString(6, value);
			int x = ptsm.executeUpdate();
			PrintWriter pw = res.getWriter();
			pw.println("<html><body>");
			if (x > 0) {
				pw.println("<h3> Marks Updated for <u style=color:#3CB41B;>" +  value + "</u></h3>");
				req.getRequestDispatcher("Update_BCA.html").include(req, res);
			} else {
				pw.println("<h3> Error for <u style=color:red;>" + value+ "</u></h3>");
				 req.getRequestDispatcher("Update_BCA.html").include(req, res);
			}
			pw.println("</body></html>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
