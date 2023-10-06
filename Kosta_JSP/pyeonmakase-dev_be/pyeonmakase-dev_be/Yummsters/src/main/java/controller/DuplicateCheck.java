package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import service.MemberService;
import service.MemberServiceImpl;

/**
 * Servlet implementation class DuplicateCheck
 */
@WebServlet("/duplicateCheck")
public class DuplicateCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DuplicateCheck() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String nickname = request.getParameter("nickname"); // ajax로부터 받은 데이터
		String email = request.getParameter("email");
		String id = request.getParameter("id");

		try {
			MemberService service = new MemberServiceImpl();
			String isIdCheck = service.isIdCheck(id);
			String isEmailCheck = service.isEmailCheck(email);
			String isNicknameCheck = service.isNicknameCheck(nickname);

			JSONObject result = new JSONObject();
			result.put("id", isIdCheck);
			result.put("email", isEmailCheck);
			result.put("nickname", isNicknameCheck);

			// json 결과 전송
			response.getWriter().print(result.toString());

		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().print("error!");
		}
	}

}