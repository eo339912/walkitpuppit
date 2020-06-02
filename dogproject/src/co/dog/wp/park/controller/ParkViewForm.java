package co.dog.wp.park.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dog.wp.common.Command;
import co.dog.wp.park.model.ParkDAO;
import co.dog.wp.park.model.ParkVO;
import co.dog.wp.park.model.ParkcoVO;

public class ParkViewForm implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 받기 -> 세션에서 seq가져오기
		String seq = request.getParameter("seq");
	
		String comments = request.getParameter("comments");
		
		//서비스 로직 처리
		ParkDAO parkDAO = new ParkDAO();
		ParkVO parkvo = parkDAO.getPark(seq);
		
		//서비스 로직 처리 -> seq에 해당하는 댓글 리스트 조회
		ArrayList<ParkcoVO> parkcoList = parkDAO.getParkcoList(seq);
		
		//결과저장
		request.setAttribute("park", parkvo);  
		request.setAttribute("parkco", parkcoList);
		
		return "park/parkView.jsp";
	}

}
