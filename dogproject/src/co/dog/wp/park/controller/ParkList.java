package co.dog.wp.park.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dog.wp.common.Command;
import co.dog.wp.common.Paging;
import co.dog.wp.park.model.ParkDAO;
import co.dog.wp.park.model.ParkVO;
import co.dog.wp.park.model.WalkDAO;
import co.dog.wp.park.model.WalkVO;

public class ParkList implements Command {
	

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ParkDAO parkdao = new ParkDAO();
		
		String sname = request.getParameter("sname");
		
		String spotnum = request.getParameter("spotnum");
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
	
		paging.setTotalRecord(parkdao.getCount(sname, spotnum)); //전체 레코드 건수 조회
		request.setAttribute("paging", paging);
					
		int start = paging.getFirst();
		int end = paging.getLast();		
	 	
		//리스트
		ArrayList<ParkVO> list = parkdao.getParkList(start, end, sname, spotnum);
		
		WalkDAO walkDAO2 = new WalkDAO();
		walkDAO2.ParkUpdate();
		//결과저장
		request.setAttribute("park", list); 
		
		return "park/parkList.jsp";
	}



}
