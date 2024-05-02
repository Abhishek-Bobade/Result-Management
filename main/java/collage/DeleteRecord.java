package collage;

import java.io.IOException;
import java.io.PrintWriter;

import access.DeleteOperations;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/delete")
public class DeleteRecord extends GenericServlet implements Servlet {

	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String s1 = req.getParameter("roll");
		String br = s1.substring(2, 5);
		PrintWriter pw = res.getWriter();
		try {
			if (br == null) {
				pw.println("null");
			} else if (br.equals("MCA")) {
				new DeleteOperations(s1).delMCAData(req,res);			
			} else if (br.equals("MSC")) {
				new DeleteOperations(s1).delMSCData(req,res);
			}else if (br.equals("BCA")) {
				new DeleteOperations(s1).delBCAData(req,res);
			}else if (br.equals("BSC")) {
					 new DeleteOperations(s1).delBSCData(req,res);
			}else {
				pw.println("Invalid Information /  RollNo type Correctely");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}