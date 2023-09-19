package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemRegServlet
 */
@WebServlet("/memReg")
public class MemRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemRegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8"); // 한글 인코딩
		
		// 콘솔 출력을 위해 필요한 부분
		String name = request.getParameter("memName");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		String hobby = request.getParameter("hobby");
		System.out.println(name + "," + address + "," + tel + "," + hobby);
		// 끝
		
		// data를 받기 위해 필요한 부분
		RequestDispatcher dispatcher = request.getRequestDispatcher("MemReg.jsp"); // request를 jsp파일에 위임
		dispatcher.forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("memReg.html"); // request를 jsp파일에 위임
		dispatcher.forward(request, response);
//		response.sendRedirect("memReg.html"); // url이 바뀜
	}

}
