package access;

import java.sql.Connection;
import java.sql.DriverManager;

//DataBase Connection for entire Project
public class DataBase {
	private static Connection con = null; // Connection variable.
	private static final String FEEDBACK = "SELECT * FROM FEEDBACK"; // Showing feedback from database.
	private static final String INSERT_FEEDBACK = "INSERT INTO FEEDBACK VALUES (?,?,?,?)"; //Insert Feedback details on Database.
	private static final String BCA_STUDENT = "SELECT * FROM BCA_STUDENT ORDER BY Roll_No"; // Showing all student details in BCA
	private static final String BSC_STUDENT = "SELECT * FROM BSC_STUDENT ORDER BY Roll_No"; // Showing all student details in BSC
	private static final String MCA_STUDENT = "SELECT * FROM MCA_STUDENT ORDER BY Roll_No"; // Showing all student details in MCA
	private static final String MSC_STUDENT = "SELECT * FROM MSC_STUDENT ORDER BY Roll_No"; // Showing all student details in MSC
	private static final String ALL_STUDENT_DETAILS = "SELECT * FROM MCA_Student UNION ALL "
																								  + "SELECT * FROM MSC_Student UNION ALL "
																								  + "SELECT * FROM BCA_Student UNION ALL "
																								  + "SELECT * FROM BSC_Student"; // Showing all student
	private static final String Update_BCA_STUDENT = "SELECT * FROM BCA_STUDENT WHERE ROLL_NO=?"; //Getting data for edit
	private static final String Update_BSC_STUDENT =  "SELECT * FROM BSC_STUDENT WHERE ROLL_NO=?"; //Getting data for edit
	private static final String Update_MCA_STUDENT =  "SELECT * FROM MCA_STUDENT WHERE ROLL_NO=?"; //Getting data for edit
	private static final String Update_MSC_STUDENT =  "SELECT * FROM MSC_STUDENT WHERE ROLL_NO=?"; //Getting data for edit
	private static final String Update_BCA_STUDENT_Details = "UPDATE BCA_STUDENT SET JAVA=?,PYTHON=?,ECOMMERCE=?,SE=?,AI=? WHERE ROLL_NO=?"; //Update BCA Student Marks
	private static final String Update_BSC_STUDENT_Details =  "UPDATE BSC_STUDENT SET CF=?,DBMS=?,OS=?,HTML=?,NETWORKING=? WHERE ROLL_NO=?"; //Update BSC Student Marks
	private static final String Update_MCA_STUDENT_Details =  "UPDATE MCA_STUDENT SET JAVA=?,DSA=?,OOSE=?,OS=?,NT=? WHERE ROLL_NO=?"; //Update MCA Student Marks
	private static final String Update_MSC_STUDENT_Details =  "UPDATE MSC_STUDENT SET JAVA=?,CN=?,DAO=?,DS=?,OS=? WHERE ROLL_NO=?"; //Update MSC Student Marks
	private static final String Delete_MCA_STUDENT_Details = "Delete From MCA_STUDENT WHERE ROLL_NO=?";  //Delete MCA Student Record
	private static final String Delete_MSC_STUDENT_Details = "Delete From MSC_STUDENT WHERE ROLL_NO=?";  //Delete MSC Student Record
	private static final String Delete_BCA_STUDENT_Details = "Delete From BCA_STUDENT WHERE ROLL_NO=?";  //Delete BCA Student Record
	private static final String Delete_BSC_STUDENT_Details = "Delete From BSC_STUDENT WHERE ROLL_NO=?";  //Delete BSC Student Record
	private static final String Insert_MCA_STUDENT_Details = "INSERT INTO MCA_STUDENT VALUES(?,?,?,?,?,?,?,?,?,?)"; //Insert MCA Student Record.
	private static final String Insert_MSC_STUDENT_Details = "INSERT INTO MSC_STUDENT VALUES(?,?,?,?,?,?,?,?,?,?)"; //Insert MSC Student Record.
	private static final String Insert_BCA_STUDENT_Details = "INSERT INTO BCA_STUDENT VALUES(?,?,?,?,?,?,?,?,?,?)"; //Insert BCA Student Record.
	private static final String Insert_BSC_STUDENT_Details = "INSERT INTO BSC_STUDENT VALUES(?,?,?,?,?,?,?,?,?,?)"; //Insert BSC Student Record.
	private static final String VIEW_MCA_STUDENT_Details = "SELECT * FROM MCA_STUDENT WHERE F_NAME=? AND ROLL_NO=?"; //View MCA Student Record.
	private static final String VIEW_MSC_STUDENT_Details = "SELECT * FROM MSC_STUDENT WHERE F_NAME=? AND ROLL_NO=?"; //View MSC Student Record.
	private static final String VIEW_BCA_STUDENT_Details = "SELECT * FROM BCA_STUDENT WHERE F_NAME=? AND ROLL_NO=?"; //View BCA Student Record.
	private static final String VIEW_BSC_STUDENT_Details = "SELECT * FROM BSC_STUDENT WHERE F_NAME=? AND ROLL_NO=?"; //View BSC Student Record.

