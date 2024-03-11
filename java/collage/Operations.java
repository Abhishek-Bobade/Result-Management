package collage;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletResponse;

public class Operations {
	PreparedStatement pstm = null;
	ResultSet rs;
	Connection con;
	PrintWriter pw ;
	String sqlmca = "select * from MCA_STUDENT where F_NAME=? and ROLL_NO=?";
	String sqlmsc = "select * from MSC_STUDENT where F_NAME=? and ROLL_NO=?";
	String sqlbca = "select * from BCA_STUDENT where F_NAME=? and ROLL_NO=?";
	String sqlbsc = "select * from BSC_STUDENT where F_NAME=? and ROLL_NO=?";
	String s1;
	String s2;
		public Operations(String v1, String v2) {
			this.s1=v1;
			this.s2=v2;
		}
		
		
		// Showing MCA Result
		public void getMCAData(ServletResponse res) {
			
				try {
					con = DataBase.getCon();
					pstm = con.prepareStatement(sqlmca);
					pstm.setString(1, s1);
					pstm.setString(2, s2);
					rs = pstm.executeQuery();
					pw = res.getWriter();
					pw.println("<html><head><title>Result</title></head><body bgcolor=#D3D0BD text=black><h1>");
					if (rs.next()) {
						pw.println("<center>" + "Welcome " + s1 + "</center>" + "<hr>");
						String r1 = rs.getString(1);
						String r2 = rs.getString(2);
						String r3 = rs.getString(3);
						String r4 = rs.getString(4);
						String r5 = rs.getString(5);
						int r6 = Integer.parseInt(rs.getString(6));
						int r7 = Integer.parseInt(rs.getString(7));
						int r8 = Integer.parseInt(rs.getString(8));
						int r9 = Integer.parseInt(rs.getString(9));
						int r10 = Integer.parseInt(rs.getString(10));
						float Total = (r6 + r7 + r8 + r9 + r10);
						float percentage = (Total * 100 / 500);
						String finalResult =CalculateResult.finalRes(percentage, r6, r7, r8, r9, r10);
						pw.println("Personal Details:<br>");
						pw.println("<ul><li>" + "Student Name: " + r1 + " " + r2 + "<br>" + "</li>");
						pw.println("<li>" + "Roll Number: " + r3 + "<br>" + "</li>");
						pw.println("<li>" + "Class: " + r4 + "<br>" + "</li>");
						pw.println("<li>" + "Mail Id: " + r5 + "<br>" + "</li></ul>");
						pw.println("<center> Result </center><br>");
						pw.println(
								"<center><table bgcolor=#BDD5D2 border=10% bordercolor=#686B6A cellpadding=20 cellspacing=5>");
						pw.println(
								"<tr bgcolor=#98B3AF><th>Subject</th><th>Subject 1: Java</th><th>Subject 2: DSA</th><th>Subject 3: OOSE</th><th>Subject 4: OS</th><th>Subject 5: NT</th><th>Total</th><tr>");
						pw.println("<tr><th bgcolor=#98B3AF>Total Marks</th><td>" + 100 + "</td><td>" + 100 + "</td><td>"
								+ 100 + "</td><td>" + 100 + "</td><td>" + 100 + "</td><td>" + 500 + "</td><tr>");
						pw.println("<tr><th bgcolor=#98B3AF>Obtained Marks</th><td>" + r6 + "</td><td>" + r7 + "</td><td>"
								+ r8 + "</td><td>" + r9 + "</td><td>" + r10 + "</td><td>" + Total + "</td><tr>");
						pw.println("<tr><th bgcolor=#98B3AF>Percentage</th><td Colspan=2 align=center>" + percentage + "%"
								+ "</td><th bgcolor=#98B3AF>Reslut</th><td bgcolor=#52A79E Colspan=3 align=center>"
								+ finalResult + "</td><tr>");
						pw.println("</table></center>");
						pw.println("</h1></body></html>");
					} else {
						pw.println("Not Found...");
					}
				} catch (Exception e) {
					e.printStackTrace();
				} 
		}
		
		
		
		
		
		
		// Showing MSC Result
		public void getMSCData(ServletResponse res) {
			
			try {
				con = DataBase.getCon();
				pstm = con.prepareStatement(sqlmsc);
				pstm.setString(1, s1);
				pstm.setString(2, s2);
				rs = pstm.executeQuery();
				pw = res.getWriter();
				pw.println("<html><head><title>Result</title></head><body bgcolor=#D3D0BD text=black><h1>");
				if (rs.next()) {
					pw.println("<center>" + "Welcome " + s1 + "</center>" + "<hr>");
					String r1 = rs.getString(1);
					String r2 = rs.getString(2);
					String r3 = rs.getString(3);
					String r4 = rs.getString(4);
					String r5 = rs.getString(5);
					int r6 = Integer.parseInt(rs.getString(6));
					int r7 = Integer.parseInt(rs.getString(7));
					int r8 = Integer.parseInt(rs.getString(8));
					int r9 = Integer.parseInt(rs.getString(9));
					int r10 = Integer.parseInt(rs.getString(10));
					float Total = (r6 + r7 + r8 + r9 + r10);
					float percentage = (Total * 100 / 500);
					String finalResult =CalculateResult.finalRes(percentage, r6, r7, r8, r9, r10);
					pw.println("Personal Details:<br>");
					pw.println("<ul><li>" + "Student Name: " + r1 + " " + r2 + "<br>" + "</li>");
					pw.println("<li>" + "Roll Number: " + r3 + "<br>" + "</li>");
					pw.println("<li>" + "Class: " + r4 + "<br>" + "</li>");
					pw.println("<li>" + "Mail Id: " + r5 + "<br>" + "</li></ul>");
					pw.println("<center> Result </center><br>");
					pw.println(
							"<center><table bgcolor=#BDD5D2 border=10% bordercolor=#686B6A cellpadding=20 cellspacing=5>");
					pw.println(
							"<tr bgcolor=#98B3AF><th>Subject</th><th>Subject 1: Java</th><th>Subject 2: CN</th><th>Subject 3: DAO</th><th>Subject 4: DS</th><th>Subject 5: OS</th><th>Total</th><tr>");
					pw.println("<tr><th bgcolor=#98B3AF>Total Marks</th><td>" + 100 + "</td><td>" + 100 + "</td><td>"
							+ 100 + "</td><td>" + 100 + "</td><td>" + 100 + "</td><td>" + 500 + "</td><tr>");
					pw.println("<tr><th bgcolor=#98B3AF>Obtained Marks</th><td>" + r6 + "</td><td>" + r7 + "</td><td>"
							+ r8 + "</td><td>" + r9 + "</td><td>" + r10 + "</td><td>" + Total + "</td><tr>");
					pw.println("<tr><th bgcolor=#98B3AF>Percentage</th><td Colspan=2 align=center>" + percentage + "%"
							+ "</td><th bgcolor=#98B3AF>Reslut</th><td bgcolor=#52A79E Colspan=3 align=center>"
							+ finalResult + "</td><tr>");
					pw.println("</table></center>");
					pw.println("</h1></body></html>");
				} else {
					pw.println("Not Found... MSC data");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
	}
		
		
		// Showing BCA Result
		public void getBCAData(ServletResponse res) {
			
			try {
				con = DataBase.getCon();
				pstm = con.prepareStatement(sqlbca);
				pstm.setString(1, s1);
				pstm.setString(2, s2);
				rs = pstm.executeQuery();
				pw = res.getWriter();
				pw.println("<html><head><title>Result</title></head><body bgcolor=#D3D0BD text=black><h1>");
				if (rs.next()) {
					pw.println("<center>" + "Welcome " + s1 + "</center>" + "<hr>");
					String r1 = rs.getString(1);
					String r2 = rs.getString(2);
					String r3 = rs.getString(3);
					String r4 = rs.getString(4);
					String r5 = rs.getString(5);
					int r6 = Integer.parseInt(rs.getString(6));
					int r7 = Integer.parseInt(rs.getString(7));
					int r8 = Integer.parseInt(rs.getString(8));
					int r9 = Integer.parseInt(rs.getString(9));
					int r10 = Integer.parseInt(rs.getString(10));
					float Total = (r6 + r7 + r8 + r9 + r10);
					float percentage = (Total * 100 / 500);
					String finalResult =CalculateResult.finalRes(percentage, r6, r7, r8, r9, r10);
					pw.println("Personal Details:<br>");
					pw.println("<ul><li>" + "Student Name: " + r1 + " " + r2 + "<br>" + "</li>");
					pw.println("<li>" + "Roll Number: " + r3 + "<br>" + "</li>");
					pw.println("<li>" + "Class: " + r4 + "<br>" + "</li>");
					pw.println("<li>" + "Mail Id: " + r5 + "<br>" + "</li></ul>");
					pw.println("<center> Result </center><br>");
					pw.println(
							"<center><table bgcolor=#BDD5D2 border=10% bordercolor=#686B6A cellpadding=20 cellspacing=5>");
					pw.println(
							"<tr bgcolor=#98B3AF><th>Subject</th><th>Subject 1: Java</th><th>Subject 2: Python</th><th>Subject 3: eCom</th><th>Subject 4: SE</th><th>Subject 5: AI</th><th>Total</th><tr>");
					pw.println("<tr><th bgcolor=#98B3AF>Total Marks</th><td>" + 100 + "</td><td>" + 100 + "</td><td>"
							+ 100 + "</td><td>" + 100 + "</td><td>" + 100 + "</td><td>" + 500 + "</td><tr>");
					pw.println("<tr><th bgcolor=#98B3AF>Obtained Marks</th><td>" + r6 + "</td><td>" + r7 + "</td><td>"
							+ r8 + "</td><td>" + r9 + "</td><td>" + r10 + "</td><td>" + Total + "</td><tr>");
					pw.println("<tr><th bgcolor=#98B3AF>Percentage</th><td Colspan=2 align=center>" + percentage + "%"
							+ "</td><th bgcolor=#98B3AF>Reslut</th><td bgcolor=#52A79E Colspan=3 align=center>"
							+ finalResult + "</td><tr>");
					pw.println("</table></center>");
					pw.println("</h1></body></html>");
				} else {
					pw.println("Not Found...");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
	}
		
		
		
		// Showing BSC Result
		public void getBSCData(ServletResponse res) {
			
			try {
				con = DataBase.getCon();
				pstm = con.prepareStatement(sqlbsc);
				pstm.setString(1, s1);
				pstm.setString(2, s2);
				rs = pstm.executeQuery();
				pw = res.getWriter();
				pw.println("<html><head><title>Result</title></head><body bgcolor=#D3D0BD text=black><h1>");
				if (rs.next()) {
					pw.println("<center>" + "Welcome " + s1 + "</center>" + "<hr>");
					String r1 = rs.getString(1);
					String r2 = rs.getString(2);
					String r3 = rs.getString(3);
					String r4 = rs.getString(4);
					String r5 = rs.getString(5);
					int r6 = Integer.parseInt(rs.getString(6));
					int r7 = Integer.parseInt(rs.getString(7));
					int r8 = Integer.parseInt(rs.getString(8));
					int r9 = Integer.parseInt(rs.getString(9));
					int r10 = Integer.parseInt(rs.getString(10));
					float Total = (r6 + r7 + r8 + r9 + r10);
					float percentage = (Total * 100 / 500);
					String finalResult =CalculateResult.finalRes(percentage, r6, r7, r8, r9, r10);
					pw.println("Personal Details:<br>");
					pw.println("<ul><li>" + "Student Name: " + r1 + " " + r2 + "<br>" + "</li>");
					pw.println("<li>" + "Roll Number: " + r3 + "<br>" + "</li>");
					pw.println("<li>" + "Class: " + r4 + "<br>" + "</li>");
					pw.println("<li>" + "Mail Id: " + r5 + "<br>" + "</li></ul>");
					pw.println("<center> Result </center><br>");
					pw.println(
							"<center><table bgcolor=#BDD5D2 border=10% bordercolor=#686B6A cellpadding=20 cellspacing=5>");
					pw.println(
							"<tr bgcolor=#98B3AF><th>Subject</th><th>Subject 1: CF</th><th>Subject 2: DBMS</th><th>Subject 3: OS</th><th>Subject 4: HTML</th><th>Subject 5: NT</th><th>Total</th><tr>");
					pw.println("<tr><th bgcolor=#98B3AF>Total Marks</th><td>" + 100 + "</td><td>" + 100 + "</td><td>"
							+ 100 + "</td><td>" + 100 + "</td><td>" + 100 + "</td><td>" + 500 + "</td><tr>");
					pw.println("<tr><th bgcolor=#98B3AF>Obtained Marks</th><td>" + r6 + "</td><td>" + r7 + "</td><td>"
							+ r8 + "</td><td>" + r9 + "</td><td>" + r10 + "</td><td>" + Total + "</td><tr>");
					pw.println("<tr><th bgcolor=#98B3AF>Percentage</th><td Colspan=2 align=center>" + percentage + "%"
							+ "</td><th bgcolor=#98B3AF>Reslut</th><td bgcolor=#52A79E Colspan=3 align=center>"
							+ finalResult + "</td><tr>");
					pw.println("</table></center>");
					pw.println("</h1></body></html>");
				} else {
					pw.println("Not Found...");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
	}
}
