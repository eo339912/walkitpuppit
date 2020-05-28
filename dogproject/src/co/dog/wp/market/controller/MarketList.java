package co.dog.wp.market.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dog.wp.common.Command;
import co.dog.wp.common.Paging;
import co.dog.wp.market.model.MarketDAO;
import co.dog.wp.market.model.MarketVO;


public class MarketList implements Command {



	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.파라미터
		// 2.서비스(DAO 목록조회)
		MarketDAO marketdao = new MarketDAO();
		String id = request.getParameter("id");
		
		//페이징처리
		//현재 페이지 파라미터 받기
		String strPage = request.getParameter("p");
		int p = 1;
		if(strPage != null && !strPage.isEmpty()) {
			p = Integer.parseInt(strPage);
		}
		

		//페이징 객체를  생성
		Paging paging = new Paging();
		paging.setPageUnit(4); //한페이지에 출력할 레코드 건수/ default = 10
		paging.setPageSize(3); //한페이지에 출력할 페이지 번호 수
		paging.setPage(p); //현재페이지

		paging.setTotalRecord(marketdao.getCount(id)); //전체 레코드 건수 조회
		request.setAttribute("paging", paging);
		
		int start = paging.getFirst();
		int end = paging.getLast();
		ArrayList<MarketVO> list = marketdao.getMarketList(start, end, id);
		// 3.결과출력 또는 결과 저장해서 VIEW 포워드
		response.setContentType("text/html; charset=UTF-8");
		// 3.결과출력 or 결과 저장해서 view 포워드s
		request.setAttribute("list",list);
	
		return "market/marketList.jsp";
		
	}


}