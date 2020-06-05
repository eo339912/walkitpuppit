package co.dog.wp.message.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dog.wp.common.Command;
import co.dog.wp.message.model.MessageDAO;
import co.dog.wp.message.model.MessageVO;

public class MessageInsert2 implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = (String) request.getSession().getAttribute("loginId");
		String seq = request.getParameter("seq");
		// 1 파라미터 받기
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		String m_id = request.getParameter("m_id");
		
		
		// 2. 서비스 로직 처리(DAO)
		MessageDAO messageDAO = new MessageDAO();
		MessageVO message = new MessageVO();
		message.setM_id(m_id);
		message.setTitle(title);
		message.setContents(contents);
		message.setUserid(id);
		
		messageDAO.messageInsert(message);

		
		return "/message/massageInsert2.do";
	}

}
