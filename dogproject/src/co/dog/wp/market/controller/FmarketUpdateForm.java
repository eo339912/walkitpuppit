package co.dog.wp.market.controller;

import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dog.wp.common.Command;
import co.dog.wp.market.model.MarketDAO;
import co.dog.wp.market.model.MarketVO;

public class FmarketUpdateForm implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  // 파라미터 받기
		   String seq = request.getParameter("seq");
			
	      // 서비스 로직처리 (회원정보 1건 조회)
	      MarketDAO marketdao = new MarketDAO();
	      MarketVO vo = marketdao.getFmarket(seq);
	      
	      request.setAttribute("market", vo);
	
		return "market/fmarketUpdate.jsp";
		
	}

}

