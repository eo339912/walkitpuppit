package co.dog.wp.mypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dog.wp.board.model.BoardVO;
import co.dog.wp.common.Command;
import co.dog.wp.member.model.MemberDAO;
import co.dog.wp.member.model.MemberVO;
import co.dog.wp.message.model.MessageDAO;
import co.dog.wp.message.model.MessageVO;


public class Mypage implements Command {
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String id = (String) request.getSession().getAttribute("loginId");
		if(id == null ) {
			return "MemberLogin.do";
		}
		
		MemberDAO memberDAO = new MemberDAO();
		MemberVO member = memberDAO.getMember(id);
		
	
		request.setAttribute("member", member);
		
		
		//쪽지 서비스로직
		MessageDAO messageDAO = new MessageDAO();
		List<MessageVO> list = messageDAO.getMessageList(id);
		
		request.setAttribute("message", list);
		
		return "mypage/mypage.jsp";
	}

	

}
