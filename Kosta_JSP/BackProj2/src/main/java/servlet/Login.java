package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Member;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		
		RequestDispatcher dispatcher = null;
		if (member != null) {
			if(member.getId().equals(id)) {// 로그인 정상처리
				if(member.getPassword().equals(password)) {// 로그인 정상처리
					request.setAttribute("id", id);
					session.setAttribute("id", id); // 세션에 아이디 값을 저장
					dispatcher = request.getRequestDispatcher("makeAccount.jsp");
				} else { // 비밀번호 오류
					request.setAttribute("err", "비밀번호가 틀립니다");
					dispatcher = request.getRequestDispatcher("error.jsp");
				}
			} else { // 회원가입하지 않음
				request.setAttribute("err", "아이디가 틀립니다.");
				dispatcher = request.getRequestDispatcher("error.jsp");
			}
		} else { // 회원가입 하지 않음
			request.setAttribute("err", "회원가입을 해주세요.");
			dispatcher = request.getRequestDispatcher("error.jsp");
		}
		dispatcher.forward(request, response);
	}

}
