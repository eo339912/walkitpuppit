package co.dog.wp.mypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dog.wp.common.Command;
import co.dog.wp.member.model.MemberVO;
import co.dog.wp.message.model.MessageDAO;
import co.dog.wp.message.model.MessageVO;


public class Mypage implements Command {
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String id = (String) request.getSession().getAttribute("loginId");
		//쪽지 서비스로직
		MessageDAO messageDAO = new MessageDAO();
		String m_id = request.getParameter("m_id");
		
		//(쪽지함 리트스)
		List<MessageVO> list = messageDAO.getMessageList(m_id);
		
		request.setAttribute("message", list);
		
		MemberVO member = new MemberVO();
		request.setAttribute("member", member);
		
		
		return "mypage/mypage.jsp";
	}

	

}
