package collage;

import java.io.IOException;
import java.io.PrintWriter;

import access.InsertOperation;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/insert")
public class InsertRecord extends GenericServlet implements Servlet{
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String s1 = req.getParameter("roll");
		String br = s1.substring(2, 5);
		PrintWriter pw = res.getWriter();
		try {
			if (br == null) {
				pw.println("null");
			} else if (br.equals("MCA")) {
				new InsertOperation(s1).insertMCAData(req,res);			
			} else if (br.equals("MSC")) {
				new InsertOperation(s1).insertMSCData(req,res);
			}else if (br.equals("BCA")) {
				new InsertOperation(s1).insertBCAData(req,res);
			}else if (br.equals("BSC")) {
					 new InsertOperation(s1).insertBSCData(req,res);
			}else {
				pw.println("Invalid Information /  RollNo type Correctely");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
