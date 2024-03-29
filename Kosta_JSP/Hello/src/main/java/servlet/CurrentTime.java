package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CurrentTime
 */
@WebServlet("/CurrentTime")
public class CurrentTime extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CurrentTime() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		Calendar c = Calendar.getInstance();
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		
		request.setAttribute("hour", hour);
		request.setAttribute("minute", minute);
		request.setAttribute("second", second);
		RequestDispatcher dispatcher = request.getRequestDispatcher("CurrentTime.jsp"); // 위임할 페이지
		dispatcher.forward(request, response);
		
		// jsp로 작성한 것을 servlet으로 작성
//		response.setContentType("text/html");
//		response.setCharacterEncoding("UTF-8");
//		Calendar c = Calendar.getInstance();
//		int hour = c.get(Calendar.HOUR_OF_DAY);
//		int minute = c.get(Calendar.MINUTE);
//		int second = c.get(Calendar.SECOND);
//		PrintWriter out = response.getWriter();
//		out.write("<html><head><titla>현재시간 : </title></head>");
//		out.write("<body><h1>현재시간은 ");
//		out.write(hour + "");
//		out.write("시 ");
//		out.write(minute + "");
//		out.write("분 ");
//		out.write(second + "");
//		out.write("초 입니다.</h1></body></html>");
//		out.close();
	}
}
