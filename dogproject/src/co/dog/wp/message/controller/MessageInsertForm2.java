package co.dog.wp.message.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dog.wp.common.Command;
import co.dog.wp.message.model.MessageDAO;
import co.dog.wp.message.model.MessageVO;

public class MessageInsertForm2 implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "message/messageInsert2.jsp";
	}

}
