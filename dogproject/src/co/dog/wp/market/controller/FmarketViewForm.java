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

public class FmarketViewForm implements Command {
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			   // 파라미터 받기
			   String seq = request.getParameter("seq");
			  
		      // 서비스 로직처리 (회원정보 1건 조회)
			   MarketDAO marketdao = new MarketDAO();
			   marketdao.increaseCnt(seq);
		      MarketVO vo = marketdao.getFmarket(seq);

		      // 결과저장
		      McommentDAO mcommentdao = new McommentDAO();
			  ArrayList<McommentVO> mcommentList = mcommentdao.getMcommentList(seq);
		     
			  McommentDAO McommentDAO3 = new McommentDAO();
				 McommentVO McommentVO3  = McommentDAO3.commentCount(seq);
				request.setAttribute("cCnt", McommentVO3);
				
				request.setAttribute("market", vo);
				request.setAttribute("mcomment", mcommentList);

		      // 뷰페이지로이동 //재요청필요 -> forward 사용		 
				return "market/fmarketView.jsp";
			}
}