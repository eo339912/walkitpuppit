package co.dog.wp.market.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dog.wp.market.model.MarketDAO;
import co.dog.wp.market.model.MarketVO;

/**
 * Servlet implementation class MarketInsert
 */
@WebServlet("/MarketInsert.do")
public class MarketInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//응답결과 인코딩 - utf-8형식으로 변환. -> 한글 안 깨지게
		response.setContentType("text/html; charset=UTF-8");
		//요청정보 인코딩
		request.setCharacterEncoding("UTF-8");
		//1.파라미터받기
//		  HttpSession session = request.getSession();
//		String logInNb = (String) session.getAttribute("loginGradeNb");
//		
		String seq = request.getParameter("seq");
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String okays = request.getParameter("okays");
		String pimage = request.getParameter("pimage");
		String sselect = request.getParameter("sselect");
		String regdt = request.getParameter("regdt");
	
		//2.서비스로직처리	(DAO)
		MarketDAO marketDAO = new MarketDAO();
		MarketVO market = new MarketVO();
		market.setSeq(seq);
		market.setId(id);
		market.setTitle(title);
		market.setContent(content);
		market.setOkays(okays);
		market.setPimage(pimage);
		market.setSselect(sselect);
		market.setRegdt(regdt);
		
	
		marketDAO.MarketInsert(market);
		response.sendRedirect(request.getContextPath()+"/MarketView.do");

		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//회원가입 페이지로 포워드
		request.getRequestDispatcher("/market/marketInsert.jsp").forward(request, response);

	}


}
