package tw.brad;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/Brad11")
@MultipartConfig
public class Brad11 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		String uploadPath = context.getInitParameter("upload-dir");
		System.out.println(uploadPath);
		
		Part upload = request.getPart("upload");
		Collection<String> headerNames = upload.getHeaderNames();
		for(String name : headerNames) {
			String value = upload.getHeader(name);
			System.out.println(name + " : " + value);
		}
		System.out.println("---");
		long size = upload.getSize();
		System.out.println("len = " + size);
		String fname = upload.getSubmittedFileName();
		System.out.println(fname);
		
		String status = "";
		
		InputStream in = upload.getInputStream();
		BufferedInputStream bin = 
				new BufferedInputStream(in);
		byte[] buf = in.readAllBytes();
		bin.close();
		try {
			FileOutputStream fout = 
				new FileOutputStream(new File(uploadPath, fname));
			fout.write(buf);
			fout.flush();
			fout.close();
			status = "OK";
		}catch(Exception e) {
			System.out.println(e);
			status = e.toString();
		}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.append("Status: " + status);
		
		
	}
}
