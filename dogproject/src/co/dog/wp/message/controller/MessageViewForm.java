package co.dog.wp.message.controller;

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
import co.dog.wp.message.model.MessageDAO;
import co.dog.wp.message.model.MessageVO;

public class MessageViewForm implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 받기 -> 세션에서 seq가져오기
		String seq = request.getParameter("seq");
		
		//1. 서비스 로직 처리
		MessageDAO messageDAO = new MessageDAO();
		MessageVO messageVO = messageDAO.getMessage(seq);
				
		//결과저장
		request.setAttribute("message", messageVO);
		
		return "message/messageView.jsp";
	}

}
