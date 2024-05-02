package access;
//Calculating result based on Percentage
public class CalculateResult {
	
	// Method returns Result
	static String  finalRes(float per, float a1, float a2, float a3, float a4, float a5) {
		if ((per >= 70 && per <= 100) && (a1 >= 35) && (a2 >= 35) && (a3 >= 35) && (a4 >= 35) && (a5 >= 35)) {
			return "PASS (Distinction)";
		} else if ((per >= 60 && per < 70) && (a1 >= 35) && (a2 >= 35) && (a3 >= 35) && (a4 >= 35) && (a5 >= 35)) {
			return "PASS (First Class)";
		} else if ((per >= 50 && per < 60) && (a1 >= 35) && (a2 >= 35) && (a3 >= 35) && (a4 >= 35) && (a5 >= 35)) {
			return "PASS (Second Class)";
		} else if ((per >= 35 && per < 50) && (a1 >= 35) && (a2 >= 35) && (a3 >= 35) && (a4 >= 35) && (a5 >= 35)) {
			return "PASS (Third Class)";
		} else {
			return "FAIL";
		}
	}
}