package access;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

@SuppressWarnings("unused")
public class InsertOperation {
	Connection con;
	String s;

	public InsertOperation(String v) {
		this.s = v;
	}

	//Insert MCA Student Details.
	public void insertMCAData(ServletRequest request, ServletResponse response) {
		try {
			con = DataBase.getCon();
			PreparedStatement pstm = con.prepareStatement(DataBase.getInsert_MCA_STUDENT_Details());
			pstm.setString(1, request.getParameter("name"));
			pstm.setString(2, request.getParameter("sname"));
			pstm.setString(3, request.getParameter("roll"));
			pstm.setString(4, request.getParameter("class"));
			pstm.setString(5, request.getParameter("email"));
			pstm.setString(6, request.getParameter("java"));
			pstm.setString(7, request.getParameter("dsa"));
			pstm.setString(8, request.getParameter("oose"));
			pstm.setString(9, request.getParameter("os"));
			pstm.setString(10, request.getParameter("nt"));
			int x = pstm.executeUpdate();
			PrintWriter pw = response.getWriter();
			pw.println("<html><head><title>Data Inserted</title></head<body>");
			if(x>0) {
				pw.println("<h3>Marks Inserted for Student <u style=color:red;>" + request.getParameter("name") + "</u></h3>");
				request.getRequestDispatcher("Insert_MCA.html").include(request, response);
			}else {
				pw.println("Invalid...");
			}
			pw.println("</body></html>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Insert MSC Student Details.
	public void insertMSCData(ServletRequest request, ServletResponse response) {
		try {
			con = DataBase.getCon();
			PreparedStatement pstm = con.prepareStatement(DataBase.getInsert_MSC_STUDENT_Details());
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
				request.getRequestDispatcher("Insert_MSC.html").include(request, response);
			}else {
				pw.println("Invalid...");
			}			
			pw.println("</body></html>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Insert BCA Student Details.
	public void insertBCAData(ServletRequest request, ServletResponse response) {
		try {
			con = DataBase.getCon();
			PreparedStatement pstm = con.prepareStatement(DataBase.getInsert_BCA_STUDENT_Details());
			pstm.setString(1, request.getParameter("name"));
			pstm.setString(2, request.getParameter("sname"));
			pstm.setString(3, request.getParameter("roll"));
			pstm.setString(4, request.getParameter("class"));
			pstm.setString(5, request.getParameter("email"));
			pstm.setString(6, request.getParameter("java"));
			pstm.setString(7, request.getParameter("python"));
			pstm.setString(8, request.getParameter("eCommerce"));
			pstm.setString(9, request.getParameter("se"));
			pstm.setString(10, request.getParameter("ai"));
			int x = pstm.executeUpdate();
			PrintWriter pw = response.getWriter();
			pw.println("<html><head><title>Data Inserted</title></head<body>");
			if (x > 0) {
				pw.println("<h3>Marks Inserted for Student <u style=color:red;>" + request.getParameter("name")
						+ "</u></h3>");
				request.getRequestDispatcher("Insert_BCA.html").include(request, response);
			} else {
				pw.println("Invalid...");
			}
			pw.println("</body></html>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Insert BSC Student Details.
	public void insertBSCData(ServletRequest request, ServletResponse response) {
		try {
			con = DataBase.getCon();
			PreparedStatement pstm = con.prepareStatement(DataBase.getInsert_BSC_STUDENT_Details());
			pstm.setString(1, request.getParameter("name"));
			pstm.setString(2, request.getParameter("sname"));
			pstm.setString(3, request.getParameter("roll"));
			pstm.setString(4, request.getParameter("class"));
			pstm.setString(5, request.getParameter("email"));
			pstm.setString(6, request.getParameter("cf"));
			pstm.setString(7, request.getParameter("dbms"));
			pstm.setString(8, request.getParameter("os"));
			pstm.setString(9, request.getParameter("html"));
			pstm.setString(10, request.getParameter("nt"));
			int x = pstm.executeUpdate();
			PrintWriter pw = response.getWriter();
			pw.println("<html><head><title>Data Inserted</title></head<body>");
			if(x>0) {
				pw.println("<h3>Marks Inserted for Student <u style=color:red;>" + request.getParameter("name") + "</u></h3>");
				request.getRequestDispatcher("Insert_BSC.html").include(request, response);
			}else {
				pw.println("Invalid...");
			}			
			pw.println("</body></html>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}