package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Account;

/**
 * Servlet implementation class AllAccountInfo
 */
@WebServlet("/allAccountInfo")
public class AllAccountInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllAccountInfo() {
        super();
        // TODO Auto-generated constructor stub
    }    	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Account 목록을 담을 ArrayList 생성
		List<Account> accs = new ArrayList<Account>();
		
		// 2. session을 얻어온다.
		HttpSession session = request.getSession();
		
		// 3. session에 있는 모든 키 목록을 가져온다.
		Enumeration<String> e = session.getAttributeNames();
		while(e.hasMoreElements()) {
			String name = e.nextElement();
			if(name.equals("member") | name.equals("id")) continue; // 계좌번호가 아닌 키는 제외
			Account acc = (Account) session.getAttribute(name); // 계좌번호로 계좌를 가져옴
			accs.add(acc); // list(accs)에 계좌를 담음
		}
		RequestDispatcher dispatcher = null;
		if(accs.size()>0) { // 목록에 데이터가 있으면 request에 담아 allAccuntInfo.jsp로 포워딩
			request.setAttribute("accs", accs);
			dispatcher = request.getRequestDispatcher("allAccountInfo.jsp");
		} else { // 목록에 데이터가 없으면 error.jsp로 포워딩
			request.setAttribute("err", "개설된 계좌가 없습니다.");
			dispatcher = request.getRequestDispatcher("error.jsp");
		}
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
