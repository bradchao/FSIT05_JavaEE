package tw.brad;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Brad01")
public class Brad01 extends HttpServlet {
	private static int a; 
	private int b; 
	
    public Brad01() {
    	System.out.println("Brad01()");
    }

	protected void doGet(
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		System.out.println("doGet()");
		
		PrintWriter pw = response.getWriter();
		pw.append("Hello, World<br>");
		pw.append("a = " + a++ + "<br>");
		pw.append("b = " + b++ + "<br>");
		pw.flush();
		
//		response.getWriter()
//			.append("Served @: ")
//			.append(request.getContextPath());
		
	}
}
