package a02_mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class calcu
 */
@WebServlet(name="calcu.do", urlPatterns= {"/calcu.do"})
public class A20_MVC_Calcu extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private int num01, num02, cal;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A20_MVC_Calcu() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	public int getNum01() {
		return num01;
	}

	public int getNum02() {
		return num02;
	}
	
	public int getCal() {
		return cal;
	}

	public void setCal(int cal) {
		this.cal = cal;
	}

	public void setNum01(int num01) {
		this.num01 = num01;
	}

	public void setNum02(int num02) {
		this.num02 = num02;
	}

	public int plus() {
		return num01+num02;
	}
	
	public int minus() {
		return num01-num02;
	}
	
	public int multi() {
		return num01*num02;
	}
	
	public int div() {
		return num01/num02;
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 요청값 처리
		String num01S = request.getParameter("num01");
		String num02S = request.getParameter("num02");
		String calS = request.getParameter("cal");
		//2. 모델 처리
		if(num01S != null) {
			setNum01(Integer.parseInt(num01S));
			setNum02(Integer.parseInt(num02S));
			setCal(Integer.parseInt(calS));
			String calSign[] = {"+", "-", "*", "/"};
			int result[] = {plus(), minus(), multi(), div()};
			
			request.setAttribute("calSign", calSign[cal]);
			request.setAttribute("result", result[cal]);
		}
		
		//3. view단 호출
		String page = "a14_mvc\\a01_basic.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
		
		
		
	}

}
