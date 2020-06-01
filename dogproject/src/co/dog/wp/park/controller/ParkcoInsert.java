package co.dog.wp.park.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dog.wp.board.model.CommentsDAO;
import co.dog.wp.board.model.CommentsVO;
import co.dog.wp.common.Command;
import co.dog.wp.park.model.ParkDAO;
import co.dog.wp.park.model.ParkcoVO;


public class ParkcoInsert implements Command {


	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = (String)request.getSession().getAttribute("loginId");
		String pseq = request.getParameter("pseq");
		String seq = request.getParameter("seq");
		String comments = request.getParameter("comments");
		
		ParkDAO parkDAO = new ParkDAO();
		ParkcoVO parkcovo = new ParkcoVO();	
		parkcovo.setId(id);
		parkcovo.setComments(comments);
		parkcovo.setPseq(pseq);
		parkcovo.setPseq(seq);
		parkDAO.ParkcoInsert((parkcovo));
		
		//2. 서비스 로직 처리(DAO) -> seq에 해당하는 댓글 리스트 조회
		ParkDAO parkDAO2 = new ParkDAO();
		ArrayList<ParkcoVO> parkcoList = parkDAO2.getParkcoList(pseq);
		
		//결과저장
	
		request.setAttribute("parkco", parkcoList);
		
		return "park/parkView.jsp";
	}

}
