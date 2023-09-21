package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import dto.Account;

/**
 * Servlet implementation class MakeAccount
 */
@WebServlet("/makeAccount")
public class MakeAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 한글 처리를 위한 인코딩
		request.setCharacterEncoding("utf-8");
		
		// http post 요청에서 클라이언트가 보낸 파라미터 값을 추출하고 서블릿 내부의 변수에 저장
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		Integer money = Integer.parseInt(request.getParameter("money"));
		String type = request.getParameter("type");
		String grade = request.getParameter("grade");
		
		// 일반계좌 개설 시 grade null 입력 방지
		if(grade==null) grade="-";
		
		// 추출한 파라미터 값을 사용하여 Account 객체 생성
		Account acc = new Account(id, name, money, type, grade);
		
		// session 생성 -> 서버-클라이언트 간 상태 유지, 다른 서블릿 또는 jsp 페이지에서 사용 가능
		HttpSession session = request.getSession();
		session.setAttribute(id, acc); // key=id, value=acc
		
		// 요청 객체에 속성 설정 -> 다른 jsp로 데이터를 전달하는 데 사용 
		// main.jsp에서는 page만 사용하고 include를 통해 해당 페이지 내에서 acc 속성 사용
		request.setAttribute("acc", acc); // acc라는 이름으로 acc번수에 저장된 Account 객체 설정
		request.setAttribute("page", "accountInfo"); // page라는 이름으로 accountInfo 문자열 설정
		
		// forward, main.jsp에서 요청과 응답을 처리하도록 위임
		RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
		dispatcher.forward(request, response);
	}

}
