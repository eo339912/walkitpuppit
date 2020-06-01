package co.dog.wp.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dog.wp.board.model.BoardDAO;
import co.dog.wp.board.model.BoardVO;
import co.dog.wp.board.model.CommentsDAO;
import co.dog.wp.board.model.CommentsVO;
import co.dog.wp.common.Command;

public class BoardView implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		return "board/boardView.jsp";
	}
	

}
