package co.dog.wp.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dog.wp.board.model.BoardDAO;
import co.dog.wp.board.model.BoardVO;



/**
 * Servlet implementation class Login
 */
@WebServlet("/BoardList.do")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//list처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	//list페이지로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		String id = (String) request.getSession().getAttribute("loginId");
		if(id == null) {
			response.sendRedirect("/dogproject/member/memberLogin.jsp");
			return;
		}
	
		//1. 파라미터
		//2. 서비스 (DAO 목록조회)
		ArrayList<BoardVO> list = dao.getBoardList();
		
		//view page에 forward
		request.setAttribute("board", list);
		request.getRequestDispatcher("/board/boardList.jsp").forward(request, response);
	}

}
