package co.dog.wp.mypage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dog.wp.common.Command;
import co.dog.wp.mypage.model.MypageDAO;
import co.dog.wp.park.model.WalkVO;

public class MywalkTime implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = (String) request.getSession().getAttribute("loginId");
		
		MypageDAO mypageDAO = new MypageDAO();
		
		ArrayList<WalkVO> list = mypageDAO.getWalkTime(id); 
		
		request.setAttribute("mywlist", list);
		
		return "mypage/mywalktime.jsp";
	}

}
