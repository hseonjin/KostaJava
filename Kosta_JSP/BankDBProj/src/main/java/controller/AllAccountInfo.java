package controller;

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
import service.AccountService;

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
		List<Account> accs = new ArrayList<Account>();
		
		AccountService service = new AccountService();
		
	    try {
	        accs = service.getAllAccounts();

	        if (accs.size() > 0) {
	            request.setAttribute("accs", accs);
	            request.getRequestDispatcher("allAccountInfo.jsp").forward(request, response);
	        } else {
	            request.setAttribute("err", "개설된 계좌가 없습니다");
	            request.getRequestDispatcher("error.jsp").forward(request, response);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        request.setAttribute("err", "계좌를 불러오는 동안 오류가 발생했습니다");
	        request.getRequestDispatcher("error.jsp").forward(request, response);
	    }
	}

}
