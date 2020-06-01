package co.dog.wp.main.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dog.wp.board.model.BoardDAO;
import co.dog.wp.board.model.BoardVO;
import co.dog.wp.common.Command;


public class Main implements Command {
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		//1. 파라미터
		//2. 서비스 (DAO 목록조회)
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardVO> list = dao.getBoardList();
		//view page에 forward
		request.setAttribute("board", list);
		
		
		return "main/main.jsp";
	}

	

}
