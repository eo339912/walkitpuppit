package co.dog.wp.market.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dog.wp.common.Command;
import co.dog.wp.market.model.MarketDAO;
import co.dog.wp.market.model.MarketVO;
import co.dog.wp.market.model.McommentDAO;
import co.dog.wp.market.model.McommentVO;
import co.dog.wp.market.model.McommentsDAO;
import co.dog.wp.market.model.McommentsVO;
import co.dog.wp.market.model.ReviewDAO;
import co.dog.wp.market.model.ReviewVO;

public class ReviewViewForm implements Command {
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			   // 파라미터 받기
			   String seq = request.getParameter("seq");
			  
		      // 서비스 로직처리 (회원정보 1건 조회)
		      ReviewDAO reviewdao = new ReviewDAO();
		      reviewdao.increaseCnt(seq);
		      ReviewVO vo = reviewdao.getReview(seq);
		      
		      McommentsDAO mcommentsdao = new McommentsDAO();
			  ArrayList<McommentsVO> mcommentsList = mcommentsdao.getMcommentsList(seq);
		     
		      // 결과저장
		      request.setAttribute("review", vo);
		      request.setAttribute("mcomments", mcommentsList);

		      // 뷰페이지로이동 //재요청필요 -> forward 사용		 
				return "market/reviewView.jsp";
			}
}