package collage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/result")
public class Result extends GenericServlet implements Servlet {
	Connection con;
	PreparedStatement pstm = null;
	String sql = null;
	ResultSet rs = null;
	String s1, s2 = null;

	public void init() throws ServletException {
		con = DataBase.getCon();
	}

	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		s1 = req.getParameter("name");
		s2 = req.getParameter("roll");
		String br = s2.substring(2, 5);
		PrintWriter pw = res.getWriter();
		try {
			if (br == null) {
				pw.println("null");
			} else if (br.equals("MCA")) {
				Operations op = new Operations(s1,s2);
				op.getMCAData(res);				
			} else if (br.equals("MSC")) {
				Operations op = new Operations(s1,s2);
				op.getMSCData(res);	
			}else if (br.equals("BCA")) {
				Operations op = new Operations(s1,s2);
				op.getBCAData(res);	
			}else if (br.equals("BSC")) {
					Operations op = new Operations(s1,s2);
					op.getBSCData(res);	
			}else {
				pw.println("Invalid Information / Name & RollNo type Correctely");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}