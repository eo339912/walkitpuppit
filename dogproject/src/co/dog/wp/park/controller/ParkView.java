package co.dog.wp.park.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dog.wp.park.model.ParkDAO;
import co.dog.wp.park.model.ParkVO;


/**
 * Servlet implementation class ParkView
 */
@WebServlet("/ParkView.do")
public class ParkView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String seq = (String) request.getParameter("seq");
		
		//서비스 로직 처리
		ParkDAO parkdao  = new ParkDAO();
		ParkVO parkvo = parkdao.getPark(seq);
 
		//결과저장
		request.setAttribute("park", parkvo);  
		
		request.getRequestDispatcher("/park/parkView.jsp")
		   .forward(request, response); 
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}


