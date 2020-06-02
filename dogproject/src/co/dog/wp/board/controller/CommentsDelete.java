package co.dog.wp.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dog.wp.board.model.CommentsDAO;
import co.dog.wp.common.Command;

public class CommentsDelete  implements Command {
	
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 받기 -> 세션에서 seq가져오기
		String seq = request.getParameter("seq");
		String b_seq = request.getParameter("b_seq");
		//서비스 로직 처리
		CommentsDAO commentsDao = new CommentsDAO();
		commentsDao.deleteComments(seq);
		
		return "BoardViewForm.do?seq=" + b_seq;
	}


}
