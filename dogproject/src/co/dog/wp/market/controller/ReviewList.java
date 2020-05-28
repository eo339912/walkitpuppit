package co.dog.wp.market.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dog.wp.common.Paging;
import co.dog.wp.market.model.MarketDAO;
import co.dog.wp.market.model.MarketVO;
import co.dog.wp.market.model.ReviewDAO;
import co.dog.wp.market.model.ReviewVO;

/**
 * Servlet implementation class ReviewList
 */
@WebServlet("/ReviewList")
public class ReviewList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	   protected void doGet(HttpServletRequest request, HttpServletResponse response)
		         throws ServletException, IOException {
			  
	//HttpSession session = request.getSession();
	//String id = (String) session.getAttribute("loginId");
	
	//1.파라미터
	//2.서비스(DAO 목록조회)
	ReviewDAO reviewdao = new ReviewDAO();
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

	paging.setTotalRecord(reviewdao.getCount(id)); //전체 레코드 건수 조회
	request.setAttribute("paging", paging);
	
	int start = paging.getFirst();
	int end = paging.getLast();
	ArrayList<ReviewVO> list = reviewdao.getReviewList();
	//3.결과출력 또는 결과 저장해서 VIEW 포워드 
	response.setContentType("text/html; charset=UTF-8");
	//3.결과출력 or 결과 저장해서 view 포워드s
	request.setAttribute("list", list);
	request.getRequestDispatcher("/market/reviewtList.jsp")
	.forward(request, response);
}


protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	doGet(request, response);
}

}
