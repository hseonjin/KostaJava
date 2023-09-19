package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginProcess
 */
@WebServlet("/Login")
public class LoginProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginProcess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8"); // 한글 인코딩
		String id = request.getParameter("id"); // name으로 지정한 값을 파라미터로 가져온다 (key로 사용됨)
		String password = request.getParameter("password");
		System.out.println(id);
		System.out.println(password);
		RequestDispatcher dispatcher = request.getRequestDispatcher("LoginSuccess.jsp"); // request를 jsp파일에 위임
		dispatcher.forward(request, response);
//		doGet(request, response);
	}

}
