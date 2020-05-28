package co.dog.wp.park.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dog.wp.park.model.ParkDAO;
import co.dog.wp.park.model.ParkVO;



/**
 * Servlet implementation class ParkList
 */
@WebServlet("/ParkList.do")
public class ParkList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		
		 	String spotnm = request.getParameter("spotnm"); //서비스 로직 처리
		 	String seq = request.getParameter("seq");
		 	
			ParkDAO parkdao = new ParkDAO();
			ArrayList<ParkVO> list = parkdao.getParkList(spotnm);
				
			//결과저장
			request.setAttribute("park", list); 
			
	
			request
			.getRequestDispatcher("/park/parkList.jsp") //뷰페이지 포워드 넘어감
			.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
