package co.dog.wp.market.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.dog.wp.market.model.MarketDAO;
import co.dog.wp.market.model.MarketVO;

/**
 * Servlet implementation class MarketView
 */
@WebServlet("/MarketView.do")
public class MarketView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	   // 수정페이지로이동
	   protected void doGet(HttpServletRequest request, HttpServletResponse response)
	         throws ServletException, IOException {
		  
		   // 파라미터 받기
		   HttpSession session = request.getSession();
		   String id = (String) session.getAttribute("loginId");
			
	      // 서비스 로직처리 (회원정보 1건 조회)
	      MarketDAO dao = new MarketDAO();
	      MarketVO vo = dao.getMarket(id);
	      // 결과저장
	      request.setAttribute("market", vo);
	      // 뷰페이지로이동 //재요청필요 -> forward 사용
	      request.getRequestDispatcher("/market/marketView.jsp").forward(request, response);
	  
	      String contextPath = getServletContext().getContextPath();
	      response.sendRedirect(contextPath + "/FmarketList.do");

	   }
}
	    

