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

public class FmarketViewForm implements Command {
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			   // 파라미터 받기
			   String seq = request.getParameter("seq");
			  
		      // 서비스 로직처리 (회원정보 1건 조회)
		      ReviewDAO reviewdao = new ReviewDAO();
		      reviewdao.increaseCnt(seq);
		      ReviewVO vo = reviewdao.getReview(seq);
		      // 결과저장
		      McommentDAO mcommentdao = new McommentDAO();
			  ArrayList<McommentVO> mcommentList = mcommentdao.getMcommentList(seq);
		     
				
				request.setAttribute("review", vo);
				request.setAttribute("mcomment", mcommentList);

		      // 뷰페이지로이동 //재요청필요 -> forward 사용		 
				return "market/fmarketView.jsp";
			}
}