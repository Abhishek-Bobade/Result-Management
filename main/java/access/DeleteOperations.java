package access;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class DeleteOperations {
	Connection con;
	PreparedStatement pstm;
	PrintWriter pw;
	String roll;

	public DeleteOperations(String v) {
		this.roll = v;
	}
	// Delete MCA Student record By Roll Number
	public void delMCAData(ServletRequest req, ServletResponse res) {
		try {
			con = DataBase.getCon();
			pstm = con.prepareStatement(DataBase.getDelete_MCA_STUDENT_Details());
			pstm.setString(1, roll);
			int rs = pstm.executeUpdate();
			pw = res.getWriter();
			if (rs > 0) {
				pw.println("<html><body>");
				pw.println("<h3> Record Deleted For <u style=color:#3CB41B;>" + roll + "</u></h3>");
				req.getRequestDispatcher("Delete_MCA.html").include(req, res);
				pw.println("</body></html>");
			} else {
				pw.println("<html><body>");
				pw.println("<h3> Not Found <u style=color:red;>" + roll + "</u></h3> ");
				req.getRequestDispatcher("Delete_MCA.html").include(req, res);
				pw.println("</body></html>");
			}
		} catch (SQLException | IOException | ServletException e) {
			e.printStackTrace();
		}
	}

	// Delete MSC Student record By Roll Number
	public void delMSCData(ServletRequest req, ServletResponse res) {
		try {
			con = DataBase.getCon();
			pstm = con.prepareStatement(DataBase.getDelete_MSC_STUDENT_Details());
			pstm.setString(1, roll);
			int rs = pstm.executeUpdate();
			pw = res.getWriter();
			if (rs > 0) {
				pw.println("<html><body>");
				pw.println("<h3> Record Deleted For <u style=color:#3CB41B;>" + roll + "</u></h3>");
				req.getRequestDispatcher("Delete_MSC.html").include(req, res);
				pw.println("</body></html>");
			} else {
				pw.println("<html><body>");
				pw.println("<h3> Not Found <u style=color:red;>" + roll + "</u></h3> ");
				req.getRequestDispatcher("Delete_MSC.html").include(req, res);
				pw.println("</body></html>");
			}
		} catch (SQLException | IOException | ServletException e) {
			e.printStackTrace();
		}
	}

	// Delete BCA Student record By Roll Number
	public void delBCAData(ServletRequest req, ServletResponse res) {
		try {
			con = DataBase.getCon();
			pstm = con.prepareStatement(DataBase.getDelete_BCA_STUDENT_Details());
			pstm.setString(1, roll);
			int rs = pstm.executeUpdate();
			pw = res.getWriter();
			if (rs > 0) {
				pw.println("<html><body>");
				pw.println("<h3> Record Deleted For <u style=color:#3CB41B;>" + roll + "</u></h3>");
				req.getRequestDispatcher("Delete_BCA.html").include(req, res);
				pw.println("</body></html>");
			} else {
				pw.println("<html><body>");
				pw.println("<h3> Not Found <u style=color:red;>" + roll + "</u></h3> ");
				req.getRequestDispatcher("Delete_BCA.html").include(req, res);
				pw.println("</body></html>");
			}
		} catch (SQLException | IOException | ServletException e) {
			e.printStackTrace();
		}
	}

	// Delete BSC Student record By Roll Number
	public void delBSCData(ServletRequest req, ServletResponse res) {
		try {
			con = DataBase.getCon();
			pstm = con.prepareStatement(DataBase.getDelete_BSC_STUDENT_Details());
			pstm.setString(1, roll);
			int rs = pstm.executeUpdate();
			pw = res.getWriter();
			if (rs > 0) {
				pw.println("<html><body>");
				pw.println("<h3> Record Deleted For <u style=color:#3CB41B;>" + roll + "</u></h3>");
				req.getRequestDispatcher("Delete_BSC.html").include(req, res);
				pw.println("</body></html>");
			} else {
				pw.println("<html><body>");
				pw.println("<h3> Not Found <u style=color:red;>" + roll + "</u></h3> ");
				req.getRequestDispatcher("Delete_BSC.html").include(req, res);
				pw.println("</body></html>");
			}
		} catch (SQLException | IOException | ServletException e) {
			e.printStackTrace();
		}
	}

}