	private DataBase() {	}

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // Loading class..
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "tiger"); // Initializing connection "con" Object.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getCon() {
		return con;
	}
	public static String getFeedback() {
		return FEEDBACK;
	}
	public static String insertFeedback() {
		return INSERT_FEEDBACK;
	}
	public static String getBCA_STUDENT() {
		return BCA_STUDENT;
	}
	public static String getBSC_STUDENT() {
		return BSC_STUDENT;
	}
	public static String getMCA_STUDENT() {
		return MCA_STUDENT;
	}
	public static String getMSC_STUDENT() {
		return MSC_STUDENT;
	}
	public static String getAll_Student_Details() {
		return ALL_STUDENT_DETAILS;
	}
	public static String getUpdate_BCA_STUDENT() {
		return Update_BCA_STUDENT;
	}
	public static String getUpdate_BSC_STUDENT() {
		return Update_BSC_STUDENT;
	}
	public static String getUpdate_MCA_STUDENT() {
		return Update_MCA_STUDENT;
	}
	public static String getUpdate_MSC_STUDENT() {
		return Update_MSC_STUDENT;
	}
	public static String getUpdate_BCA_STUDENT_Details() {
		return Update_BCA_STUDENT_Details;
	}
	public static String getUpdate_BSC_STUDENT_Details() {
		return Update_BSC_STUDENT_Details;
	}
	public static String getUpdate_MCA_STUDENT_Details() {
		return Update_MCA_STUDENT_Details;
	}
	public static String getUpdate_MSC_STUDENT_Details() {
		return Update_MSC_STUDENT_Details;
	}
	public static String getDelete_MCA_STUDENT_Details() {
		return Delete_MCA_STUDENT_Details;
	}
	public static String getDelete_MSC_STUDENT_Details() {
		return Delete_MSC_STUDENT_Details;
	}
	public static String getDelete_BCA_STUDENT_Details() {
		return Delete_BCA_STUDENT_Details;
	}
	public static String getDelete_BSC_STUDENT_Details() {
		return Delete_BSC_STUDENT_Details;
	}
	public static String getInsert_MCA_STUDENT_Details() {
		return Insert_MCA_STUDENT_Details;
	}
	public static String getInsert_MSC_STUDENT_Details() {
		return Insert_MSC_STUDENT_Details;
	}
	public static String getInsert_BCA_STUDENT_Details() {
		return Insert_BCA_STUDENT_Details;
	}
	public static String getInsert_BSC_STUDENT_Details() {
		return Insert_BSC_STUDENT_Details;
	}
	public static String getVIEW_MCA_STUDENT_Details() {
		return VIEW_MCA_STUDENT_Details;
	}
	public static String getVIEW_MSC_STUDENT_Details() {
		return VIEW_MSC_STUDENT_Details;
	}
	public static String getVIEW_BCA_STUDENT_Details() {
		return VIEW_BCA_STUDENT_Details;
	}
	public static String getVIEW_BSC_STUDENT_Details() {
		return VIEW_BSC_STUDENT_Details;
	}
}