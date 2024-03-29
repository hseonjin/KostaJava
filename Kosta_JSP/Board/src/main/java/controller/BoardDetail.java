package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Board;
import dto.Member;
import service.BoardService;
import service.BoardServiceImpl;

/**
 * Servlet implementation class BoardDetail
 */
@WebServlet("/boarddetail")
public class BoardDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Integer num = Integer.parseInt(request.getParameter("num"));
		try {
			BoardService service = new BoardServiceImpl();
			Board board = service.boardDetail(num);
			request.setAttribute("board", board);
			HttpSession session = request.getSession();
			Member member = (Member)session.getAttribute("user");
			if(member!=null) {
				Boolean isLike = service.isBoardLike(member.getId(), num);
				request.setAttribute("select", isLike);
			}
			request.getRequestDispatcher("detailform.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("err", "글 상세 조회 실패");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}
}
