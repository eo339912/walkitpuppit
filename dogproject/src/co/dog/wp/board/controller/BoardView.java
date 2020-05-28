package co.dog.wp.board.controller;

import java.io.File;
import java.io.IOException;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import co.dog.wp.board.model.BoardDAO;
import co.dog.wp.board.model.BoardVO;
import co.dog.wp.common.FileRenamePolicy;


/**
 * Servlet implementation class boardInsert
 */
@WebServlet("/BoardView.do")
public class BoardView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 받기 -> 세션에서 seq가져오기
		String seq = request.getParameter("seq");
		
		//서비스 로직 처리
		BoardDAO boardDao = new BoardDAO();
		boardDao.increaseCnt(seq);
		BoardVO vo = boardDao.getBoard(seq);
		
		//결과저장
		request.setAttribute("board", vo);
		
		//뷰페이지로 이동
		request.getRequestDispatcher("/board/boardView.jsp")
				.forward(request, response);
	}
	


}
