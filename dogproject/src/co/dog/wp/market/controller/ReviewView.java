package co.dog.wp.market.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dog.wp.common.Command;
import co.dog.wp.market.model.McommentDAO;
import co.dog.wp.market.model.McommentVO;
import co.dog.wp.market.model.ReviewDAO;
import co.dog.wp.market.model.ReviewVO;

public class ReviewView implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String seq = request.getParameter("seq");
		 String id = request.getParameter("id");
		  
		String mcomment = request.getParameter("mcomment");

		McommentDAO mcommentdao = new McommentDAO();
		McommentVO mcommentvo = new McommentVO();
		mcommentvo.setM_seq(seq);
		mcommentvo.setMcomment(mcomment);
		mcommentvo.setId(id);
		mcommentdao.commentsInsert(mcommentvo);
		
	      // 서비스 로직처리 (회원정보 1건 조회)
	      ReviewDAO reviewdao = new ReviewDAO();
	      reviewdao.increaseCnt(seq);
	      ReviewVO vo = reviewdao.getReview(id);
	      McommentDAO mcommentDAO = new McommentDAO();
		  ArrayList<McommentVO> mcommentList = mcommentDAO.getMcommentList(seq);
			
	      // 결과저장
	      request.setAttribute("review", vo);
		  request.setAttribute("mcomment", mcommentList);

	
		return "market/fmarketView.jsp";
	}

}