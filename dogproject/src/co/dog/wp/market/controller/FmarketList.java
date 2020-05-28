package co.dog.wp.market.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.dog.wp.market.model.MarketDAO;
import co.dog.wp.market.model.MarketVO;


/**
 * Servlet implementation class fmarketList
 */
@WebServlet("/fmarketList.do")
public class FmarketList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	   
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			String id = (String) session.getAttribute("loginId");
			
			//1.파라미터
			//2.서비스(DAO 목록조회)
			MarketDAO marketdao = new MarketDAO();
			ArrayList<MarketVO> list = marketdao.getFMarketList();
			//3.결과출력 또는 결과 저장해서 VIEW 포워드 
			response.setContentType("text/html; charset=UTF-8");
			//3.결과출력 or 결과 저장해서 view 포워드s
			request.setAttribute("list", list);
			request.getRequestDispatcher("/market/fmarketList.jsp")
			.forward(request, response);
		}
		



		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}

	}
