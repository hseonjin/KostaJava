package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Register extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // 취소 버튼 클릭 시 메인 리스트 페이지로 이동
        res.sendRedirect("main_list.jsp");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // TODO : 레시피 관련 DB 저장 로직 작성 필요

        // 등록 페이지에서 등록 버튼 클릭 시 메인 리스트 페이지로 이동
        req.getRequestDispatcher("main_list.jsp").forward(req, res);
    }

}
