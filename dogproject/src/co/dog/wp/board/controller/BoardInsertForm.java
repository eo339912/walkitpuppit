package co.dog.wp.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dog.wp.common.Command;

public class BoardInsertForm  implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "board/boardInsert.jsp";
	}
	

}
