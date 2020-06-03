package co.dog.wp.market.controller;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dog.wp.common.Command;

import co.dog.wp.market.model.McommentsDAO;

public class McommentDelete  implements Command {
	
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 받기 -> 세션에서 seq가져오기
		String seq = request.getParameter("seq");
		String c_seq = request.getParameter("c_seq");
		//서비스 로직 처리
		McommentsDAO mcommentsDao = new McommentsDAO();
		mcommentsDao.deleteComments(seq);
		
		return "ReviewViewForm.do?seq=" + c_seq;
	}


}
