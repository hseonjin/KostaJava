package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.google.gson.Gson;

import bean.Board;
import service.BoardService;
import service.BoardServiceImpl;

/**
 * Servlet implementation class Main_List
 */
@WebServlet("/mainlist")
public class Main_List extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main_List() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Integer foodId = Integer.parseInt(request.getParameter("foodId"));
        String[] storeIdValues = request.getParameterValues("storeIds[]"); // "storeIds"로 수정 // 값이 안들어가 -> 파라미터이름을 잘못지정, []안해주면 왜 값이 안들어가는거지?
        List<Integer> storeIds = new ArrayList<>(); // "storeIds"로 수정

        if (storeIdValues != null) {
            for (String storeIdValue : storeIdValues) {
                storeIds.add(Integer.parseInt(storeIdValue));
            }
        } else {
        	storeIds.addAll(Arrays.asList(1,2,3,4,5));
        	System.out.println("기본값-store전체선택");
        }

        try {
            BoardService service = new BoardServiceImpl();
            List<Board> boardList = service.boardListByCate(foodId, storeIds);
            request.setAttribute("boardList", boardList);
            request.setAttribute("foodId", foodId);
            request.setAttribute("storeIds", storeIds); // "storeIds"로 수정
            request.getRequestDispatcher("main_list.jsp").forward(request, response);
            System.out.println("success, foodId: " + foodId + ", storeIds: " + storeIds);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
