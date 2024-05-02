package collage;

import java.io.IOException;
import java.io.PrintWriter;

import access.ViewOperations;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/result")
public class Result extends GenericServlet implements Servlet {

	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String s1 = req.getParameter("name");
		String s2 = req.getParameter("roll");
		String br = s2.substring(2, 5);
		PrintWriter pw = res.getWriter();
		try {
			if (br == null) {
				pw.println("null");
			} else if (br.equals("MCA")) {
				new ViewOperations(s1,s2).getMCAData(req,res);			
			} else if (br.equals("MSC")) {
				new ViewOperations(s1,s2).getMSCData(req,res);
			}else if (br.equals("BCA")) {
				new ViewOperations(s1,s2).getBCAData(req,res);
			}else if (br.equals("BSC")) {
					 new ViewOperations(s1,s2).getBSCData(req,res);
			}else {
				pw.println("<html><body>");
				pw.println("<h2 style=color:red;>Invalid Information / Select Branch Correctely</h2>");
				RequestDispatcher rd = req.getRequestDispatcher("Result.html");
				rd.include(req, res);
				pw.println("</body></html>");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}