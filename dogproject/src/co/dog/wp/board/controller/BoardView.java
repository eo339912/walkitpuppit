package co.dog.wp.board.controller;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dog.wp.board.model.BoardDAO;
import co.dog.wp.board.model.BoardVO;
import co.dog.wp.board.model.CommentsDAO;
import co.dog.wp.board.model.CommentsVO;


/**
 * Servlet implementation class boardInsert
 */
@WebServlet("/BoardView.do")
public class BoardView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//응답결과 인코당
    	response.setContentType("text/html; charset=UTF-8");
    	//요청정보 인코딩
    	request.setCharacterEncoding("utf-8");
    	
		// 1 파라미터 받기		
		String id = (String) request.getSession().getAttribute("loginId");
		String seq = request.getParameter("seq");
		
		String commentsO = request.getParameter("commentsO");
		
		//2. 서비스 로직 처리(DAO) -> comment 저장
		CommentsDAO commentsDAO = new CommentsDAO();
		CommentsVO commentsVO = new CommentsVO();
		commentsVO.setB_seq(seq);
		commentsVO.setCommentsO(commentsO);
		commentsVO.setId(id);
		commentsDAO.commentsInsert(commentsVO);
		
    	//2. 서비스 로직 처리(DAO) -> seq에 해당하는 board 한건조회
		BoardDAO boardDao = new BoardDAO();
		BoardVO board = boardDao.getBoard(seq);
		
		//2. 서비스 로직 처리(DAO) -> seq에 해당하는 댓글 리스트 조회
		CommentsDAO commentsDAO2 = new CommentsDAO();
		ArrayList<CommentsVO> commentsList = commentsDAO2.getCommentsList(seq);
		
		//결과저장
		request.setAttribute("board", board);
		request.setAttribute("comments", commentsList);
		
		//뷰페이지로 이동
		request.getRequestDispatcher("/board/boardView.jsp")
				.forward(request, response);
		
		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청정보 인코딩
		request.setCharacterEncoding("utf-8");
		
		//파라미터 받기 -> 세션에서 seq가져오기
		String seq = request.getParameter("seq");
		
		//1. 서비스 로직 처리
		BoardDAO boardDao = new BoardDAO();
		boardDao.increaseCnt(seq);
		BoardVO vo = boardDao.getBoard(seq);
		
		//2. 서비스 로직 처리(DAO) -> seq에 해당하는 댓글 리스트 조회
		CommentsDAO commentsDAO = new CommentsDAO();
		ArrayList<CommentsVO> commentsList = commentsDAO.getCommentsList(seq);
				
		//결과저장
		request.setAttribute("board", vo);
		request.setAttribute("comments", commentsList);
		
		//뷰페이지로 이동
		request.getRequestDispatcher("/board/boardView.jsp")
				.forward(request, response);
	}
	


}
