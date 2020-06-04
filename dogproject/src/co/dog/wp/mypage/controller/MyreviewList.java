package co.dog.wp.mypage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dog.wp.common.Command;
import co.dog.wp.market.model.ReviewVO;
import co.dog.wp.mypage.model.MypageDAO;

public class MyreviewList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = (String) request.getSession().getAttribute("loginId");
		
		MypageDAO mypageDAO = new MypageDAO();
		
		ArrayList<ReviewVO> list = mypageDAO.getMyreviewList(id); 

		request.setAttribute("myrlist", list);
		
		return "mypage/myreviewList.jsp";
	}

}
