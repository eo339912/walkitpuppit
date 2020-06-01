package co.dog.wp.market.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dog.wp.board.model.CommentsDAO;
import co.dog.wp.common.Command;
import co.dog.wp.market.model.McommentDAO;

public class FcommentDelete  implements Command {
	
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 받기 -> 세션에서 seq가져오기
		String seq = request.getParameter("seq");
		String m_seq = request.getParameter("m_seq");
		//서비스 로직 처리
		McommentDAO mcommentDao = new McommentDAO();
		mcommentDao.deleteComments(seq);
		
		return "FmarketViewForm.do?seq=" + m_seq;
	}


}
