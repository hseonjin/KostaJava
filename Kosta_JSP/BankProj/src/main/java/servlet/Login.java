package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Account;
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
		if (member != null) {
			if(member.getId().equals(id)) {// 로그인 정상처리
				if(member.getPassword().equals(password)) {// 로그인 정상처리
					request.setAttribute("id", id);
					request.setAttribute("page", "makeAccount");
				} else { // 비밀번호 오류
					request.setAttribute("err", "비밀번호가 틀립니다");
					request.setAttribute("page", "error");
				}
			} else { // 회원가입하지 않음
				request.setAttribute("err", "아이디가 틀립니다.");
				request.setAttribute("page", "error");
			}
		} else { // 회원가입 하지 않음
			request.setAttribute("err", "회원이 아닙니다");
			request.setAttribute("page", "error");

		}
		dispatcher.forward(request, response);
	}

}
