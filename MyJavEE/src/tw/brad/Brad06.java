package tw.brad;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Brad06")
public class Brad06 extends HttpServlet {
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		int intX = 0;
		try {
			intX = Integer.parseInt(x);
		}catch(NumberFormatException e) {
		}
		int intY = 0;
		try {
			intY = Integer.parseInt(y);
		}catch(NumberFormatException e) {
		}
		
		int intResult = intX + intY;
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.append(intX + " + " + intY + " = " + intResult);
		writer.flush();
	
	}
}
