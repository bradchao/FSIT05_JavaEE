package tw.brad;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Brad07")
public class Brad07 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		String op = request.getParameter("op");
		String ret = "";
		boolean isInit = true;
		
		int intX = 0;
		try {
			intX = Integer.parseInt(x);
			isInit = false;
		}catch(NumberFormatException e) {
			x = "";
		}
		int intY = 0;
		try {
			intY = Integer.parseInt(y);
		}catch(NumberFormatException e) {
			y = "";
		}
		
		
		ret = "";
		
		if (!isInit) {
			int intResult = 0;
			switch(op) {
				case "1": intResult = intX + intY; break;
				case "2": intResult = intX - intY; break;
				case "3": intResult = intX * intY; break;
				case "4": intResult = intX / intY; break;
			}
			ret += intResult;
		}else {
			op = "";
		}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		writer.append("<form action='Brad07'>");
		writer.append("<input name='x' value='" + x + "'>");
		writer.append(" <select name='op'> ");
		writer.append("<option value='1' " + (op.equals("1")?"selected":"") + ">+</option>");
		writer.append("<option value='2' " + (op.equals("2")?"selected":"") + ">-</option>");
		writer.append("<option value='3' " + (op.equals("3")?"selected":"") + ">x</option>");
		writer.append("<option value='4' " + (op.equals("3")?"selected":"") + ">/</option>");
		writer.append("</select> ");
		writer.append("<input name='y' value='" + y + "'> ");
		writer.append("<input type='submit' value='='>");
		writer.append(" " + ret);
	
		writer.flush();
	
	}
}
