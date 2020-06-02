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


public class ParkView implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = (String) request.getSession().getAttribute("loginId");
		String seq = request.getParameter("seq");
	
		String comments = request.getParameter("comments");
		
		//서비스 로직 처리
		ParkDAO parkDAO = new ParkDAO();
		ParkcoVO parkcovo = new ParkcoVO();	
		parkcovo.setId(id);
		parkcovo.setPseq(seq);
		parkcovo.setComments(comments);
		parkDAO.ParkcoInsert((parkcovo));
		
		//서비스 로직 처리
		ParkDAO parkdao  = new ParkDAO();
		ParkVO parkvo = parkdao.getPark(seq);
		
		//2. 서비스 로직 처리(DAO) -> seq에 해당하는 댓글 리스트 조회
		ParkDAO parkDAO2 = new ParkDAO();
		ArrayList<ParkcoVO> parkcoList = parkDAO2.getParkcoList(seq);
 
		//결과저장
		request.setAttribute("park", parkvo);  
		request.setAttribute("parkco", parkcoList);
		
		return "park/parkView.jsp";
	}

}


