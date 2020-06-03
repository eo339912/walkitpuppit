package co.dog.wp.market.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dog.wp.common.Command;
import co.dog.wp.market.model.MarketDAO;


public class MarketDelete implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 받기 -> 세션에서 seq가져오기
		String seq = request.getParameter("seq");
		//서비스 로직 처리
		MarketDAO marketdao = new MarketDAO();
		marketdao.deleteMarket(seq);
		
		return "MarketList.do";
	}

}
