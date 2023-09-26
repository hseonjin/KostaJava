package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.User;

/**
 * Servlet implementation class UserInfo
 */
@WebServlet("/userInfo")
public class UserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("userInfoForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id"); // http 요청에서 "id"라는 요청 매개변수의 값 찾기
		// db에서 아이디로 사용자 조회
		// User user = new User(id, "홍길동", "서울시 금천구", "hong@kosta.com"); // 임시 데이터 작성
		Map<String, String> user = new HashMap<>();
		user.put("id", id);
		user.put("name", "홍길동");
		user.put("address", "서울시 금천구");
		user.put("email", "hong@kosta.com");
		HttpSession session = request.getSession(); // 세션 가져오기
		session.setAttribute("id", id); // 세션에서 "id"라는 속성을 설정하고 요청에서 검색된 id 변수의 값과 연결
		request.setAttribute("user", user); // "user"라는 속성을 설정하고 생성한 user객체로 설정
		request.getRequestDispatcher("userInfo.jsp").forward(request, response); // userInfo로 위임
	}

}
