package co.dog.wp.main.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dog.wp.board.model.BoardDAO;
import co.dog.wp.board.model.BoardVO;
import co.dog.wp.common.Command;
import co.dog.wp.market.model.MarketDAO;
import co.dog.wp.market.model.MarketVO;


public class Main implements Command {
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		//1. 파라미터
		String id = request.getParameter("id");
		//2. 서비스 (DAO 목록조회)
		MarketDAO maketdao = new MarketDAO();
		ArrayList<MarketVO> list = maketdao.getMarketList2();
		
		request.setAttribute("market", list);
		
		return "main/main.jsp";
	}

	

}
