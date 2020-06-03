package co.dog.wp.market.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dog.wp.common.Command;
import co.dog.wp.market.model.McommentDAO;
import co.dog.wp.market.model.McommentVO;
import co.dog.wp.market.model.McommentsDAO;
import co.dog.wp.market.model.McommentsVO;
import co.dog.wp.market.model.ReviewDAO;
import co.dog.wp.market.model.ReviewVO;

public class ReviewView implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String seq = request.getParameter("seq");
		 String id = (String) request.getSession().getAttribute("loginId");
		  
		String mcomments = request.getParameter("mcomments");

		McommentsDAO mcommentsdao = new McommentsDAO();
		McommentsVO mcommentsvo = new McommentsVO();
		mcommentsvo.setC_seq(seq);
		mcommentsvo.setMcomments(mcomments);
		mcommentsvo.setId(id);
		mcommentsdao.commentsInsert(mcommentsvo);
		
	      // 서비스 로직처리 (회원정보 1건 조회)
	      ReviewDAO reviewdao = new ReviewDAO();
	      reviewdao.increaseCnt(seq);
	      ReviewVO vo = reviewdao.getReview(seq);
	      McommentsDAO mcommentsDAO = new McommentsDAO();
		  ArrayList<McommentsVO> mcommentsList = mcommentsDAO.getMcommentsList(seq);
			
	      // 결과저장
	      request.setAttribute("review", vo);
		  request.setAttribute("mcomments", mcommentsList);

	
		return "market/reviewView.jsp";
	}

}
