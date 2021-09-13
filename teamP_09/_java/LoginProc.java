package teamP_09;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginProc
 */
@WebServlet("/LoginProc.do")
public class LoginProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginProc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		reqPro(request,response);
	}
	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService service = new MemberService();
	    Member m;
		String page="";
		
		//1. 요청
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		m=service.getMember(id);

		if(m.getMemnum().equals("0") || !pass.equals(m.getPw())) {
			//아이디 없음 or 비밀번호 다름
				response.setContentType("text/html; charset=UTF-8"); 
				PrintWriter writer = response.getWriter(); 
				writer.println("<script>alert('로그인 실패!<br>아이디와 비밀번호를 확인하세요.'); location.href='javascript:history.back();'</script>"); 
				writer.close();
		}else {
			//로그인 성공
			SessionMember sm = new SessionMember();
			sm.setId(m.getId());
			sm.setMemNum(m.getMemnum());
			sm.setName(m.getName());
			HttpSession session = request.getSession();
			session.setAttribute("login", sm);
			
				//request.setAttribute("member", service.getMember(id));
			
		
		}
		
		
	
		RequestDispatcher dis = request.getRequestDispatcher("teamP_09\\game\\game.jsp");
		dis.forward(request, response);
		//index.do 생기면 request.sendRedirect("index.do") 이걸로 바꿔야함
		
	}

}
