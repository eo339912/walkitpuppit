package co.dog.wp.park.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dog.wp.common.Command;
import co.dog.wp.park.model.ParkDAO;
import co.dog.wp.park.model.ParkVO;


public class ParkView implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = (String) request.getSession().getAttribute("loginId");
		String seq = request.getParameter("seq");
	
		//서비스 로직 처리
		ParkDAO parkdao  = new ParkDAO();
		ParkVO parkvo = parkdao.getPark(seq);
 
		//결과저장
		request.setAttribute("park", parkvo);  
		
		return "park/parkView.jsp";
	}

}


