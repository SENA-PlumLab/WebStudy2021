package a02_mvc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Test
 */
@WebServlet(name="test.do", urlPatterns={"/test.do"})
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * Default constructor.
     */
	
	//왜 에러가 날까요..???????????????????????????????????
    public Test() {
        //super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<h1>이클립스로 서블릿 만들기</h1>");
	}

}
