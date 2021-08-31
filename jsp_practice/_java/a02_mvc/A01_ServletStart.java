package a02_mvc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class A01_ServletStart
 */
@WebServlet(name = "start.do", urlPatterns = { "/start.do" })
public class A01_ServletStart extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
	
	
    public A01_ServletStart() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		PrintWriter out = response.getWriter();
		out.print("<h2 align='center'>Hello servlet</h2>");
		/*
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		boolean isSuccess=false;
		if(id!=null && id.equals("himan")) {
			if(pass!=null && pass.equals("7777")) {
				isSuccess=true;
			}
		}
		
		if(isSuccess) {
			//request.setAttribute("성공");
		}
		else {
			//request.setAttribute("실패");
		}
		*/	
	}

}
