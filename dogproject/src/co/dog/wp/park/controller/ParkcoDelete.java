package co.dog.wp.park.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dog.wp.common.Command;
import co.dog.wp.park.model.ParkDAO;

public class ParkcoDelete implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 받기 -> 세션에서 seq가져오기
		String seq = request.getParameter("seq");
		String pseq = request.getParameter("pseq");
		
		ParkDAO parkDAO = new ParkDAO();
		parkDAO.deleteParkco(seq);
		
		return "ParkViewForm.do?seq=" + pseq;

	}

}
