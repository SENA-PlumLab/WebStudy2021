package teamP_09;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberJoinProc
 */
@WebServlet("/JoinProc.do")
public class MemberJoinProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberJoinProc() {
        super();
        // TODO Auto-generated constructor stub
    }


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
		Member mBean = new Member();
		mBean.setId(request.getParameter("id"));
		mBean.setPw(request.getParameter("pass"));
		mBean.setName(request.getParameter("name"));
		mBean.setMail(request.getParameter("email"));
		mBean.setBirth(request.getParameter("birth"));
		mBean.setTel(request.getParameter("mobile"));
		
		//DB객체 선언 후 저장
		MemberDao mDao = new MemberDao();
		mDao.joinMember(mBean);
		
		RequestDispatcher dis = request.getRequestDispatcher("teamP_09\\game\\game.jsp");
		dis.forward(request, response);
		//index.do 생기면 request.sendRedirect("index.do") 이걸로 바꿔야함

	}

}
