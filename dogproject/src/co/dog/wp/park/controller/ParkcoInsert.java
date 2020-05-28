package co.dog.wp.park.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dog.wp.park.model.ParkDAO;
import co.dog.wp.park.model.ParkcoVO;


/**
 * Servlet implementation class ParkcoInsert
 */
@WebServlet("/ParkcoInsert")
public class ParkcoInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		
		String id = (String)request.getSession().getAttribute("loginId");
		String pseq = request.getParameter("pseq");
		String comments = request.getParameter("comments");
		
		ParkDAO parkDAO = new ParkDAO();
		ParkcoVO parkcovo = new ParkcoVO();
		
		parkcovo.setId(id);
		parkcovo.setComments(comments);
		parkcovo.setPseq(pseq);
		parkDAO.ParkcoInsert((parkcovo));
		
		response.sendRedirect(request.getContextPath()+"/BoardView.do?seq="+pseq);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
