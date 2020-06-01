package co.dog.wp.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dog.wp.board.model.BoardDAO;
import co.dog.wp.common.Command;


public class BoardDelete implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 받기 -> 세션에서 seq가져오기
		String seq = request.getParameter("seq");
		//서비스 로직 처리
		BoardDAO dao = new BoardDAO();
		dao.deleteBoard(seq);
		
		return "BoardList.do";
	}

}
