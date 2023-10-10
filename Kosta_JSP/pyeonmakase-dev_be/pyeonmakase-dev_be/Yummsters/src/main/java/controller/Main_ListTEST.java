//package controller;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.json.JSONObject;
//
//import com.google.gson.Gson;
//
//import bean.Board;
//import service.BoardService;
//import service.BoardServiceImpl;
//
///**
// * Servlet implementation class Main_List
// */
//@WebServlet("/list")
//public class Main_ListTEST extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public Main_ListTEST() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		String foodCategoryId = request.getParameter("foodId"); // 카테고리별 리스트
////		String[] storeIds = request.getParameterValues("storeIds[]"); // 편의점 체크박스 선택값
//		String storeIds = request.getParameter("storeIds");
//		String[] storeId = storeIds.split(",");
//		
//		Integer foodId = 0;
//		List<Integer> sId = new ArrayList<>();
////		List<Integer> storeIdDefaultValues = Arrays.asList(1,2,3,4,5);
//		List<Board> boardList;
//		
//		if(storeId != null) {
//			for(String s : storeId) {
//				sId.add(Integer.parseInt(s));
//			}
//			System.out.println(sId);
//		} 
////		else {
////			storeId.addAll(storeIdDefaultValues);
////		}
//
//		try {
//			BoardService service = new BoardServiceImpl();
//
//			if(foodCategoryId != null) { // foodCategory에 따라 필터링
//				foodId = Integer.parseInt(foodCategoryId);				
//				boardList = service.boardListByCate(foodId, sId);
//				request.setAttribute("boardList", boardList);
//				request.setAttribute("foodId", foodId);
//
//
//			} else { // foodCategory 값이 0일 때, 전체 리스트 출력
//				boardList = service.boardAllList(); 
//			    request.setAttribute("boardList", boardList);
//			    request.setAttribute("foodId", foodId);
//
//			}
//            // 실제로는 위에서 가져온 게시물 정보를 JSON 형식으로 변환하여 응답
//            String jsonResponse = storeIds; // JSON 형식의 응답 데이터 생성
//
//            // JSON 형식으로 응답 설정
//            response.setContentType("application/json");
//            response.setCharacterEncoding("UTF-8");
//
//            // JSON 응답 데이터 전송
//            response.getWriter().write(jsonResponse);
//            
//            // 서버 로그에 응답 내용을 출력
//            System.out.println("JSON 응답 데이터: " + jsonResponse);
//            
////			request.getRequestDispatcher("main_list.jsp").forward(request, response);
//
//            
//            
//            
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
////}
////		
////        request.setCharacterEncoding("utf-8");
////        String foodCategoryId = request.getParameter("foodId"); // 카테고리별 리스트
////        String[] storeIds = request.getParameterValues("storeIds[]"); // 편의점 체크박스 선택값
////
////        Integer foodId;
////        List<Integer> storeId = new ArrayList<>();
////        List<Integer> storeIdDefaultValues = Arrays.asList(1, 2, 3, 4, 5);
////        List<Board> boardList;
////
////        if (storeIds != null) {
////            for (String s : storeIds) {
////                storeId.add(Integer.parseInt(s));
////            }
////        }
////
////        try {
////            BoardService service = new BoardServiceImpl();
////
////            if (foodCategoryId != null) { // foodCategory에 따라 필터링
////                foodId = Integer.parseInt(foodCategoryId);
////                boardList = service.boardListByCate(foodId, storeId);
////            } else { // foodCategory 값이 0일 때, 전체 리스트 출력
////                foodId = 0;
////                boardList = service.boardAllList();
////            }
////
////            // JSON 형식으로 응답 설정
////            response.setContentType("application/json");
////            response.setCharacterEncoding("UTF-8");
////
////            // JSON 데이터를 응답으로 전송
////            response.getWriter().write(new Gson().toJson(boardList));
////
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////    }
//}
//
//
//package controller;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.json.JSONObject;
//
//import com.google.gson.Gson;
//
//import bean.Board;
//import service.BoardService;
//import service.BoardServiceImpl;
//
///**
// * Servlet implementation class Main_List
// */
//@WebServlet("/mainlist")
//public class Main_List extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public Main_List() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		String foodCategoryId = request.getParameter("foodId"); // 카테고리별 리스트
////		String storeIdParam = request.getParameter("storeIds"); // 편의점 체크박스 선택값
////		String[] storeIds = storeIdParam.split(",");
//		String[] storeIds = request.getParameterValues("storeIds[]");
//		
//		Integer foodId = 0;
//		List<Integer> storeId = new ArrayList<>();
//		List<Integer> storeIdDefaultValues = Arrays.asList(1,2,3,4,5);
//		List<Board> boardList;
//		
//		if(storeIds != null) {
//			for(String s : storeIds) {
//				storeId.add(Integer.parseInt(s));
//			}
//			System.out.println(storeId);
//} 		else {
//			storeId.addAll(storeIdDefaultValues);
//		}
//
//
//		try {
//			BoardService service = new BoardServiceImpl();
//
//			if(foodCategoryId != null) { // foodCategory에 따라 필터링
//				foodId = Integer.parseInt(foodCategoryId);				
//				boardList = service.boardListByCate(foodId, storeId);
//				request.setAttribute("boardList", boardList);
//				request.setAttribute("foodId", foodId);
//
//
//			} else { // foodCategory 값이 0일 때, 전체 리스트 출력
//				boardList = service.boardAllList(); 
//			    request.setAttribute("boardList", boardList);
//			    request.setAttribute("foodId", foodId);
//			}
//			
//	        // JSON 형식으로 응답 데이터 생성
//	        String jsonRes = new Gson().toJson(boardList);
//
//	        // JSON 응답 데이터 전송
//	        response.setContentType("application/json");
//	        response.setCharacterEncoding("UTF-8");
//	        response.getWriter().write(jsonRes);
//	        
//	     // 서버 로그에 응답 내용을 출력
//	        System.out.println("JSON 응답 데이터: " + jsonRes);
//
////			request.getRequestDispatcher("main_list.jsp").forward(request, response);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
////}
////		
////        request.setCharacterEncoding("utf-8");
////        String foodCategoryId = request.getParameter("foodId"); // 카테고리별 리스트
////        String[] storeIdParam = request.getParameterValues("storeIdParam[]"); // 편의점 체크박스 선택값
////
////        Integer foodId;
////        List<Integer> storeId = new ArrayList<>();
////        List<Integer> storeIdDefaultValues = Arrays.asList(1, 2, 3, 4, 5);
////        List<Board> boardList;
////
////        if (storeIdParam != null) {
////            for (String s : storeIdParam) {
////                storeId.add(Integer.parseInt(s));
////            }
////        }
////
////        try {
////            BoardService service = new BoardServiceImpl();
////
////            if (foodCategoryId != null) { // foodCategory에 따라 필터링
////                foodId = Integer.parseInt(foodCategoryId);
////                boardList = service.boardListByCate(foodId, storeId);
////            } else { // foodCategory 값이 0일 때, 전체 리스트 출력
////                foodId = 0;
////                boardList = service.boardAllList();
////            }
////
////            // JSON 형식으로 응답 설정
////            response.setContentType("application/json");
////            response.setCharacterEncoding("UTF-8");
////
////            // JSON 데이터를 응답으로 전송
////            response.getWriter().write(new Gson().toJson(boardList));
////
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////    }
//}
//
