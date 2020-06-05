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

public class BoardViewForm  implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 받기 -> 세션에서 seq가져오기
		String seq = request.getParameter("seq");
		
		//1. 서비스 로직 처리
		BoardDAO boardDao = new BoardDAO();
		BoardVO vo = boardDao.getBoard(seq);
		boardDao.increaseCnt(seq);
		
		//2. 서비스 로직 처리(DAO) -> seq에 해당하는 댓글 리스트 조회
		CommentsDAO commentsDAO = new CommentsDAO();
		ArrayList<CommentsVO> commentsList = commentsDAO.getCommentsList(seq);
		
		CommentsDAO commentsDAO3 = new CommentsDAO();
		CommentsVO commentsVO3  = commentsDAO3.commentCount(seq);
		
		//결과저장
		request.setAttribute("board", vo);
		request.setAttribute("comments", commentsList);
		request.setAttribute("cCnt", commentsVO3);
		
		return "board/boardView.jsp";
	}
	
}
